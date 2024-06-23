package org.hzz.rabbitmq.core;

import lombok.extern.slf4j.Slf4j;
import org.hzz.rabbitmq.util.UUIDHelper;
import org.slf4j.MDC;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import static org.hzz.rabbitmq.constants.Constant.*;

/**
 * 封装RabbitTemplate
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/23
 */
@Slf4j
public class RabbitMQHelper {

    private final RabbitTemplate rabbitTemplate;
    private final ThreadPoolTaskExecutor executor;
    private final MessagePostProcessor postProcessor;


    public RabbitMQHelper(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
        this.postProcessor = new BasicIdMessageProcessor();
        this.executor = new ThreadPoolTaskExecutor();
        initExecutor();
    }

    private void initExecutor(){
        //配置核心线程数
        executor.setCorePoolSize(10);
        //配置最大线程数
        executor.setMaxPoolSize(15);
        //配置队列大小
        executor.setQueueCapacity(99999);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("mq-async-send-handler");

        // 设置拒绝策略：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
    }

    /**
     * 发送消息
     * @param exchange 交换机
     * @param routingKey 路由key
     * @param m 消息
     * @param <M> 消息类型
     */
    public <M> void send(String exchange,String routingKey,M m){
        log.info("准备发送消息，exchange：{}， RoutingKey：{}， message：{}",
                exchange,routingKey,m);
        // 1.设置消息标示，用于消息确认，消息发送失败直接抛出异常，交给调用者处理
        CorrelationData correlationData = new CorrelationData(UUIDHelper.generateUUID());
        // 2.设置发送超时时间为500毫秒
        rabbitTemplate.setReplyTimeout(500);
        rabbitTemplate.convertAndSend(exchange,routingKey,m,postProcessor,correlationData);
    }

    /**
     * 发送延迟消息
     * @param exchange 交换机
     * @param routingKey 路由key
     * @param m 消息
     * @param duration 时间
     * @param <M> 消息类型
     */
    public <M> void sendDelayMessage(String exchange, String routingKey, M m, Duration duration){
        log.info("准备发送消息，exchange：{}， RoutingKey：{}， message：{}",
                exchange,routingKey,m);
        // 1.设置消息标示，用于消息确认，消息发送失败直接抛出异常，交给调用者处理
        CorrelationData correlationData = new CorrelationData(UUIDHelper.generateUUID());
        // 2.设置发送超时时间为500毫秒
        rabbitTemplate.setReplyTimeout(500);
        rabbitTemplate.convertAndSend(exchange,routingKey,m,
                new DelayedMessageProcessor(duration),correlationData);
    }

    /**
     * 异步发送消息
     * @param exchange 交换机
     * @param routingKey 路由key
     * @param m 消息
     * @param millis 延迟时间
     * @param <M> 消息类型
     */
    public <M> void sendAsync(String exchange,String routingKey,M m,Long millis){
        String requestId = MDC.get(REQUEST_ID_HEADER);

        Runnable task = ()->{
            try{
                MDC.put(REQUEST_ID_HEADER,requestId);
                if(millis != null && millis > 0L){
                    Thread.sleep(millis);
                }
                send(exchange,routingKey,m);
            }catch (Exception e){
                log.error("推送消息异常，t:{},",m,e);
            }
        };
        CompletableFuture.runAsync(task,executor);
    }

    /**
     * 异步发送消息
     * @param exchange 交换机
     * @param routingKey 路由key
     * @param m 消息
     * @param <M> 消息类型
     */
    public <M> void sendAsync(String exchange,String routingKey,M m){
        sendAsync(exchange,routingKey,m,0L);
    }

}

package org.hzz;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/30
 */
import java.util.concurrent.Callable;
import java.util.stream.Stream;

public class Main {

    private static BrokerA brokerA = new BrokerA();
    private static BrokerB brokerB = new BrokerB();
    private static BrokerC brokerC = new BrokerC();

    public static void main(String[] args) throws Exception {
        String[] transactions = {"A", "B", "C"};
        Main main = new Main();
        Callable<Integer> initialCallable = () -> 0; // 初始Callable示例


        Integer result = main.inCombined(initialCallable, transactions);

        System.out.println("Result: " + result); // 期待的输出结果
    }

    public <V> V inCombined(Callable<V> callable, String[] names) throws Exception {
        Callable<V> combined = Stream.of(names)
                .reduce(callable, (r, tx) -> {
                    System.out.println(tx);
                    // jdk新特性写法，switch表达式
                    switch (tx) {
                        case "A" -> {return () -> brokerA.someMethod(r);}
                        case "B" -> {return () -> brokerB.someMethod(r);}
                        case "C" -> {return () -> brokerC.someMethod(r);}
                        default -> throw new IllegalArgumentException("Unknown transaction: " + tx);
                    }
                },(r1,r2)->r1); // 这里第三个参数主要是为了符合类型，因为我们返回了一个新的callable

        return combined.call();
    }

    public static class BrokerA {
        public <V> V someMethod(Callable<V> callable) throws Exception {
            System.out.println("Processed in A");
            V result = callable.call();
            // 在这里进行其他操作
            return result;
        }
    }

    public static class BrokerB {
        public <V> V someMethod(Callable<V> callable) throws Exception {
            System.out.println("Processed in B");
            V result = callable.call();
            // 在这里进行其他操作
            return result;
        }
    }

    public static class BrokerC {
        public <V> V someMethod(Callable<V> callable) throws Exception {
            System.out.println("Processed in C");
            V result = callable.call();
            // 在这里进行其他操作
            return result;
        }
    }
}


package org.hzz.learning.infrastructure.mq.rabbitmq.model;

import lombok.Data;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/24
 */
public class TestData {
    private String msg;

    // 无参构造函数
    public TestData() {}

    // getter 和 setter
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "TestData{" +
                "msg='" + msg + '\'' +
                '}';
    }
}

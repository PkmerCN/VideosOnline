package org.hzz.test;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import org.hzz.learning.infrastructure.mq.rabbitmq.model.TestData;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/24
 */
public class MainTest {
    public static void main(String[] args) {
        String jsonStr = "{\r\n"
                + "  \"id\":\"01\",\r\n"
                + "  \"data\":{\r\n"
                + "      \"key\":\"test\"\r\n"
                + "  }\r\n"
                + "}";
        JSONObject json = JSON.parseObject(jsonStr);
        Bean bean = JSON.toJavaObject(json, Bean.class);
        JSONObject o = (JSONObject)bean.getData();

    }
    class Bean {
        private String id;
        private Object data;
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public Object getData() {
            return data;
        }
        public void setData(Object data) {
            this.data = data;
        }

    }
}

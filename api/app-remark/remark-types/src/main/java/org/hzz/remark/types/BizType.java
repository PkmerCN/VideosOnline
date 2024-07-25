package org.hzz.remark.types;

import lombok.Getter;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/24
 */
@Getter
public enum BizType {
    QA("QA","问答业务")
    ;

    private final String type;
    private final String desc;

    BizType(String type,String desc){
        this.type = type;
        this.desc = desc;
    }
}

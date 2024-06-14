package org.hzz.domain.app;

import com.alibaba.fastjson2.annotation.JSONField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/13
 */

@Data
@Schema(description = "返回结果")
public class Result<T> {
    @Schema(description = "返回码",example = "200")
    @JSONField(ordinal = 0)
    private String code;

    @Schema(description = "返回信息",example = "success")
    @JSONField(ordinal = 1)
    private String msg;

    @Schema(description = "返回数据")
    @JSONField(ordinal = 2)
    private T data;
    public static <T> Result<T> success(T data){
        Result<T> result = new Result<>();
        result.setCode("200");
        result.setMsg("success");
        result.setData(data);
        return result;
    }

    public static <T> Result<T> error(T data, String code, String msg){
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

}

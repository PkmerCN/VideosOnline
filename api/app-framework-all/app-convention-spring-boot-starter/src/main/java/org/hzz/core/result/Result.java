package org.hzz.core.result;

import com.alibaba.fastjson2.annotation.JSONField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hzz.core.code.AppStatus;
import org.hzz.core.code.impl.AppStatusImpl;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/22
 */
@Data
@Schema(description = "返回结果")
public class Result<T> {
    @Schema(description = "返回码",example = "200")
    @JSONField(ordinal = 0)
    private int code;

    @Schema(description = "返回信息",example = "成功")
    @JSONField(ordinal = 1)
    private String msg;

    @Schema(description = "返回数据")
    @JSONField(ordinal = 2)
    private T data;

    private Result(){}

    public Result(T data,int code,String msg){
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public static <T> Result<T> success(T data){
        Result<T> result = new Result<>();
        result.setCode(AppStatusImpl.OK.code());
        result.setMsg(AppStatusImpl.OK.getReason());
        result.setData(data);
        return result;
    }

    public static <T> Result<T> error(T data, int code, String msg){
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static Result<Object> success(){
         return success(null);
    }

    public static <T> Result<T> error(int code,String msg){
        return new Result<>(null,code,msg);
    }

    public static <T> Result<T> error(AppStatus appStatus){
        return error(appStatus.code(),appStatus.getReason());
    }

    public static <T> Result<T> error(String message){
        return error(AppStatusImpl.INTERNAL_ERROR.code(),message);
    }

}
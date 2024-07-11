package org.hzz.core.controller;

import org.hzz.core.base.AppBase;
import org.hzz.core.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/20
 */
public abstract class BaseController extends AppBase {

    protected <T> Result<T> success(T data){
        return Result.success(data);
    }

    public Result<Object> success(){
        return Result.success(null);
    }
}

package com.sav.common.handler;


import com.sav.common.constant.CommonConstants;
import com.sav.common.exception.BaseException;
import com.sav.common.vo.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by kaikai on 2018/1/13.
 * 全局异常处理
 * 通过@ControllerAdvice 和 @ExceptionHandler
 */
@ControllerAdvice("com.itnao.uc.rest")
@ResponseBody
public class GlobalBaseException {

    /*
     * 用于在controller层统一捕捉基础自定义异常
     */
    @ExceptionHandler(BaseException.class)
    public BaseResponse baseExceptionHandler(HttpServletResponse response, BaseException ex){
           return new BaseResponse(ex.getStatus(),ex.getMessage());
    }


    /*
     * 用于在controller层统一捕捉其他异常
     * 比如sql抛出的异常等
     */
    @ExceptionHandler(Exception.class)
    public BaseResponse otherExceptionHandler(HttpServletResponse response,Exception ex){
        return new BaseResponse(CommonConstants.EX_OTHER_CODE,ex.getMessage());
    }

}

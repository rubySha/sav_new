package com.sav.common.exception.auth;


import com.sav.common.constant.CommonConstants;
import com.sav.common.exception.BaseException;

/**
 * Created by kaikai on 2018/1/13.
 * 用于当token验证失败时返回固定状态码
 */
public class TokenBaseException extends BaseException {

    public TokenBaseException(String message, int status) {
        super(message, CommonConstants.EX_OTHER_CODE);
    }
}

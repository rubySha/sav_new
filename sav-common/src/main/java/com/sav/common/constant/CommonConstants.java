package com.sav.common.constant;

/**
 * Created by kaikai on 2018/1/13.
 */
public class CommonConstants {

    // 当token验证失败时返回的异常
    public static final Integer EX_TOKEN_ERR_CODE = 40101;

    public static final Integer USER_INVALID_CODE = 401;


    // 当其他异常时统一返回
    public static final Integer EX_OTHER_CODE = 500;

    public static final String CONTEXT_KEY_USER_ID = "currentUserId";
    public static final String CONTEXT_KEY_USERNAME = "currentUserName";


    public static final String JWT_KEY_USER_ID = "JWTUserId";
    public static final String JWT_KEY_NAME = "JWTName";
}

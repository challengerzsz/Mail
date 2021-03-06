package com.bsb.mail.common;

/**
 * @Author: zeng
 * @Date: 2018/9/29 18:41
 */
public class SecurityConstants {

    /**
     * 当请求需要身份认证时，默认跳转的url
     *
     */
    public static final String DEFAULT_UNAUTHENTICATED_URL = "/authentication/require";
    /**
     * 处理登录逻辑的url
     */
    public static final String LOGIN_PROCESSING_URL = "/authentication/login";
    /**
     * 默认主页
     */
    public static final String LOGIN_PAGE = "/";
    /**
     * 默认注册页
     */
    public static final String REGISTER_PAGE = "/register";
    /**
     * 默认注册接口
     */
    public static final String REGISTER_PAGE_API = "/user/register";
    /**
     * 用户默认登出接口
     */
    public static final String LOGOUT_URL = "/user/logout";


    /**
     * 默认Http错误验证码跳转url前缀
     */
    public static final String BAD_URLS = "/bad/*";
    /**
     * 401需要身份认证
     */
    public static final String NEED_AUTHENTICATION_PAGE = "/bad/401";
    /**
     * 400
     */
    public static final String RESOURCE_NOT_FOUND_PAGE = "/bad/400";
    /**
     * 500
     */
    public static final String INNER_ERROR_PAGE = "/bad/500";


}

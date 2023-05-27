package com.pancm.model.utils;

import com.alibaba.fastjson.JSONObject;
import com.pancm.model.DTO.PostBase;
import org.springframework.util.LinkedMultiValueMap;

public class RequestUtil {

    private static final String PreUrl15 = AddressUtil.getPreUrl15();

    private static final String PreUrl16 = AddressUtil.getPreUrl16();

    private static final String PreUrl12 = AddressUtil.getPreUrl12();

    private static final String PreUrl14 = AddressUtil.getPreUrl14();

    /**
     * get
     *
     * @param url
     * @return
     */
    private static JSONObject get(String url) {
        //发送http请求并返回结果
        return AddressUtil.sendGetRequest(url, new LinkedMultiValueMap<String, String>());
    }

    public static JSONObject get15(String action) {
        //发送http请求并返回结果
        return get(PreUrl15 + action);
    }

    public static JSONObject get16(String action) {
        //发送http请求并返回结果
        return get(PreUrl16 + action);
    }

    public static JSONObject get12(String action) {
        //发送http请求并返回结果
        return get(PreUrl12 + action);
    }

    public static JSONObject get14(String action) {
        //发送http请求并返回结果
        return get(PreUrl14 + action);
    }


    /**
     * post
     *
     * @param url
     * @param base
     * @return
     */
    private static JSONObject post(String url, PostBase base) {
        //发送http请求并返回结果
        return AddressUtil.sendPostRequest(url, base);
    }

    public static JSONObject post15(String action, PostBase base) {
        //发送http请求并返回结果
        return post(PreUrl15 + action, base);
    }

    public static JSONObject post16(String action, PostBase base) {
        //发送http请求并返回结果
        return post(PreUrl16 + action, base);
    }

    public static JSONObject post12(String action, PostBase base) {
        //发送http请求并返回结果
        return post(PreUrl12 + action, base);
    }

    public static JSONObject post14(String action, PostBase base) {
        //发送http请求并返回结果
        return post(PreUrl14 + action, base);
    }
}

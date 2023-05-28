package com.pancm.model.utils;

import com.alibaba.fastjson.JSONObject;
import com.pancm.model.DTO.PostBase;
import org.springframework.util.LinkedMultiValueMap;

public class RequestUtil {

    /**
     * get
     *
     * @param url
     * @return
     */
    public static JSONObject get(String url, String action) {
        //发送http请求并返回结果
        return AddressUtil.sendGetRequest(AddressUtil.getUrl(url) + action, new LinkedMultiValueMap<String, String>());
    }

    /**
     * post
     *
     * @param url
     * @param base
     * @return
     */
    public static JSONObject post(String url, String action, PostBase base) {
        //发送http请求并返回结果
        return AddressUtil.sendPostRequest(AddressUtil.getUrl(url) + action, base);
    }
}

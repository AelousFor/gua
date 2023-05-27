package com.pancm.model.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pancm.model.DTO.PostBase;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Properties;

public class AddressUtil {

    private static final String Version = "v1/";

    private static final String PreUrl12 = "http://127.0.0.1:12207/api/" + Version;

    private static final String PreUrl14 = "http://12.12.12.208:12207/api/" + Version;

    private static final String PreUrl15 = "http://" + readConf("ip-ue") + ":12207/api/" + Version;

    private static final String PreUrl16 = "http://" + readConf("ip-dy") + ":12207/api/" + Version;

    private static final String TestUrl = "http://127.0.0.1:9632/test";

    public static String getInfo() {
        return "info";
    }

    public static String getStart() {
        return "startprocess";
    }

    public static String getStop() {
        return "stopprocess";
    }

    public static String getScriptStatus() {
        return "scriptstatus";
    }

    public static String getSp() {
        return "sp/";
    }

    public static String getGetStatus() {
        return "getstatus";
    }

    public static String getCommands() {
        return "commands";
    }

    public static String getCases() {
        return "cases";
    }

    public static String getSearch() {
        return "searchcom";
    }

    public static String getUseral() {
        return "useral";
    }

    public static String getPreUrl15() {
        return PreUrl15;
    }

    public static String getPreUrl16() {
        return PreUrl16;
    }

    public static String getPreUrl12() {
        return PreUrl12;
    }

    public static String getPreUrl14() {
        return PreUrl14;
    }

    public static String getTestUrl() {
        return TestUrl;
    }

    public static JSONObject sendGetRequest(String url, MultiValueMap<String, String> params) {
        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        //  请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        //  执行HTTP请求
        ResponseEntity<String> response = client.exchange(url, HttpMethod.GET, requestEntity, String.class);
        return JSON.parseObject(response.getBody());
    }

    public static JSONObject sendPostRequest(String url, PostBase base) {
        RestTemplate client = getInstance("utf-8");
        HttpHeaders headers = new HttpHeaders();
        //  请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<PostBase> requestEntity = new HttpEntity<>(base, headers);
        //  执行HTTP请求
        ResponseEntity<String> response = client.postForEntity(url, requestEntity, String.class);
        return JSON.parseObject(response.getBody());
    }

    /**
     * 创建指定字符集的RestTemplate(解决response.getBody()为null的问题)
     *
     * @param charset 编码
     * @return 返回结果
     */
    public static RestTemplate getInstance(String charset) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter(Charset.forName(charset)));
        return restTemplate;
    }


    public static String readConf(String key) {
        //读取配置文件
        Properties properties = new Properties();
        File file = new File("conf.properties");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //获取配置文件数据
        return properties.getProperty(key);
    }

}

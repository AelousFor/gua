package com.pancm.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/serve")
@Api(value = "重定向controller", tags = {"重定向接口"})
public class RequestRedirectController {

    private static final String Info = "info";

    private static final String Start = "startprocess";

    private static final String Stop = "stopprocess";

    private static final String PreUrl15 = "http://172.22.56.15:12207/api/v1/";

    private static final String PreUrl16 = "http://172.22.56.16:12207/api/v1/";

    private static final String PreUrl12 = "http://172.22.56.12:12207/api/v1/";

    @GetMapping("/apiOn12")
    public void get12ApiRedirect(HttpServletResponse response) throws Exception {
        response.sendRedirect(PreUrl12);
    }

    @GetMapping("/apiOn15")
    public void get15ApiRedirect(HttpServletResponse response) throws Exception {
        response.sendRedirect(PreUrl15);
    }

    @GetMapping("/apiOn16")
    public void get16ApiRedirect(HttpServletResponse response) throws Exception {
        response.sendRedirect(PreUrl16);
    }

    @GetMapping("/infoOn12")
    public void get12InfoRedirect(HttpServletResponse response) throws Exception {
        response.sendRedirect(PreUrl12 + Info);
    }

    @GetMapping("/infoOn15")
    public void get15InfoRedirect(HttpServletResponse response) throws Exception {
        response.sendRedirect(PreUrl15 + Info);
    }

    @GetMapping("/infoOn16")
    public void get16InfoRedirect(HttpServletResponse response) throws Exception {
        response.sendRedirect(PreUrl16 + Info);
    }

    /**
     * 启动和停止
     */
    public void startOrStopRedirect(String pre, String suf, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String string = "?" + request.getQueryString();
        response.sendRedirect(pre + "shit/" + suf + string);
    }

    @GetMapping("/start12")
    public void start12Redirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
        startOrStopRedirect(PreUrl12, Start, request, response);
    }

    @GetMapping("/stop12")
    public void stop12Redirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
        startOrStopRedirect(PreUrl12, Stop, request, response);
    }

    @GetMapping("/start15")
    public void start15Redirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
        startOrStopRedirect(PreUrl15, Start, request, response);
    }

    @GetMapping("/stop15")
    public void stop15Redirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
        startOrStopRedirect(PreUrl15, Stop, request, response);
    }

    @GetMapping("/start16")
    public void start16Redirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
        startOrStopRedirect(PreUrl16, Start, request, response);
    }

    @GetMapping("/stop16")
    public void stop16Redirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
        startOrStopRedirect(PreUrl16, Stop, request, response);
    }
}

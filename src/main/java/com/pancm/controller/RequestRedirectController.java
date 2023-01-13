package com.pancm.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/serve")
@Api(value = "重定向controller", tags = {"重定向接口"})
public class RequestRedirectController {

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
        response.sendRedirect(PreUrl12 + "info");
    }

    @GetMapping("/infoOn15")
    public void get15InfoRedirect(HttpServletResponse response) throws Exception {
        response.sendRedirect(PreUrl15 + "info");
    }

    @GetMapping("/infoOn16")
    public void get16InfoRedirect(HttpServletResponse response) throws Exception {
        response.sendRedirect(PreUrl16 + "info");
    }

    @GetMapping("/start12")
    public void start12Redirect(HttpServletResponse response) throws Exception {
        response.sendRedirect(PreUrl12 + "startprocess");
    }

    @GetMapping("/stop12")
    public void stop12Redirect(HttpServletResponse response) throws Exception {
        response.sendRedirect(PreUrl12 + "stopprocess");
    }

    @GetMapping("/start15")
    public void start15Redirect(HttpServletResponse response) throws Exception {
        response.sendRedirect(PreUrl15 + "startprocess");
    }

    @GetMapping("/stop15")
    public void stop15Redirect(HttpServletResponse response) throws Exception {
        response.sendRedirect(PreUrl15 + "stopprocess");
    }

    @GetMapping("/start16")
    public void start16Redirect(HttpServletResponse response) throws Exception {
        response.sendRedirect(PreUrl16 + "startprocess");
    }

    @GetMapping("/stop16")
    public void stop16Redirect(HttpServletResponse response) throws Exception {
        response.sendRedirect(PreUrl16 + "stopprocess");
    }
}

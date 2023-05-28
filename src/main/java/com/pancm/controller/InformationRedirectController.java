package com.pancm.controller;

import com.alibaba.fastjson.JSONObject;
import com.pancm.model.utils.AddressUtil;
import com.pancm.model.utils.RequestUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serve")
@Api(value = "节点基本信息controller", tags = {"查看节点基本信息接口"})
public class InformationRedirectController {

    private static final String Info = AddressUtil.getInfo();

    /**
     * api
     */
    @GetMapping("/api")
    @ApiOperation(value = "api信息")
    public JSONObject getApi(@RequestParam String key) {
        return RequestUtil.get(key, "");
    }

    /**
     * info
     */
    @GetMapping("/info")
    @ApiOperation(value = "info信息")
    public JSONObject getInfo(@RequestParam String key) {
        return RequestUtil.get(key, Info);
    }

}

package com.pancm.controller;

import com.alibaba.fastjson.JSONObject;
import com.pancm.model.utils.AddressUtil;
import com.pancm.model.utils.RequestUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serve")
@Api(value = "节点基本信息controller", tags = {"查看节点基本信息接口"})
public class InformationRedirectController {

    private static final String Info = AddressUtil.getInfo();

    /**
     * api
     */
    @GetMapping("/apiOn12")
    @ApiOperation(value = "12api信息")
    public JSONObject get12Api() {
        return RequestUtil.get12("");
    }

    @GetMapping("/apiOn14")
    @ApiOperation(value = "14api信息")
    public JSONObject get14Api() {
        return RequestUtil.get14("");
    }

    @GetMapping("/apiOn15")
    @ApiOperation(value = "15api信息")
    public JSONObject get15Api() {
        return RequestUtil.get15("");
    }

    @GetMapping("/apiOn16")
    @ApiOperation(value = "16api信息")
    public JSONObject get16Api() {
        return RequestUtil.get16("");
    }

    /**
     * info
     */
    @GetMapping("/infoOn12")
    @ApiOperation(value = "12info信息")
    public JSONObject get12Info() {
        return RequestUtil.get12(Info);
    }

    @GetMapping("/infoOn14")
    @ApiOperation(value = "14info信息")
    public JSONObject get14Info() {
        return RequestUtil.get14(Info);
    }

    @GetMapping("/infoOn15")
    @ApiOperation(value = "15info信息")
    public JSONObject get15Info() {
        return RequestUtil.get15(Info);
    }

    @GetMapping("/infoOn16")
    @ApiOperation(value = "16info信息")
    public JSONObject get16Info() {
        return RequestUtil.get16(Info);
    }
}

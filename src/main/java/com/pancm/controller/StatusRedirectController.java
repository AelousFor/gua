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
@Api(value = "脚本状态controller", tags = {"检查脚本状态接口"})
public class StatusRedirectController {

    private static final String ScriptStatus = AddressUtil.getScriptStatus();

    private static final String GetStatus = AddressUtil.getGetStatus();

    /**
     * getStatus
     */
    @GetMapping("/getStatusOn12")
    @ApiOperation(value = "12脚本状态")
    public JSONObject get12Status() {
        return RequestUtil.get12(GetStatus);
    }

    @GetMapping("/getStatusOn14")
    @ApiOperation(value = "14脚本状态")
    public JSONObject get14Status() {
        return RequestUtil.get14(GetStatus);
    }

    @GetMapping("/getStatusOn15")
    @ApiOperation(value = "15脚本状态")
    public JSONObject get15Status() {
        return RequestUtil.get15(GetStatus);
    }

    @GetMapping("/getStatusOn16")
    @ApiOperation(value = "16脚本状态")
    public JSONObject get16Status() {
        return RequestUtil.get16(GetStatus);
    }

    /**
     * scriptStatus
     */
    @GetMapping("/statusOn12")
    @ApiOperation(value = "12查询通过params启动的进程")
    public JSONObject get12ScriptStatus() {
        return RequestUtil.get12(ScriptStatus);
    }

    @GetMapping("/statusOn14")
    @ApiOperation(value = "14查询通过params启动的进程")
    public JSONObject get14ScriptStatus() {
        return RequestUtil.get14(ScriptStatus);
    }

    @GetMapping("/statusOn15")
    @ApiOperation(value = "15查询通过params启动的进程")
    public JSONObject get15ScriptStatus() {
        return RequestUtil.get15(ScriptStatus);
    }

    @GetMapping("/statusOn16")
    @ApiOperation(value = "16查询通过params启动的进程")
    public JSONObject get16ScriptStatus() {
        return RequestUtil.get16(ScriptStatus);
    }
}

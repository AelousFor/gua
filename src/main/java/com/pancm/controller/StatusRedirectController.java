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
@Api(value = "脚本状态controller", tags = {"检查脚本状态接口"})
public class StatusRedirectController {

    private static final String ScriptStatus = AddressUtil.getScriptStatus();

    private static final String GetStatus = AddressUtil.getGetStatus();

    /**
     * getStatus
     */
    @GetMapping("/getStatus")
    @ApiOperation(value = "脚本状态")
    public JSONObject getStatus(@RequestParam String key) {
        return RequestUtil.get(key, GetStatus);
    }

    /**
     * scriptStatus
     */
    @GetMapping("/status")
    @ApiOperation(value = "12查询通过params启动的进程")
    public JSONObject getScriptStatus(@RequestParam String key) {
        return RequestUtil.get(key, ScriptStatus);
    }

}

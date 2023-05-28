package com.pancm.controller;

import com.alibaba.fastjson.JSONObject;
import com.pancm.model.DTO.*;
import com.pancm.model.utils.AddressUtil;
import com.pancm.model.utils.RequestUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/serve")
@Api(value = "开关节点controller", tags = {"开关节点接口"})
public class RequestRedirectController {

    private static final String Sp = AddressUtil.getSp();

    private static final String Start = AddressUtil.getStart();

    private static final String Stop = AddressUtil.getStop();


    /**
     * sp_command
     **/
    private JSONObject spGet(String key, String action) {
        return RequestUtil.get(key, Sp + action);
    }

    private JSONObject spPost(String key, String action, PostBase base) {
        return RequestUtil.post(key, Sp + action, base);
    }

    @GetMapping("/spNew")
    @ApiOperation(value = "spNew启动新的sp_command实例用于控制")
    public JSONObject spNew(@RequestParam String key) {
        //发送http请求并返回结果
        return spGet(key, "new");
    }

    @PostMapping("/spStart")
    @ApiOperation(value = "spStart通过指定的场景和存储模式启动演习")
    public JSONObject spStart(@RequestBody SpStartDTO spStartDTO) {
        //发送http请求并返回结果
        return spPost(spStartDTO.getKey(), "start", spStartDTO);
    }

    @GetMapping("/spStop")
    @ApiOperation(value = "spStop停止当前正在运行的演习")
    public JSONObject spStop(@RequestParam String key) {
        //发送http请求并返回结果
        return spGet(key, "stop");
    }

    @GetMapping("/spList")
    @ApiOperation(value = "spList获得已记录的存储")
    public JSONObject spList(@RequestParam String key) {
        //发送http请求并返回结果
        return spGet(key, "list");
    }

    @PostMapping("/spReplay")
    @ApiOperation(value = "spReplay通过指定的场景和存储模式启动演习")
    public JSONObject spReplay(@RequestBody SpReplayDTO spReplayDTO) {
        //发送http请求并返回结果
        return spPost(spReplayDTO.getKey(), "replay", spReplayDTO);
    }

    @GetMapping("/spDestory")
    @ApiOperation(value = "spDestory销毁当前的sp_command_iinterface")
    public JSONObject spDestory(@RequestParam String key) {
        //发送http请求并返回结果
        return spGet(key, "destory");
    }


    /**
     * 启动和停止
     */


    @PostMapping("/start")
    @ApiOperation(value = "启动")
    public JSONObject startRedirect(@RequestBody StartDTO startDTO) {
        return RequestUtil.post(startDTO.getKey(), Start, startDTO);
    }

    @PostMapping("/stop")
    @ApiOperation(value = "终止")
    public JSONObject stopRedirect(@RequestBody StopDTO stopDTO) {
        return RequestUtil.post(stopDTO.getKey(), Stop, stopDTO);
    }


}

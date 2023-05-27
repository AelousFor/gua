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
    private JSONObject spGet(String action) {
        return RequestUtil.get12(Sp + action);
    }

    private JSONObject spPost(String action, PostBase base) {
        return RequestUtil.post12(Sp + action, base);
    }

    @GetMapping("/spNew")
    @ApiOperation(value = "spNew启动新的sp_command实例用于控制")
    public JSONObject spNew() {
        //发送http请求并返回结果
        return spGet("new");
    }

    @PostMapping("/spStart")
    @ApiOperation(value = "spStart通过指定的场景和存储模式启动演习")
    public JSONObject spStart(@RequestBody SpStartDTO spStartDTO) {
        //发送http请求并返回结果
        return spPost("start", spStartDTO);
    }

    @GetMapping("/spStop")
    @ApiOperation(value = "spStop停止当前正在运行的演习")
    public JSONObject spStop() {
        //发送http请求并返回结果
        return spGet("stop");
    }

    @GetMapping("/spList")
    @ApiOperation(value = "spList获得已记录的存储")
    public JSONObject spList() {
        //发送http请求并返回结果
        return spGet("list");
    }

    @PostMapping("/spReplay")
    @ApiOperation(value = "spReplay通过指定的场景和存储模式启动演习")
    public JSONObject spReplay(@RequestBody SpReplayDTO spReplayDTO) {
        //发送http请求并返回结果
        return spPost("replay", spReplayDTO);
    }

    @GetMapping("/spDestory")
    @ApiOperation(value = "spDestory销毁当前的sp_command_iinterface")
    public JSONObject spDestory() {
        //发送http请求并返回结果
        return spGet("destory");
    }


    /**
     * 启动和停止
     */


    @PostMapping("/start12")
    @ApiOperation(value = "12启动")
    public JSONObject start12Redirect(@RequestBody StartDTO startDTO) {
        return RequestUtil.post12(Start, startDTO);
    }

    @PostMapping("/stop12")
    @ApiOperation(value = "12终止")
    public JSONObject stop12Redirect(@RequestBody StopDTO stopDTO) {
        return RequestUtil.post12(Stop, stopDTO);
    }

    @PostMapping("/start14")
    @ApiOperation(value = "14启动")
    public JSONObject start14Redirect(@RequestBody StartDTO startDTO) {
        return RequestUtil.post14(Start, startDTO);
    }

    @PostMapping("/stop14")
    @ApiOperation(value = "14终止")
    public JSONObject stop14Redirect(@RequestBody StopDTO stopDTO) {
        return RequestUtil.post14(Stop, stopDTO);
    }

    @PostMapping("/start15")
    @ApiOperation(value = "15启动")
    public JSONObject start15Redirect(@RequestBody StartDTO startDTO) {
        return RequestUtil.post15(Start, startDTO);
    }

    @PostMapping("/stop15")
    @ApiOperation(value = "15终止")
    public JSONObject stop15Redirect(@RequestBody StopDTO stopDTO) {
        return RequestUtil.post15(Stop, stopDTO);
    }

    @PostMapping("/start16")
    @ApiOperation(value = "16启动")
    public JSONObject start16Redirect(@RequestBody StartDTO startDTO) {
        return RequestUtil.post16(Start, startDTO);
    }

    @PostMapping("/stop16")
    @ApiOperation(value = "16终止")
    public JSONObject stop16Redirect(@RequestBody StopDTO stopDTO) {
        return RequestUtil.post16(Stop, stopDTO);
    }

}

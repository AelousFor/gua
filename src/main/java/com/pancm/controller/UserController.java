package com.pancm.controller;

import com.alibaba.fastjson.JSONObject;
import com.pancm.model.DTO.SearchDTO;
import com.pancm.model.DTO.UseralDTO;
import com.pancm.model.utils.AddressUtil;
import com.pancm.model.utils.RequestUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/serve")
@Api(value = "用户controller", tags = {"用户接口"})
public class UserController {

    private static final String Cases = AddressUtil.getCases();

    private static final String Search = AddressUtil.getSearch();

    private static final String Useral = AddressUtil.getUseral();

    @GetMapping("/cases15")
    @ApiOperation(value = "获取案例15")
    private JSONObject cases15() {
        return RequestUtil.get15(Cases);
    }

    @GetMapping("/cases16")
    @ApiOperation(value = "获取案例16")
    private JSONObject cases16() {
        return RequestUtil.get16(Cases);
    }

    @PostMapping("/search15")
    @ApiOperation(value = "查找action15")
    private JSONObject search15(@RequestBody SearchDTO searchDTO) {
        return RequestUtil.post15(Search, searchDTO);
    }

    @PostMapping("/search16")
    @ApiOperation(value = "查找action16")
    private JSONObject search16(@RequestBody SearchDTO searchDTO) {
        return RequestUtil.post16(Search, searchDTO);
    }

    @GetMapping("/useral15")
    @ApiOperation(value = "获取算法15")
    private JSONObject getUseral15() {
        return RequestUtil.get15(Useral);
    }

    @GetMapping("/useral16")
    @ApiOperation(value = "获取算法16")
    private JSONObject getUseral16() {
        return RequestUtil.get16(Useral);
    }

    @PostMapping("/useral15")
    @ApiOperation(value = "修改算法15")
    private JSONObject postUseral15(@RequestBody UseralDTO useralDTO) {
        return RequestUtil.post15(Useral, useralDTO);
    }

    @PostMapping("/useral16")
    @ApiOperation(value = "修改算法16")
    private JSONObject postUseral16(@RequestBody UseralDTO useralDTO) {
        return RequestUtil.post16(Useral, useralDTO);
    }
}

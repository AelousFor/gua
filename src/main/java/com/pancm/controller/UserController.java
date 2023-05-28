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

    @GetMapping("/cases")
    @ApiOperation(value = "获取案例")
    private JSONObject cases(@RequestParam String key) {
        return RequestUtil.get(key, Cases);
    }


    @PostMapping("/search")
    @ApiOperation(value = "查找action")
    private JSONObject search(@RequestBody SearchDTO searchDTO) {
        return RequestUtil.post(searchDTO.getKey(), Search, searchDTO);
    }


    @GetMapping("/useral")
    @ApiOperation(value = "获取算法")
    private JSONObject getUseral(@RequestParam String key) {
        return RequestUtil.get(key, Useral);
    }


    @PostMapping("/useral")
    @ApiOperation(value = "修改算法")
    private JSONObject postUseral(@RequestBody UseralDTO useralDTO) {
        return RequestUtil.post(useralDTO.getKey(), Useral, useralDTO);
    }

}

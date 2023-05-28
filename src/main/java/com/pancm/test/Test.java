package com.pancm.test;

import com.alibaba.fastjson.JSONObject;
import com.pancm.model.DTO.StartDTO;
import com.pancm.model.utils.AddressUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@Api(value = "本地测试controller", tags = {"本地测试接口"})
public class Test {

    @PostMapping("/post")
    public JSONObject test1(@RequestBody StartDTO startDTO) {
        return AddressUtil.sendPostRequest(AddressUtil.getTestUrl() + "/base", startDTO);
    }

    @PostMapping("/base")
    public StartDTO base(@RequestBody StartDTO startDTO) {
        return startDTO;
    }

    @GetMapping("/urltest")
    public String test2(@RequestParam String key) {
        return AddressUtil.getUrl(key);
    }

}

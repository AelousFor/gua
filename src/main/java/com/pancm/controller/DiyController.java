package com.pancm.controller;

import com.alibaba.fastjson.JSONObject;
import com.pancm.model.DTO.diy.*;
import com.pancm.model.DTO.diy.component.Delay;
import com.pancm.model.utils.AddressUtil;
import com.pancm.model.utils.RequestUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/serve")
@Api(value = "自定义controller", tags = {"自定义接口"})
public class DiyController {

    private static final String Commands = AddressUtil.getCommands();

    /**
     * 自定义启动
     *
     * @return
     */
    @GetMapping("/commands15")
    @ApiOperation(value = "get自定义15")
    private JSONObject getOn15() {
        return RequestUtil.get15(Commands);
    }

    @GetMapping("/commands16")
    @ApiOperation(value = "get自定义16")
    private JSONObject getOn16() {
        return RequestUtil.get16(Commands);
    }

    @GetMapping("/commands12")
    @ApiOperation(value = "get自定义12")
    private JSONObject getOn12() {
        return RequestUtil.get12(Commands);
    }

    @PostMapping("/commands15")
    @ApiOperation(value = "post自定义15")
    private JSONObject postOn15(@RequestBody DiyDTO diyDTO) {
        return RequestUtil.post15(Commands, checkDTO(diyDTO));
    }

    @PostMapping("/commands16")
    @ApiOperation(value = "post自定义16")
    private JSONObject postOn16(@RequestBody DiyDTO diyDTO) {
        return RequestUtil.post16(Commands, checkDTO(diyDTO));
    }

    @PostMapping("/commands12")
    @ApiOperation(value = "post自定义12")
    private JSONObject postOn12(@RequestBody DiyDTO diyDTO) {
        return RequestUtil.post12(Commands, checkDTO(diyDTO));
    }

    private DiyRedirectDTO checkDTO(DiyDTO diyDTO) {
        DiyRedirectDTO dto = new DiyRedirectDTO();
        dto.setAction(diyDTO.getAction());

        HashMap<String, DataBase> map = new HashMap<>();
        HashMap<String, CommandsData> data = diyDTO.getData();
        for (Map.Entry<String, CommandsData> entry : data.entrySet()) {
            String key = entry.getKey();
            CommandsData value = entry.getValue();
            com.pancm.model.DTO.diy.component.Commands commands = value.getCommands();
            String excom = value.getExcom();
            String workdir = value.getWorkdir();
            Delay delay = value.getDelay();
            String start = delay.getStart();
            if (workdir.isEmpty() && start.isEmpty()) {
                DataWithoutBoth both = new DataWithoutBoth();
                both.setCommands(commands);
                both.setExcom(excom);
                map.put(key, both);
            } else if (workdir.isEmpty()) {
                DataWithoutWorkdir dataWithoutWorkdir = new DataWithoutWorkdir();
                dataWithoutWorkdir.setCommands(commands);
                dataWithoutWorkdir.setExcom(excom);
                dataWithoutWorkdir.setDelay(delay);
                map.put(key, dataWithoutWorkdir);
            } else if (start.isEmpty()) {
                DataWithoutDelay dataWithoutDelay = new DataWithoutDelay();
                dataWithoutDelay.setCommands(commands);
                dataWithoutDelay.setExcom(excom);
                dataWithoutDelay.setWorkdir(workdir);
                map.put(key, dataWithoutDelay);
            } else {
                map.put(key, value);
            }
        }
        dto.setData(map);
        return dto;
    }
}

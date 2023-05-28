package com.pancm.model.DTO.diy;

import lombok.Data;

import java.util.HashMap;

@Data
public class DiyDTO {

    String key;
    String action;
    HashMap<String, CommandsData> data;
}

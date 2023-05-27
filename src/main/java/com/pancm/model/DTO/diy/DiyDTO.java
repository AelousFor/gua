package com.pancm.model.DTO.diy;

import lombok.Data;

import java.util.HashMap;

@Data
public class DiyDTO {

    String action;
    HashMap<String, CommandsData> data;
}

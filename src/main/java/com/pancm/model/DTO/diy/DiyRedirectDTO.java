package com.pancm.model.DTO.diy;

import com.pancm.model.DTO.PostBase;
import lombok.Data;

import java.util.HashMap;

@Data
public class DiyRedirectDTO extends PostBase {

    String action;
    HashMap<String, DataBase> data;
}

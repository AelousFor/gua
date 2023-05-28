package com.pancm.model.DTO;

import lombok.Data;

@Data
public class StartDTO extends PostBase {

    String key;
    String process_name;
    String token;
    String process_isshell;
}

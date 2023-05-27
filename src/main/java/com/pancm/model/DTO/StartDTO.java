package com.pancm.model.DTO;

import lombok.Data;

@Data
public class StartDTO extends PostBase {

    String process_name;
    String token;
    String process_isshell;
}

package com.pancm.model.DTO;

import lombok.Data;

@Data
public class StopDTO extends PostBase {
    String process_id;
    String token;
}

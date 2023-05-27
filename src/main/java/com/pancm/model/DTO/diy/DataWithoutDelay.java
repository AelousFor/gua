package com.pancm.model.DTO.diy;

import com.pancm.model.DTO.diy.component.Commands;
import lombok.Data;

@Data
public class DataWithoutDelay extends DataBase{
    Commands commands;
    String excom;
    String workdir;
}

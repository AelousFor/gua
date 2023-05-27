package com.pancm.model.DTO.diy;

import com.pancm.model.DTO.diy.component.Commands;
import com.pancm.model.DTO.diy.component.Delay;
import lombok.Data;

@Data
public class DataWithoutWorkdir extends DataBase{
    Commands commands;
    String excom;
    Delay delay;
}

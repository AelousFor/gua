package com.pancm.model.DTO.diy;

import com.pancm.model.DTO.diy.component.Commands;
import com.pancm.model.DTO.diy.component.Delay;
import lombok.Data;

@Data
public class CommandsData extends DataBase {

    Commands commands;
    String excom;
    String workdir;
    Delay delay;
}

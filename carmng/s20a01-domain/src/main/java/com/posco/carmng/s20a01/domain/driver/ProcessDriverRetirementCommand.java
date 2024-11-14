package com.posco.carmng.s20a01.domain.driver;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ProcessDriverRetirementCommand {

    private String driverEmpNo;
    private String retirementFlag;
    private Date retiredDate;
}

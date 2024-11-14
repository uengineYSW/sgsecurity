package com.posco.carmng.s20a01.domain.driver;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateDriverCommand {

    private String driverEmpNo;
    private String name;
    private String companyCode;
    private String worksCode;
    private String hrAccessLevel;
    private String supervisorType;
    private String currentJob;
    private String handPhone;
    private String licenseNumber;
    private String nationalIdentifier;
    private Long resourceId;
    private String carType;
    private String retirementFlag;
    private Date retiredDate;
    private String description;
}

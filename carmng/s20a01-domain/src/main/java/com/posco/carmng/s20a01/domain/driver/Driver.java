package com.posco.carmng.s20a01.domain.driver;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Driver_table")
@Data
public class Driver {

    @Id
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

    public void processDriverRetirement(
        ProcessDriverRetirementCommand command
    ) {
        // 비즈니스 로직 구현
    }
}

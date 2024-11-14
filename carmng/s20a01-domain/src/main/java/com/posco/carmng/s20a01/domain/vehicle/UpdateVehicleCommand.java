package com.posco.carmng.s20a01.domain.vehicle;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateVehicleCommand {

    private String carrierNo;
    private String worksCode;
    private String companyCode;
    private String carType;
    private String carModel;
    private String usage;
    private String fuelFlag;
    private String partCompanyCd;
    private String ownerTypeCode;
    private String assetNumber;
    private String organizationName;
    private Long acquisitionAmt;
    private String driverEmpNo;
    private String userName;
    private Date registDate;
    private Date reversalDate;
    private String managementNumber;
    private String type;
    private String yearTp;
    private String mdOutputValue;
    private Integer lcaHeight;
    private Long quantity;
    private Integer personCount;
    private Long standardValue;
    private Integer maxCapacity;
    private Integer shortDistance;
    private Integer laneDistance;
    private Integer loadedTravelDistance;
    private Date inspectionDate;
    private String description;
    private Integer weight40Max;
    private Integer width40Max;
    private Integer lengthConstraintKan;
    private Long usedWeight;
}

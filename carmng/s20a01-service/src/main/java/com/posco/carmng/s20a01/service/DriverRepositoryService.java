package com.posco.carmng.s20a01.service;

import com.posco.carmng.s20a01.domain.driver.CreateDriverCommand;
import com.posco.carmng.s20a01.domain.driver.DeleteDriverCommand;
import com.posco.carmng.s20a01.domain.driver.Driver;
import com.posco.carmng.s20a01.domain.driver.DriverRepository;
import com.posco.carmng.s20a01.domain.driver.ProcessDriverRetirementCommand;
import com.posco.carmng.s20a01.domain.driver.UpdateDriverCommand;
import com.posco.carmng.s20a01.domain.driver.mybatis.DriverMapper;
import com.posco.carmng.s20a01.domain.driver.mybatis.DriverMybatisEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
public class DriverRepositoryService {

    private final DriverRepository driverRepository;
    private final DriverMapper driverMapper;

    @Autowired
    public DriverRepositoryService(
        DriverRepository driverRepository,
        DriverMapper driverMapper
    ) {
        this.driverRepository = driverRepository;
        this.driverMapper = driverMapper;
    }

    public Driver create(CreateDriverCommand command) {
        Driver driver = new Driver();
        driver.setDriverEmpNo(command.getDriverEmpNo());
        driver.setName(command.getName());
        driver.setCompanyCode(command.getCompanyCode());
        driver.setWorksCode(command.getWorksCode());
        driver.setHrAccessLevel(command.getHrAccessLevel());
        driver.setSupervisorType(command.getSupervisorType());
        driver.setCurrentJob(command.getCurrentJob());
        driver.setHandPhone(command.getHandPhone());
        driver.setLicenseNumber(command.getLicenseNumber());
        driver.setNationalIdentifier(command.getNationalIdentifier());
        driver.setResourceId(command.getResourceId());
        driver.setCarType(command.getCarType());
        driver.setRetirementFlag(command.getRetirementFlag());
        driver.setRetiredDate(command.getRetiredDate());
        driver.setDescription(command.getDescription());
        return driverRepository.save(driver);
    }

    public Driver update(String id, UpdateDriverCommand command) {
        Driver existing = findById(id);
        if (command.getDriverEmpNo() != null) {
            existing.setDriverEmpNo(command.getDriverEmpNo());
        }
        if (command.getName() != null) {
            existing.setName(command.getName());
        }
        if (command.getCompanyCode() != null) {
            existing.setCompanyCode(command.getCompanyCode());
        }
        if (command.getWorksCode() != null) {
            existing.setWorksCode(command.getWorksCode());
        }
        if (command.getHrAccessLevel() != null) {
            existing.setHrAccessLevel(command.getHrAccessLevel());
        }
        if (command.getSupervisorType() != null) {
            existing.setSupervisorType(command.getSupervisorType());
        }
        if (command.getCurrentJob() != null) {
            existing.setCurrentJob(command.getCurrentJob());
        }
        if (command.getHandPhone() != null) {
            existing.setHandPhone(command.getHandPhone());
        }
        if (command.getLicenseNumber() != null) {
            existing.setLicenseNumber(command.getLicenseNumber());
        }
        if (command.getNationalIdentifier() != null) {
            existing.setNationalIdentifier(command.getNationalIdentifier());
        }
        if (command.getResourceId() != null) {
            existing.setResourceId(command.getResourceId());
        }
        if (command.getCarType() != null) {
            existing.setCarType(command.getCarType());
        }
        if (command.getRetirementFlag() != null) {
            existing.setRetirementFlag(command.getRetirementFlag());
        }
        if (command.getRetiredDate() != null) {
            existing.setRetiredDate(command.getRetiredDate());
        }
        if (command.getDescription() != null) {
            existing.setDescription(command.getDescription());
        }
        return driverRepository.save(existing);
    }

    public void delete(String id) {
        Driver driver = findById(id);
        driverRepository.delete(driver);
    }

    public Driver save(Driver driver) {
        return driverRepository.save(driver);
    }

    public List<Driver> findAll() {
        return driverRepository.findAll();
    }

    public Driver findById(String id) {
        return driverRepository
            .findById(id)
            .orElseThrow(() ->
                new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Driver not found"
                )
            );
    }

    //// mybatis
    private Driver convertToEntity(DriverMybatisEntity mybatisEntity) {
        Driver entity = new Driver();
        return entity;
    }

    private DriverMybatisEntity convertToMybatisEntity(Driver entity) {
        DriverMybatisEntity mybatisEntity = new DriverMybatisEntity();
        return mybatisEntity;
    }
    // 예시
    // public List<Driver> findAllByMapper() {
    //     return mybatisMapper.selectDriverList().stream()
    //         .map(this::convertToEntity)
    //         .collect(Collectors.toList());
    // }

    // public Driver findByIdMapper(String id) {
    //     DriverMybatisEntity mybatisEntity = mybatisMapper.selectDriver(id);
    //     if (mybatisEntity == null) {
    //         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Driver not found");
    //     }
    //     return convertToEntity(mybatisEntity);
    // }
}

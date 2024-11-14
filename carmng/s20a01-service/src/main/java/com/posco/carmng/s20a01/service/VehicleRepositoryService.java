package com.posco.carmng.s20a01.service;

import com.posco.carmng.s20a01.domain.vehicle.CreateVehicleCommand;
import com.posco.carmng.s20a01.domain.vehicle.DeleteVehicleCommand;
import com.posco.carmng.s20a01.domain.vehicle.UpdateVehicleCommand;
import com.posco.carmng.s20a01.domain.vehicle.Vehicle;
import com.posco.carmng.s20a01.domain.vehicle.VehicleRepository;
import com.posco.carmng.s20a01.domain.vehicle.mybatis.VehicleMapper;
import com.posco.carmng.s20a01.domain.vehicle.mybatis.VehicleMybatisEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
public class VehicleRepositoryService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    @Autowired
    public VehicleRepositoryService(
        VehicleRepository vehicleRepository,
        VehicleMapper vehicleMapper
    ) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
    }

    public Vehicle create(CreateVehicleCommand command) {
        Vehicle vehicle = new Vehicle();
        vehicle.setCarrierNo(command.getCarrierNo());
        vehicle.setWorksCode(command.getWorksCode());
        vehicle.setCompanyCode(command.getCompanyCode());
        vehicle.setCarType(command.getCarType());
        vehicle.setCarModel(command.getCarModel());
        vehicle.setUsage(command.getUsage());
        vehicle.setFuelFlag(command.getFuelFlag());
        vehicle.setPartCompanyCd(command.getPartCompanyCd());
        vehicle.setOwnerTypeCode(command.getOwnerTypeCode());
        vehicle.setAssetNumber(command.getAssetNumber());
        vehicle.setOrganizationName(command.getOrganizationName());
        vehicle.setAcquisitionAmt(command.getAcquisitionAmt());
        vehicle.setDriverEmpNo(command.getDriverEmpNo());
        vehicle.setUserName(command.getUserName());
        vehicle.setRegistDate(command.getRegistDate());
        vehicle.setReversalDate(command.getReversalDate());
        vehicle.setManagementNumber(command.getManagementNumber());
        vehicle.setType(command.getType());
        vehicle.setYearTp(command.getYearTp());
        vehicle.setMdOutputValue(command.getMdOutputValue());
        vehicle.setLcaHeight(command.getLcaHeight());
        vehicle.setQuantity(command.getQuantity());
        vehicle.setPersonCount(command.getPersonCount());
        vehicle.setStandardValue(command.getStandardValue());
        vehicle.setMaxCapacity(command.getMaxCapacity());
        vehicle.setShortDistance(command.getShortDistance());
        vehicle.setLaneDistance(command.getLaneDistance());
        vehicle.setLoadedTravelDistance(command.getLoadedTravelDistance());
        vehicle.setInspectionDate(command.getInspectionDate());
        vehicle.setDescription(command.getDescription());
        vehicle.setWeight40Max(command.getWeight40Max());
        vehicle.setWidth40Max(command.getWidth40Max());
        vehicle.setLengthConstraintKan(command.getLengthConstraintKan());
        vehicle.setUsedWeight(command.getUsedWeight());
        return vehicleRepository.save(vehicle);
    }

    public Vehicle update(String id, UpdateVehicleCommand command) {
        Vehicle existing = findById(id);
        if (command.getCarrierNo() != null) {
            existing.setCarrierNo(command.getCarrierNo());
        }
        if (command.getWorksCode() != null) {
            existing.setWorksCode(command.getWorksCode());
        }
        if (command.getCompanyCode() != null) {
            existing.setCompanyCode(command.getCompanyCode());
        }
        if (command.getCarType() != null) {
            existing.setCarType(command.getCarType());
        }
        if (command.getCarModel() != null) {
            existing.setCarModel(command.getCarModel());
        }
        if (command.getUsage() != null) {
            existing.setUsage(command.getUsage());
        }
        if (command.getFuelFlag() != null) {
            existing.setFuelFlag(command.getFuelFlag());
        }
        if (command.getPartCompanyCd() != null) {
            existing.setPartCompanyCd(command.getPartCompanyCd());
        }
        if (command.getOwnerTypeCode() != null) {
            existing.setOwnerTypeCode(command.getOwnerTypeCode());
        }
        if (command.getAssetNumber() != null) {
            existing.setAssetNumber(command.getAssetNumber());
        }
        if (command.getOrganizationName() != null) {
            existing.setOrganizationName(command.getOrganizationName());
        }
        if (command.getAcquisitionAmt() != null) {
            existing.setAcquisitionAmt(command.getAcquisitionAmt());
        }
        if (command.getDriverEmpNo() != null) {
            existing.setDriverEmpNo(command.getDriverEmpNo());
        }
        if (command.getUserName() != null) {
            existing.setUserName(command.getUserName());
        }
        if (command.getRegistDate() != null) {
            existing.setRegistDate(command.getRegistDate());
        }
        if (command.getReversalDate() != null) {
            existing.setReversalDate(command.getReversalDate());
        }
        if (command.getManagementNumber() != null) {
            existing.setManagementNumber(command.getManagementNumber());
        }
        if (command.getType() != null) {
            existing.setType(command.getType());
        }
        if (command.getYearTp() != null) {
            existing.setYearTp(command.getYearTp());
        }
        if (command.getMdOutputValue() != null) {
            existing.setMdOutputValue(command.getMdOutputValue());
        }
        if (command.getLcaHeight() != null) {
            existing.setLcaHeight(command.getLcaHeight());
        }
        if (command.getQuantity() != null) {
            existing.setQuantity(command.getQuantity());
        }
        if (command.getPersonCount() != null) {
            existing.setPersonCount(command.getPersonCount());
        }
        if (command.getStandardValue() != null) {
            existing.setStandardValue(command.getStandardValue());
        }
        if (command.getMaxCapacity() != null) {
            existing.setMaxCapacity(command.getMaxCapacity());
        }
        if (command.getShortDistance() != null) {
            existing.setShortDistance(command.getShortDistance());
        }
        if (command.getLaneDistance() != null) {
            existing.setLaneDistance(command.getLaneDistance());
        }
        if (command.getLoadedTravelDistance() != null) {
            existing.setLoadedTravelDistance(command.getLoadedTravelDistance());
        }
        if (command.getInspectionDate() != null) {
            existing.setInspectionDate(command.getInspectionDate());
        }
        if (command.getDescription() != null) {
            existing.setDescription(command.getDescription());
        }
        if (command.getWeight40Max() != null) {
            existing.setWeight40Max(command.getWeight40Max());
        }
        if (command.getWidth40Max() != null) {
            existing.setWidth40Max(command.getWidth40Max());
        }
        if (command.getLengthConstraintKan() != null) {
            existing.setLengthConstraintKan(command.getLengthConstraintKan());
        }
        if (command.getUsedWeight() != null) {
            existing.setUsedWeight(command.getUsedWeight());
        }
        return vehicleRepository.save(existing);
    }

    public void delete(String id) {
        Vehicle vehicle = findById(id);
        vehicleRepository.delete(vehicle);
    }

    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    public Vehicle findById(String id) {
        return vehicleRepository
            .findById(id)
            .orElseThrow(() ->
                new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Vehicle not found"
                )
            );
    }

    //// mybatis
    private Vehicle convertToEntity(VehicleMybatisEntity mybatisEntity) {
        Vehicle entity = new Vehicle();
        return entity;
    }

    private VehicleMybatisEntity convertToMybatisEntity(Vehicle entity) {
        VehicleMybatisEntity mybatisEntity = new VehicleMybatisEntity();
        return mybatisEntity;
    }
    // 예시
    // public List<Vehicle> findAllByMapper() {
    //     return mybatisMapper.selectVehicleList().stream()
    //         .map(this::convertToEntity)
    //         .collect(Collectors.toList());
    // }

    // public Vehicle findByIdMapper(String id) {
    //     VehicleMybatisEntity mybatisEntity = mybatisMapper.selectVehicle(id);
    //     if (mybatisEntity == null) {
    //         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle not found");
    //     }
    //     return convertToEntity(mybatisEntity);
    // }
}

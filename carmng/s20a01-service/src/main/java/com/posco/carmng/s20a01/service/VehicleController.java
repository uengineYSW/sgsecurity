package com.posco.carmng.s20a01.service;

import com.posco.carmng.s20a01.domain.vehicle.CreateVehicleCommand;
import com.posco.carmng.s20a01.domain.vehicle.DeleteVehicleCommand;
import com.posco.carmng.s20a01.domain.vehicle.UpdateVehicleCommand;
import com.posco.carmng.s20a01.domain.vehicle.Vehicle;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RepositoryRestController
public class VehicleController {

    private final VehicleRepositoryService vehicleRepositoryService;

    @Autowired
    public VehicleController(
        VehicleRepositoryService vehicleRepositoryService
    ) {
        this.vehicleRepositoryService = vehicleRepositoryService;
    }

    @GetMapping(path = "/vehicles")
    public ResponseEntity<List<Vehicle>> findAll() {
        return ResponseEntity.ok(vehicleRepositoryService.findAll());
    }

    @PostMapping(path = "/vehicles")
    public ResponseEntity<Vehicle> create(
        @Valid @RequestBody CreateVehicleCommand command
    ) {
        return ResponseEntity.ok(vehicleRepositoryService.create(command));
    }

    @PatchMapping(path = "vehicles/{id}")
    public ResponseEntity<Vehicle> update(
        @PathVariable String id,
        @Valid @RequestBody UpdateVehicleCommand command
    ) {
        return ResponseEntity.ok(vehicleRepositoryService.update(id, command));
    }

    @DeleteMapping(path = "vehicles/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        vehicleRepositoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

package com.posco.carmng.s20a01.service;

import com.posco.carmng.s20a01.domain.driver.CreateDriverCommand;
import com.posco.carmng.s20a01.domain.driver.DeleteDriverCommand;
import com.posco.carmng.s20a01.domain.driver.Driver;
import com.posco.carmng.s20a01.domain.driver.ProcessDriverRetirementCommand;
import com.posco.carmng.s20a01.domain.driver.UpdateDriverCommand;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RepositoryRestController
public class DriverController {

    private final DriverRepositoryService driverRepositoryService;

    @Autowired
    public DriverController(DriverRepositoryService driverRepositoryService) {
        this.driverRepositoryService = driverRepositoryService;
    }

    @GetMapping(path = "/drivers")
    public ResponseEntity<List<Driver>> findAll() {
        return ResponseEntity.ok(driverRepositoryService.findAll());
    }

    @PostMapping(path = "/drivers")
    public ResponseEntity<Driver> create(
        @Valid @RequestBody CreateDriverCommand command
    ) {
        return ResponseEntity.ok(driverRepositoryService.create(command));
    }

    @PatchMapping(path = "drivers/{id}")
    public ResponseEntity<Driver> update(
        @PathVariable String id,
        @Valid @RequestBody UpdateDriverCommand command
    ) {
        return ResponseEntity.ok(driverRepositoryService.update(id, command));
    }

    @DeleteMapping(path = "drivers/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        driverRepositoryService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(path = "drivers/{id}/processDriverRetirement")
    public ResponseEntity<Driver> processDriverRetirement(
        @PathVariable("id") String id,
        @Valid @RequestBody ProcessDriverRetirementCommand command
    ) {
        Driver driver = driverRepositoryService.findById(id);

        // 도메인 포트 메서드 직접 호출
        driver.processDriverRetirement(command);

        return ResponseEntity.ok(driverRepositoryService.save(driver));
    }
}

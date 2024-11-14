package com.posco.carmng.s20a01.domain.vehicle;

import com.posco.carmng.s20a01.domain.vehicle.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "vehicles", path = "vehicles")
public interface VehicleRepository extends JpaRepository<Vehicle, String> {}

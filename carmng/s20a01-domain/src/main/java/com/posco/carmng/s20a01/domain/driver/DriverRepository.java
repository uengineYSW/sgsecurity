package com.posco.carmng.s20a01.domain.driver;

import com.posco.carmng.s20a01.domain.driver.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "drivers", path = "drivers")
public interface DriverRepository extends JpaRepository<Driver, String> {}

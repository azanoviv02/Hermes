package com.hermes.infrastructure.dataaccess.repositories;

import com.hermes.domain.vehicles.AbstractVehicle;

/**
 * Created by ivan on 01.11.16.
 */
public class VehicleRepository extends GenericRepository<AbstractVehicle> {
    VehicleRepository() {
        super(AbstractVehicle.class);
    }
}
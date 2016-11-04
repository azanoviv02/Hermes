package com.hermes.infrastructure.dataaccess.repositories;

import com.hermes.domain.cargo.AbstractCargo;

/**
 * Created by ivan on 01.11.16.
 */
public class CargoRepository extends GenericRepository<AbstractCargo> {
    CargoRepository() {
        super(AbstractCargo.class);
    }
}

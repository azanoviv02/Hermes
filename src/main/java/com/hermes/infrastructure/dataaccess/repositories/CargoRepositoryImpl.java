package com.hermes.infrastructure.dataaccess.repositories;


import com.hermes.domain.cargo.AbstractCargo;

/**
 * Created by ivan on 05.11.16.
 */
public class CargoRepositoryImpl extends GenericRepositoryImpl<AbstractCargo> implements CargoRepository {
    public CargoRepositoryImpl(GenericDao<AbstractCargo> dao) {
        super(dao);
    }
}

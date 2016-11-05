package com.hermes.infrastructure.dataaccess.repositories;


import com.hermes.domain.cargo.AbstractCargo;
import org.hibernate.SessionFactory;

/**
 * Created by ivan on 05.11.16.
 */
public class CargoRepositoryImpl extends GenericRepositoryImpl<AbstractCargo> implements CargoRepository {
    public CargoRepositoryImpl(Class<? extends AbstractCargo> daoType, SessionFactory sessionFactory) {
        super(daoType, sessionFactory);
    }
}

package com.hermes.infrastructure.dataaccess.repositories;

import com.hermes.domain.vehicles.AbstractVehicle;
import org.hibernate.SessionFactory;

/**
 * Created by ivan on 05.11.16.
 */
public class VehicleRepositoryImpl extends GenericRepositoryImpl<AbstractVehicle> implements VehicleRepository {
    public VehicleRepositoryImpl(SessionFactory sessionFactory) {
        super(AbstractVehicle.class, sessionFactory);
    }
}

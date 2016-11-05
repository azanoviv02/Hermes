package com.hermes.infrastructure.dataaccess.repositories;

import com.hermes.domain.places.AbstractPlace;
import org.hibernate.SessionFactory;

/**
 * Created by ivan on 05.11.16.
 */
public class PlaceRepositoryImpl extends GenericRepositoryImpl<AbstractPlace> implements PlaceRepository {
    public PlaceRepositoryImpl(Class<? extends AbstractPlace> daoType, SessionFactory sessionFactory) {
        super(daoType, sessionFactory);
    }
}

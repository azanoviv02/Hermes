package com.hermes.infrastructure.dataaccess.repositories;

import com.hermes.domain.hauls.AbstractHaul;
import org.hibernate.SessionFactory;

/**
 * Created by ivan on 05.11.16.
 */
public class HaulRepositoryImpl extends GenericRepositoryImpl<AbstractHaul> implements HaulRepository {
    public HaulRepositoryImpl(SessionFactory sessionFactory) {
        super(AbstractHaul.class, sessionFactory);
    }
}

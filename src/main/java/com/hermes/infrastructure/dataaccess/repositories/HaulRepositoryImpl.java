package com.hermes.infrastructure.dataaccess.repositories;

import com.hermes.domain.hauls.AbstractHaul;

/**
 * Created by ivan on 05.11.16.
 */
public class HaulRepositoryImpl extends GenericRepositoryImpl<AbstractHaul> implements HaulRepository {
    public HaulRepositoryImpl(GenericDao<AbstractHaul> dao) {
        super(dao);
    }
}

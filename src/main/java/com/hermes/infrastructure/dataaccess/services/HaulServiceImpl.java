package com.hermes.infrastructure.dataaccess.services;

import com.hermes.domain.hauls.AbstractHaul;

/**
 * Created by ivan on 05.11.16.
 */
public class HaulServiceImpl extends GenericServiceImpl<AbstractHaul> implements HaulService {
    public HaulServiceImpl(GenericRepository<AbstractHaul> repository) {
        super(repository);
    }
}

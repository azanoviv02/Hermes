package com.hermes.infrastructure.dataaccess.repositories;

import com.hermes.domain.hauls.AbstractHaul;

/**
 * Created by ivan on 01.11.16.
 */
public class HaulRepository extends GenericRepository<AbstractHaul> {

    HaulRepository() {
        super(AbstractHaul.class);
    }
}

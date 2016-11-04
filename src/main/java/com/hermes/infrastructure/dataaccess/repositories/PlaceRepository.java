package com.hermes.infrastructure.dataaccess.repositories;

import com.hermes.domain.places.AbstractPlace;

/**
 * Created by ivan on 01.11.16.
 */
public class PlaceRepository extends GenericRepository<AbstractPlace> {
    PlaceRepository() {
        super(AbstractPlace.class);
    }
}

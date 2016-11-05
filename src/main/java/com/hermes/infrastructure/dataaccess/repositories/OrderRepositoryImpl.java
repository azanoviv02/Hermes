package com.hermes.infrastructure.dataaccess.repositories;

import com.hermes.domain.orders.AbstractOrder;

/**
 * Created by ivan on 05.11.16.
 */
public class OrderRepositoryImpl extends GenericRepositoryImpl<AbstractOrder> implements OrderRepository {
    public OrderRepositoryImpl(GenericDao<AbstractOrder> dao) {
        super(dao);
    }
}
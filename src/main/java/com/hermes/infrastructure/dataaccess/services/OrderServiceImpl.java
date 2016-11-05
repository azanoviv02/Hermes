package com.hermes.infrastructure.dataaccess.services;

import com.hermes.domain.orders.AbstractOrder;

/**
 * Created by ivan on 05.11.16.
 */
public class OrderServiceImpl extends GenericServiceImpl<AbstractOrder> implements OrderService {
    public OrderServiceImpl(GenericRepository<AbstractOrder> repository) {
        super(repository);
    }
}
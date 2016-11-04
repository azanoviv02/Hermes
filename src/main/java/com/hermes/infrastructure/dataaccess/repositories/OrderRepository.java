package com.hermes.infrastructure.dataaccess.repositories;

import com.hermes.domain.orders.AbstractOrder;

/**
 * Created by ivan on 01.11.16.
 */
public class OrderRepository extends GenericRepository<AbstractOrder> {
    OrderRepository() {
        super(AbstractOrder.class);
    }
}

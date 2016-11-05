package com.hermes.infrastructure.dataaccess.repositories;

import com.hermes.domain.orders.AbstractOrder;
import org.hibernate.SessionFactory;

/**
 * Created by ivan on 05.11.16.
 */
public class OrderRepositoryImpl extends GenericRepositoryImpl<AbstractOrder> implements OrderRepository {
    public OrderRepositoryImpl(SessionFactory sessionFactory) {
        super(AbstractOrder.class, sessionFactory);
    }
}
package com.hermes.domain.cargo;

import com.hermes.domain.orders.AbstractOrder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by ivan on 25.10.16.
 */
@Entity
@DiscriminatorValue("BOX")
public class Box extends AbstractSolidCargo {
    Box() {
    }

    public Box(AbstractOrder order, double weight, double volume) {
        super(order, weight, volume);
    }
}

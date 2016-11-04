package com.hermes.infrastructure.dataaccess.repositories;

import com.hermes.domain.milestones.AbstractMilestone;

/**
 * Created by ivan on 01.11.16.
 */
public class MilestoneRepository extends GenericRepository<AbstractMilestone> {
    MilestoneRepository() {
        super(AbstractMilestone.class);
    }
}

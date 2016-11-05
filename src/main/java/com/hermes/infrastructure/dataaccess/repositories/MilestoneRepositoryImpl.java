package com.hermes.infrastructure.dataaccess.repositories;


import com.hermes.domain.milestones.AbstractMilestone;

public class MilestoneRepositoryImpl extends GenericRepositoryImpl<AbstractMilestone> implements MilestoneRepository {
    public MilestoneRepositoryImpl(GenericDao<AbstractMilestone> dao) {
        super(dao);
    }
}

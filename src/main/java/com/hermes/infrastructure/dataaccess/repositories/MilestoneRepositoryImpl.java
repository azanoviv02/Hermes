package com.hermes.infrastructure.dataaccess.repositories;


import com.hermes.domain.milestones.AbstractMilestone;
import org.hibernate.SessionFactory;

public class MilestoneRepositoryImpl extends GenericRepositoryImpl<AbstractMilestone> implements MilestoneRepository {
    public MilestoneRepositoryImpl(Class<? extends AbstractMilestone> daoType, SessionFactory sessionFactory) {
        super(daoType, sessionFactory);
    }
}

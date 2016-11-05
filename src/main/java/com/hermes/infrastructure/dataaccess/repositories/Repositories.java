package com.hermes.infrastructure.dataaccess.repositories;

public final class Repositories {

    private CargoRepository storedCargoRepository;
    private EmployeeRepository storedEmployeeRepository;
    private HaulRepository storedHaulRepository;
    private MilestoneRepository storedMilestoneRepository;
    private OrderRepository storedOrderRepository;
    private PlaceRepository storedPlaceRepository;
    private VehicleRepository storedVehicleRepository;
    private UserRepository storedUserRepository;

    public Repositories(CargoRepository storedCargoRepository,
                        EmployeeRepository storedEmployeeRepository,
                        HaulRepository storedHaulRepository,
                        MilestoneRepository storedMilestoneRepository,
                        OrderRepository storedOrderRepository,
                        PlaceRepository storedPlaceRepository,
                        VehicleRepository storedVehicleRepository,
                        UserRepository storedUserRepository) {
        this.storedCargoRepository = storedCargoRepository;
        this.storedEmployeeRepository = storedEmployeeRepository;
        this.storedHaulRepository = storedHaulRepository;
        this.storedMilestoneRepository = storedMilestoneRepository;
        this.storedOrderRepository = storedOrderRepository;
        this.storedPlaceRepository = storedPlaceRepository;
        this.storedVehicleRepository = storedVehicleRepository;
        this.storedUserRepository = storedUserRepository;
    }

    public CargoRepository getCargoRepository(){
        return storedCargoRepository;
    }

    public EmployeeRepository getEmployeeRepository(){
        return storedEmployeeRepository;
    }

    public HaulRepository getHaulRepository(){
        return storedHaulRepository;
    }

    public MilestoneRepository getMilestoneRepository(){
        return storedMilestoneRepository;
    }

    public OrderRepository getOrderRepository(){
        return storedOrderRepository;
    }

    public PlaceRepository getPlaceRepository(){
        return storedPlaceRepository;
    }

    public UserRepository getUserRepository(){
        return storedUserRepository;
    }

    public VehicleRepository getVehicleRepository(){
        return storedVehicleRepository;
    }
}

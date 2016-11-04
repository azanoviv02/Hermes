package com.hermes.infrastructure.dataaccess.repositories;

public final class Repositories {

    private static CargoRepository storedCargoRepository;
    private static EmployeeRepository storedEmployeeRepository;
    private static HaulRepository storedHaulRepository;
    private static MilestoneRepository storedMilestoneRepository;
    private static OrderRepository storedOrderRepository;
    private static PlaceRepository storedPlaceRepository;
    private static VehicleRepository storedVehicleRepository;
    private static UserRepository storedUserRepository;

//    private static GenericRepository<AbstractPersistentObject> universalRepository;
//
//    static {
//        universalRepository = new GenericRepository<>(AbstractPersistentObject.class);
//    }

    public static CargoRepository getCargoRepository(){
        if(storedCargoRepository == null){
            storedCargoRepository = new CargoRepositoryImpl();
        }
        return storedCargoRepository;
    }

    public static EmployeeRepository getEmployeeRepository(){
        if(storedEmployeeRepository == null){
            storedEmployeeRepository = new EmployeeRepositoryImpl();
        }
        return storedEmployeeRepository;
    }

    public static HaulRepository getHaulRepository(){
        if(storedHaulRepository == null){
            storedHaulRepository = new HaulRepositoryImpl();
        }
        return storedHaulRepository;
    }

    public static MilestoneRepository getMilestoneRepository(){
        if(storedMilestoneRepository == null){
            storedMilestoneRepository = new MilestoneRepositoryImpl();
        }
        return storedMilestoneRepository;
    }

    public static OrderRepository getOrderRepository(){
        if(storedOrderRepository == null){
            storedOrderRepository = new OrderRepositoryImpl();
        }
        return storedOrderRepository;
    }

    public static PlaceRepository getPlaceRepository(){
        if(storedPlaceRepository == null){
            storedPlaceRepository = new PlaceRepositoryImpl();
        }
        return storedPlaceRepository;
    }

    public static UserRepository getUserRepository(){
        if(storedUserRepository == null){
            storedUserRepository = new UserRepositoryImpl();
        }
        return storedUserRepository;
    }

    public static VehicleRepository getVehicleRepository(){
        if(storedVehicleRepository == null){
            storedVehicleRepository = new VehicleRepositoryImpl();
        }
        return storedVehicleRepository;
    }
}

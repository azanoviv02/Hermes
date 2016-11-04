package com.hermes.domain.places;

/**
 * Created by ivan on 02.11.16.
 */
public class PlaceFactory {
    public static BasicCompanyBase createBasicCompanyBase(String name){
        return new BasicCompanyBase(name);
    }

    public static BasicClientBase createBasicClientBase(String name){
        return new BasicClientBase(name);
    }

    public static BasicFix createBasicFix(String name){
        return new BasicFix(name);
    }
}

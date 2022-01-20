package com.learn.app;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton, simple factory and simple factory method
 */
public final class  TravelByCar implements Travel{
    private static TravelByCar travelByCar = new TravelByCar();
    public static TravelByCar getInstance() {
        return travelByCar;
    }
    private TravelByCar() {
        init();
    }

    Map<String, Car> carMap = new HashMap<>();

    public void init() {
        System.out.println("init");
        carMap.put("Sedan",new Sedan());
        carMap.put("Minivan",new Minivan());
    }


    public Car getCar(String carType) {
        return carMap.get(carType);
    }

    public static void main(String[] args) {
        TravelByCar travelByCar =  TravelByCar.getInstance();
        System.out.println("travelByCar1:instanceId="+travelByCar.hashCode());
        Car car= travelByCar.getCar(4);
        car.start();
        // simple factory
        TravelByCar travelByCar2 =  TravelByCar.getInstance();
        System.out.println("travelByCar2:instanceId2="+travelByCar2.hashCode());

        car= travelByCar2.getCar("Minivan");
        car.start();
    }

    interface  Car {
        public void start();
    }

    public class  Sedan implements Car{
        public void start() {
            System.out.println("Sedan");
        }
    }

    public class  Minivan implements Car{
        public void start() {
            System.out.println("Minivan");
        }
    }

    @Override
    public Car getCar(int seats) {
        if(seats>4) {
          return  new Minivan();
        }

        return  new Sedan();

    }
}

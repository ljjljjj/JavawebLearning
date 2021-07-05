package com.bjpowernode.test;

import com.bjpowernode.entity.Car;
import com.bjpowernode.service.Engine;
import com.bjpowernode.serviceImpl.SprotEngine;
import com.bjpowernode.serviceImpl.SuvEngine;

public class TestMain {
    public static void main(String[] args) {
        //用户需要具有运动特征的汽车
        Engine engine= new SprotEngine();
        //用户需要SUV
        Engine engine1= new SuvEngine();

        Car car = new Car(engine);
        car.run();
    }
}


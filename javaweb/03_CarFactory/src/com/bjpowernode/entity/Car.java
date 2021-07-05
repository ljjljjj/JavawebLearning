package com.bjpowernode.entity;

import com.bjpowernode.service.Engine;

public class Car {
    private Engine engine;

    public Car(Engine engine){
        this.engine = engine;
    }
    public void run(){
        engine.run();
    }
}

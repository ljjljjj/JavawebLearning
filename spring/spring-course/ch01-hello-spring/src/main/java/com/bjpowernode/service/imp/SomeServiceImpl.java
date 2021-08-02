package com.bjpowernode.service.imp;

import com.bjpowernode.service.SomeService;

public class SomeServiceImpl implements SomeService {
    public SomeServiceImpl(){
        System.out.println("SomeServiceImpl的无参构造方法");
    }

    @Override
    public void dosome() {
        System.out.println("执行了SomeServiceImp的doSome()方法");
    }
}

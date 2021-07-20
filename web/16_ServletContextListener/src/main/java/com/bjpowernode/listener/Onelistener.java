package com.bjpowernode.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 对生命周期进行监听
 */
public class Onelistener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("恭喜恭喜，来世走一朝");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("兄弟别怕，迟早要去！");
    }
}

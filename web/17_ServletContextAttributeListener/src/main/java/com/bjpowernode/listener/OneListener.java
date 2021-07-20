package com.bjpowernode.listener;
/**
 * 对作用域对象进行监听
 */

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class OneListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("添加共享数据");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("删除共享数据");    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("更新共享数据");    }
}

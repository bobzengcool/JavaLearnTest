package com.bob.learn1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
    	
        ApplicationContext context = new ClassPathXmlApplicationContext("com/bob/learn1/Beans.xml");
        HelloWorld obj = context.getBean("helloWorld",HelloWorld.class);
        obj.getMessage();
    }
}
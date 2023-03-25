package com.ebank.beans.sessions;
import jakarta.ejb.Singleton;

@Singleton
public class HelloSessionBeans {
    public String sayHello(){
        return "Hello World!!!!";
    }
}

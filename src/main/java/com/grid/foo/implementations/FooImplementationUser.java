package com.grid.foo.implementations;

import org.springframework.stereotype.Component;

@Component
public class FooImplementationUser {
    private final FooImplementation fooImplementation;

    FooImplementationUser(FooImplementation fooImplementation){
        this.fooImplementation=fooImplementation;
    }

    public void printMessage(){
        System.out.println("Injected via implementation ====> "+ fooImplementation.getMessage());
    }
}

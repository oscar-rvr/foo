package com.grid.foo.implementations;

import com.grid.foo.interfaces.Foo;
import org.springframework.stereotype.Component;

@Component
public class FooImplementation implements Foo {
    @Override
    public String getMessage(){
        return "Hello World";
    }
}

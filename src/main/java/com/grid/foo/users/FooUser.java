package com.grid.foo.users;

import com.grid.foo.interfaces.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FooUser {
    private Foo foo;

    @Autowired
    public FooUser(Foo foo){
        this.foo = foo;
    }

    public void printMessage(){
        System.out.println("Injected Via Interface ====> "+ foo.getMessage()
        );
    }
}

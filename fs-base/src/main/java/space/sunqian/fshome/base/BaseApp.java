package space.sunqian.fshome.base;

import jakarta.annotation.PostConstruct;

public class BaseApp {

    @PostConstruct
    public void start() {
        System.out.println("Starts BaseApp!");
    }
}

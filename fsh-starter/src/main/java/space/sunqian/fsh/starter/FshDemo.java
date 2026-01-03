package space.sunqian.fsh.starter;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import space.sunqian.fs.app.di.InjectedApp;
import space.sunqian.fs.base.system.JvmKit;

public class FshDemo {

    public static void main(String[] args) {
        InjectedApp app = InjectedApp.newBuilder()
            .resourceTypes(SomeApp.class)
            .build();
        app.shutdown();
    }

    public static class SomeApp {

        @Resource
        private SomeService someService;

    }

    public static class SomeService {

        @PostConstruct
        public void init() {
            helloWorld();
        }

        public void helloWorld() {
            System.out.println(JvmKit.javaMajorVersion());
            System.out.println("hello world");
        }
    }
}

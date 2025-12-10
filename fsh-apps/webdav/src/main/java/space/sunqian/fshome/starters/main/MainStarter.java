package space.sunqian.fshome.starters.main;

import space.sunqian.common.app.di.InjectedApp;
import space.sunqian.fshome.base.BaseApp;

public class MainStarter {

    static void main() {
        InjectedApp.newBuilder()
            .resourceTypes(BaseApp.class)
            .build();
    }
}

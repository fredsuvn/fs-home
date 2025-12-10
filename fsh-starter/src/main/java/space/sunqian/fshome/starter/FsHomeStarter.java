package space.sunqian.fshome.starter;

import space.sunqian.common.app.di.InjectedApp;
import space.sunqian.fshome.apps.webdav.WebDavApp;

public class FsHomeStarter {

    public static void main(String[] args) {
        InjectedApp app = InjectedApp.newBuilder()
            .resourceTypes(WebDavApp.class)
            .build();
    }
}

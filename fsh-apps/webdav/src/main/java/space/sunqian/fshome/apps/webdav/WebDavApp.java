package space.sunqian.fshome.apps.webdav;

import jakarta.annotation.PostConstruct;
import org.apache.catalina.Wrapper;
import org.apache.catalina.servlets.WebdavServlet;
import org.apache.catalina.startup.Tomcat;

public class WebDavApp {

    @PostConstruct
    public void start() throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8888);
        tomcat.getConnector();
        //tomcat.setBaseDir("D:\\webdav\\");
        tomcat.addContext("/webdav", "D:\\webdav\\");
        WebdavServlet webdavServlet = new WebdavServlet();
        Wrapper wrapper = tomcat.addServlet("/webdav", "WebDAVServlet", webdavServlet);
        wrapper.addInitParameter("debug", "0");
        wrapper.addInitParameter("listings", "true");
        wrapper.addInitParameter("readonly", "false");
        wrapper.addInitParameter("propertyStore", WebdavServlet.MemoryPropertyStore.class.getName());
        wrapper.addMapping("/*");
        tomcat.start();
        tomcat.getServer().await();
        tomcat.addServlet("/webdav", "WebDAVServlet2", webdavServlet);
    }
}

package com.koala.service;

import com.google.common.base.Throwables;
import org.apache.commons.io.FilenameUtils;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class KoalaHttpServer {
  private static final Logger LOGGER = LoggerFactory.getLogger(KoalaHttpServer.class);

  private static final String DB_PROPERTIES = "db.properties";
  private final Server server;
  private String confDir;

  public KoalaHttpServer(String confDir, int port) {
    this.confDir = confDir;
    server = new Server(port);
  }

  public void start() throws Exception {
    System.setProperty("log.path", "./log");
    System.setProperty(MyBatisUtil.MYBATIS_DB_PROPERTIES, FilenameUtils.concat(confDir, DB_PROPERTIES));
    WebAppContext webAppContext = new WebAppContext();
    webAppContext.setContextPath("/");
    webAppContext.setWar(confDir + "/webapp");
    webAppContext.setServer(server);
    server.setHandler(webAppContext);
    server.start();
  }

  public void stop() {
    try {
      server.stop();
    } catch (Exception e) {
      LOGGER.error("Http server stopped failed : {}", Throwables.getStackTraceAsString(e));
    }
  }

  public static void main(String[] args) throws Exception {
    String confDir = "./config/";
    int port = 9090;

    if (args.length >= 1)
      confDir = args[0];
    else
      System.out.println("Need config dir.");

    if (args.length == 2)
      port = Integer.valueOf(args[1]);

    KoalaHttpServer httpServer = new KoalaHttpServer(confDir, port);
    httpServer.start();
  }
}

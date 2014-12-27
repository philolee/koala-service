package com.koala.service;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;

public class KoalaServer {

  private HttpServer server;

  public KoalaServer(int port) throws Exception {
    final URI BASE_URI = URI.create("http://0.0.0.0:" + port);

    Set<Class<?>> classSet = new HashSet<>();
    classSet.add(KoalaResource.class);
    classSet.add(JacksonFeature.class);
    final ResourceConfig rc = new ResourceConfig(classSet);
    rc.register(CrossDomainFilter.class);
    server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
  }

  public void start() throws IOException, InterruptedException {
    server.start();
    while (true) {
      Thread.sleep(10000);
    }
  }

  public void close() {
    server.shutdown();
  }

  public static void main(String[] args) throws Exception {
    KoalaServer server = new KoalaServer(9090);
    server.start();
  }
}

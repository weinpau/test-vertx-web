package org.pw.test.vertx.web;

import io.vertx.core.Vertx;

/**
 * @author weinpau
 */
public class App {


    public static void main(String... args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new HelloWorld());
    }
}

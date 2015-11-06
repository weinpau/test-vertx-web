package org.pw.test.vertx.web;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

/**
 * @author weinpau
 */
public class HelloWorld extends AbstractVerticle {


    @Override
    public void start() throws Exception {

        Router router = Router.router(vertx);


        router.route("/").handler(routingContext -> {
            HttpServerResponse response = routingContext.response();
            response
                    .putHeader("content-type", "text/html")
                    .end("<h1>Hello from my first Vert.x 3 application</h1>");
        });

        vertx.createHttpServer()
              .requestHandler(router::accept)
              .listen(port());

    }

    public static int port() {
        String port = System.getenv("PORT");
        if (port == null) {
            return 8080;
        } else {
            return Integer.parseInt(port);
        }
    }

}

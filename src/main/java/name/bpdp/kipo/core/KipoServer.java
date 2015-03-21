package name.bpdp.kipo.core;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.apex.Router;

import name.bpdp.kipo.helper.KipoRunner;

/*
 * @author <a href="http://bpdp.name">Bambang Purnomosidi</a>
 *
 */
public class KipoServer extends AbstractVerticle {

  public static void main(String[] args) {
    KipoRunner.runKipo(KipoServer.class);
  }

  @Override
  public void start() throws Exception {

    Router router = Router.router(vertx);

    router.route().handler(routingContext -> {
      routingContext.response().putHeader("content-type", "text/html").end("Hello World!");
    });

    vertx.createHttpServer().requestHandler(router::accept).listen(8080);
  }
}

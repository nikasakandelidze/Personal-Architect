package web.requester.groupChat;

import io.vertx.core.Vertx;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class VertxInitializer {

    @PostConstruct
    void initializeVertex() {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new ChatVerticle());
        vertx.deployVerticle(new ChatServiceHandlerVerticle());
    }

}

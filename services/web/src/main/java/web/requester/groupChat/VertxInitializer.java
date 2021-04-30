package web.requester.groupChat;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Verticle;
import io.vertx.core.Vertx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class VertxInitializer {
    @Autowired
    @Qualifier("chatVerticle")
    private Verticle chatVerticle;
    @Autowired
    @Qualifier("chatServiceHandler")
    private Verticle chatServiceHandler;
    @Autowired
    @Qualifier("chatServiceWorkerVerticle")
    private Verticle chatServiceProviderVerticle;

    @PostConstruct
    void initializeVertex() {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(chatVerticle);
        vertx.deployVerticle(chatServiceHandler);
        vertx.deployVerticle(chatServiceProviderVerticle, new DeploymentOptions().setWorker(true));
    }

}

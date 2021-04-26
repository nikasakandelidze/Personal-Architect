package web;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Verticle;
import io.vertx.core.Vertx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import web.requester.auth.AuthenticationVerticle;
import web.validator.UserValidatorVerticle;

import javax.annotation.PostConstruct;

@SpringBootApplication
@ComponentScan(basePackages = {"service","web","storage"})
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

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
        vertx.deployVerticle(new AuthenticationVerticle());
        vertx.deployVerticle(new UserValidatorVerticle());
    }

}

package web.requester.groupChat.config;

import io.vertx.core.Verticle;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import web.requester.groupChat.ChatServiceHandlerVerticle;
import web.requester.groupChat.ChatVerticle;

@Configuration
public class ChatVerticlesConfiguration {

    @Bean
    @Qualifier("chatVerticle")
    public Verticle chatVerticle() {
        return new ChatVerticle();
    }

    @Bean
    @Qualifier("chatServiceHandler")
    public Verticle chatServiceHandlerVerticle() {
        return new ChatServiceHandlerVerticle();
    }
}

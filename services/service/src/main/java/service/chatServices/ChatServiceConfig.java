package service.chatServices;

import io.vertx.core.Verticle;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatServiceConfig {
    @Bean
    @Qualifier("chatServiceWorkerVerticle")
    public Verticle chatServiceWorkerVerticle() {
        return new ChatServiceProviderWorkerVerticle();
    }
}

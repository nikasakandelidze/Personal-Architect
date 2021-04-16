package service.chatServices;

import io.vertx.core.AbstractVerticle;

class ChatServiceProviderWorkerVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        vertx.eventBus().consumer(ChatServiceEventBus.PRIVATE_CHAT_SERVICE_BUS, msg -> {
            System.out.println((String) msg.body());
        });
        vertx.eventBus().consumer(ChatServiceEventBus.GROUP_CHAT_SERVICE_BUS, msg -> {
            System.out.println((String) msg.body());
        });
    }
}

package web.requester.groupChat;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.Message;
import org.springframework.beans.factory.annotation.Autowired;
import service.chatServices.ChatServiceProvider;
import web.requester.groupChat.eventBus.EventBusConstants;

public class ChatServiceHandlerVerticle extends AbstractVerticle {

    @Autowired
    private ChatServiceProvider chatServiceProvider;

    public static final String DELIMITER = ":";

    @Override
    public void start() throws Exception {
        super.start();
        vertx.eventBus().consumer(EventBusConstants.GROUP_CHAT_EVENT_BUS_ADDR, this::serveSendingGroupChatMessage);
        vertx.eventBus().consumer(EventBusConstants.PERSONAL_CHAT_EVENT_BUS_ADDR, this::serveSendingPersonalChatMessage);
    }

    private void serveSendingGroupChatMessage(Message<Object> msg) {
        String message = (String) msg.body();
        String[] array = message.split(DELIMITER);
        msg.reply(String.format("Sent message from user with id:%s, to group with id:%s", array[0], array[1]));
    }


    private void serveSendingPersonalChatMessage(Message<Object> msg) {
        vertx.executeBlocking(promise -> {
            String message = (String) msg.body();
            String[] array = message.split(DELIMITER);
            chatServiceProvider.sendMessageFromUserToUser(array[0], array[1]);
            promise.complete(array);
        }, result -> {
            String[] array = (String[]) result.result();
            msg.reply(String.format("Sent message from user with id:%s, to user with id:%s", array[0], array[1]));
        });
    }
}

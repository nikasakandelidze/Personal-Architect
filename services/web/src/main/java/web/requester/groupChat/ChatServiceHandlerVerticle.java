package web.requester.groupChat;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.eventbus.Message;
import web.requester.groupChat.eventBus.EventBusConstants;
import web.requester.groupChat.eventBus.EventBusChatDto;

public class ChatServiceHandlerVerticle extends AbstractVerticle {

    public static final String DELIMITER = ":";

    @Override
    public void start() throws Exception {
        super.start();
        vertx.eventBus().consumer(EventBusConstants.GROUP_CHAT_EVENT_BUS_ADDR, this::serveGroupChatMessage);
        vertx.eventBus().consumer(EventBusConstants.PERSONAL_CHAT_EVENT_BUS_ADDR, this::servePersonalChatMessage);
    }

    private void serveGroupChatMessage(Message<Object> msg) {
        String message = (String) msg.body();
        String[] array = message.split(DELIMITER);
        msg.reply(String.format("Sent message from user with id:%s, to group with id:%s", array[0], array[1]));
    }


    private void servePersonalChatMessage(Message<Object> msg) {
        String message = (String) msg.body();
        String[] array = message.split(DELIMITER);
        msg.reply(String.format("Sent message from user with id:%s, to user with id:%s", array[0], array[1]));
    }
}

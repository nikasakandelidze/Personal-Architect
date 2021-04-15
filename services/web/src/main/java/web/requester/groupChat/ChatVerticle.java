package web.requester.groupChat;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import web.requester.groupChat.eventBus.EventBusChatDto;
import web.requester.groupChat.eventBus.EventBusConstants;

public class ChatVerticle extends AbstractVerticle {

    public static final String DELIMITER = ":";

    @Override
    public void start() {
        Router router = Router.router(vertx);
        router.get("/api/chat/group/:fromUserId/:toGroupId").handler(ctx -> {
            String toGroupId = ctx.pathParam("toGroupId");
            String fromUserId = ctx.pathParam("fromUserId");
            vertx.eventBus().request(EventBusConstants.GROUP_CHAT_EVENT_BUS_ADDR, fromUserId + DELIMITER + toGroupId, replyMsg -> {
                ctx.request().response().end((String) replyMsg.result().body());
            });
        });
        router.get("/api/chat/personal/:fromUserId/:toUserId").handler(ctx -> {
            String toUserId = ctx.pathParam("toUserId");
            String fromUserId = ctx.pathParam("fromUserId");
            vertx.eventBus().request(EventBusConstants.PERSONAL_CHAT_EVENT_BUS_ADDR, fromUserId + DELIMITER + toUserId, replyMsg -> {
                ctx.request().response().end((String) replyMsg.result().body());
            });
        });

        vertx.createHttpServer().requestHandler(router).listen(8081);
    }
}

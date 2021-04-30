package web.validator;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;
import web.commons.EventBusConstants;

public class UserValidatorVerticle extends AbstractVerticle {
    public static final String RESEARCHER = "researcher";
    public static final String ADMIN = "admin";

    @Override
    public void start() throws Exception {
        vertx.eventBus().consumer(EventBusConstants.VALIDATOR_ADDR, this::validatorHandler);
        vertx.eventBus().consumer(EventBusConstants.ROLE_CHECKER_ADDR, this::roleCheckerHandler);
    }

    private void roleCheckerHandler(Message<JsonObject> input) {
        final String username = input.body().getString("username");
        if (username.equals("nika")) {
            input.reply(new JsonObject().put("role", RESEARCHER));
        } else if (username.equals("gio")) {
            input.reply(new JsonObject().put("role", ADMIN));
        }
    }

    private void validatorHandler(Message<JsonObject> req) {
        final JsonObject body = req.body();
        final String username = body.getString("username");
        final String password = body.getString("password");
        final boolean valid = isValid(username, password);
        req.reply(new JsonObject().put("isValid", valid));
    }

    /*
     * Nika - Researcher
     *
     * Gio - Admin
     *
     * Notice! In some blogs it was written that role in jwt is not a good practice! We should read more about it.
     * */
    private boolean isValid(String username, String password) {
        return (username.equals("nika") && password.equals("123"))
                || (username.equals("gio") && password.equals("123"));
    }
}

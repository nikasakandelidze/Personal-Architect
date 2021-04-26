package web.requester.auth;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.JWTOptions;
import io.vertx.ext.auth.PubSecKeyOptions;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.auth.jwt.JWTAuthOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.JWTAuthHandler;
import web.commons.EventBusConstants;
import web.utils.UtilCrypto;

import java.io.IOException;

//todo: some api with restricted access, some with broad access

/*
 *  2 Users: 1) Nika - Researcher  2) Gio - Admin
 *  2 Endpoints: 1) /researcher/api    2)/admin/api
 */


public class AuthenticationVerticle extends AbstractVerticle {
    private JWTAuth jwtAuth;
    public static final int PORT = 8083;

    @Override
    public void start(Promise<Void> startPromise) throws Exception {

        setupJwtAuth();

        Router router = Router.router(vertx);

        router.route().handler(BodyHandler.create());

        router.get("/authorize").handler(this::token);

        router.get("/user/api")
                .handler(JWTAuthHandler.create(jwtAuth))
                .handler(ctx -> checkUser(ctx, "user"))
                .handler(ctx -> processAuthorizedRequest(ctx, "Hi from researcher"));

        router.get("/admin/api")
                .handler(JWTAuthHandler.create(jwtAuth))
                .handler(ctx -> checkUser(ctx, "admin"))
                .handler(ctx -> processAuthorizedRequest(ctx, "Hi from admin"));


        vertx.createHttpServer()
                .requestHandler(router)
                .listen(PORT)
                .onSuccess(e -> System.out.println("Started"))
                .onFailure(e -> System.out.println("Failed to Start"));
    }

    private void setupJwtAuth() throws IOException {
        final String privateKey = UtilCrypto.privateKey();
        final String publicKey = UtilCrypto.publicKey();
        jwtAuth = JWTAuth.create(vertx, new JWTAuthOptions().
                addPubSecKey(new PubSecKeyOptions().setAlgorithm("RS256").setBuffer(publicKey))
                .addPubSecKey(new PubSecKeyOptions().setAlgorithm("RS256").setBuffer(privateKey)));
    }

    private void processAuthorizedRequest(RoutingContext routingContext, String message) {
        routingContext.response().setStatusCode(200).end(message);
    }

    private void checkUser(RoutingContext ctx, String role) {
        String roleClaim = ctx.user().principal().getString("role");
        if (!role.equals(roleClaim)) {
            ctx.request().response().setStatusCode(403).end();
        } else {
            ctx.next();
        }
    }

    private void token(RoutingContext ctx) {
        JsonObject payload = ctx.getBodyAsJson();
        String username = payload.getString("username");
        String password = payload.getString("password");

        vertx.eventBus().<JsonObject>request(EventBusConstants.VALIDATOR_ADDR, new JsonObject().put("username", username).put("password", password), ar -> {
            final String isValid = ar.result().body().getString("isValid");
            if (isValid.equalsIgnoreCase("true")) {
                generateAndSendToken(ctx, username);
            } else {
                ctx.response().setStatusCode(403).end();
            }
        });

    }

    private void generateAndSendToken(RoutingContext ctx, String username) {
        vertx.eventBus().<JsonObject>request(EventBusConstants.ROLE_CHECKER_ADDR, new JsonObject().put("username", username), ar -> {
            final String token = makeJwtToken(username, ar.result().body().getString("role"));
            sendToken(ctx, token);
        });
    }

    private void sendToken(RoutingContext ctx, String token) {
        ctx.response().putHeader("Content-Type", "application/jwt").end(token);
    }

    private String makeJwtToken(String username, String role) {
        JsonObject claims = new JsonObject()
                .put("role", role);
        JWTOptions jwtOptions = new JWTOptions()
                .setAlgorithm("RS256")
                .setExpiresInMinutes(10_080) // 7 days
                .setIssuer("vertx-jwt-issuer")
                .setSubject(username);
        return jwtAuth.generateToken(claims, jwtOptions);
    }
}

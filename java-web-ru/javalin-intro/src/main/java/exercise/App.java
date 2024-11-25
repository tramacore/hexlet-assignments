package exercise;

import io.javalin.Javalin;

public final class App {

    public static Javalin getApp() {
        var app= Javalin.create(javalinConfig -> javalinConfig.bundledPlugins.enableDevLogging());
        app.get("/welcome", ctx -> ctx.result("Welcome to Hexlet!"));
        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}

package exercise;

import io.javalin.Javalin;

import java.util.List;

public final class App {

    public static Javalin getApp() {
        var app = Javalin.create(javalinConfig -> {
            javalinConfig.bundledPlugins.enableDevLogging();
        });

        app.get("/phones", ctx -> {
            List<String> phones = Data.getPhones();
            ctx.json(phones); // Возвращаем список телефонов в формате JSON
        });

        app.get("/domains", ctx -> {
            List<String> domains = Data.getDomains();
            ctx.json(domains); // Возвращаем список доменов в формате JSON
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
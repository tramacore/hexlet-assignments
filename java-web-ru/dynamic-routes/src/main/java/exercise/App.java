package exercise;

import io.javalin.Javalin;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import exercise.Data;

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });


        app.get("/companies/{id}", ctx -> {
            boolean found = false;
            for (Map<String, String> comps : COMPANIES) {
                if (comps.containsValue(ctx.pathParam("id"))) {
                    ctx.json(comps);
                    found = true;
                    break;
                }
            }
            if (!found) {
                ctx.status(404).result("Company not found");
            }
        });

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}

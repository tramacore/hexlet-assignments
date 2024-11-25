package exercise;

import io.javalin.Javalin;

import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        app.get("/users", ctx -> {
            // Получаем параметры page и per
            int page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
            int per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);

            // Вычисляем индексы для выборки
            int fromIndex = (page - 1) * per;
            int toIndex = Math.min(fromIndex + per, USERS.size());

            // Проверяем, что fromIndex не выходит за пределы
            if (fromIndex >= USERS.size()) {
                ctx.json(List.of()); // Возвращаем пустой список, если страница пустая
                return;
            }

            // Получаем подсписок пользователей
            List<Map<String, String>> paginatedUsers = USERS.subList(fromIndex, toIndex);
            ctx.json(paginatedUsers); // Возвращаем подсписок пользователей в формате JSON
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
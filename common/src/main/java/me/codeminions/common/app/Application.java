package me.codeminions.common.app;

import me.codeminions.factory.bean.db.User;

public class Application extends android.app.Application {
    private static User currentUser = null;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        Application.currentUser = currentUser;
    }
}

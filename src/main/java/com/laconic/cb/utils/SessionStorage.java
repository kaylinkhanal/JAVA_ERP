package com.laconic.cb.utils;

import javax.servlet.http.HttpSession;

public class SessionStorage {

    public static void setStorage(HttpSession session, String key, Object object) {
        var storage = session.getAttribute(key);
        if (storage != null) {
            session.invalidate();
            session.setAttribute(key, object);
        } else {
            session.setAttribute(key, object);
        }
    }

    public static Object getStorage(HttpSession session, String key) {
        var storage = session.getAttribute(key);
        if (storage != null) {
            return storage;
        }
        return null;
    }

    public static void destroy(HttpSession session) {
        session.invalidate();
    }
}

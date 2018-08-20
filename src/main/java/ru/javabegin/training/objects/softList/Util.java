package ru.javabegin.training.objects.softList;

import javax.servlet.http.HttpSession;

public class Util {
    public static boolean sessionCheck(HttpSession session)
    {
        if (session==null) return false;
        return true;
    }
}

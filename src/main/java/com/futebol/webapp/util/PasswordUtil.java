package com.futebol.webapp.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtil {
    private static final PasswordEncoder passwordEnconder = new BCryptPasswordEncoder();


    public static String encoderPassword(String password){
        return passwordEnconder.encode(password);
    }
}

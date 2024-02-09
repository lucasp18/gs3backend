package org.example.util;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Hash {


    public static String password(String password){
        //BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //return bCryptPasswordEncoder.encode(password);
        return password;
    }

    public static String username(String name){
        return null;
    }

}

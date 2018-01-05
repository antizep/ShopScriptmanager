package services;

import models.Authentification;

import java.util.LinkedList;

public class SessionService {

    public static final int ROLE_ADMIN = 1;

    private static LinkedList<Authentification> authentifications = new LinkedList<>();

    public static void addAuthentication(Authentification auth) {

        authentifications.add(auth);

    }

    public static void deleteAuthentication(Authentification auth){
        authentifications.remove(auth);
    }

    public static boolean hasAuth(Authentification auth){

        if(authentifications.size()>0) {
            int id= authentifications.indexOf(auth);
            auth.setRole(authentifications.get(id).getRole());
            return authentifications.contains(auth);
        }else {
            return false;
        }

    }

}

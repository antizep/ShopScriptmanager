package services;

import models.Authentification;

import java.util.LinkedList;

public class SessionService {

    private static LinkedList<Authentification> authentifications = new LinkedList<>();

    public static void addAuthentication(Authentification auth) {

        authentifications.add(auth);

    }

    public static void deleteAuthentication(Authentification auth){
        authentifications.remove(auth);
    }

    public boolean hasAuth(Authentification auth){
        return authentifications.contains(auth);
    }

}

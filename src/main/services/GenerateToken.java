package services;

import models.Authentification;

public class GenerateToken {

    public static String generateToken(Authentification account){

        Hasher hasher = new Hasher();
        String token = hasher.generateHash(account.getUserId());

        return token;

    }
}

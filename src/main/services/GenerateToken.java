package services;

import models.Authentication;

public class GenerateToken {

    public static String generateToken(Authentication account){

        Hasher hasher = new Hasher();
        String token = hasher.generateHash(account.getUserId());

        return token;

    }
}

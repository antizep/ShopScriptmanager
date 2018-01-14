package services;

import models.Authentication;

import java.util.LinkedList;

public class SessionService {

    public static final int ROLE_ADMIN = 1;

    private static LinkedList<Authentication> authentications = new LinkedList<>();

    public static void addAuthentication(Authentication auth) {

        authentications.add(auth);

    }

    public static void deleteAuthentication(Authentication auth){
        authentications.remove(auth);
    }

    public static boolean hasAuth(Authentication auth){

        if(authentications.size()>0) {
            int id= authentications.indexOf(auth);
            if(id!=-1) {
                auth.setRole(authentications.get(id).getRole());
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }

    }

}

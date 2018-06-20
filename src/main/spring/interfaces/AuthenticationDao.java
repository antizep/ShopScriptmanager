package spring.interfaces;

import spring.entity.EntityAuthentication;

public interface AuthenticationDao {

    EntityAuthentication auntification (EntityAuthentication entityAuthentication);
    EntityAuthentication save(EntityAuthentication entityAuthentication);
    
    boolean searshByLogin(String login);

}

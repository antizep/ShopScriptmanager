package spring.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.entity.EntityAuthentication;

public interface AuthentificationRepository extends CrudRepository<EntityAuthentication, Long> {

    EntityAuthentication findAuthenticationEntityByLoginAndPassword(String login, String password);

}

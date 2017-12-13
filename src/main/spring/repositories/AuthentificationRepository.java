package spring.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.entity.AuthenticationEntity;
import spring.entity.RolesEntity;

public interface AuthentificationRepository extends CrudRepository<AuthenticationEntity, Long> {

    AuthenticationEntity findAuthenticationEntityByLoginAndPassword(String login, String password);

}

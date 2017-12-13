package spring.interfaces;

import org.springframework.data.repository.CrudRepository;
import spring.entity.AuthenticationEntity;

public interface AuthenticationDao {

    AuthenticationEntity auntification (AuthenticationEntity authenticationEntity);

}

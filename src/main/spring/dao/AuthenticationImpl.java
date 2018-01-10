package spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.EntityAuthentication;
import spring.interfaces.AuthenticationDao;
import spring.repositories.AuthentificationRepository;

@Service("jpaAuthenticationService")
@Repository
@Transactional

public class AuthenticationImpl implements AuthenticationDao {

    @Autowired
    AuthentificationRepository repository;

    @Override
    public EntityAuthentication auntification(EntityAuthentication entityAuthentication) {

        return repository.findAuthenticationEntityByLoginAndPassword(entityAuthentication.getLogin(), entityAuthentication.getPassword());

    }
}

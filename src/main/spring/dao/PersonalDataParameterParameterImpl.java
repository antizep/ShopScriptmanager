package spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.EntityPersonalDataParameter;
import spring.interfaces.PersonalDataParameterDao;
import spring.repositories.PersonalDataParameterRepository;

@Service("jpaPersonalDataParameter")
@Repository
@Transactional
public class PersonalDataParameterParameterImpl implements PersonalDataParameterDao {

    @Autowired
    PersonalDataParameterRepository repository;

    @Override
    public EntityPersonalDataParameter save(EntityPersonalDataParameter personalDataParameter) {
        return repository.save(personalDataParameter);
    }
}

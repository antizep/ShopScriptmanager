package spring.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.entity.EntityPersonalDataParameter;

public interface PersonalDataParameterRepository extends CrudRepository<EntityPersonalDataParameter , Integer> {
}

package spring.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.entity.EntityPersonalData;

public interface PersonalDataRepository extends CrudRepository<EntityPersonalData, Integer> {
}

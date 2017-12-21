package spring.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.entity.EntityProvider;

public interface ProviderRepository extends CrudRepository<EntityProvider , Long> {
}

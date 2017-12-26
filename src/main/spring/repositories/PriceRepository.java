package spring.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.entity.EntityPrice;

public interface PriceRepository extends CrudRepository<EntityPrice , Long> {
}

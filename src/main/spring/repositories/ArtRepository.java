package spring.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.entity.EntityArt;

public interface ArtRepository extends CrudRepository<EntityArt, Long> {
}

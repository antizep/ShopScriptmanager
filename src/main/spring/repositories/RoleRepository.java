package spring.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.entity.EntityRoles;

public interface RoleRepository extends CrudRepository<EntityRoles, Integer> {
    EntityRoles findByIdRole(int id);
    EntityRoles findByName(String name);
}

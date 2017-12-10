package spring.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.RolesEntity;

public interface RoleRepository extends CrudRepository<RolesEntity, Integer> {
    RolesEntity findByIdRole(int id);
}

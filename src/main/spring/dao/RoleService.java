package spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.EntityRoles;
import spring.interfaces.RoleDao;
import spring.repositories.RoleRepository;


@Service("jpaAuntificationRoleService")
@Repository
@Transactional
public class RoleService implements RoleDao {
    final
    RoleRepository repository;

    @Autowired
    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public EntityRoles findById(int id) {
        return repository.findByIdRole(id);
    }

    @Override
    public EntityRoles findByName(String name) {
        return repository.findByName(name);
    }
}

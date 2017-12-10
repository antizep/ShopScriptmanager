package spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.RolesEntity;
import spring.interfaces.RoleDao;
import spring.interfaces.RoleRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Service("jpaAuntificationService")
@Repository
@Transactional
public class RoleService implements RoleDao {
    @Autowired
    RoleRepository repository;

    @Override
    public RolesEntity findById(int id) {
        return repository.findByIdRole(id);
    }
}

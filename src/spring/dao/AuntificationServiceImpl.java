package spring.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.EntityAuntification;
import spring.interfaces.AuntificationService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service("jpaAuntificationService")
@Repository
@Transactional
public class AuntificationServiceImpl implements AuntificationService {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<EntityAuntification> findAll() {
        return null;
    }

    @Transactional
    @Override
    public EntityAuntification auntification(String login, String password) {
        TypedQuery<EntityAuntification> query = em.createNamedQuery("EntityAuntification.auntif", EntityAuntification.class);
        query.setParameter("login", login);
        query.setParameter("password", password);

        EntityAuntification e = query.getSingleResult();

        return e;
    }


    @Override
    public void update(EntityAuntification auntification) {

        em.merge(auntification);

    }

    @Override
    public void save(EntityAuntification auntification) {

        em.persist(auntification);
    }

}

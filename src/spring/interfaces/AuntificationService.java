package spring.interfaces;

import spring.entity.EntityAuntification;

import java.util.List;

public interface AuntificationService {
    List<EntityAuntification> findAll();

    EntityAuntification auntification(String login, String password);

    void save(EntityAuntification auntification);

    void update(EntityAuntification auntification);
}

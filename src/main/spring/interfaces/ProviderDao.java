package spring.interfaces;

import spring.entity.EntityProvider;

import java.util.List;

public interface ProviderDao {

    EntityProvider save(EntityProvider provider);
    List<EntityProvider> selectAll();
}

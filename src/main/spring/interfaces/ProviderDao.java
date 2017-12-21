package spring.interfaces;

import spring.entity.EntityProvider;

public interface ProviderDao {

    EntityProvider save(EntityProvider provider);

}

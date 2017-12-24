package spring.dao;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.EntityProvider;
import spring.interfaces.ProviderDao;
import spring.repositories.ProviderRepository;

import java.util.ArrayList;
import java.util.List;


@Service("jpaProviderService")
@Repository
@Transactional
public class ProviderImpl implements ProviderDao {

    @Autowired
    ProviderRepository repository;

    @Override
    public EntityProvider save(EntityProvider provider) {

        return repository.save(provider);

    }

    @Override
    public List<EntityProvider> selectAll() {
        return Lists.newArrayList(repository.findAll());
    }
}

package spring.dao;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.EntityArt;
import spring.interfaces.ArtDao;
import spring.repositories.ArtRepository;

import java.util.List;

@Service("jpaArt")
@Repository
@Transactional
public class ArtImpl implements ArtDao {

    final
    private ArtRepository repository;

    @Autowired
    public ArtImpl(ArtRepository repository) {
        this.repository = repository;
    }


    @Override
    public EntityArt save(EntityArt entityArt) {

        return repository.save(entityArt);

    }

    @Override
    public List<EntityArt> saveAll(List<EntityArt> arts) {

        return Lists.newArrayList(repository.saveAll(arts));

    }

}

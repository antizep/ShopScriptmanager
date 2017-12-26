package spring.dao;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.EntityPrice;
import spring.interfaces.PriceDao;
import spring.repositories.PriceRepository;

import java.util.List;

@Service("jpaPrice")
@Repository
@Transactional

public class PriceImpl implements PriceDao {

    @Autowired
    PriceRepository repository;

    @Override
    public List<EntityPrice> saveAll(List<EntityPrice> price) {

        return Lists.newArrayList(repository.saveAll(price));

    }

    @Override
    public List<EntityPrice> findAll() {

        return Lists.newArrayList(repository.findAll());

    }
}

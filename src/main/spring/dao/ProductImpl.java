package spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.EntityProduct;
import spring.interfaces.ProductDao;
import spring.repositories.ProductRepository;

@Service("jpaProduct")
@Repository
@Transactional

public class ProductImpl implements ProductDao {

    @Autowired
    ProductRepository repository;

    @Override
    public EntityProduct save(EntityProduct product) {
        return repository.save(product);
    }
}

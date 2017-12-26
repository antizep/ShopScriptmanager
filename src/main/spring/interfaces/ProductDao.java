package spring.interfaces;

import spring.entity.EntityProduct;

public interface ProductDao {
    EntityProduct save(EntityProduct product);
}

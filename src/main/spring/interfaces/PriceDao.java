package spring.interfaces;

import spring.entity.EntityPrice;

import java.util.List;

public interface PriceDao {
    List<EntityPrice> saveAll(List<EntityPrice> prices);
    List<EntityPrice> findAll();
}

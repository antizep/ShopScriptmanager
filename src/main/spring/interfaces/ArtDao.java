package spring.interfaces;

import spring.entity.EntityArt;

import javax.validation.constraints.Null;
import java.util.List;

public interface ArtDao {

    EntityArt save(EntityArt entityArt);
    List<EntityArt> saveAll(List<EntityArt> arts);

}

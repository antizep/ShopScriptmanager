package spring.interfaces;

import spring.entity.EntityRoles;

public interface RoleDao {
    EntityRoles findById(int id);
    EntityRoles findByName(String name);
}

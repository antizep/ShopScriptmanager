package spring.interfaces;

import spring.entity.RolesEntity;

public interface RoleDao {
    RolesEntity findById(int id);
}

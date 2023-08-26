package com.example.demo.Service;

import com.example.demo.Dao.RoleDao;
import com.example.demo.Entity.Role;
import com.example.demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    public Role createRole(Role newRole) {
        return roleDao.createRole(newRole);
    }

    public Role createOrUpdateRole(Role newOrUpdatedRole) {
        return roleDao.createOrUpdateRole(newOrUpdatedRole);
    }

    public void deleteRoleById(Long roleId) {
        roleDao.deleteRoleById(roleId);
    }
}

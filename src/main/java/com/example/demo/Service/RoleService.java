package com.example.demo.Service;

import com.example.demo.Dao.RoleDao;
import com.example.demo.Entity.Role;
import com.example.demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    public Role createRole(Role newRole) {
        newRole.setCreatedAt(LocalDate.now());
        newRole.setUpdatedAt(LocalDate.now());
        return roleDao.createRole(newRole);
    }

    public Role createOrUpdateRole(Role newOrUpdatedRole) {
        Role newRole = new Role();
        newRole.setRoleId(newOrUpdatedRole.getRoleId());
        newRole.setUpdatedAt(LocalDate.now());
        newRole.setName(newOrUpdatedRole.getName());
        return roleDao.createOrUpdateRole(newRole);
    }

    public void deleteRoleById(Long roleId) {
        roleDao.deleteRoleById(roleId);
    }
}

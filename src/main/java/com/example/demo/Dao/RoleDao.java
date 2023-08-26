package com.example.demo.Dao;

import com.example.demo.Entity.Role;
import com.example.demo.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleDao {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role createRole(Role newRole) {
        return roleRepository.save(newRole);
    }

    public Role createOrUpdateRole(Role newOrUpdatedRole) {
        return roleRepository.save(newOrUpdatedRole);
    }

    public void deleteRoleById(Long roleId) {
        roleRepository.deleteById(roleId);
    }
}

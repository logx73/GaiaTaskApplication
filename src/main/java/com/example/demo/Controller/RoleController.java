package com.example.demo.Controller;

import com.example.demo.Entity.Role;
import com.example.demo.Entity.User;
import com.example.demo.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/role")
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    @PostMapping(value = "/saveRole")
    public ResponseEntity<Role> createRols(@RequestBody Role newRole) {
        return ResponseEntity.ok(roleService.createRole(newRole));
    }

    @PutMapping(value = "/saveRole")
    public ResponseEntity<Role> createOrUpdateRole(@RequestBody Role newOrUpdatedRole) {
        return ResponseEntity.ok(roleService.createOrUpdateRole(newOrUpdatedRole));
    }

    @DeleteMapping(value = "/deleteRole/{roleId}")
    public void deleteRoleById(@PathVariable("roleId") Long roleId) {
        roleService.deleteRoleById(roleId);
    }
}

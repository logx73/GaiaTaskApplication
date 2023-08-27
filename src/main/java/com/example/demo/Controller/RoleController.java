package com.example.demo.Controller;

import com.example.demo.Entity.Role;
import com.example.demo.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PreAuthorize("hasRole('ROLE_SUPERADMIN','ROLE_CLIENTADMIN','ROLE_SITEADMIN','ROLE_SITEUSER')")
    @GetMapping(value = "/role")
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @PostMapping(value = "/saveRole")
    public ResponseEntity<Role> createRols(@RequestBody Role newRole) {
        return ResponseEntity.ok(roleService.createRole(newRole));
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @PutMapping(value = "/saveRole")
    public ResponseEntity<Role> createOrUpdateRole(@RequestBody Role newOrUpdatedRole) {
        return ResponseEntity.ok(roleService.createOrUpdateRole(newOrUpdatedRole));
    }

    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    @DeleteMapping(value = "/deleteRole/{roleId}")
    public void deleteRoleById(@PathVariable("roleId") Long roleId) {
        roleService.deleteRoleById(roleId);
    }
}

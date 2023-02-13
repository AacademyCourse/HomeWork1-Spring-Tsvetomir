package com.example.homeworkOne.service;


import com.example.homeworkOne.entity.Role;
import com.example.homeworkOne.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getRole(Long id) {
        Role findRole = new Role();
        if (this.roleRepository.findById(id).isPresent()) {
            findRole = this.roleRepository.findById(id).get();
        }
        return findRole;
    }

    public Role addRole(Role role) {
        Role newRole = new Role();
     //   newRole.setRole(role.getRole());
        return this.roleRepository.save(newRole);
    }

    public void deleteRole(Long id) {
        this.roleRepository.deleteById(id);
    }
}
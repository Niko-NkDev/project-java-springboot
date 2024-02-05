package com.nikonkdev.MySchoolAPP.controllers;

import com.nikonkdev.MySchoolAPP.entities.Role;
import com.nikonkdev.MySchoolAPP.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Se realiza el controlador para realizar un CRUD de la entidad Curso
 */
@RestController
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/role-list") public List<Role> findAll(){
        List<Role> roleList = roleRepository.findAll();

        return roleList;
    }

    @PostMapping("/create-role") public Role create(@RequestBody Role role){
        Role roleResponse = roleRepository.save(role);

        return roleResponse;
    }

    @PutMapping("/update-role") public Role update(@RequestBody Role role){
        Role roleResponse = roleRepository.save(role);

        return roleResponse;
    }

    @DeleteMapping("/delete-role/{id}") public String delete(@PathVariable Long id){
        roleRepository.deleteById(id);

        return "Se elimino el rol con el id: " + id;
    }

}

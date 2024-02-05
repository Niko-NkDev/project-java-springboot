package com.nikonkdev.MySchoolAPP.controllers;

import com.nikonkdev.MySchoolAPP.entities.Gender;
import com.nikonkdev.MySchoolAPP.repositories.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Se realiza el controlador para realizar un CRUD de la entidad Genero
 */
@RestController
public class GenderController {
    @Autowired
    private GenderRepository genderRepository;

    @GetMapping("/gender-list") public List<Gender> findAll(){
        List<Gender> gendersList = genderRepository.findAll();

        return gendersList;

    }

    @PostMapping("/create-gender-type") public Gender create(@RequestBody Gender gender){
        Gender genderResponse = genderRepository.save(gender);

            return genderResponse;
    }

    @PutMapping("/update-gender-type") public Gender update(@RequestBody Gender gender){
        Gender genderResponse = genderRepository.save(gender);

            return genderResponse;

    }

    @DeleteMapping("/delete-gender-type/{id}") public String delete(@PathVariable Long id){
        genderRepository.deleteById(id);

        return "Se elimino el tipo de genero con el id: " + id;
    }
}

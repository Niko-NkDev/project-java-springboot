package com.nikonkdev.MySchoolAPP.controllers;

import com.nikonkdev.MySchoolAPP.entities.DocumentType;
import com.nikonkdev.MySchoolAPP.entities.Institution;
import com.nikonkdev.MySchoolAPP.repositories.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Se realiza el controlador para realizar un CRUD de la entidad Institucion
 */
@RestController
public class InstitutionController {

    @Autowired private InstitutionRepository institutionRepository;

    @GetMapping("/institution-list") public List<Institution> findAll() {
        return institutionRepository.findAll();
    }

    @PostMapping("/crate-institution-usser") public Institution create(@RequestBody Institution institution) {
        Institution institutionResponse = institutionRepository.save(institution);

        return institutionResponse;
    }

    @PutMapping("/upgrade-institution-usser") public Institution update(@RequestBody Institution institution){
        Institution institutionResponse = institutionRepository.save(institution);

        return institutionResponse;
    }

    @DeleteMapping("/delete-institution-usser/{id}") public String delete(@PathVariable Long id){
        institutionRepository.deleteById(id);

        return "Se elimino el usuario de la institucion con el id: " + id;
    }
}

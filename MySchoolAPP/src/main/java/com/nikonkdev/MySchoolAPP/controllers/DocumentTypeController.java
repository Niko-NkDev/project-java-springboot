package com.nikonkdev.MySchoolAPP.controllers;

import com.nikonkdev.MySchoolAPP.entities.DocumentType;
import com.nikonkdev.MySchoolAPP.repositories.DocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Se realiza el controlador para realizar un CRUD de la entidad Tipo de Dcoumento
 */
@RestController
public class DocumentTypeController {
    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    @GetMapping("/document-type-list") public List<DocumentType> findAll(){
        List<DocumentType> documentTypeList = documentTypeRepository.findAll();

        return documentTypeList;
    }

    @PostMapping("/create-document-type") public DocumentType create(@RequestBody DocumentType documentType){
        DocumentType documentTypeResponse = documentTypeRepository.save(documentType);

        return documentTypeResponse;
    }

    @PutMapping("/update-document-type") public DocumentType update(@RequestBody DocumentType documentType){
        DocumentType documetTypeResponse = documentTypeRepository.save(documentType);

        return documetTypeResponse;
    }

    @DeleteMapping("/delete-document-type/{id}") public String delete(@PathVariable Long id){
        documentTypeRepository.deleteById(id);

        return "Se elimino el tipo de documento con el id: " + id;

    }
}

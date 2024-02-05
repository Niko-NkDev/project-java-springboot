package com.nikonkdev.MySchoolAPP.repositories;

import com.nikonkdev.MySchoolAPP.entities.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Se crea la interface repository que hereda de JPA(Java Persistence API) repository
 */
@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {

}

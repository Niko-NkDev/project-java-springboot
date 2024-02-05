package com.nikonkdev.MySchoolAPP.repositories;

import com.nikonkdev.MySchoolAPP.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Se crea la interface repository que hereda de JPA(Java Persistence API) repository
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

}

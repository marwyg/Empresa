package de.virtuos.empresa.repository;

import de.virtuos.empresa.entity.EmpresaUser;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface EmpresaUserRepository extends CrudRepository<EmpresaUser, Integer> {

    EmpresaUser findByUsername(String username);

}

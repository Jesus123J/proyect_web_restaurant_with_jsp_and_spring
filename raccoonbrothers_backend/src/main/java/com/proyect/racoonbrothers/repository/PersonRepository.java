package com.proyect.racoonbrothers.repository;

import com.proyect.racoonbrothers.data.entity.PersonTb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonTb,Long> {
    Optional<PersonTb> findByEmail(String email);

    Optional<PersonTb> findByIdAccount(Long idAccount);

    Optional<PersonTb> findByDni(String dni);
//    Optional<PersonTb> findByEmail(String email);
}

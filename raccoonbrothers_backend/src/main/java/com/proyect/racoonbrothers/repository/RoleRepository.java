package com.proyect.racoonbrothers.repository;

import com.proyect.racoonbrothers.data.entity.RoleTb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleTb,Integer> {

    Optional<RoleTb> findById(Integer id);

}

package com.proyect.racoonbrothers.repository;

import com.proyect.racoonbrothers.data.entity.RecordOrderTb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecordOrderRepository extends JpaRepository<RecordOrderTb,Long> {

//    Encuentra el primer registro de la tabla ordenada por el id de manera descendente
    Optional<RecordOrderTb> findFirstByOrderByIdDesc();

}

package com.proyect.racoonbrothers.repository;

import com.proyect.racoonbrothers.data.entity.RecordNoticeTb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecordNoticeRepository extends JpaRepository<RecordNoticeTb,Long> {
    Optional<RecordNoticeTb> findByIdAccount(Long idAccount);
}

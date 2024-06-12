package com.proyect.racoonbrothers.repository;

import com.proyect.racoonbrothers.data.entity.OtpTb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OtpRepository extends JpaRepository<OtpTb,Long> {
    Optional<OtpTb> findByIdAccount(Long idAccount);
}

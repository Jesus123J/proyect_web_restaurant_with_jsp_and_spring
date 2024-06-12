package com.proyect.racoonbrothers.repository;

import com.proyect.racoonbrothers.data.entity.AccountTb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountTb,Long> {


    Optional<AccountTb> findByUsername(String username);

    Optional<AccountTb> findByUsernameAndPassword(String username, String password);

    Optional<AccountTb> findByIdAndStatusNot(Long idAccount, Integer status);
}

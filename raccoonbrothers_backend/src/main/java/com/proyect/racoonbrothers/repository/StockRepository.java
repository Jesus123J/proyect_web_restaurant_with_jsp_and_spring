package com.proyect.racoonbrothers.repository;

import com.proyect.racoonbrothers.data.entity.StockTb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<StockTb,Integer> {
}

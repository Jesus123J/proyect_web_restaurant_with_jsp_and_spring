package com.proyect.racoonbrothers.repository;

import com.proyect.racoonbrothers.data.entity.HistoryStockTb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryStockRepository extends JpaRepository<HistoryStockTb,Long>{
}

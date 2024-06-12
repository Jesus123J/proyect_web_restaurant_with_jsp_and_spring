package com.proyect.racoonbrothers.repository;

import com.proyect.racoonbrothers.data.entity.OrderProductTb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProductTb,Long> {

}

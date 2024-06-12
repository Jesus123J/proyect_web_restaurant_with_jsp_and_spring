package com.proyect.racoonbrothers.repository;

import com.proyect.racoonbrothers.data.entity.ProductTb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductTb,Integer> {

    

}

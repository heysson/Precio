package com.between.precio.repository;
import com.between.precio.entity.Prices;

import java.util.List;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PricesRepository extends JpaRepository <Prices,Long> {
    
    @Query("SELECT p FROM Prices p WHERE p.startDate <= :fecha and p.endDate >= :fecha and p.productId = :idProduct and p.brandId = :idCadena" )
    public List<Prices> findByIdFecha(@Param("idProduct") int idProduct, @Param("fecha") Date fechaApli, @Param("idCadena") int idCadena);
}

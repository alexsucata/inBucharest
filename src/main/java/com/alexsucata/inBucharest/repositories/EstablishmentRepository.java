package com.alexsucata.inBucharest.repositories;


import com.alexsucata.inBucharest.entities.EstablishmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstablishmentRepository extends JpaRepository<EstablishmentEntity, Integer> {


}

package com.alexsucata.inBucharest.repositories;

import com.alexsucata.inBucharest.entities.EstablishmentTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EstablishmentTypeRepository extends JpaRepository<EstablishmentTypeEntity, Integer> {

}

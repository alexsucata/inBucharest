package com.alexsucata.inBucharest.repositories;


import com.alexsucata.inBucharest.entities.PhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<PhotoEntity, Integer> {
}

package com.bosonit.SA2.infraestructure.repository;

import com.bosonit.SA2.domain.FileEnt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository <FileEnt,Integer> {
    FileEnt findByName(String name);
}

package com.uemura.ufood.repositories;

import com.uemura.ufood.domains.Entities.CidadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<CidadeEntity, Long> {

}


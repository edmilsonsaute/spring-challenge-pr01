package com.challenge.application01.features.provincia;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinciaRepository extends CrudRepository<ProvinciaModel,Long> {
    
}

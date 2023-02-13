package com.example.JavaFluxProject.repository;

import com.example.JavaFluxProject.entity.Menu;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface MenuRepository extends ReactiveMongoRepository<Menu,String> {

    public Flux<Menu> findByName(String name);
}

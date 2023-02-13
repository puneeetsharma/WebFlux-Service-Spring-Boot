package com.example.JavaFluxProject.services;

import com.example.JavaFluxProject.dto.MenuDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MenuService {

    public Flux<MenuDto> getAllMenuItems();
    public Mono<MenuDto> getMenuItem(String id);
    public Mono<MenuDto> saveMenuItem(MenuDto menuDto);
    public Mono<MenuDto> updateMenuItem(MenuDto menuDtoMono,String id);
    public Mono<Void> deleteById(String id);
    public Flux<MenuDto> findByName(String name);


}

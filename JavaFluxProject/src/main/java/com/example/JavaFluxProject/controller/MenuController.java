package com.example.JavaFluxProject.controller;

import com.example.JavaFluxProject.dto.MenuDto;
import com.example.JavaFluxProject.entity.Menu;
import com.example.JavaFluxProject.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;


    @GetMapping(value = "/getAllMenuItems")
    public Flux<MenuDto> getAllMenuItems()
    {
        return menuService.getAllMenuItems();
    }

    @GetMapping(value = "/getMenuItem/{id}")
    public Mono<MenuDto> getMenuItem(@PathVariable(value = "id") String id)
    {
        return menuService.getMenuItem(id);
    }


    @PostMapping(value = "/insertMenuItem")
    public Mono<MenuDto> insertMenuItem(@RequestBody MenuDto menuDto)
    {
        return menuService.saveMenuItem(menuDto);
    }

    @PostMapping(value = "/updateMenuIetm/{id}")
    public Mono<MenuDto> updateMenuIetm(@RequestBody MenuDto menuDtoMono , @PathVariable(value = "id") String id)
    {
        return menuService.updateMenuItem(menuDtoMono,id);
    }

    @DeleteMapping(value = "/deleteMenuItem/{id}")
    public Mono<Void> deleteMenuItem(@PathVariable(value = "id") String id)
    {
        return menuService.deleteById(id);
    }

    @GetMapping("/findMenuItemByName/{name}")
    public Flux<MenuDto> findMenuItemByName(@PathVariable(value = "name") String name)
    {
        return menuService.findByName(name);
    }

}

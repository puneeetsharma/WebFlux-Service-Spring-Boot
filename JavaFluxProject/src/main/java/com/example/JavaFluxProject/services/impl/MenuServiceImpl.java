package com.example.JavaFluxProject.services.impl;

import com.example.JavaFluxProject.dto.MenuDto;
import com.example.JavaFluxProject.entity.Menu;
import com.example.JavaFluxProject.repository.MenuRepository;
import com.example.JavaFluxProject.services.MenuService;
import com.example.JavaFluxProject.utils.CopyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public Flux<MenuDto> getAllMenuItems()
    {
        return menuRepository.findAll().map(CopyUtil::entityToDto);
    }

    @Override
    public Mono<MenuDto> getMenuItem(String id)
    {
        return menuRepository.findById(id).map(CopyUtil::entityToDto);
    }

    @Override
    public Mono<MenuDto> saveMenuItem(MenuDto menuDto) {

        Menu menu = CopyUtil.dtoToEntity(menuDto);
        return menuRepository.insert(menu)
                .map(CopyUtil::entityToDto);
    }

    @Override
    public Mono<MenuDto> updateMenuItem(MenuDto menuDto,String id)
    {
        Menu menu = CopyUtil.dtoToEntity(menuDto);
        menu.setId(id);

//        return menuRepository.findById(id)
//                .flatMap(m->menuDto.map(CopyUtil::dtoToEntity).doOnNext(i->i.setId(id)))
//                .flatMap(menuRepository::save)
//                .map(CopyUtil::entityToDto);


//         return menuRepository.findById(id)
//                 .doOnNext(i->i.setId(id))
//                 .doOnNext(i->{
//                     i.setName(menuDto.getName()),
//                     i.setPrice(menuDto.getPrice())
//                 })
//                 .flatMap(menuRepository::save)
//                 .map(CopyUtil::entityToDto);


        return menuRepository.save(menu)
               .map(CopyUtil::entityToDto);
    }

    @Override
    public Mono<Void> deleteById(String id)
    {
        return menuRepository.deleteById(id);
    }

    @Override
    public Flux<MenuDto> findByName(String name)
    {
        return menuRepository.findByName(name).map(CopyUtil::entityToDto);
    }



}

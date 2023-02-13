package com.example.JavaFluxProject.utils;

import com.example.JavaFluxProject.dto.MenuDto;
import com.example.JavaFluxProject.entity.Menu;
import org.springframework.beans.BeanUtils;

public class CopyUtil {
    public static MenuDto entityToDto(Menu menu)
    {
        MenuDto menuDto = new MenuDto();
        BeanUtils.copyProperties(menu,menuDto);
        return menuDto;
    }


    public static Menu dtoToEntity(MenuDto menuDto)
    {
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuDto,menu);
        return menu;
    }

}

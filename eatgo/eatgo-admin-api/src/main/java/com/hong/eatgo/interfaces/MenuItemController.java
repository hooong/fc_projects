package com.hong.eatgo.interfaces;

import com.hong.eatgo.application.MenuItemService;
import com.hong.eatgo.domain.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @GetMapping("/restaurants/{restaurantId}/menuitems")
    public List<MenuItem> getMenuitems(@PathVariable("restaurantId") Long restaurantId) {
        return menuItemService.getMenuItems(restaurantId);
    }

    @PatchMapping("/restaurants/{restaurantId}/menuitems")
    public String bulkUpdate(
            @PathVariable("restaurantId") Long id,
            @RequestBody List<MenuItem> menuItems
    ) {
        menuItemService.bulkUpdate(id, menuItems);

        return "";
    }

}

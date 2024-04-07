package com.example.CRUDassignment.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author shauna
 */
@RequestMapping("/items")
@Controller
public class ItemsController {

    @Autowired
    private ItemsService service;

    @GetMapping("/all")
    public String getItems(Model model) {
        model.addAttribute("itemList", service.getAllItems());
        return "items/list-items";
    }

    @GetMapping("/id={itemId}")
    public String getItem(@PathVariable long itemId, Model model) {
        model.addAttribute("item", service.getItemById(itemId));
        return "items/item-detail";
    }

    @GetMapping("/delete/id={itemId}")
    public String deleteItem(@PathVariable long itemId, Model model) {
        service.deleteItemById(itemId);
        return "redirect:/items/all";
    }

    @PostMapping("/create")
    public String createItem(Items item) {
        service.saveItem(item);
        return "redirect:/items/all";
    }

    @PostMapping("/update/id={itemId}")
    public String updateItem(@PathVariable long itemId, Items item) {
        service.saveItem(item);
        return "redirect:/items/all";
    }

    @GetMapping("/create")
    public String newItemForm(Model model) {
        Items item = new Items();
        model.addAttribute("item", item);
        model.addAttribute("isUpdate", false);
        return "items/update-item";
    }

    @GetMapping("/update/id={itemId}")
    public String updateItemForm(@PathVariable long itemId, Model model) {
        model.addAttribute("item", service.getItemById(itemId));
        model.addAttribute("isUpdate", true);
        model.addAttribute("itemList", service.getAllItems());
        return "items/update-item";
    }

}

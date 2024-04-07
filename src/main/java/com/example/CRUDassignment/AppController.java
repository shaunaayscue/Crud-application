package com.example.CRUDassignment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author shauna
 */
@Controller
public class AppController {

    @GetMapping({"/", ""})
    public String deleteItem() {

        return "redirect:/item/all";
    }
}

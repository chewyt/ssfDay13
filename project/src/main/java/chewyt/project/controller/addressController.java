package chewyt.project.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class addressController {

    @Autowired
    private Contact contact;

    @GetMapping(value = "/")
    public String getHome() {
        return "index";
    }

    @PostMapping(path = "/contact", consumes = "application/x-www-form-urlencoded", produces = "text/html")
    public String createContact(@ModelAttribute Contact contact, Model model) {

        contact.generateId();
        File file = null;
        ;
        try {
            file = contact.createFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        contact.writeData(file);
        return "index";
    }

    @GetMapping(path = "/contact/{id}")
    public String getId(@PathVariable String id, Model model){
        
        if (contact.loadfile(id)) {
            model.addAttribute("id", contact.getId());
            model.addAttribute("name", contact.getName());
            model.addAttribute("email", contact.getEmail());
            model.addAttribute("mobile", contact.getMobile());
            return "id";  
        } else {
            return "error";
        }
        
        
    }

}

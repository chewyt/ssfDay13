package chewyt.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class addressController {

    @GetMapping(value = "/")
    public String getHome() {
        return "index";
    }

    @RequestMapping(value="/contact", method=RequestMethod.POST)
    public void setContact(@RequestBody String param) {
        return new SomeData();
    }
    

}

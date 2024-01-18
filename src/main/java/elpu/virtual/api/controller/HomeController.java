package elpu.virtual.api.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/politicas")
    public String politicas() {
        return "politicas";
    }
    @GetMapping("/solicitudbaja")
    public String solicitudBaja() {
        return "solicitudbaja";
    }
}
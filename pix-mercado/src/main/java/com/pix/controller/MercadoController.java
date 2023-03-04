package com.pix.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/mercados")
public class MercadoController {

    @GetMapping("/test")
    public String ping() {
        return "pong";
    }

}

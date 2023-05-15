package com.vae.cursalumnes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api")
public class testControllerUno {

  @GetMapping("hola")
  public String test() {
    return "templates/view/hola.jsp";
  }

}

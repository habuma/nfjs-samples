package com.example.ubergraphbooks;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWebController {

  @GetMapping("/helloweb")
  public String helloWeb(Model model) {

    model.addAttribute("stuff", "<script>alert('hi')</script>");

    return "hello";
  }

}

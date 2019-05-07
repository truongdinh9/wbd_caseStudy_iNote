package com.codegym.controller;

import com.codegym.service.InotesManagerment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InoteController {
    @Autowired
    InotesManagerment inotesManagerment;
@GetMapping("/inote")
public ModelAndView listAll(Pageable pageable) {
    ModelAndView modelAndView=new ModelAndView("/inotes/list");
    modelAndView.addObject("inotes/",inotesManagerment.findAll(pageable));
    return modelAndView;
}

}
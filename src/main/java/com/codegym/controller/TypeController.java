package com.codegym.controller;

import com.codegym.model.Inote;
import com.codegym.model.Note_type;
import com.codegym.service.InotesManagerment;
import com.codegym.service.Type_InotesManagerment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TypeController {
    @Autowired
    Type_InotesManagerment typeManagerment;
    @Autowired
    InotesManagerment inotesManagerment;

    @GetMapping("/types")
    public ModelAndView listAll(@PageableDefault(value = 1) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("types/list");
        modelAndView.addObject("types", typeManagerment.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/types/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("types/create");
        modelAndView.addObject("type", new Note_type());
        return modelAndView;
    }

    @PostMapping("/types/save")
    public ModelAndView save(Note_type type, RedirectAttributes redirect) {
        typeManagerment.save(type);
        ModelAndView modelAndView = new ModelAndView("redirect:/types");
        redirect.addFlashAttribute("message", " A note_type was created");
        return modelAndView;
    }

    @GetMapping("/types/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        Note_type type = typeManagerment.findById(id);
        ModelAndView modelAndView = new ModelAndView("types/edit");
        modelAndView.addObject("type", type);
        return modelAndView;
    }

    @PostMapping("/types/edit")
    public ModelAndView edit(@ModelAttribute("type") Note_type type, RedirectAttributes redirect){
        typeManagerment.save(type);
        redirect.addFlashAttribute("message","Edited type successfully");
        return new ModelAndView("redirect:/types");
    }
    @GetMapping("types/views/{id}")
    public ModelAndView view(@PathVariable("id") Long id){
       Note_type type= typeManagerment.findById(id);
       Iterable<Inote> inotes =inotesManagerment.findAllbytype(type);
       ModelAndView modelAndView=new ModelAndView("types/view");
       modelAndView.addObject("type",type);
       modelAndView.addObject("inotes",inotes);
        return modelAndView;
    }
    @GetMapping("/types/delete/{id}")
    public ModelAndView delete(@PathVariable Long id){
        Note_type type=typeManagerment.findById(id);
        return new ModelAndView("types/delete", "type",type);
    }
    @PostMapping("/types/delete")
    public ModelAndView delete(Note_type type){
        typeManagerment.remove(type.getId());
        return new  ModelAndView("redirect:/types");
    }

}

package com.codegym.controller;

import com.codegym.model.Inote;
import com.codegym.model.Note_type;
import com.codegym.service.InotesManagerment;
import com.codegym.service.Type_InotesManagerment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class InoteController {
    @Autowired
    InotesManagerment inotesManagerment;
    @Autowired
    Type_InotesManagerment typeManagerment;

    @GetMapping("/inotes")
    public ModelAndView listAll(@PageableDefault(value = 5) Pageable pageable, @RequestParam("find") Optional<String> title,
                                @RequestParam("type") Optional<Note_type> type) {
        ModelAndView modelAndView = new ModelAndView("inotes/list");
        modelAndView.addObject("typ",type);
        modelAndView.addObject("types", typeManagerment.findAll());
        if (!(title.isPresent()&&type.isPresent())){
            modelAndView.addObject("inotes", inotesManagerment.findAll(pageable));
        }
        if (type.isPresent()) {
            modelAndView.addObject("inotes", inotesManagerment.findAllByType(type.get(), pageable));
        }else if (title.isPresent()){
            modelAndView.addObject("inotes",inotesManagerment.findAllByTitle(title.get(),pageable));
        }


        return modelAndView;
    }

    @GetMapping("/inotes/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("inotes/create");
        Iterable<Note_type> types = typeManagerment.findAll();
        modelAndView.addObject("types", types);
        modelAndView.addObject("inote", new Inote());
        return modelAndView;
    }

    @PostMapping("/inotes/save")
    public ModelAndView save(Inote inote, RedirectAttributes redirect) {
        inotesManagerment.save(inote);
        ModelAndView modelAndView = new ModelAndView("redirect:/inotes");
        redirect.addFlashAttribute("message", " A inote was created");
        return modelAndView;
    }

    @GetMapping("/inotes/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        Inote inote = inotesManagerment.findById(id);
        Iterable<Note_type> types = typeManagerment.findAll();
        ModelAndView modelAndView = new ModelAndView("inotes/edit");
        modelAndView.addObject("inote", inote);
        modelAndView.addObject("types", types);
        return modelAndView;
    }

    @PostMapping("/inotes/edit")
    public ModelAndView edit(@ModelAttribute("inote") Inote inote, RedirectAttributes redirect) {
        inotesManagerment.save(inote);
        redirect.addFlashAttribute("message", "Edited note successfully");
        return new ModelAndView("redirect:/inotes");
    }

    @GetMapping("/inotes/views/{id}")
    public ModelAndView view(@PathVariable("id") Long id) {
        Inote inote = inotesManagerment.findById(id);
        return new ModelAndView("inotes/view", "inote", inote);
    }

    @GetMapping("/inotes/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        Inote inote = inotesManagerment.findById(id);
        return new ModelAndView("inotes/delete", "inote", inote);
    }

    @PostMapping("/inotes/delete")
    public ModelAndView delete(Inote inote) {
        inotesManagerment.remove(inote.getId());
        return new ModelAndView("redirect:/inotes");
    }

}

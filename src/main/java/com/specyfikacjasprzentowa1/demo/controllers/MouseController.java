package com.specyfikacjasprzentowa1.demo.controllers;


import com.specyfikacjasprzentowa1.demo.command.MonitorCommand;
import com.specyfikacjasprzentowa1.demo.command.MouseCommand;
import com.specyfikacjasprzentowa1.demo.converters.MouseCommandToMouse;
import com.specyfikacjasprzentowa1.demo.converters.MouseToMouseCommand;
import com.specyfikacjasprzentowa1.demo.model.Mouse;
import com.specyfikacjasprzentowa1.demo.repositories.MouseRepository;
import com.specyfikacjasprzentowa1.demo.repositories.SpeakersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class MouseController {

    private MouseRepository mouseRepository;
    private SpeakersRepository speakersRepositoryRepository;
    private MouseCommandToMouse mouseCommandToMouse;
    private MouseToMouseCommand mouseToMouseCommand;

    public MouseController(MouseCommandToMouse mouseCommandToMouse, MouseToMouseCommand mouseToMouseCommand,MouseRepository mouseRepository, SpeakersRepository speakersRepository) {
        this.mouseRepository = mouseRepository;
        this.speakersRepositoryRepository = speakersRepository;
        this.mouseCommandToMouse = mouseCommandToMouse;
        this.mouseToMouseCommand = mouseToMouseCommand;
    }

    @RequestMapping(value = {"/mouse", "/mouse/list"})
    public String getMouse(Model model) {
        model.addAttribute("mouses", mouseRepository.findAll());
        return "mouse/list";
    }


    @GetMapping("/mouse/{id}/show")
    public String getMouseDetails(Model model, @PathVariable("id") Long id) {
        model.addAttribute("mouse", mouseRepository.findById(id).get());
        return "mouse/show";
    }

    @RequestMapping("/mouse/{id}/edit")
    public String editMouse(Model model, @PathVariable("id") Long id) {
        Mouse mouse = mouseRepository.findById(id).get();
        MouseCommand mouseCommand = mouseToMouseCommand.convert(mouse);
        model.addAttribute("mouse", mouseCommand);
        return "mouse/addedit";
    }

    @RequestMapping("/mouse/{id}/delete")
    public String deleteMouse(@PathVariable("id") Long id) {
        mouseRepository.deleteById(id);
        return "redirect:/mouse";
    }

    @GetMapping
    @RequestMapping("/mouse/new")
    public String newSpeakers(Model model){
        model.addAttribute("mouse", new MonitorCommand());
        return "mouse/addedit";
    }

    @PostMapping("mouse")
    public String saveOrUpdate(@ModelAttribute MouseCommand command){

        Optional<Mouse> mouseOptional = mouseRepository.getFirstByTypMyszyAndCzuloscMyszy(command.getTypMyszy(), command.getCzuloscMyszy());

        Mouse detachedSong = mouseCommandToMouse.convert(command);
        Mouse savedMouse = mouseRepository.save(detachedSong);

        return "redirect:/mouse/" + savedMouse.getId() + "/show";
    }
}

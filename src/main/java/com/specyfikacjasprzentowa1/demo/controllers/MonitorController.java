package com.specyfikacjasprzentowa1.demo.controllers;

import com.specyfikacjasprzentowa1.demo.command.MonitorCommand;
import com.specyfikacjasprzentowa1.demo.converters.MonitorCommandToMonitor;
import com.specyfikacjasprzentowa1.demo.model.Monitor;
import com.specyfikacjasprzentowa1.demo.repositories.ComputerRepository;
import com.specyfikacjasprzentowa1.demo.repositories.MonitorRepository;
import com.specyfikacjasprzentowa1.demo.repositories.MouseRepository;
import com.specyfikacjasprzentowa1.demo.repositories.SpeakersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MonitorController {

    private MonitorRepository monitorRepository;
    private MonitorCommandToMonitor monitorCommandToMonitor;
    private MouseRepository mouseRepository;
    private ComputerRepository computerRepository;
    private SpeakersRepository speakersRepository;

    public MonitorController(MonitorRepository monitorRepository, MonitorCommandToMonitor monitorCommandToMonitor, ComputerRepository computerRepository, MouseRepository mouseRepository, SpeakersRepository speakersRepository) {
        this.computerRepository = computerRepository;
        this.monitorRepository = monitorRepository;
        this.mouseRepository = mouseRepository;
        this.speakersRepository = speakersRepository;
        this.monitorCommandToMonitor = monitorCommandToMonitor;
    }

    @GetMapping
    @RequestMapping(value = {"/monitor" , "monitor/list"})
    public String getMonitor(Model model) {
        model.addAttribute("monitor", mouseRepository.findAll());
        return "monitor/list";
    }

    @GetMapping
    @RequestMapping("/song/{id}/show")
    public String getSongDetails(Model model, @PathVariable("id") Long id) {
        model.addAttribute("monitor", monitorRepository.findById(id).get());
        return "monitor/show";
    }


    @GetMapping
    @RequestMapping("/monitor/{id}/delete")
    public String deleteMonitor(@PathVariable("id") Long id) {
        monitorRepository.deleteById(id);
        return "redirect:/monitors";
    }

    @GetMapping
    @RequestMapping("/song/new")
    public String newMonitor(Model model){
        model.addAttribute("monitor", new MonitorCommand());
        model.addAttribute("mouse", mouseRepository.findAll());
        model.addAttribute("computer", computerRepository.findAll());
        model.addAttribute("speakers" , speakersRepository.findAll());
        return "monitor/addedit";
    }

    @PostMapping("monitor")
    public String saveOrUpdate(@ModelAttribute MonitorCommand command){
        Monitor detachedMonitor = monitorCommandToMonitor.convert(command);
        Monitor savedMonitor = monitorRepository.save(detachedMonitor);


        return "redirect:/monitor/" + savedMonitor.getId() + "/show";
    }
}

package com.specyfikacjasprzentowa1.demo.controllers;

import com.specyfikacjasprzentowa1.demo.command.SpeakersCommand;
import com.specyfikacjasprzentowa1.demo.converters.SpeakersCommandToSpeakers;
import com.specyfikacjasprzentowa1.demo.model.Monitor;
import com.specyfikacjasprzentowa1.demo.model.Speakers;
import com.specyfikacjasprzentowa1.demo.repositories.ComputerRepository;
import com.specyfikacjasprzentowa1.demo.repositories.MonitorRepository;
import com.specyfikacjasprzentowa1.demo.repositories.MouseRepository;
import com.specyfikacjasprzentowa1.demo.repositories.SpeakersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class SpeakersController {

    private MonitorRepository monitorRepository;
    private SpeakersCommandToSpeakers speakersCommandToSpeakers;
    private MouseRepository mouseRepository;
    private ComputerRepository computerRepository;
    private SpeakersRepository speakersRepository;

    public SpeakersController(SpeakersRepository speakersRepository, SpeakersCommandToSpeakers speakersCommandToSpeakers, MonitorRepository monitorRepository, MouseRepository mouseRepository, ComputerRepository computerRepository) {
        this.speakersCommandToSpeakers = speakersCommandToSpeakers;
        this.computerRepository = computerRepository;
        this.monitorRepository = monitorRepository;
        this.mouseRepository = mouseRepository;
        this.speakersRepository = speakersRepository;
    }

    @RequestMapping(value = {"/speakers" , "speakers/list"})
    public String getSpeakers(Model model) {
        model.addAttribute("speakers", speakersRepository.findAll());
        return "speakers/list";
    }

    @GetMapping
    @RequestMapping("/speakers/{id}/show")
    public String getSpeakersDetails(Model model, @PathVariable("id") Long id) {
        model.addAttribute("speakers", speakersRepository.findById(id).get());
        return "speakers/show";
    }

    @GetMapping
    @RequestMapping("/speakers/{id}/delete")
    public String deleteSpeakers(@PathVariable("id") Long id) {
        speakersRepository.deleteById(id);
        return "redirect:/speakers";
    }

    @GetMapping
    @RequestMapping("/speakers/new")
    public String newSpeakers (Model model){
        model.addAttribute("speakers", new SpeakersCommand());
        //model.addAttribute("mouse", mouseRepository.findAll());
        //model.addAttribute("computer", computerRepository.findAll());
        //model.addAttribute("monitor" , monitorRepository.findAll());
        return "speakers/addedit";
    }

    @PostMapping("speakers")
    public String saveOrUpdate(@ModelAttribute SpeakersCommand command){
        //Speakers detachedSpeakers = speakersCommandToSpeakers.convert(command);
        //Speakers savedSpeakers = speakersRepository.save(detachedSpeakers);
        //return "redirect:/speakers/" + savedSpeakers.getId() + "/show";


        Optional<Speakers> speakersOptional = speakersRepository.getSpeakersByTypZestawu(command.getTypZestawu());

        if (!speakersOptional.isPresent()) {
            Speakers detachedSpeakers = speakersCommandToSpeakers.convert(command);
            Speakers savedSpeakers = speakersRepository.save(detachedSpeakers);
            return "redirect:/speakers/" + savedSpeakers.getId() + "/show";
        } else {
            //TODO: error message to template
            System.out.println("Sorry, there's such speakers in db");
            return "redirect:/speakers/" + speakersOptional.get().getId() + "/show";
        }


    }
}

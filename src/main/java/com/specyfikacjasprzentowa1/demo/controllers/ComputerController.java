package com.specyfikacjasprzentowa1.demo.controllers;

import com.specyfikacjasprzentowa1.demo.command.ComputerCommand;
import com.specyfikacjasprzentowa1.demo.converters.ComputerCommandToComputer;
import com.specyfikacjasprzentowa1.demo.converters.ComputerToComputerCommand;
import com.specyfikacjasprzentowa1.demo.model.Computer;
import com.specyfikacjasprzentowa1.demo.repositories.ComputerRepository;
import com.specyfikacjasprzentowa1.demo.repositories.MonitorRepository;
import com.specyfikacjasprzentowa1.demo.repositories.MouseRepository;
import com.specyfikacjasprzentowa1.demo.repositories.SpeakersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ComputerController {

    private final ComputerRepository computerRepository;
    private final MonitorRepository monitorRepository;
    private final ComputerCommandToComputer computerCommandToComputer;
    private final ComputerToComputerCommand computerToComputerCommand;

    public ComputerController(ComputerCommandToComputer computerCommandToComputer, ComputerToComputerCommand computerToComputerCommand, ComputerRepository computerRepository, MonitorRepository monitorRepository, SpeakersRepository speakersRepository, MouseRepository mouseRepository) {
        this.computerRepository = computerRepository;
        this.monitorRepository = monitorRepository;
        this.computerCommandToComputer = computerCommandToComputer;
        this.computerToComputerCommand = computerToComputerCommand;
    }

    @RequestMapping(value = {"/computer", "/computer/list"})
    public String getComputer(Model model) {
        model.addAttribute("computer", computerRepository.findAll());
        return "computer/list";
    }

    @RequestMapping("/computer/{id}/monitor")
    public String getMonitor(Model model, @PathVariable("id") Long id) {
        Optional<Computer> computer = computerRepository.findById(id);

        if (computer.isPresent()) {
            model.addAttribute("monitors", monitorRepository.getAllByComputersIsContaining(computer.get()));
            model.addAttribute("filter", "computer: " + computer.get().getProcesor() + " " + computer.get().getKartaGraficzna());
        } else {
            model.addAttribute("monitors", new ArrayList<>());
            model.addAttribute("filter", "computer for this id doesn't exist");
        }

        return "monitor/list";
    }

    @GetMapping("/computer/{id}/show")
    public String getComputerDetails(Model model, @PathVariable("id") Long id) {
        model.addAttribute("computer", computerRepository.findById(id).get());
        return "computer/show";
    }

    @RequestMapping("/computer/{id}/edit")
    public String editComputer(Model model, @PathVariable("id") Long id) {
        Computer computer = computerRepository.findById(id).get();
        ComputerCommand computerCommand = computerToComputerCommand.convert(computer);
        model.addAttribute("computer", computerCommand);
        return "computer/addedit";
    }

    @RequestMapping("/computer/{id}/delete")
    public String deleteComputer(@PathVariable("id") Long id){
        computerRepository.deleteById(id);
        return "redirect:/computers";
    }


    @GetMapping
    @RequestMapping("/computer/new")
    public String newComputer (Model model){
        model.addAttribute("computer", new ComputerCommand());
        return "computer/addedit";
    }

    @PostMapping("computer")
    public String saveOrUpdate (@ModelAttribute ComputerCommand command){

        Optional<Computer> computerOptional = computerRepository.getFirstByProcesorAndKartaGraficzna(command.getProcesor(), command.getKartaGraficzna());

        if (!computerOptional.isPresent()) {
            Computer detachedComputer = computerCommandToComputer.convert(command);
            Computer savedComputer = computerRepository.save(detachedComputer);
            return "redirect:/computer/" + savedComputer.getId() + "/show";
        } else {
            //TODO: error message to template
            System.out.println("Sorry, there's such artist in db");
            return "redirect:/computer/" + computerOptional.get().getId() + "/show";
        }

    }


}

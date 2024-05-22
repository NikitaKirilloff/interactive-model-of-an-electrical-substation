package kirilloffna.interactiveModelOfAnElectricalSubstation.substations.controller;

import kirilloffna.interactiveModelOfAnElectricalSubstation.substations.entity.Substation;
import kirilloffna.interactiveModelOfAnElectricalSubstation.substations.service.SubstationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SubstationController { //TODO rename

  private final SubstationService substationService;

  @GetMapping("/substations")
  public String substation() {
    return "mainPage";
  }

  @GetMapping("/substations/create")
  public String createSubstation(Model model) {
    model.addAttribute("substation", new Substation());
    return "createSubstationPage";
  }

  @PostMapping("/substations/create")
  public String createSubstation(@ModelAttribute("substation") Substation substation) {
    substationService.saveSubstation(substation);
    return "redirect:/substations";
  }

  @GetMapping("/substations/viewing")
  public String viewingSubstation(Model model) {
    model.addAttribute("substations", substationService.getAllSubstations());
    return "viewingSubstationPage";
  }
}

package kirilloffna.interactiveModelOfAnElectricalSubstation.substations.service;

import kirilloffna.interactiveModelOfAnElectricalSubstation.substations.entity.Substation;
import kirilloffna.interactiveModelOfAnElectricalSubstation.substations.entity.SubstationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubstationService {

  private final SubstationRepository substationRepository;

  public void saveSubstation(Substation substation) {
    substationRepository.save(substation);
  }

  public List<Substation> getAllSubstations() {
    return substationRepository.findAll();
  }

  public Substation getSubstationByName(String name) {
    return substationRepository.findByName(name).orElseThrow();
  }

  public Substation getSubstationById(Long id) {
    return substationRepository.findById(id).orElseThrow();
  }

  public void updateSubstation(Long id, Substation substation) {
    if (substationRepository.existsById(id)) {
      Substation oldSubstation = substationRepository.findById(id).orElseThrow();
      substationRepository.delete(oldSubstation);
      substationRepository.save(substation);
    }
  }

  public void deleteSubstationByName(Substation substation) {
    if (substation != null) substationRepository.delete(substation);
  }

  public void deleteSubstationById(Long id) {
    if (id > 0) substationRepository.deleteById(id);
  }


}

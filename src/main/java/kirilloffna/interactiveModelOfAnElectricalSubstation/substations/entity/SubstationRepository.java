package kirilloffna.interactiveModelOfAnElectricalSubstation.substations.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubstationRepository extends JpaRepository<Substation, Long> {
  Optional<Substation> findByName(String name);
  Optional<Substation> findById(Long id);
}

package algebra.spring_boot.ProgramObrazovanja;

import algebra.spring_boot.Polaznik.Polaznik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProgramObrazovanjaRepository extends JpaRepository<ProgramObrazovanja, Integer> {

    Optional<ProgramObrazovanja> findById (Integer id);

    List<ProgramObrazovanja> fetchAll ();
}

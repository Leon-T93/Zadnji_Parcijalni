package algebra.spring_boot.Upis;

import algebra.spring_boot.Polaznik.Polaznik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UpisRespository extends JpaRepository<Upis, Integer> {

    Optional<Upis> findById (Integer id);

    List<Upis> findAll ();
}

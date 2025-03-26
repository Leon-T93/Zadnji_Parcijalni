package algebra.spring_boot.Polaznik;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PolaznikRepository extends JpaRepository<Polaznik, Integer> {


    Optional<Polaznik> findById (Integer id);

    List<Polaznik> fetchAll ();
}

package algebra.spring_boot.Polaznik;

import java.util.List;
import java.util.Optional;

public interface PolaznikService {

    Optional<Polaznik> findById (Integer id);

    List<Polaznik> fetchAll ();
}

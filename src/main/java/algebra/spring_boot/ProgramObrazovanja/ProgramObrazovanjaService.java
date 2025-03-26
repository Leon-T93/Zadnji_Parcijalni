package algebra.spring_boot.ProgramObrazovanja;

import java.util.List;
import java.util.Optional;

public interface ProgramObrazovanjaService {

    Optional<ProgramObrazovanja> findById (Integer id);

    List<ProgramObrazovanja> fetchAll ();
}

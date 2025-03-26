package algebra.spring_boot.Upis;

import java.util.List;
import java.util.Optional;

public interface UpisService {

    Optional<Upis> findById (Integer id);

    List<Upis> fetchAll ();
}

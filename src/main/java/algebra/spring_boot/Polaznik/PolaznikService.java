package algebra.spring_boot.Polaznik;

import algebra.spring_boot.Polaznik.dto.CreatePolaznikDto;

import java.util.List;
import java.util.Optional;

public interface PolaznikService {

    Optional<Polaznik> findById (Integer id);

    List<Polaznik> findAll ();

    Polaznik create (CreatePolaznikDto dto);
}

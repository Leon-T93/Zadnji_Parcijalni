package algebra.spring_boot.ProgramObrazovanja;

import algebra.spring_boot.Polaznik.Polaznik;
import algebra.spring_boot.Polaznik.dto.CreatePolaznikDto;
import algebra.spring_boot.ProgramObrazovanja.dto.CreateProgramObrazovanjaDto;

import java.util.List;
import java.util.Optional;

public interface ProgramObrazovanjaService {

    Optional<ProgramObrazovanja> findById (Integer id);

    List<ProgramObrazovanja> findAll ();

    ProgramObrazovanja create (CreateProgramObrazovanjaDto dto);
}

package algebra.spring_boot.Upis;

import algebra.spring_boot.ProgramObrazovanja.ProgramObrazovanja;
import algebra.spring_boot.ProgramObrazovanja.dto.CreateProgramObrazovanjaDto;
import algebra.spring_boot.Upis.dto.CreateUpisDto;

import java.util.List;
import java.util.Optional;

public interface UpisService {

    Optional<Upis> findById (Integer id);

    List<Upis> findAll ();

    Upis create (CreateUpisDto dto);
}

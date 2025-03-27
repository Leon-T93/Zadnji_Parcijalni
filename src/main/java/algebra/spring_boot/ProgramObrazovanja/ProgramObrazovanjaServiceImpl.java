package algebra.spring_boot.ProgramObrazovanja;

import algebra.spring_boot.ProgramObrazovanja.dto.CreateProgramObrazovanjaDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProgramObrazovanjaServiceImpl implements ProgramObrazovanjaService{

    private final ProgramObrazovanjaRepository programObrazovanjaRepository;

    @Override
    public Optional<ProgramObrazovanja> findById(Integer id) {
        return programObrazovanjaRepository.findById(id);
    }

    @Override
    public List<ProgramObrazovanja> findAll() {
        return programObrazovanjaRepository.findAll();
    }

    @Override
    public ProgramObrazovanja create(CreateProgramObrazovanjaDto dto) {
        ProgramObrazovanja programObrazovanja = new ProgramObrazovanja(dto.getNaziv(),dto.getCsvet());
        return programObrazovanjaRepository.save(programObrazovanja);
    }
}

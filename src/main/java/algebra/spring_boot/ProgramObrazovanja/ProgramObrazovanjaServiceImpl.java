package algebra.spring_boot.ProgramObrazovanja;

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
    public List<ProgramObrazovanja> fetchAll() {
        return programObrazovanjaRepository.fetchAll();
    }
}

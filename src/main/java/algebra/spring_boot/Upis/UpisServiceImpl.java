package algebra.spring_boot.Upis;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UpisServiceImpl implements UpisService{


    private final UpisRespository upisRespository;


    @Override
    public Optional<Upis> findById(Integer id) {
        return upisRespository.findById(id);
    }

    @Override
    public List<Upis> fetchAll() {
        return upisRespository.fetchAll();
    }
}

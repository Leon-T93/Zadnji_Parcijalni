package algebra.spring_boot.ProgramObrazovanja;

import algebra.spring_boot.Polaznik.Polaznik;
import algebra.spring_boot.Polaznik.PolaznikRepository;
import algebra.spring_boot.Polaznik.PolaznikServiceImpl;
import algebra.spring_boot.Polaznik.dto.CreatePolaznikDto;
import algebra.spring_boot.ProgramObrazovanja.dto.CreateProgramObrazovanjaDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProgramObrazovanjaServiceImplTest {

    @InjectMocks
    private ProgramObrazovanjaServiceImpl programObrazovanjaService;

    @Mock
    private ProgramObrazovanjaRepository programObrazovanjaRepositoryMock;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testFindById() {
        ProgramObrazovanja programObrazovanja = new ProgramObrazovanja("Programiranje",5);

        when(programObrazovanjaRepositoryMock.findById(programObrazovanja.getId())).thenReturn(Optional.of(programObrazovanja));

        programObrazovanjaService.findById(programObrazovanja.getId());

        verify(programObrazovanjaRepositoryMock, times(1)).findById(programObrazovanja.getId());
    }

    @Test
    public void testFindAll() {
        ProgramObrazovanja programObrazovanja = new ProgramObrazovanja("Programiranje",5);
        ProgramObrazovanja programObrazovanja2 = new ProgramObrazovanja("Matematika",4);

        List<ProgramObrazovanja> programObrazovanjaList = new ArrayList<>();
        programObrazovanjaList.add(programObrazovanja);
        programObrazovanjaList.add(programObrazovanja2);

        when(programObrazovanjaRepositoryMock.findAll()).thenReturn(programObrazovanjaList);

        programObrazovanjaService.findAll();

        verify(programObrazovanjaRepositoryMock, times(1)).findAll();
    }

    @Test
    public void testCreate() {
        CreateProgramObrazovanjaDto dto = new CreateProgramObrazovanjaDto("Programiranje", 5);
        ProgramObrazovanja programObrazovanja = new ProgramObrazovanja(dto.getNaziv(), dto.getCsvet());

        when(programObrazovanjaRepositoryMock.save(programObrazovanja)).thenReturn(programObrazovanja);

        programObrazovanjaService.create(dto);

        verify(programObrazovanjaRepositoryMock,times(1)).save(programObrazovanja);
    }

}
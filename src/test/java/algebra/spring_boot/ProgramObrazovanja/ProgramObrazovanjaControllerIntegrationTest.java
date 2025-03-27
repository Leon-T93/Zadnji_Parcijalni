package algebra.spring_boot.ProgramObrazovanja;

import algebra.spring_boot.Polaznik.PolaznikController;
import algebra.spring_boot.Polaznik.PolaznikRepository;
import algebra.spring_boot.Polaznik.PolaznikService;
import algebra.spring_boot.ProgramObrazovanja.dto.CreateProgramObrazovanjaDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ProgramObrazovanjaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProgramObrazovanjaController programObrazovanjaController;

    @Autowired
    private ProgramObrazovanjaService programObrazovanjaService;

    @Autowired
    private ProgramObrazovanjaRepository programObrazovanjaRepository;


    private CreateProgramObrazovanjaDto createProgramObrazovanjaDto = new CreateProgramObrazovanjaDto("Programiranje",5);


    @Test
    void testFindAll() throws Exception {
        mockMvc.perform(get("/programiObrazovanja")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    void testFindById() throws Exception {
        mockMvc.perform(get("/programiObrazovanja/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }



    @Test
    void create() throws Exception {
        mockMvc.perform(post("/programiObrazovanja")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createProgramObrazovanjaDto))
                )
                .andExpect(status().isCreated());
    }




}
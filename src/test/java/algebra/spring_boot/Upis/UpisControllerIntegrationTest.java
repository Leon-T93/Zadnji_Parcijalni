package algebra.spring_boot.Upis;

import algebra.spring_boot.ProgramObrazovanja.ProgramObrazovanjaController;
import algebra.spring_boot.ProgramObrazovanja.ProgramObrazovanjaRepository;
import algebra.spring_boot.ProgramObrazovanja.ProgramObrazovanjaService;
import algebra.spring_boot.Upis.dto.CreateUpisDto;
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
class UpisControllerIntegrationTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UpisController upisController;

    @Autowired
    private UpisService upisService;

    @Autowired
    private UpisRespository upisRespository;

    private CreateUpisDto createUpisDto = new CreateUpisDto(1,2);

    @Test
    void testFindAll() throws Exception {
        mockMvc.perform(get("/upisi")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    void testFindById() throws Exception {
        mockMvc.perform(get("/upisi/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }



    @Test
    void create() throws Exception {
        mockMvc.perform(post("/upisi")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createUpisDto))
                )
                .andExpect(status().isCreated());
    }

}
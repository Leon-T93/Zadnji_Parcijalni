package algebra.spring_boot.ProgramObrazovanja.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateProgramObrazovanjaDto {

    @NotBlank
    @Size (max = 100)
    private String naziv;

    @NotNull
    private Integer csvet;
}

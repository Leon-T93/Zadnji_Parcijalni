package algebra.spring_boot.Polaznik.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreatePolaznikDto {

    @NotBlank
    @Size (max = 50)
    private String ime;

    @NotBlank
    @Size (max = 50)
    private String prezime;
}

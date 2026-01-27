package igor_dev.CrmEvolution.dto;

import igor_dev.CrmEvolution.enums.Canais;
import igor_dev.CrmEvolution.enums.Segmento;
import igor_dev.CrmEvolution.model.Empresa;
import jakarta.validation.constraints.NotBlank;

public record LeadRequestDTO(

        @NotBlank(message = "O campo 'empresa' não pode ser vazio")
        Empresa empresa,

        @NotBlank(message = "O campo 'segmento' não pode ser vazio")
        String segmento,

        @NotBlank(message = "O campo 'canalOrigem' não pode ser vazio")
        Canais canalOrigem
) {
}

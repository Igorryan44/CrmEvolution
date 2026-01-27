package igor_dev.CrmEvolution.dto;

import igor_dev.CrmEvolution.enums.Canais;
import igor_dev.CrmEvolution.enums.LeadStatus;
import igor_dev.CrmEvolution.enums.Segmento;
import igor_dev.CrmEvolution.model.Empresa;

import java.time.OffsetDateTime;

public record LeadResponseDTO(

        Long id,

        Empresa empresa,

        LeadStatus status,

        String segmento,

        Canais canalOrigem,

        Integer score,

        OffsetDateTime createAt,

        OffsetDateTime updateAt

) {


}

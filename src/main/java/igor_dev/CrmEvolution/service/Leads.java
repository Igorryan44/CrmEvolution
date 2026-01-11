package igor_dev.CrmEvolution.service;

import igor_dev.CrmEvolution.enums.Canais;
import igor_dev.CrmEvolution.enums.LeadStatus;
import igor_dev.CrmEvolution.enums.MotivoNegativa;
import igor_dev.CrmEvolution.enums.Segmento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table()
public class Leads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private LeadStatus leadStatus;

    private String empresa;

    private String contato;

    private String email;

    private OffsetDateTime dataEntrada;

    private OffsetDateTime ultimoContato;

    private Integer tentativas;

    private OffsetDateTime agendamento;

    @Enumerated(EnumType.STRING)
    private MotivoNegativa motivoNegativa;

    private BigDecimal valorEstimado;

    private String proximoPasso;

    private Integer diasFunil; /* TODO: Implementar lógica de KPIs para essa coluna*/

    private Integer score; /* TODO: Implementar lógica de KPIs para essa coluna*/

    @Enumerated(EnumType.STRING)
    private Canais canalOrigem;

    @Enumerated(EnumType.STRING)
    private Segmento segmento;

    private String observacoes;

}
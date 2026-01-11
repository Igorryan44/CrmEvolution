package igor_dev.CrmEvolution.service;

import igor_dev.CrmEvolution.enums.Canais;
import igor_dev.CrmEvolution.enums.LeadStatus;
import igor_dev.CrmEvolution.enums.MotivoNegativa;
import igor_dev.CrmEvolution.enums.Segmento;
import igor_dev.CrmEvolution.kpis.KpisFunil;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private LeadStatus status;

    private String empresa;

    private String contato;

    private String email;

    private OffsetDateTime dataEntrada;

    private OffsetDateTime ultimoContato;

    private Integer tentativas;

    private OffsetDateTime agendamento;

    @Enumerated(EnumType.STRING)
    private MotivoNegativa motivoNegatia;

    private BigDecimal valorEstimado;

    private String proximoPasso;

    private KpisFunil diasFunil;

    private KpisFunil score;

    @Enumerated(EnumType.STRING)
    private Canais canalOrigem;

    @Enumerated(EnumType.STRING)
    private Segmento segmento;

    private String observacoes;
}

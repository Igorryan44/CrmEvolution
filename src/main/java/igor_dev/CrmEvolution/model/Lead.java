package igor_dev.CrmEvolution.model;

import igor_dev.CrmEvolution.enums.Canais;
import igor_dev.CrmEvolution.enums.LeadStatus;
import igor_dev.CrmEvolution.enums.Segmento;
import jakarta.persistence.*;
import lombok.*;

import java.time.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "leads")
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id")
    public Empresa empresa;

    @Enumerated(EnumType.STRING)
    private LeadStatus status;

    @Enumerated(EnumType.STRING)
    private Segmento segmento;

    @Enumerated(EnumType.STRING)
    @Column(updatable = false, nullable = false)
    private Canais canalOrigem;

    private Integer score;

    private OffsetDateTime createAt;

    private OffsetDateTime updateAt;

    @OneToMany(mappedBy = "lead")
    private List<Interacao> interacao;

    @OneToMany(mappedBy = "lead")
    private List<Contato> contatos;

    @OneToMany(mappedBy = "lead")
    private List<Agendamento> agendamentos;

    @OneToOne(fetch = FetchType.LAZY)
    private AuditEntry audit;

    @OneToOne(fetch = FetchType.LAZY)
    private Email email;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;
}
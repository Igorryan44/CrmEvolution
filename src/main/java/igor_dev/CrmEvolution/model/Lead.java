package igor_dev.CrmEvolution.model;

import igor_dev.CrmEvolution.enums.Canais;
import igor_dev.CrmEvolution.enums.LeadStatus;
import igor_dev.CrmEvolution.enums.Segmento;
import jakarta.persistence.*;

import java.time.*;

@Entity
@Table()
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String empresa;

    @Enumerated(EnumType.STRING)
    private LeadStatus status;

    @Enumerated(EnumType.STRING)
    private Segmento segmento;

    @Enumerated(EnumType.STRING)
    private Canais canalOrigem;

    private Integer score;

    private OffsetDateTime createAt;

    private OffsetDateTime updateAt;

    public Lead() {
    }

    public Lead(
            Long id, String empresa, LeadStatus status,
            Segmento segmento, Canais canalOrigem,
            Integer score,
            OffsetDateTime updateAt
            )
    {
        this.id = id;
        this.empresa = empresa;
        this.status = status;
        this.segmento = segmento;
        this.canalOrigem = canalOrigem;
        this.score = score;
        this.createAt = OffsetDateTime.now();
        this.updateAt = updateAt;
    }


    /// Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setStatus(LeadStatus status) {
        this.status = status;
    }

    public void setSegmento(Segmento segmento) {
        this.segmento = segmento;
    }

    public void setCanalOrigem(Canais canalOrigem) {
        this.canalOrigem = canalOrigem;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setCreateAt(OffsetDateTime createAt) {
        this.createAt = createAt;
    }

    public void setUpdateAt(OffsetDateTime updateAt) {
        this.updateAt = updateAt;
    }

    /// Getters
    public Long getId() {
        return id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public LeadStatus getStatus() {
        return status;
    }

    public Segmento getSegmento() {
        return segmento;
    }

    public Canais getCanalOrigem() {
        return canalOrigem;
    }

    public Integer getScore() {
        return score;
    }

    public OffsetDateTime getCreateAt() {
        return createAt;
    }

    public OffsetDateTime getUpdateAt() {
        return updateAt;
    }
}
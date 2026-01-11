package igor_dev.CrmEvolution.enums;

public enum LeadStatus {
    NOVO("Cinza Claro"),
    QUALIFICADO("Azul"),
    CONTATO_REALIZADO("Ciano"),
    EM_NEGOCIACAO("Amarelo"),
    PROPOSTA_ENVIADA("Laranja"),
    GANHO("Verde"),
    PERDIDO("Vermelho"),
    CANCELADO("Cinza Escuro");

    private final String cor;

    LeadStatus(String cor) {
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }
}

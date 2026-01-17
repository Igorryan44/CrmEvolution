# CrmEvolution 🚀

O **CrmEvolution** é uma solução robusta de **Backend para Gestão de Relacionamento com o Cliente (CRM)**, projetada para alta performance, escalabilidade e rastreabilidade completa de pipelines de vendas.  
O sistema é construído sobre o que há de mais atual no ecossistema Java, utilizando **Java 25** e **Spring Boot 4.0.1**, com foco em arquitetura limpa e domínio bem definido.

---

## 🛠️ Tecnologias e Stack Técnica

- **Linguagem:** [Java 25](https://openjdk.org/)  
  Utilização das JEPs mais recentes para ganhos de produtividade, imutabilidade e clareza semântica.

- **Framework:** [Spring Boot 4.0.1](https://spring.io/projects/spring-boot)  
  Base para construção de aplicações modernas, seguras e escaláveis.

- **Persistência:** Spring Data JPA + Hibernate  
  Abstração de acesso a dados com foco em domínio e consistência transacional.

- **Base de Dados:** PostgreSQL  
  Banco relacional robusto, confiável e adequado a cargas analíticas e operacionais.

- **Utilitários:**
    - **Lombok:** Redução de boilerplate (getters, setters, builders).
    - **SLF4J:** Padronização e desacoplamento de logging.

- **Build Tool:** Maven  
  Gerenciamento de dependências e ciclo de vida do projeto.

---

## 📋 Funcionalidades do Sistema

O núcleo da aplicação é centrado na entidade **Lead**, desenhada para suportar fluxos de venda complexos e orientados a métricas.

### Principais Capacidades

- **Gestão Completa de Leads**
    - Cadastro detalhado de empresas, contatos e e-mails.
    - Histórico estruturado de interações.

- **Pipeline de Vendas**
    - Controle de estágios via enum `LeadStatus`.
    - Segmentação de mercado por `Segmento`.

- **Motor de KPIs**
    - **`diasFunil`:** Cálculo preciso do tempo de permanência do lead em cada etapa.
    - **Lead Scoring:** Pontuação dinâmica baseada em perfil, estágio e interações.

- **Rastreabilidade e Auditoria**
    - Registro de canais de origem (`Canais`).
    - Tentativas de contato e agendamentos.
    - Uso de `OffsetDateTime` para precisão de fuso horário e consistência temporal.

---

## 📂 Arquitetura do Projeto

A organização do projeto segue boas práticas de **arquitetura em camadas**, com separação clara de responsabilidades.

### Estrutura de Pacotes

```
igor_dev.CrmEvolution
├── service → Regras de negócio, serviços de domínio e entidades JPA
├── enums → Tipagens fortes para estados e regras de negócio
│ (Canais, LeadStatus, Segmento, MotivoNegativa)
├── kpis → Componentes de inteligência, métricas e cálculos analíticos
```


Essa abordagem favorece:
- Manutenibilidade
- Testabilidade
- Evolução incremental do domínio

---

## 🚀 Configuração e Instalação

### Pré-requisitos

- **JDK:** 25 ou superior
- **PostgreSQL:** 15+
- **Maven:** 3.9+

---

### Configuração da Base de Dados

1. Crie uma base de dados no PostgreSQL:

```sql
CREATE DATABASE crm_evolution;
```  

---
 
### Colaboradores
<table>
  <tr>
    <td align="center">
      <a href="https://linkedin.com/in/igorryan" title="link do linkedin de Igor Alves">
        <img src="https://media.licdn.com/dms/image/v2/D4D03AQGopZX3ceB7cg/profile-displayphoto-scale_200_200/B4DZkU851wHYAY-/0/1756993135190?e=1770249600&v=beta&t=h9bDvamr828zA_KrdE0HtSG7NoF4sewwUMiiwpZXH4o" width="100px;" alt="Foto do Igor Alves"/><br>
        <sub>
          <b>Igor Alves</b>
        </sub>
      </a>
    </td>
  </tr>
</table>  

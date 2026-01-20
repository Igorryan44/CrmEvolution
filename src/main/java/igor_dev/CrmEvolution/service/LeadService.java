package igor_dev.CrmEvolution.service;

import igor_dev.CrmEvolution.dto.LeadRequestDTO;
import igor_dev.CrmEvolution.dto.LeadResponseDTO;
import igor_dev.CrmEvolution.enums.LeadStatus;
import igor_dev.CrmEvolution.enums.Segmento;
import igor_dev.CrmEvolution.mapper.LeadMapper;
import igor_dev.CrmEvolution.model.Lead;
import igor_dev.CrmEvolution.repository.LeadRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import static igor_dev.CrmEvolution.enums.LeadStatus.NOVO;

@Service
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;
    @Autowired
    private LeadMapper mapper;

    public List<LeadResponseDTO> getAllLeads(){
        return mapper.toLeadResponseDTO(leadRepository.findAll());
    }

    public LeadResponseDTO save(LeadRequestDTO leadRequest){
        Lead lead = new Lead();

        lead.setEmpresa(leadRequest.empresa());
        lead.setStatus(NOVO);
        lead.setSegmento(leadRequest.segmento());
        lead.setCanalOrigem(leadRequest.canalOrigem());
        lead.setCreateAt(OffsetDateTime.now());

        return mapper.toLeadResponseDTO(leadRepository.save(lead));
    }

    public Optional<LeadResponseDTO> findById(Long id) {
        Lead entity = leadRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Lead não encontrado!"));
        return Optional.ofNullable(mapper.toLeadResponseDTO(entity));
    }

    public void delete(Long id) {
        Lead entity = leadRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Lead não encontrado!"));
        leadRepository.delete(entity);
    }

    public LeadResponseDTO updateLead(LeadRequestDTO leadRequestDTO, Long id){
        Lead leadOld = leadRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Lead não encontrado!"));

        leadOld.setId(id);
        leadOld.setEmpresa(leadRequestDTO.empresa() !=null ? leadRequestDTO.empresa() : leadOld.getEmpresa());
        leadOld.setSegmento(leadRequestDTO.segmento() !=null ? leadRequestDTO.segmento() : leadOld.getSegmento());
        leadOld.setCanalOrigem(leadRequestDTO.canalOrigem() !=null ? leadRequestDTO.canalOrigem() : leadOld.getCanalOrigem());
        leadOld.setUpdateAt(OffsetDateTime.now());

        return mapper.toLeadResponseDTO(leadRepository.save(leadOld));
    }

    public List<LeadResponseDTO> getLeadByStatus(String status){
        return mapper.toLeadResponseDTO(leadRepository.findByStatus(status));
    }

    public LeadResponseDTO updateStatus(Long id, String status){
        Lead leadOld = leadRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Lead não encontrado!"));

        leadOld.setId(id);
        leadOld.setStatus(LeadStatus.valueOf(status));
        leadOld.setUpdateAt(OffsetDateTime.now());

        return mapper.toLeadResponseDTO(leadRepository.save(leadOld));
    }

    public LeadResponseDTO updateSegmento(Long id, String segmento){
        Lead leadOld = leadRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Lead não encontrado!"));

        leadOld.setId(id);
        leadOld.setSegmento(Segmento.valueOf(segmento));
        leadOld.setUpdateAt(OffsetDateTime.now());

        return mapper.toLeadResponseDTO(leadRepository.save(leadOld));
    }

}

package igor_dev.CrmEvolution.service;

import igor_dev.CrmEvolution.dto.LeadRequestDTO;
import igor_dev.CrmEvolution.dto.LeadResponseDTO;
import igor_dev.CrmEvolution.mapper.LeadMapper;
import igor_dev.CrmEvolution.model.Lead;
import igor_dev.CrmEvolution.repository.LeadRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

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
        return mapper.toLeadResponseDTO(leadRepository.save(mapper.toLeadEntity(leadRequest)));
    }

    public Optional<Lead> findLeadsById(Long id){
        return leadRepository.findById(id);
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

}

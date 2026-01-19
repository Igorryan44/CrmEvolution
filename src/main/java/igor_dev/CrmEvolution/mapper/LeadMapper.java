package igor_dev.CrmEvolution.mapper;

import igor_dev.CrmEvolution.dto.LeadRequestDTO;
import igor_dev.CrmEvolution.dto.LeadResponseDTO;
import igor_dev.CrmEvolution.model.Lead;
import igor_dev.CrmEvolution.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface LeadMapper {

    @Mapping(target = "id", ignore = true)
    Lead toLeadEntity(LeadRequestDTO leadDTO);

    LeadResponseDTO toLeadResponseDTO(Lead leadEntity);

    List<LeadResponseDTO> toLeadResponseDTO(List<Lead> leadEntityList);
}

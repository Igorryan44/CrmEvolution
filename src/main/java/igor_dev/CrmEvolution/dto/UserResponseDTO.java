package igor_dev.CrmEvolution.dto;

import igor_dev.CrmEvolution.enums.UserAccess;
import igor_dev.CrmEvolution.model.Email;

public record UserResponseDTO(
        Long id,
        String name,
        String nickname,
        Email email,
        String senha,
        UserAccess access
) {
}

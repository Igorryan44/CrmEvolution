package igor_dev.CrmEvolution.dto;

import igor_dev.CrmEvolution.enums.UserAccess;

public record UserResponseDTO(
        Long id,
        String name,
        String nickname,
        String email,
        String senha,
        UserAccess access
) {
}

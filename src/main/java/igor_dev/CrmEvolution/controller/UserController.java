package igor_dev.CrmEvolution.controller;

import igor_dev.CrmEvolution.dto.UserRequestDTO;
import igor_dev.CrmEvolution.dto.UserResponseDTO;
import igor_dev.CrmEvolution.model.User;
import igor_dev.CrmEvolution.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    /// Aplicar lógica de gestão de acessos
    @PostMapping
    @Valid
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO user){
            UserResponseDTO response = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserResponseDTO>> getUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping
    @Valid
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
        return ResponseEntity.ok(userService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
            userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@Valid @RequestBody UserRequestDTO user, @PathVariable Long id){
        return ResponseEntity.ok(userService.updateUser(user, id));
    }

    @PutMapping("/access/{id}")
    public ResponseEntity<UserResponseDTO> updateUserAccess(@PathVariable Long id, @Valid @RequestBody String access){
        return ResponseEntity.ok(userService.updateUserAccess(id, access));
    }

}

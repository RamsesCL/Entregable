package com.senati.senati_web_Entregable.controller;

import com.senati.senati_web_Entregable.model.Response;
import com.senati.senati_web_Entregable.model.User;
import com.senati.senati_web_Entregable.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://entregable-final-hmf0gmckg6ctfddf.chilecentral-01.azurewebsites.net/")
public class UserController {

    @Autowired
    private UserService userService;

    // ✅ Obtener todos los usuarios
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // ✅ Agregar nuevo usuario
    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return userService.newUser(user);
    }

    // ✅ Eliminar usuario
    @DeleteMapping("/user/{id}")
    public Response deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    // ✅ Actualizar usuario
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }
}

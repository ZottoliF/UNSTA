package com.bienestar.controllers;

import com.bienestar.models.Usuario;
import com.bienestar.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.crearUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerUsuarios() {
        List<Usuario> usuarios = usuarioService.obtenerUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable String id) {
        return usuarioService.obtenerUsuarioPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable String id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/auth")
    public ResponseEntity<Usuario> autenticarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioAutenticado = usuarioService.autenticarUsuario(usuario.getEmail(), usuario.getContrasena());
        return usuarioAutenticado != null ? ResponseEntity.ok(usuarioAutenticado) : ResponseEntity.status(401).build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Usuario>> buscarUsuariosPorNombre(@RequestParam String nombre) {
        List<Usuario> usuarios = usuarioService.buscarUsuariosPorNombre(nombre);
        return ResponseEntity.ok(usuarios);
    }
}

package com.bienestar.services;

import com.bienestar.models.Usuario;
import com.bienestar.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerUsuarioPorId(String id) {
        return usuarioRepository.findById(id);
    }

    public void eliminarUsuario(String id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario autenticarUsuario(String email, String contrasena) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario != null && usuario.getContrasena().equals(contrasena)) {
            return usuario;
        }
        return null; 
    }

    public List<Usuario> buscarUsuariosPorNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre);
    }
}

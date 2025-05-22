package com.bienestar.repositories;

import com.bienestar.models.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Usuario findByEmail(String email);
    
    List<Usuario> findByNombre(String nombre);
}

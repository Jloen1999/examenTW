package es.unex.cum.tw.services;

import es.unex.cum.tw.models.Usuario;

import java.sql.SQLException;
import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> login(String username, String password) throws SQLException;
    boolean guardarUsuario(Usuario usuario) throws SQLException;
}

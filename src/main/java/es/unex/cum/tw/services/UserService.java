package es.unex.cum.tw.services;

import es.unex.cum.tw.models.Usuario;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define los métodos que debe implementar un servicio de usuario.
 * @author Jose Luis Obiang Ela Nanguang
 * @version 1.0 12-05-2024, Sun, 12:51
 */
public interface UserService {
    Optional<Usuario> login(String username, String password);
    boolean save(Usuario usuario) throws SQLException;
    List<Usuario> findAll() throws SQLException;
    boolean deleteUserById(int id) throws SQLException;
    Optional<Usuario> findByUsernameAndPassword(String username, String password) throws SQLException;
    Optional<Usuario> findUserById(int idUsuario) throws SQLException;
}

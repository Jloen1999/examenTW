package es.unex.cum.tw.services;

import es.unex.cum.tw.models.Usuario;
import es.unex.cum.tw.repositories.UserRepository;
import es.unex.cum.tw.repositories.UserRepositoryJDBCImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Servicio que implementa la interfaz UserService y que se encarga de gestionar los usuarios en la base de datos.
 * @author Jose Luis Obiang Ela Nanguang
 * @version 1.0 12-05-2024, Sun, 12:52
 */
public class UserServiceJDBCImpl implements UserService{

    private UserRepository userRepository;


    public UserServiceJDBCImpl(Connection connection){
        this.userRepository = new UserRepositoryJDBCImpl(connection);
    }

    @Override
    public Optional<Usuario> login(String username, String password) {
        try {
            return userRepository.findByUsernameAndPassword(username, password).filter(user -> user.getPassword().equals(password));
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }

    }


    @Override
    public boolean save(Usuario usuario) {
        try {
            return userRepository.save(usuario);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Usuario> findAll() throws SQLException {
        try{
            return userRepository.findAll();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public boolean deleteUserById(int id) throws SQLException {
        try{
            return userRepository.deleteById(id);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Usuario> findByUsernameAndPassword(String username, String password) throws SQLException {
        try{
            return userRepository.findByUsernameAndPassword(username, password);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Usuario> findUserById(int idUsuario) throws SQLException {
        try{
            return userRepository.findById(idUsuario);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

}

package es.unex.cum.tw.repositories;

import es.unex.cum.tw.models.Usuario;
import es.unex.cum.tw.util.ConexionBD_DSPool;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UsuarioRepositoryJDBCImpl implements UsuarioRepository {

    private final Connection conn;

    public UsuarioRepositoryJDBCImpl() throws SQLException, NamingException {
        conn = ConexionBD_DSPool.getConexionBD();
    }


    /**
     * Busca un usuario por su nombre de usuario y contraseña
     *
     * @param username nombre de usuario
     * @param password contraseña
     * @return <ul>
     *     <li>Optional.empty() si no se encuentra el usuario</li>
     *     <li>Optional.of(Usuario) si se encuentra el usuario</li>
     * </ul>
     */
    @Override
    public Optional<Usuario> findByUsernameAndPassword(String username, String password){
        Usuario user = null;
        try (PreparedStatement statement = conn.prepareStatement("SELECT * FROM usuarios WHERE nombre_usuario = ? AND contrasena = ?")) {
            statement.setString(1, username);
            statement.setString(2, password);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    user = new Usuario(username, password);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<Usuario> findById(int id){
        String sql = "SELECT * FROM usuarios WHERE id_Usuario = ?";
        Usuario usuario = null;
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    usuario = getUsuario(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.ofNullable(usuario);
    }

    private static Usuario getUsuario(ResultSet rs) throws SQLException {
        Usuario usuario;
        usuario = new Usuario(rs.getInt("id_Usuario"), rs.getString("nombre_usuario"), rs.getString("contrasena"));
        return usuario;
    }

    @Override
    public List<Usuario> findAll(){
        List<Usuario> usuarios = null;
        try (PreparedStatement statement = conn.prepareStatement("SELECT * FROM usuarios")) {
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    usuarios.add(getUsuario(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuarios;
    }

    @Override
    public boolean save(Usuario usuario){
        String sql = "INSERT INTO usuarios (nombre_usuario, contrasena) VALUES (?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, usuario.getNombre_usuario());
            statement.setString(2, usuario.getContrasena());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Usuario usuario){
        String sql = "UPDATE usuarios SET nombre_usuario = ?, contrasena = ? WHERE id_Usuario = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, usuario.getNombre_usuario());
            statement.setString(2, usuario.getContrasena());
            statement.setInt(3, usuario.getId_Usuario());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(int id){
        String sql = "DELETE FROM usuarios WHERE id_Usuario = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Usuario usuario){
        return deleteById(usuario.getId_Usuario());
    }
}

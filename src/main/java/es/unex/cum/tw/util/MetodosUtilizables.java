package es.unex.cum.tw.util;

import jakarta.servlet.ServletContext;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Interfaz que contiene métodos útiles para la aplicación.
 *
 * @author Jose Luis Obiang Ela Nanguang
 * @version 1.0 12-05-2024, Sun, 12:53
 */
public interface MetodosUtilizables {
    static void showDataInitPage(ServletContext servletContext) {
        try (Connection conn = ConexionBD_DSPool.getConexionBD()) {
            // servletContext.setAttribute("books", booksWithPuntuacionMedia);
            // servletContext.setAttribute("newBooks", newBooks);
        } catch (SQLException | NamingException e) {
            throw new RuntimeException(e);
        }
    }
}

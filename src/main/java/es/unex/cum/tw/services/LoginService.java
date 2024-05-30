package es.unex.cum.tw.services;

import es.unex.cum.tw.models.Usuario;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

/**
 * @author Jose Luis Obiang Ela Nanguang
 * @version 1.0 30-05-2024, Thu, 05:30
 */
public interface LoginService {
    Optional<Usuario> verifyUserSession(HttpServletRequest request);
}

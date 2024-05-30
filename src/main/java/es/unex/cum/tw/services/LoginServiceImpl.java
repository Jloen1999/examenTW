package es.unex.cum.tw.services;

import es.unex.cum.tw.models.Usuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

/**
 * @author Jose Luis Obiang Ela Nanguang
 * @version 1.0 30-05-2024, Thu, 05:36
 */


public class LoginServiceImpl implements LoginService {
    @Override
    public Optional<Usuario> verifyUserSession(HttpServletRequest request) {
        HttpSession session = request.getSession();

        Usuario user = (Usuario) session.getAttribute("user");

        return Optional.ofNullable(user);
    }
}

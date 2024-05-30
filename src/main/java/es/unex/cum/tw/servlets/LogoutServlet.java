package es.unex.cum.tw.servlets;

import es.unex.cum.tw.models.Usuario;
import es.unex.cum.tw.services.LoginService;
import es.unex.cum.tw.services.LoginServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

/**
 * @author Jose Luis Obiang Ela Nanguang
 * @version 1.0 30-05-2024, Thu, 06:19
 */


@WebServlet(
        name = "LogoutServlet",
        value = "/logout"
)
public class LogoutServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");

        LoginService auth = new LoginServiceImpl();
        Optional<Usuario> userOptional = auth.verifyUserSession(request); // Obtener el usuario de la sesión

        if (userOptional.isPresent()) { // Si el usuario está logueado
            HttpSession session = request.getSession();
            session.invalidate(); // Invalidar la sesión
        }

        response.sendRedirect(request.getContextPath() + "/index.jsp");

    }

}

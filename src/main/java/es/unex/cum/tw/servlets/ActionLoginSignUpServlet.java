package es.unex.cum.tw.servlets;

import es.unex.cum.tw.models.Usuario;
import es.unex.cum.tw.services.UsuarioService;
import es.unex.cum.tw.services.UsuarioServiceJDBCImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet(
        name = "LoginOrSignup",
        value = "/actionLogin"
)
public class ActionLoginSignUpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        String accion = req.getParameter("action");

        if (accion != null) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            UsuarioService usuarioService = null;
            Optional<Usuario> usuarioOptional = null;

            HttpSession session = req.getSession();

            try {
                usuarioService = new UsuarioServiceJDBCImpl();
                usuarioOptional = usuarioService.login(username, password);
            } catch (SQLException | NamingException e) {
                throw new RuntimeException(e);
            }
            switch (accion) {
                case "login":
                    if (usuarioOptional.isPresent()) {
                        req.setAttribute("mensaje", "Usuario logueado");
                        session.setAttribute("user", usuarioOptional.get());
                    } else {
                        req.setAttribute("mensaje", "Error, Credenciales incorrectas");
                        session.setAttribute("showLogin", true);
                    }

                    break;

                case "signUp":
                        if (usuarioOptional.isEmpty()) {
                            try {
                                if (usuarioService.guardarUsuario(new Usuario(username, password))) {
                                    req.setAttribute("mensaje", "Usuario registrado");
                                    session.setAttribute("user", new Usuario(username, password));
                                } else {
                                    req.setAttribute("mensaje", "Error, No se ha podido registrar el usuario");
                                    session.setAttribute("showLogin", true);
                                }
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }

                        } else {
                            req.setAttribute("mensaje", "Error, El usuario ya existe. Inicia sesión");
                            session.setAttribute("showLogin", true);
                        }

            }


        }

        RequestDispatcher dispatcher = null;
        try {
            dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }


}

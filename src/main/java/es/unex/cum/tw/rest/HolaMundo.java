package es.unex.cum.tw.rest;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import javax.naming.NamingException;
import java.sql.SQLException;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/")
@Produces(APPLICATION_JSON)
public class HolaMundo {

    @GET
    public String HolaMundo(String mensaje) throws SQLException, NamingException {
        return "Hola Mundo";
    }
}
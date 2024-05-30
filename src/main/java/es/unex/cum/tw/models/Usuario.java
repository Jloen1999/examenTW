package es.unex.cum.tw.models;

import java.util.Objects;

public class Usuario {
    private int id_Usuario;
    private String nombre_usuario;
    private String contrasena;

    public Usuario() {
        this.id_Usuario = 0;
        this.nombre_usuario = "";
        this.contrasena = "";
    }

    public Usuario(int id_Usuario, String nombre_usuario, String contrasena) {
        this.id_Usuario = id_Usuario;
        this.nombre_usuario = nombre_usuario;
        this.contrasena = contrasena;
    }

    public Usuario(String nombre_usuario, String contrasena) {
        this.nombre_usuario = nombre_usuario;
        this.contrasena = contrasena;
    }

    public int getId_Usuario() {
        return id_Usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id_Usuario == usuario.id_Usuario && Objects.equals(nombre_usuario, usuario.nombre_usuario) && Objects.equals(contrasena, usuario.contrasena);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_Usuario, nombre_usuario, contrasena);
    }
}

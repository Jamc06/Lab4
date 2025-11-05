package model;

public abstract class Usuario {
    protected String nombre;
    protected String tipo; // "Administrador" o "Editor"

    public Usuario(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }

    // Comportamientos generales
    public abstract void crearContenido();
}

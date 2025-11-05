package model;

public class Administrador extends Usuario {

    public Administrador(String nombre) {
        super(nombre, "Administrador");
    }

    @Override
    public void crearContenido() {
        System.out.println(nombre + " creó un nuevo contenido.");
    }

    public void eliminarContenido(Contenido c) {
        System.out.println( nombre + " eliminó el contenido: " + c.getTitulo());
    }

    public void publicarContenido(Contenido c) {
        c.publicar();
    }
}

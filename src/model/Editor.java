package model;

public class Editor extends Usuario {

    public Editor(String nombre) {
        super(nombre, "Editor");
    }

    @Override
    public void crearContenido() {
        System.out.println(nombre + " creó un nuevo contenido para revisión.");
    }

    public void editarContenido(Contenido c, String nuevoTitulo) {
        System.out.println(nombre + " editó el contenido: " + c.getTitulo() + " -> " + nuevoTitulo);
        c.titulo = nuevoTitulo;
    }
}

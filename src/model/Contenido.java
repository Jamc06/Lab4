package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Contenido implements Publicable {
    protected int id;
    public String titulo;
    protected String autor;
    protected String categoria;
    protected List<String> etiquetas;
    protected boolean publicado;

    public Contenido(int id, String titulo, String autor, String categoria) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.etiquetas = new ArrayList<>();
        this.publicado = false;
    }

    // Métodos comunes
    public void agregarEtiqueta(String etiqueta) {
        etiquetas.add(etiqueta);
    }

    public void eliminarEtiqueta(String etiqueta) {
        etiquetas.remove(etiqueta);
    }

    public boolean isPublicado() {
        return publicado;
    }

    public void setPublicado(boolean publicado) {
        this.publicado = publicado;
    }

    // Getters y setters
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getCategoria() { return categoria; }
    public List<String> getEtiquetas() { return etiquetas; }

    // Métodos abstractos heredados de Publicable
    @Override
    public abstract void publicar();

    @Override
    public abstract void visualizar();
}

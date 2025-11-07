package controller;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CMSController {

    private List<Contenido> contenidos;

    public CMSController() {
        this.contenidos = new ArrayList<>();
    }

    //  CRUD BÁSICO 
    public void agregarContenido(Contenido c) {
        contenidos.add(c);
        System.out.println("Contenido agregado: " + c.getTitulo());
    }

    public void eliminarContenido(int id) {
        Contenido c = buscarPorId(id);
        if (c != null) {
            contenidos.remove(c);
            System.out.println("Contenido eliminado: " + c.getTitulo());
        } else {
            System.out.println("Contenido no encontrado.");
        }
    }

    public void editarTitulo(int id, String nuevoTitulo) {
        Contenido c = buscarPorId(id);
        if (c != null) {
            c.titulo = nuevoTitulo;
            System.out.println(" Título actualizado a: " + nuevoTitulo);
        } else {
            System.out.println("⚠️ Contenido no encontrado.");
        }
    }

    // === PUBLICACIÓN ===
    public void publicarContenido(int id) {
        Contenido c = buscarPorId(id);
        if (c != null) {
            c.publicar();
        } else {
            System.out.println("⚠️ Contenido no encontrado.");
        }
    }

    public void visualizarContenido(int id) {
        Contenido c = buscarPorId(id);
        if (c != null) {
            c.visualizar();
        } else {
            System.out.println("⚠️ Contenido no encontrado.");
        }
    }

    // === FILTROS Y REPORTES ===
    public List<Contenido> filtrarPorCategoria(String categoria) {
        return contenidos.stream()
                .filter(c -> c.getCategoria().equalsIgnoreCase(categoria))
                .collect(Collectors.toList());
    }

    public List<Contenido> filtrarPorTipo(String tipo) {
        return contenidos.stream()
                .filter(c -> c.getClass().getSimpleName().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }

    public void mostrarReporte() {
        System.out.println("\n📊 --- REPORTE DE CONTENIDOS ---");
        long publicados = contenidos.stream().filter(Contenido::isPublicado).count();
        System.out.println("Total contenidos: " + contenidos.size());
        System.out.println("Publicados: " + publicados);
        System.out.println("Pendientes: " + (contenidos.size() - publicados));
    }

    // === AUXILIAR ===
    private Contenido buscarPorId(int id) {
        for (Contenido c : contenidos) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public List<Contenido> getContenidos() {
        return contenidos;
    }
}

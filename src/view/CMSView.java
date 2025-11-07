package view;

import controller.CMSController;
import model.*;

import java.util.List;
import java.util.Scanner;

public class CMSView {

    private final CMSController controller;
    private final Scanner scanner;

    public CMSView() {
        this.controller = new CMSController();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("=== 🎬 SISTEMA CMS UVG ===");
        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            int opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    crearContenido();
                    break;
                case 2:
                    editarContenido();
                    break;
                case 3:
                    eliminarContenido();
                    break;
                case 4:
                    publicarContenido();
                    break;
                case 5:
                    visualizarContenido();
                    break;
                case 6:
                    filtrarPorCategoria();
                    break;
                case 7:
                    filtrarPorTipo();
                    break;
                case 8:
                    controller.mostrarReporte();
                    break;
                case 9:
                    continuar = false;
                    System.out.println(" Saliendo del CMS...");
                    break;
                default:
                    System.out.println(" Opción no válida.");
                    break;
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("\nMENÚ PRINCIPAL");
        System.out.println("1. Crear contenido");
        System.out.println("2. Editar contenido");
        System.out.println("3. Eliminar contenido");
        System.out.println("4. Publicar contenido");
        System.out.println("5. Visualizar contenido");
        System.out.println("6. Filtrar por categoría");
        System.out.println("7. Filtrar por tipo");
        System.out.println("8. Mostrar reporte");
        System.out.println("9. Salir");
    }

    private void crearContenido() {
        int id = leerEntero("ID del contenido: ");
        String titulo = leerTexto("Título: ");
        String autor = leerTexto("Autor: ");
        String categoria = leerTexto("Categoría: ");
        System.out.println("Tipo (1. Artículo / 2. Video / 3. Imagen): ");
        int tipo = leerEntero("> ");

        Contenido c = null;

        switch (tipo) {
            case 1:
                String texto = leerTexto("Texto del artículo: ");
                c = new Articulo(id, titulo, autor, categoria, texto);
                break;
            case 2:
                String url = leerTexto("URL del video: ");
                int dur = leerEntero("Duración (segundos): ");
                c = new Video(id, titulo, autor, categoria, url, dur);
                break;
            case 3:
                String resol = leerTexto("Resolución: ");
                String ruta = leerTexto("Ruta de archivo: ");
                c = new Imagen(id, titulo, autor, categoria, resol, ruta);
                break;
            default:
                System.out.println("Tipo no válido.");
                break;
        }

        if (c != null) controller.agregarContenido(c);
    }

    private void editarContenido() {
        int id = leerEntero("ID del contenido a editar: ");
        String nuevoTitulo = leerTexto("Nuevo título: ");
        controller.editarTitulo(id, nuevoTitulo);
    }

    private void eliminarContenido() {
        int id = leerEntero("ID del contenido a eliminar: ");
        controller.eliminarContenido(id);
    }

    private void publicarContenido() {
        int id = leerEntero("ID del contenido a publicar: ");
        controller.publicarContenido(id);
    }

    private void visualizarContenido() {
        int id = leerEntero("ID del contenido a visualizar: ");
        controller.visualizarContenido(id);
    }

    private void filtrarPorCategoria() {
        String categoria = leerTexto("Categoría: ");
        List<Contenido> lista = controller.filtrarPorCategoria(categoria);
        mostrarLista(lista);
    }

    private void filtrarPorTipo() {
        String tipo = leerTexto("Tipo (Articulo / Video / Imagen): ");
        List<Contenido> lista = controller.filtrarPorTipo(tipo);
        mostrarLista(lista);
    }

    private void mostrarLista(List<Contenido> lista) {
        if (lista.isEmpty()) {
            System.out.println("No se encontraron resultados.");
        } else {
            System.out.println("\nResultados:");
            for (Contenido c : lista) {
                System.out.println("- [" + c.getId() + "] " + c.getTitulo() + " (" + c.getClass().getSimpleName() + ")");
            }
        }
    }

    private String leerTexto(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    private int leerEntero(String msg) {
        System.out.print(msg);
        while (!scanner.hasNextInt()) {
            System.out.print("Ingrese un número válido: ");
            scanner.next();
        }
        int num = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer
        return num;
    }

    // Punto de entrada main
    public static void main(String[] args) {
        CMSView vista = new CMSView();
        vista.iniciar();
    }
}

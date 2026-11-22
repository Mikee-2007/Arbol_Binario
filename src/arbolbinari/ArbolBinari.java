package arbolbinari;

import java.util.Iterator;

public class ArbolBinari {

    public static void main(String[] args) {
        ArbolBinario<Familiar> abueloPaterno = new ArbolBinario<>(
            new Familiar("Miguel Badilla", 66, "Jubilado", false, "Navojoa, Sonora")
        );
        ArbolBinario<Familiar> abuelaPaterna = new ArbolBinario<>(
            new Familiar("Gricelda Ayala", 59, "Ama De Casa", false, "Navojoa, Sonora")
        );

        ArbolBinario<Familiar> abueloMaterno = new ArbolBinario<>(
            new Familiar("Ramiro Duarte", 64, "Jubilado", false, "San Pedro, Etchojoa, Sonora")
        );
        ArbolBinario<Familiar> abuelaMaterna = new ArbolBinario<>(
            new Familiar("Luz Aurora Suarez", 61, "Jubilada", true, "Bacobampo, Sonora")
        );

        ArbolBinario<Familiar> padre = new ArbolBinario<>(
            new Familiar("Miguel Ayala Lozano", 42, "Encargado de Area", false, "Navojoa, Sonora"),
            abueloPaterno,
            abuelaPaterna
        );

        ArbolBinario<Familiar> madre = new ArbolBinario<>(
            new Familiar("Bainca Vianney", 40, "Cajera", false, "Navojoa, Sonora"),
            abueloMaterno,
            abuelaMaterna
        );

        ArbolBinario<Familiar> arbolGenealogico = new ArbolBinario<>(
            new Familiar("Miguel Ayala Duarte", 19, "Estudiante", false, "Tijuana, Baja California"),
            padre,
            madre
        );

        System.out.println("=== INFORMACION DEL ARBOL GENEALOGICO ===");
        System.out.println("Raiz (Yo): " + arbolGenealogico.getRootData().getNombre());
        System.out.println("Altura del arbol (Generaciones): " + arbolGenealogico.getHeight());
        System.out.println("Total de familiares registrados: " + arbolGenealogico.getNumberNodes());
        System.out.println("El arbol esta vacio: " + arbolGenealogico.empty());

        System.out.println("\n--- RECORRIDO EN PREORDEN (Raiz -> Izq -> Der) ---");
        Iterator<Familiar> itPre = arbolGenealogico.getPreOrderIterator();
        while (itPre.hasNext()) {
            System.out.println("- " + itPre.next());
        }

        System.out.println("\n--- RECORRIDO EN POSTORDEN (Izq -> Der -> Raiz) ---");
        Iterator<Familiar> itPost = arbolGenealogico.getPostOrderIterator();
        while (itPost.hasNext()) {
            System.out.println("- " + itPost.next());
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol_Binario;

import javax.swing.JOptionPane;

/**
 *
 * @author Brand
 */
class ArbolBinario {
    private Nodo raiz;
    private boolean[] eliminado;

    public boolean[] getEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean[] eliminado) {
        this.eliminado = eliminado;
    }

    public ArbolBinario() {
        raiz = null;
    }

    public void insertar(Impresora impresora) {
        raiz = insertarRec(raiz, impresora);
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    
    
    private Nodo insertarRec(Nodo raiz, Impresora impresora) {
        if (raiz == null) {
            raiz = new Nodo(impresora);
            return raiz;
        }
        if (impresora.getId() < raiz.impresora.getId()) {
            raiz.izquierda = insertarRec(raiz.izquierda, impresora);
        } else if (impresora.getId() > raiz.impresora.getId()) {
            raiz.derecha = insertarRec(raiz.derecha, impresora);
        }
        return raiz;
    }

public Impresora buscar(int id) {
    Nodo nodo = buscarRec(raiz, id);
    return (nodo != null) ? nodo.impresora : null;
}

private Nodo buscarRec(Nodo raiz, int id) {
    if (raiz == null) {
        return null;
    }
    if (raiz.impresora.getId() == id) {
        return raiz;
    }
    return id < raiz.impresora.getId() ? buscarRec(raiz.izquierda, id) : buscarRec(raiz.derecha, id);
}

    // Método para eliminar un nodo del árbol
    public boolean eliminar(int id) {
        if (raiz == null) {
            return false; // El árbol está vacío, no se puede eliminar
        }
        boolean[] eliminado = new boolean[1];
        raiz = eliminarRec(raiz, id, eliminado);
        return eliminado[0];
    }

    // Método recursivo para eliminar un nodo
    private Nodo eliminarRec(Nodo raiz, int id, boolean[] eliminado) {
        if (raiz == null) {
            return null; // El nodo no se encuentra en el árbol
        }

        // Encuentra el nodo a eliminar
        if (id < raiz.impresora.getId()) {
            raiz.setIzquierda(eliminarRec(raiz.getIzquierda(), id, eliminado));
        } else if (id > raiz.impresora.getId()) {
            raiz.setDerecha(eliminarRec(raiz.getDerecha(), id, eliminado));
        } else {
            // Nodo encontrado
            if (raiz.getIzquierda() != null && raiz.getDerecha() != null) {
                // Nodo tiene dos hijos
                JOptionPane.showMessageDialog(null, "No se puede eliminar un nodo con dos hijos", "Error", JOptionPane.ERROR_MESSAGE);
                eliminado[0] = false;
                return raiz; // No se elimina el nodo
            } else if (raiz.getIzquierda() != null) {
                // Nodo tiene un hijo izquierdo
                eliminado[0] = true;
                return raiz.getIzquierda();
            } else if (raiz.getDerecha() != null) {
                // Nodo tiene un hijo derecho
                eliminado[0] = true;
                return raiz.getDerecha();
            } else {
                // Nodo sin hijos
                eliminado[0] = true;
                return null;
            }
        }
        return raiz;
    }

    private Nodo obtenerNodoMinimo(Nodo raiz) {
        while (raiz.izquierda != null) {
            raiz = raiz.izquierda;
        }
        return raiz;
    }
    
        public String recorridoPreOrden() {
        StringBuilder sb = new StringBuilder();
        recorridoPreOrdenRec(raiz, sb);
        return sb.toString();
     }

    private void recorridoPreOrdenRec(Nodo nodo, StringBuilder sb) {
        if (nodo != null) {
            sb.append(nodo.impresora.getId()).append("-");
            recorridoPreOrdenRec(nodo.izquierda, sb);
            recorridoPreOrdenRec(nodo.derecha, sb);
        }
    }

    
        public String recorridoPostOrden() {
        StringBuilder sb = new StringBuilder();
        recorridoPostOrdenRec(raiz, sb);
        return sb.toString();
        }

    private void recorridoPostOrdenRec(Nodo nodo, StringBuilder sb) {
        if (nodo != null) {
            recorridoPostOrdenRec(nodo.izquierda, sb);
            recorridoPostOrdenRec(nodo.derecha, sb);
            sb.append(nodo.impresora.getId()).append("-");
        }
    }

        public String recorridoInOrden() {
        StringBuilder sb = new StringBuilder();
        recorridoInOrdenRec(raiz, sb);
        return sb.toString();
        }

    private void recorridoInOrdenRec(Nodo nodo, StringBuilder sb) {
        if (nodo != null) {
            recorridoInOrdenRec(nodo.izquierda, sb);
            sb.append(nodo.impresora.getId()).append("-");
            recorridoInOrdenRec(nodo.derecha, sb);
        }
    }
}



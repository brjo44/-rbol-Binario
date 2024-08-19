/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package arbol_Binario;
import java.awt.*;

/**
 *
 * @author Brand
 */
public class ArbolPanel extends javax.swing.JPanel {

    private Nodo raiz;
    
    public ArbolPanel() {
        initComponents();
    }
    
    public ArbolPanel(Nodo raiz) {
        this.raiz = raiz;
        this.setPreferredSize(new Dimension(800, 600));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        drawTree(g2d, raiz, getWidth() / 2, 30, getWidth() / 4);
    }
    
      private void drawTree(Graphics2D g2d, Nodo nodo, int x, int y, int xOffset) {
        if (nodo != null) {
            g2d.setColor(Color.BLACK);
            g2d.drawString(String.valueOf(nodo.impresora.getId()), x - 10, y);

            if (nodo.izquierda != null) {
                g2d.drawLine(x, y, x - xOffset, y + 50);
                drawTree(g2d, nodo.izquierda, x - xOffset, y + 50, xOffset / 2);
            }

            if (nodo.derecha != null) {
                g2d.drawLine(x, y, x + xOffset, y + 50);
                drawTree(g2d, nodo.derecha, x + xOffset, y + 50, xOffset / 2);
            }
        }
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 674, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 431, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
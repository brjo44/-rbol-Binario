/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package arbol_Binario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Brand
 */
public class MainFrame extends javax.swing.JFrame {

    private ArbolBinario arbolBinario;
    public MainFrame() {
        initComponents();
        arbolBinario = new ArbolBinario();
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarImpresora();
            }
        });
        
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarImpresora();
            }
        });
        
        btnBuscar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            buscarImpresora();
        }
        });
            btnGraficar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            mostrarArbol();
        }
    });
        
          btnRecorridos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirDialogoRecorridos();
            }
        });
    }

private void agregarImpresora() {
    DialogoImpresora dialogo = new DialogoImpresora(this);
    dialogo.setVisible(true);

    if (dialogo.isConfirmado()) {
        Impresora nuevaImpresora = dialogo.obtenerImpresora();

        if (nuevaImpresora != null) {
            // Verifica si el ID ya existe en el árbol
            Impresora impresoraExistente = arbolBinario.buscar(nuevaImpresora.getId());
            if (impresoraExistente != null) {
                JOptionPane.showMessageDialog(this, "El ID ya existe en el árbol", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                arbolBinario.insertar(nuevaImpresora);
                JOptionPane.showMessageDialog(this, "Impresora agregada correctamente");
            }
        } else {
            // Manejo del caso cuando nuevaImpresora es null
            JOptionPane.showMessageDialog(this, "No se pudo agregar la impresora debido a errores en los datos ingresados.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

private void eliminarImpresora() {
    String input = JOptionPane.showInputDialog(this, "Ingrese el ID de la impresora a eliminar:");
    if (input == null || input.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Debe ingresar un ID.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    try {
        int id = Integer.parseInt(input);
        // Verifica si el ID existe antes de eliminar
        Impresora impresora = arbolBinario.buscar(id);
        if (impresora != null) {
            boolean eliminado = arbolBinario.eliminar(id);
            if (eliminado) {
                JOptionPane.showMessageDialog(this, "Operación de eliminación realizada.");
            }
            // No mostrar mensaje si el nodo no fue eliminado debido a tener dos hijos
        } else {
            JOptionPane.showMessageDialog(this, "El ID no se encuentra en el árbol.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "El ID debe ser un valor numérico.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    
private void buscarImpresora() {
    String input = JOptionPane.showInputDialog(this, "Ingrese el ID de la impresora a buscar:");
    if (input == null || input.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Debe ingresar un ID.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    try {
        int id = Integer.parseInt(input);
        Impresora impresora = arbolBinario.buscar(id);
        if (impresora != null) {
            // Crea y muestra el JDialog con la información de la impresora
            ImpresoraDialog dialogo = new ImpresoraDialog(this, impresora);
            dialogo.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "El ID no se encuentra en el árbol.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "El ID debe ser un valor numérico.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    private void mostrarArbol() {
    JFrame frame = new JFrame("Árbol Binario");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    ArbolPanel panel = new ArbolPanel(arbolBinario.getRaiz()); // Agrega un método getRaiz() si es necesario
    frame.add(panel);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}

     private void abrirDialogoRecorridos() {
        RecorridosDialog dialogo = new RecorridosDialog(this, true, arbolBinario);
        dialogo.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        btnInsertar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnGraficar = new javax.swing.JButton();
        btnRecorridos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnInsertar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnInsertar.setText("Insertar");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Árbol Binario");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("Seleccione una opción: ");

        btnEliminar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnEliminar.setText("Eliminar");

        btnBuscar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnBuscar.setText("Buscar");

        btnGraficar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnGraficar.setText("Árbol Gráfico");

        btnRecorridos.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnRecorridos.setText("Recorridos del Árbol Binario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel2)
                        .addGap(99, 99, 99)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGraficar))))
                .addContainerGap(171, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnRecorridos)
                .addGap(118, 118, 118))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnInsertar))
                .addGap(32, 32, 32)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnGraficar)
                .addGap(37, 37, 37)
                .addComponent(btnRecorridos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGraficar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnRecorridos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    // End of variables declaration//GEN-END:variables
}

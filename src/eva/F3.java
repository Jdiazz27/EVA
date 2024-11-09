package eva;

import javax.swing.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import org.json.JSONObject;

public class F3 extends javax.swing.JFrame {

    private DefaultListModel<String> listModel;
    private F2 historialFrame;

    public F3() {
        initComponents();
        listModel = new DefaultListModel<>();
        jList1.setModel(listModel);

        setLocationRelativeTo(null);

    }

    public F3(F2 historialFrame) {
        this.historialFrame = historialFrame;
        initComponents();
        listModel = new DefaultListModel<>();
        jList1.setModel(listModel);

        setLocationRelativeTo(null);
    }

    private void copiarMensajesRecursivo(String[] nuevaConversacion, int index) {
        if (index >= listModel.getSize()) { // Caso base: si index es igual al tamaño del listModel, terminar la recursión
            return;
        }
        nuevaConversacion[index] = listModel.getElementAt(index);// Copiar el mensaje en el índice actual
        copiarMensajesRecursivo(nuevaConversacion, index + 1); // Llamada recursiva con el siguiente índice
    }

    private void enviar(String userInput, int attempt) {
        int maxRetries = 3; // Número máximo de intentos
        if (attempt > maxRetries) {
            publish("Error: No se pudo conectar después de " + maxRetries + " intentos.");
            return;
        }
        new SwingWorker<Void, String>() {   //SwingWorker para ejecutar la solicitud en segundo plano
            @Override
            protected Void doInBackground() throws Exception {
                String modelName = "llama3.2";
                String promptText = userInput;
                try {
                    URL url = new URL("http://localhost:11434/api/generate");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json; utf-8");
                    conn.setRequestProperty("Accept", "application/json");
                    conn.setDoOutput(true);
                    String jsonInputString = String.format("{\"model\": \"%s\", \"prompt\": \"%s\", \"stream\": false}", modelName, promptText);
                    try ( OutputStream os = conn.getOutputStream()) {
                        byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                        os.write(input, 0, input.length);
                    }
                    int responseCode = conn.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
                        StringBuilder response = new StringBuilder();
                        String line;
                        while ((line = in.readLine()) != null) {
                            response.append(line);
                        }
                        in.close();
                        JSONObject jsonResponse = new JSONObject(response.toString());
                        String responseText = jsonResponse.getString("response");
                        publish("Eva: " + responseText);
                    } else {
                        publish("Error: Código de respuesta " + responseCode);
                        // Llamada recursiva si no fue exitoso
                        enviar(userInput, attempt + 1);
                    }
                } catch (IOException e) {
                    publish("Error: " + e.getMessage());
                    // Llamada recursiva si hubo una excepción
                    enviar(userInput, attempt + 1);
                }
                return null;
            }

            @Override
            protected void process(java.util.List<String> chunks) {
                for (String message : chunks) {
                    SwingUtilities.invokeLater(() -> listModel.addElement(message));
                }
            }
        }.execute();
    }

    private void publish(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnfin = new javax.swing.JButton();
        btnatras = new javax.swing.JButton();
        txtbot = new javax.swing.JTextField();
        btnenviar = new javax.swing.JButton();
        jList2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 115, -1, -1));

        btnfin.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        btnfin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eva/minus.png"))); // NOI18N
        btnfin.setBorderPainted(false);
        btnfin.setContentAreaFilled(false);
        btnfin.setFocusable(false);
        btnfin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnfinMouseClicked(evt);
            }
        });
        btnfin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfinActionPerformed(evt);
            }
        });
        jPanel1.add(btnfin, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 90, 40));

        btnatras.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        btnatras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eva/back.png"))); // NOI18N
        btnatras.setBorderPainted(false);
        btnatras.setContentAreaFilled(false);
        btnatras.setFocusable(false);
        btnatras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnatrasMouseClicked(evt);
            }
        });
        jPanel1.add(btnatras, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 90, 40));

        txtbot.setFont(new java.awt.Font("Ebrima", 2, 14)); // NOI18N
        txtbot.setText("Escribir mensaje a Eva...");
        txtbot.setBorder(null);
        txtbot.setDragEnabled(true);
        txtbot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbotActionPerformed(evt);
            }
        });
        jPanel1.add(txtbot, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 190, 30));

        btnenviar.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        btnenviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eva/send24.png"))); // NOI18N
        btnenviar.setBorder(null);
        btnenviar.setBorderPainted(false);
        btnenviar.setContentAreaFilled(false);
        btnenviar.setFocusable(false);
        btnenviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnenviarMouseClicked(evt);
            }
        });
        jPanel1.add(btnenviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, 80, 30));

        jList2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jList1.setBorder(null);
        jList1.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList2.setViewportView(jList1);

        jPanel1.add(jList2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 330, 290));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/3.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 450, 550));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnfinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnfinActionPerformed

    private void btnfinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnfinMouseClicked
        // Crear una nueva lista de conversaciones para el historial si no existe
        if (historialFrame == null) {
            ArrayList<String[]> historialConversaciones = new ArrayList<>();
            historialFrame = new F2(historialConversaciones);
        }
        String[] nuevaConversacion = new String[listModel.getSize()]; // Crear una nueva conversación de tamaño listModel.getSize()
        copiarMensajesRecursivo(nuevaConversacion, 0); // Llamar al método recursivo para copiar los mensajes en nuevaConversacion
        historialFrame.agregarConversacion(nuevaConversacion);// Añadir la conversación al historial y abrir `F2`
        historialFrame.setVisible(true);
        dispose();// Cerrar la ventana actual de `F3`
    }//GEN-LAST:event_btnfinMouseClicked

    private void btnatrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnatrasMouseClicked
        F1 frame = new F1(); // Crea una nueva instancia de F2
        frame.setVisible(true); // Hace visible el JFrame F2
        frame.setLocationRelativeTo(null); // Centra el JFrame F2 en la pantalla
        dispose();
    }//GEN-LAST:event_btnatrasMouseClicked

    private void btnenviarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnenviarMouseClicked
        String userInput = txtbot.getText(); // Obtiene el texto que el usuario ha escrito en el campo de texto 'txtbot'.
        if (!userInput.trim().isEmpty()) { // Verifica que el texto no esté vacío o compuesto solo de espacios.
            listModel.addElement("Tú: " + userInput); // Agrega el mensaje del usuario al modelo de la lista.
            txtbot.setText(""); // Limpia el campo de texto.
            enviar(userInput, 1); // Llama al método recursivo para enviar la solicitud y manejar los reintentos
        }
    }//GEN-LAST:event_btnenviarMouseClicked

    private void txtbotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbotActionPerformed

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
            java.util.logging.Logger.getLogger(F3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(F3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(F3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(F3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnatras;
    private javax.swing.JButton btnenviar;
    private javax.swing.JButton btnfin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtbot;
    // End of variables declaration//GEN-END:variables

}

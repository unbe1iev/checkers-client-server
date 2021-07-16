package Game;

import java.awt.event.KeyEvent;

public class chatFrame extends javax.swing.JFrame {
    static String textChat = "";

    public chatFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        chatDisplay = new javax.swing.JTextArea();
        chatField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        chatButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        chatDisplay.setEditable(false);
        chatDisplay.setColumns(20);
        chatDisplay.setRows(5);
        jScrollPane1.setViewportView(chatDisplay);

        chatField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                chatFieldKeyPressed(evt);
            }
        });

        jLabel1.setText("CHAT");

        jLabel2.setText("SAY:");

        chatButton.setText("SEND");
        chatButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chatButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chatField, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chatButton, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(chatField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chatButton))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void chatButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chatButtonMouseClicked
        if (GameFrame.whiteOne) textChat += "[white]: ";
        else textChat += "[black]: ";

        textChat += chatField.getText();
        textChat += "\n";
        GameFrame.message = chatField.getText();
        chatDisplay.setText(textChat);
        chatField.setText("");
    }//GEN-LAST:event_chatButtonMouseClicked

    private void chatFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chatFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            if (GameFrame.whiteOne) textChat += "[white]: ";
            else textChat += "[black]: ";

            textChat += chatField.getText();
            textChat += "\n";
            GameFrame.message = chatField.getText();
            chatDisplay.setText(textChat);
            chatField.setText("");
            }
    }//GEN-LAST:event_chatFieldKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chatButton;
    public static javax.swing.JTextArea chatDisplay;
    private javax.swing.JTextField chatField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

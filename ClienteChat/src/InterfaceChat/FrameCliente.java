/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceChat;

//import PacoteCliente.Mensagem;
import Servicos.ClienteServico; 
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.text.Document;
import PacoteCliente.Mensagem;
import PacoteCliente.Mensagem.Action;



/**
 *
 * @author idnil
 */
public class FrameCliente extends javax.swing.JFrame {

    /**
     * Creates new form InterfacecCliente
     */
    
    private Socket socket;
    private Mensagem mensagem;
    private ClienteServico servicocliente;
    
    public FrameCliente() {
        initComponents();
    }
    
    private class ListenerSocket implements Runnable
    {
        private ObjectInputStream recebemsg;
        
        public ListenerSocket(Socket socket)
        {
            try {
                this.recebemsg = new ObjectInputStream(socket.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(FrameCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

        
        public void run() 
        {
            Mensagem mensagem = null;           
            try {
                 //System.out.println("entrsddsddou");
                while   ((mensagem = (Mensagem) recebemsg.readObject()) !=  null)
                {
                    
                    /*
                        Recebe a ação que o servidor está enviando , atraves do metodo
                        getAcao() da msg que foi recebida pelo ouvinte
                    */             
                    Action acao  =  mensagem.getAcao();
                   
                    
                    /*
                        No cliente não precisa colocar ENVIAR_TODAS, pq 
                        o servidor não vai enviar mesg contendo todos.s
                    */
                    if (acao.equals(Action.CONECTAR))
                    {
                        conectar(mensagem);
                    }else if (acao.equals(Action.DESCONECTAR))
                    {
                        desconectar(mensagem);
                    }else if(acao.equals(Action.ENVIE_UMA))
                    {
                        //envio_uma(mensagem);
                        recebe(mensagem);
                        
                    }else if (acao.equals(Action.USUARIOS_ONLINE))
                    {
                        atualizarListaUsuario(mensagem);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(FrameCliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrameCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
        }
    }
    
    
    private void conectar (Mensagem mensagem )
    {
        this.MensagemRecebida.append(mensagem.getNome()+ "\n");
    }
    
    private void desconectar (Mensagem mensagem){};
    
    private void recebe (Mensagem mensagem)
    {
        this.MensagemRecebida.append(mensagem.getNome()+ "\n");
    }
    
    private void atualizarListaUsuario (Mensagem mensagem){}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        textonome = new javax.swing.JTextField();
        botao_conectar = new javax.swing.JButton();
        botao_disconectar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        listaAtualizarUsuario = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaOnline = new javax.swing.JList<>();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MensagemRecebida = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        MensagemEnviar = new javax.swing.JTextArea();
        botao_enviar = new javax.swing.JButton();
        botao_limparcampo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Conversar com usuário..."));

        textonome.setToolTipText("");
        textonome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textonomeActionPerformed(evt);
            }
        });

        botao_conectar.setText("Conectar");
        botao_conectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_conectarActionPerformed(evt);
            }
        });

        botao_disconectar.setText("Disconectar");
        botao_disconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_disconectarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(textonome)
                .addGap(22, 22, 22)
                .addComponent(botao_conectar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botao_disconectar)
                .addGap(6, 6, 6))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(textonome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(botao_conectar)
                .addComponent(botao_disconectar))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuários Online"));

        listaAtualizarUsuario.setText("Verificar Usuários");
        listaAtualizarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaAtualizarUsuarioActionPerformed(evt);
            }
        });

        listaOnline.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listaOnline);

        jButton6.setText("jButton6");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addGap(56, 56, 56))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(listaAtualizarUsuario)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(listaAtualizarUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        MensagemRecebida.setColumns(20);
        MensagemRecebida.setRows(5);
        jScrollPane1.setViewportView(MensagemRecebida);

        MensagemEnviar.setColumns(20);
        MensagemEnviar.setRows(5);
        jScrollPane2.setViewportView(MensagemEnviar);

        botao_enviar.setText("Enviar Mensagem");
        botao_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_enviarActionPerformed(evt);
            }
        });

        botao_limparcampo.setText("Limpar Campo");
        botao_limparcampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_limparcampoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(botao_enviar)
                        .addGap(18, 18, 18)
                        .addComponent(botao_limparcampo)
                        .addGap(41, 41, 41))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botao_enviar)
                            .addComponent(botao_limparcampo))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botao_conectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_conectarActionPerformed
        // TODO add your handling code here:
        String nome  = this.textonome.getText();
       
        
        if (!nome.isEmpty())
        {
            this.mensagem = new Mensagem();
            this.mensagem.setAcao(Action.CONECTAR);
            this.mensagem.setNome(nome);
            if (this.socket == null )
            {
                this.servicocliente = new ClienteServico();
                this.socket = this.servicocliente.conectar();
                new Thread(new ListenerSocket(this.socket)).start();
            }
            this.servicocliente.envio(mensagem);          
        }
    }//GEN-LAST:event_botao_conectarActionPerformed

    private void botao_disconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_disconectarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botao_disconectarActionPerformed

    private void botao_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_enviarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botao_enviarActionPerformed

    private void botao_limparcampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_limparcampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botao_limparcampoActionPerformed

    private void textonomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textonomeActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_textonomeActionPerformed

    private void listaAtualizarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaAtualizarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listaAtualizarUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(FrameCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea MensagemEnviar;
    private javax.swing.JTextArea MensagemRecebida;
    private javax.swing.JButton botao_conectar;
    private javax.swing.JButton botao_disconectar;
    private javax.swing.JButton botao_enviar;
    private javax.swing.JButton botao_limparcampo;
    private javax.swing.JButton jButton6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton listaAtualizarUsuario;
    private javax.swing.JList<String> listaOnline;
    private javax.swing.JTextField textonome;
    // End of variables declaration//GEN-END:variables
}

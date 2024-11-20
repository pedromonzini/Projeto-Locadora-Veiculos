/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.vroom.abas;

import java.sql.*;
import br.com.vroom.dal_cad.Principal;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
// alinha abaixo importa recursos da biblioteca rs2xml
import net.proteanit.sql.DbUtils;

/**
 * Esta classe representa uma aba de relatório de clientes.
 */
public class Aba_Relatorio_CLIENTES extends javax.swing.JInternalFrame {

    //usando variavel conexao do DAL(CAD)
    Connection conexao = null;
    /*
    PreparedStatement e ResultSet são frameworks do package java.sql
    Eles servem para preparar e executar as instruções SQL
     */
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Construtor da classe. Inicializa os componentes da interface gráfica e
     * estabelece a conexão com o banco de dados.
     */
    public Aba_Relatorio_CLIENTES() {
        initComponents();
        conexao = Principal.conector();
    }

    /**
     * Método para pesquisar clientes no banco de dados com base no nome.
     */
    private void pesquisar_clientes() {
        // Prepara e executa uma consulta SQL para buscar clientes por nome
        // Usa a biblioteca DbUtils para preencher a tabela com o resultado da consulta
        String slq = "select nomecliente as Nome, cpfcliente as CPF, telcliente as Telefone from tabclientes where nomecliente like ?";
        try {
            pst = conexao.prepareStatement(slq);
            // Passa o conteúdo da caixa de pesquisa para o ? e adiciona o %
            pst.setString(1, txt_C_PESQUISAR.getText() + "%");
            rs = pst.executeQuery();
            // Usa a biblioteca importada (rs2xml) para preencher a tabela com os resultados da consulta
            tbl_Clientes.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Clientes = new javax.swing.JTable();
        txt_C_PESQUISAR = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        tbl_Clientes = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbl_Clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "CPF", "Telefone"
            }
        ));
        tbl_Clientes.setFocusable(false);
        tbl_Clientes.getTableHeader().setReorderingAllowed(false);
        tbl_Clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Clientes);

        txt_C_PESQUISAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_C_PESQUISARActionPerformed(evt);
            }
        });
        txt_C_PESQUISAR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_C_PESQUISARKeyReleased(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/vroom/icons/MIDDLE_45X45_Search.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(374, Short.MAX_VALUE)
                .addComponent(txt_C_PESQUISAR, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txt_C_PESQUISAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(0, 0, 753, 495);
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_ClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ClientesMouseClicked

    }//GEN-LAST:event_tbl_ClientesMouseClicked

    private void txt_C_PESQUISARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_C_PESQUISARActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_C_PESQUISARActionPerformed

    private void txt_C_PESQUISARKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_C_PESQUISARKeyReleased
        // Método chamado quando o usuário digita na caixa de pesquisa
        // Chama o método pesquisar_clientes() para atualizar a tabela de clientes conforme o texto digitado
        pesquisar_clientes();
    }//GEN-LAST:event_txt_C_PESQUISARKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_Clientes;
    private javax.swing.JTextField txt_C_PESQUISAR;
    // End of variables declaration//GEN-END:variables
}

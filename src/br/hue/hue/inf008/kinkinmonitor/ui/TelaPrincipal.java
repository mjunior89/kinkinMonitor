package br.hue.hue.inf008.kinkinmonitor.ui;

import br.hue.hue.inf008.kinkinmonitor.controller.AreaMonitoradaController;
import br.hue.hue.inf008.kinkinmonitor.controller.UnidadeEuclidianaController;
import br.hue.hue.inf008.kinkinmonitor.controller.UnidadeManhattanController;
import br.hue.hue.inf008.kinkinmonitor.model.AreaMonitorada;
import br.hue.hue.inf008.kinkinmonitor.model.UnidadeMonitora;
import br.hue.hue.inf008.kinkinmonitor.persistence.DataSource;
import br.hue.hue.inf008.kinkinmonitor.ui.model.AreaMonitoradaTableModel;
import br.hue.hue.inf008.kinkinmonitor.ui.model.UnidadeMonitoraTableModel;
import java.awt.HeadlessException;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TelaPrincipal extends javax.swing.JFrame {

	public TelaPrincipal() {
		initComponents();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					// Inicialização da Base de dados
					new DataSource().initDataBase();
				} catch (Exception ex) {
					Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, "Deu pau na inicialização da 'Base de dados'.", ex);
					JOptionPane.showMessageDialog(null, "Deu pau na inicialização da 'Base de dados'.\n\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
				new TelaPrincipal().setVisible(true);
			}
		});
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAM = new javax.swing.JTable();
        btnViewAM = new javax.swing.JButton();
        btnEditAM = new javax.swing.JButton();
        btnDeleteAM = new javax.swing.JButton();
        btnCriarAM = new javax.swing.JButton();
        panelUMs = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaUM = new javax.swing.JTable();
        btnUMCriar = new javax.swing.JButton();
        btnUMEdit = new javax.swing.JButton();
        btnUMView = new javax.swing.JButton();
        btnUMDelete = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kinkin Monitor v1.0");
        setMinimumSize(new java.awt.Dimension(950, 685));
        setPreferredSize(new java.awt.Dimension(950, 685));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Áreas Monitoradas"));

        tabelaAM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaAM.setColumnSelectionAllowed(true);
        tabelaAM.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaAM.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaAM);
        tabelaAM.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btnViewAM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/map_magnify.png"))); // NOI18N
        btnViewAM.setText("Visualisar");
        btnViewAM.setEnabled(false);
        btnViewAM.setMaximumSize(null);
        btnViewAM.setMinimumSize(null);
        btnViewAM.setPreferredSize(null);
        btnViewAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAMActionPerformed(evt);
            }
        });

        btnEditAM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/map_edit.png"))); // NOI18N
        btnEditAM.setText("Editar");
        btnEditAM.setEnabled(false);
        btnEditAM.setMaximumSize(null);
        btnEditAM.setMinimumSize(null);
        btnEditAM.setPreferredSize(null);
        btnEditAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditAMActionPerformed(evt);
            }
        });

        btnDeleteAM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/map_delete.png"))); // NOI18N
        btnDeleteAM.setText("Excluir");
        btnDeleteAM.setEnabled(false);
        btnDeleteAM.setMaximumSize(null);
        btnDeleteAM.setMinimumSize(null);
        btnDeleteAM.setPreferredSize(null);
        btnDeleteAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAMActionPerformed(evt);
            }
        });

        btnCriarAM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/map_add.png"))); // NOI18N
        btnCriarAM.setText("Criar");
        btnCriarAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarAMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnViewAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(btnDeleteAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCriarAM))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnCriarAM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        btnViewAM.getAccessibleContext().setAccessibleName("btnVisualisar");

        panelUMs.setBorder(javax.swing.BorderFactory.createTitledBorder("Unidades Monitoras"));
        panelUMs.setEnabled(false);

        tabelaUM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tabelaUM);

        btnUMCriar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/transmit_blue_add.png"))); // NOI18N
        btnUMCriar.setText("Criar");
        btnUMCriar.setEnabled(false);
        btnUMCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUMCriarActionPerformed(evt);
            }
        });

        btnUMEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/transmit_blue_edit.png"))); // NOI18N
        btnUMEdit.setText("Editar");
        btnUMEdit.setEnabled(false);

        btnUMView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/transmit_blue_magnify.png"))); // NOI18N
        btnUMView.setText("Visualizar");
        btnUMView.setEnabled(false);

        btnUMDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/transmit_blue_delete.png"))); // NOI18N
        btnUMDelete.setText("Excluir");
        btnUMDelete.setEnabled(false);

        javax.swing.GroupLayout panelUMsLayout = new javax.swing.GroupLayout(panelUMs);
        panelUMs.setLayout(panelUMsLayout);
        panelUMsLayout.setHorizontalGroup(
            panelUMsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUMsLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelUMsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUMEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUMCriar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUMView, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUMDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelUMsLayout.setVerticalGroup(
            panelUMsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(panelUMsLayout.createSequentialGroup()
                .addComponent(btnUMCriar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUMEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUMView)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUMDelete)
                .addGap(0, 54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelUMs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 605, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelUMs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
		try {
			loadAMTableModel();
			addTableAMSelectionListener();
		} catch (Exception e) {
			Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, "Falha na listagem das Áreas monitoradas.", e);
			JOptionPane.showMessageDialog(null, "Falha na listagem das Áreas monitoradas.\n\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
    }//GEN-LAST:event_formWindowOpened

	private void loadAMTableModel() throws Exception {
		List<AreaMonitorada> areas = new AreaMonitoradaController().listAll();
		AreaMonitoradaTableModel dtm = new AreaMonitoradaTableModel(areas);
		tabelaAM.setModel(dtm);
	}

	private void addTableAMSelectionListener() {
		tabelaAM.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (tabelaAM.getSelectedRow() > -1) {
					btnViewAM.setEnabled(true);
					btnEditAM.setEnabled(true);
					btnDeleteAM.setEnabled(true);
				} else {
					btnViewAM.setEnabled(false);
					btnEditAM.setEnabled(false);
					btnDeleteAM.setEnabled(false);
					btnUMCriar.setEnabled(false);
					UnidadeMonitoraTableModel dtm = new UnidadeMonitoraTableModel(new ArrayList<UnidadeMonitora>(0));
					tabelaUM.setModel(dtm);
					panelUMs.setBorder(javax.swing.BorderFactory.createTitledBorder("Unidades Monitoras "));
					panelUMs.setEnabled(false);
				}
			}
		});
	}

    private void btnViewAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAMActionPerformed
		loadUMTableModel();
		btnUMCriar.setEnabled(true);
		panelUMs.setEnabled(true);

    }//GEN-LAST:event_btnViewAMActionPerformed

	private void loadUMTableModel() throws HeadlessException {
		AreaMonitorada areaSelecionada = (AreaMonitorada) tabelaAM.getModel().getValueAt(tabelaAM.getSelectedRow(), 0);
		try {
			areaSelecionada.getUnidades().addAll(new UnidadeEuclidianaController().listAllByAreaMonitorada(areaSelecionada));
			areaSelecionada.getUnidades().addAll(new UnidadeManhattanController().listAllByAreaMonitorada(areaSelecionada));
		} catch (Exception e) {
			Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, "Falha na listagem das Unidades Monitoras.", e);
			JOptionPane.showMessageDialog(null, "Falha na listagem das Unidades Monitoras.\n\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		UnidadeMonitoraTableModel dtm = new UnidadeMonitoraTableModel(areaSelecionada.getUnidades());
		panelUMs.setBorder(javax.swing.BorderFactory.createTitledBorder("Unidades Monitoras - Área: " + areaSelecionada.getNome()));
		tabelaUM.setModel(dtm);
	}

    private void btnEditAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditAMActionPerformed
		AreaMonitorada areaSelecionada = (AreaMonitorada) tabelaAM.getModel().getValueAt(tabelaAM.getSelectedRow(), 0);
		AreaMonitoradaCEForm dialog = new AreaMonitoradaCEForm(new javax.swing.JFrame(), true);
		dialog.setLocationRelativeTo(this);
		dialog.setArea(areaSelecionada);
		dialog.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				try {
					loadAMTableModel();
				} catch (Exception ex) {
					Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
				}
				super.windowClosed(e);
			}

			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				super.windowClosed(e);
			}
		});
		dialog.setVisible(true);
    }//GEN-LAST:event_btnEditAMActionPerformed

    private void btnDeleteAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAMActionPerformed
		Object[] options = {"Sim", "Não"};
		int n = JOptionPane.showOptionDialog(this, "Deseja realmente excluir esta Área Monitorada?", "Confirmação",
			JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		if (n == 0) {
			AreaMonitorada areaSelecionada = (AreaMonitorada) tabelaAM.getModel().getValueAt(tabelaAM.getSelectedRow(), 0);
			try {
				new AreaMonitoradaController().delete(areaSelecionada);
				loadAMTableModel();
				Logger.getLogger(TelaPrincipal.class.getName()).log(Level.INFO, "Exclusão da Área Monitorada realisada com sucesso.", areaSelecionada);
				JOptionPane.showMessageDialog(null, "Exclusão da Área Monitorada realisada com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, "Falha na exclusão da Área Monitorada.", e);
				JOptionPane.showMessageDialog(null, "Falha na exclusão da Área Monitorada.\n\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
    }//GEN-LAST:event_btnDeleteAMActionPerformed

    private void btnCriarAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarAMActionPerformed
		AreaMonitoradaCEForm dialog = new AreaMonitoradaCEForm(new javax.swing.JFrame(), true);
		dialog.setLocationRelativeTo(this);
		dialog.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				try {
					loadAMTableModel();
				} catch (Exception ex) {
					Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
				}
				super.windowClosed(e);
			}

			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				super.windowClosed(e);
			}
		});
		dialog.setVisible(true);
    }//GEN-LAST:event_btnCriarAMActionPerformed

    private void btnUMCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUMCriarActionPerformed
		UnidadeMonitoraCEForm dialog = new UnidadeMonitoraCEForm(new javax.swing.JFrame(), true);
		dialog.setLocationRelativeTo(this);
		dialog.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				try {
					loadUMTableModel();
				} catch (Exception ex) {
					Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
				}
				super.windowClosed(e);
			}

			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				super.windowClosed(e);
			}
		});
		dialog.setVisible(true);
    }//GEN-LAST:event_btnUMCriarActionPerformed

    // <editor-fold defaultstate="collapsed" desc="Variables declaration">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriarAM;
    private javax.swing.JButton btnDeleteAM;
    private javax.swing.JButton btnEditAM;
    private javax.swing.JButton btnUMCriar;
    private javax.swing.JButton btnUMDelete;
    private javax.swing.JButton btnUMEdit;
    private javax.swing.JButton btnUMView;
    private javax.swing.JButton btnViewAM;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel panelUMs;
    private javax.swing.JTable tabelaAM;
    private javax.swing.JTable tabelaUM;
    // End of variables declaration//GEN-END:variables
	// </editor-fold>
}

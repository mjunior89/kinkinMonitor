package br.hue.hue.inf008.kinkinmonitor.ui;

import br.hue.hue.inf008.kinkinmonitor.controller.AreaMonitoradaController;
import br.hue.hue.inf008.kinkinmonitor.controller.UnidadeEuclidianaController;
import br.hue.hue.inf008.kinkinmonitor.controller.UnidadeManhattanController;
import br.hue.hue.inf008.kinkinmonitor.controller.UnidadeMonitoraController;
import br.hue.hue.inf008.kinkinmonitor.model.AreaMonitorada;
import br.hue.hue.inf008.kinkinmonitor.model.UnidadeEuclidiana;
import br.hue.hue.inf008.kinkinmonitor.model.UnidadeManhattan;
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
	}

	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, e.getMessage(), e);
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
        btnUMCreate = new javax.swing.JButton();
        btnUMEdit = new javax.swing.JButton();
        btnUMView = new javax.swing.JButton();
        btnUMDelete = new javax.swing.JButton();
        btnUMMonitorar = new javax.swing.JButton();
        lblMap = new javax.swing.JLabel();

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
        setMinimumSize(new java.awt.Dimension(841, 712));
        setPreferredSize(new java.awt.Dimension(846, 794));
        setResizable(false);
        setSize(new java.awt.Dimension(846, 794));
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
        btnViewAM.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
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
        btnEditAM.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
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
        btnDeleteAM.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
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
        btnCriarAM.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCriarAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarAMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnViewAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(btnDeleteAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCriarAM))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnCriarAM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEditAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDeleteAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnViewAM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        tabelaUM.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(tabelaUM);

        btnUMCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/transmit_blue_add.png"))); // NOI18N
        btnUMCreate.setText("Criar");
        btnUMCreate.setEnabled(false);
        btnUMCreate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUMCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUMCreateActionPerformed(evt);
            }
        });

        btnUMEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/transmit_blue_edit.png"))); // NOI18N
        btnUMEdit.setText("Editar");
        btnUMEdit.setEnabled(false);
        btnUMEdit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUMEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUMEditActionPerformed(evt);
            }
        });

        btnUMView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/transmit_blue_magnify.png"))); // NOI18N
        btnUMView.setText("Visualizar");
        btnUMView.setEnabled(false);
        btnUMView.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUMView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUMViewActionPerformed(evt);
            }
        });

        btnUMDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/transmit_blue_delete.png"))); // NOI18N
        btnUMDelete.setText("Excluir");
        btnUMDelete.setEnabled(false);
        btnUMDelete.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUMDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUMDeleteActionPerformed(evt);
            }
        });

        btnUMMonitorar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/transmit_blue_go.png"))); // NOI18N
        btnUMMonitorar.setText("Monitorar");
        btnUMMonitorar.setEnabled(false);
        btnUMMonitorar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUMMonitorar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUMMonitorarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelUMsLayout = new javax.swing.GroupLayout(panelUMs);
        panelUMs.setLayout(panelUMsLayout);
        panelUMsLayout.setHorizontalGroup(
            panelUMsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUMsLayout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelUMsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUMEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUMCreate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUMView, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUMDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUMMonitorar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );
        panelUMsLayout.setVerticalGroup(
            panelUMsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUMsLayout.createSequentialGroup()
                .addComponent(btnUMCreate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUMMonitorar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUMView)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUMEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUMDelete)
                .addContainerGap())
            .addGroup(panelUMsLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lblMap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/Dinosaur_Land_-_Super_Mario_World.png"))); // NOI18N
        lblMap.setText("      ");
        lblMap.setEnabled(false);
        lblMap.setName(""); // NOI18N

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMap, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblMap, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelUMs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblMap.getAccessibleContext().setAccessibleName(" ");
        lblMap.getAccessibleContext().setAccessibleDescription(" ");
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
		try {
			loadAMTableModel();
			addTableAMSelectionListener();
			addTableUMSelectionListener();
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
			@Override
			public void valueChanged(ListSelectionEvent event) {
				if (tabelaAM.getSelectedRow() > -1) {
					btnViewAM.setEnabled(true);
					btnEditAM.setEnabled(true);
					btnDeleteAM.setEnabled(true);
				} else {
					btnViewAM.setEnabled(false);
					btnEditAM.setEnabled(false);
					btnDeleteAM.setEnabled(false);
					btnUMCreate.setEnabled(false);
					btnUMMonitorar.setEnabled(false);
				}
				AMSelectedAction();
			}
		});
	}

	private void AMSelectedAction() {
		UnidadeMonitoraTableModel dtm = new UnidadeMonitoraTableModel(new ArrayList<>(0));
		tabelaUM.setModel(dtm);
		panelUMs.setBorder(javax.swing.BorderFactory.createTitledBorder("Unidades Monitoras "));
		panelUMs.setEnabled(false);
		lblMap.setEnabled(false);
		tabelaUM.getColumn("tipo").setWidth(0);
		tabelaUM.getColumn("tipo").setMinWidth(0);
		tabelaUM.getColumn("tipo").setMaxWidth(0);
	}

	private void addTableUMSelectionListener() {
		tabelaUM.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				if (tabelaUM.getSelectedRow() > -1) {
					btnUMView.setEnabled(true);
					btnUMEdit.setEnabled(true);
					btnUMDelete.setEnabled(true);
				} else {
					btnUMView.setEnabled(false);
					btnUMEdit.setEnabled(false);
					btnUMDelete.setEnabled(false);
				}
			}
		});
	}

    private void btnViewAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAMActionPerformed
		loadUMTableModel();
		btnUMCreate.setEnabled(true);
		btnUMMonitorar.setEnabled(true);
		panelUMs.setEnabled(true);
//		lblMap.setEnabled(true);
    }//GEN-LAST:event_btnViewAMActionPerformed

	private void loadUMTableModel() throws HeadlessException {
		AreaMonitorada areaSelecionada = (AreaMonitorada) tabelaAM.getModel().getValueAt(tabelaAM.getSelectedRow(), 0);
		try {
			areaSelecionada.setUnidades(new ArrayList<>());
			areaSelecionada.getUnidades().addAll(new UnidadeEuclidianaController().listAllByAreaMonitorada(areaSelecionada));
			areaSelecionada.getUnidades().addAll(new UnidadeManhattanController().listAllByAreaMonitorada(areaSelecionada));
		} catch (Exception e) {
			Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, "Falha na listagem das Unidades Monitoras.", e);
			JOptionPane.showMessageDialog(null, "Falha na listagem das Unidades Monitoras.\n\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		UnidadeMonitoraTableModel dtm = new UnidadeMonitoraTableModel(areaSelecionada.getUnidades());
		panelUMs.setBorder(javax.swing.BorderFactory.createTitledBorder("Unidades Monitoras - Área: " + areaSelecionada.getNome()));
		tabelaUM.setModel(dtm);
		tabelaUM.getColumn("tipo").setWidth(0);
		tabelaUM.getColumn("tipo").setMinWidth(0);
		tabelaUM.getColumn("tipo").setMaxWidth(0);
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
					Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, "Erro Inesperado.", ex);
				}
				super.windowClosed(e);
			}

			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				super.windowClosed(e);
			}
		});
		dialog.setTitle("Editar Área Monitorada.");
		dialog.setVisible(true);
    }//GEN-LAST:event_btnEditAMActionPerformed

    private void btnDeleteAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAMActionPerformed
		Object[] options = {"Sim", "Não"};
		int n = JOptionPane.showOptionDialog(this, "Deseja realmente excluir esta Área Monitorada e suas respectivas Unidades Monitoras?", "Confirmação",
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
					Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, "Erro Inesperado.", ex);
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

    private void btnUMCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUMCreateActionPerformed
		UnidadeMonitoraCEForm dialog = new UnidadeMonitoraCEForm(new javax.swing.JFrame(), true);
		dialog.setLocationRelativeTo(this);
		AreaMonitorada areaSelecionada = (AreaMonitorada) tabelaAM.getModel().getValueAt(tabelaAM.getSelectedRow(), 0);
		dialog.setArea(areaSelecionada);
		dialog.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				try {
					loadUMTableModel();
				} catch (Exception ex) {
					Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, "Erro Inesperado.", ex);
				}
				super.windowClosed(e);
			}

			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				super.windowClosed(e);
			}
		});
		dialog.setVisible(true);
    }//GEN-LAST:event_btnUMCreateActionPerformed

    private void btnUMEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUMEditActionPerformed
		UnidadeMonitoraCEForm dialog = new UnidadeMonitoraCEForm(new javax.swing.JFrame(), true);
		dialog.setLocationRelativeTo(this);
		AreaMonitorada areaSelecionada = (AreaMonitorada) tabelaAM.getModel().getValueAt(tabelaAM.getSelectedRow(), 0);
		dialog.setArea(areaSelecionada);
		String nomeUnidade = tabelaUM.getModel().getValueAt(tabelaUM.getSelectedRow(), 0).toString();
		String tipo = tabelaUM.getModel().getValueAt(tabelaUM.getSelectedRow(), 6).toString();
		UnidadeMonitora unidadeSelecionada = null;
		try {
			Class classTipounidade = UnidadeMonitora.class;
			if (tipo.equalsIgnoreCase("br.hue.hue.inf008.kinkinmonitor.model.UnidadeManhattan")) {
				classTipounidade = UnidadeManhattan.class;
			} else if (tipo.equalsIgnoreCase("br.hue.hue.inf008.kinkinmonitor.model.UnidadeEuclidiana")) {
				classTipounidade = UnidadeEuclidiana.class;
			}
			unidadeSelecionada = (UnidadeMonitora) new UnidadeMonitoraController(classTipounidade).findById(nomeUnidade);
		} catch (Exception e) {
			Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, "Erro inesperado.", e);
		}
		dialog.setUnidade(unidadeSelecionada);
		dialog.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				try {
					loadUMTableModel();
				} catch (Exception ex) {
					Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, "Erro Inesperado.", ex);
				}
				super.windowClosed(e);
			}

			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				super.windowClosed(e);
			}
		});
		dialog.cbTipoUnidade.setEnabled(false);
		dialog.setTitle("Editar Unidade Monitora.");
		dialog.setVisible(true);
    }//GEN-LAST:event_btnUMEditActionPerformed

    private void btnUMViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUMViewActionPerformed
		UnidadeMonitoraVForm dialog = new UnidadeMonitoraVForm(new javax.swing.JFrame(), true);
		dialog.setLocationRelativeTo(this);
		AreaMonitorada areaSelecionada = (AreaMonitorada) tabelaAM.getModel().getValueAt(tabelaAM.getSelectedRow(), 0);
		dialog.setArea(areaSelecionada);
		String nomeUnidade = tabelaUM.getModel().getValueAt(tabelaUM.getSelectedRow(), 0).toString();
		String tipo = tabelaUM.getModel().getValueAt(tabelaUM.getSelectedRow(), 6).toString();
		UnidadeMonitora unidadeSelecionada = null;
		try {
			Class classTipounidade = UnidadeMonitora.class;
			if (tipo.equalsIgnoreCase("br.hue.hue.inf008.kinkinmonitor.model.UnidadeManhattan")) {
				classTipounidade = UnidadeManhattan.class;
			} else if (tipo.equalsIgnoreCase("br.hue.hue.inf008.kinkinmonitor.model.UnidadeEuclidiana")) {
				classTipounidade = UnidadeEuclidiana.class;
			}
			unidadeSelecionada = (UnidadeMonitora) new UnidadeMonitoraController(classTipounidade).findById(nomeUnidade);
		} catch (Exception e) {
			Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, "Erro inesperado.", e);
		}
		dialog.setUnidade(unidadeSelecionada);
		dialog.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				super.windowClosed(e);
			}

			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				super.windowClosed(e);
			}
		});
		dialog.setVisible(true);
    }//GEN-LAST:event_btnUMViewActionPerformed

    private void btnUMDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUMDeleteActionPerformed
		Object[] options = {"Sim", "Não"};
		int n = JOptionPane.showOptionDialog(this, "Deseja realmente excluir esta Unidade Monitora?", "Confirmação",
			JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		if (n == 0) {
			String nomeUnidade = tabelaUM.getModel().getValueAt(tabelaUM.getSelectedRow(), 0).toString();
			String tipo = tabelaUM.getModel().getValueAt(tabelaUM.getSelectedRow(), 6).toString();
			UnidadeMonitora unidadeSelecionada;
			try {
				Class classTipounidade = UnidadeMonitora.class;
				if (tipo.equalsIgnoreCase("br.hue.hue.inf008.kinkinmonitor.model.UnidadeManhattan")) {
					classTipounidade = UnidadeManhattan.class;
				} else if (tipo.equalsIgnoreCase("br.hue.hue.inf008.kinkinmonitor.model.UnidadeEuclidiana")) {
					classTipounidade = UnidadeEuclidiana.class;
				}
				unidadeSelecionada = (UnidadeMonitora) new UnidadeMonitoraController(classTipounidade).findById(nomeUnidade);
				int r = new UnidadeMonitoraController(unidadeSelecionada.getClass()).delete(unidadeSelecionada);
				loadUMTableModel();
				if (r > 0) {
					Logger.getLogger(TelaPrincipal.class.getName()).log(Level.INFO, "Exclusão da Unidade Monitora realisada com sucesso.", unidadeSelecionada);
					JOptionPane.showMessageDialog(null, "Exclusão da Unidade Monitora realisada com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e) {
				Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, "Falha na exclusão da Unidade Monitora.", e);
				JOptionPane.showMessageDialog(null, "Falha na exclusão da Unidade Monitora.\n\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
    }//GEN-LAST:event_btnUMDeleteActionPerformed

    private void btnUMMonitorarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUMMonitorarActionPerformed
		UnidadeMonitoraMForm dialog = new UnidadeMonitoraMForm(new javax.swing.JFrame(), true);
		dialog.setLocationRelativeTo(this);
		AreaMonitorada areaSelecionada = (AreaMonitorada) tabelaAM.getModel().getValueAt(tabelaAM.getSelectedRow(), 0);
		dialog.setArea(areaSelecionada);
		dialog.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				loadUMTableModel();
				super.windowClosed(e);
			}

			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				super.windowClosed(e);
			}
		});
		dialog.setVisible(true);
    }//GEN-LAST:event_btnUMMonitorarActionPerformed

    // <editor-fold defaultstate="collapsed" desc="Variables declaration">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriarAM;
    private javax.swing.JButton btnDeleteAM;
    private javax.swing.JButton btnEditAM;
    private javax.swing.JButton btnUMCreate;
    private javax.swing.JButton btnUMDelete;
    private javax.swing.JButton btnUMEdit;
    private javax.swing.JButton btnUMMonitorar;
    private javax.swing.JButton btnUMView;
    private javax.swing.JButton btnViewAM;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblMap;
    private javax.swing.JPanel panelUMs;
    private javax.swing.JTable tabelaAM;
    private javax.swing.JTable tabelaUM;
    // End of variables declaration//GEN-END:variables
	// </editor-fold>
}

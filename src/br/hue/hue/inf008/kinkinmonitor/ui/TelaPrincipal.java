package br.hue.hue.inf008.kinkinmonitor.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.DefaultListSelectionModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import br.hue.hue.inf008.kinkinmonitor.controller.AreaMonitoradaController;
import br.hue.hue.inf008.kinkinmonitor.controller.UnidadeMonitoraController;
import br.hue.hue.inf008.kinkinmonitor.model.AreaMonitorada;
import br.hue.hue.inf008.kinkinmonitor.model.UnidadeEuclidiana;
import br.hue.hue.inf008.kinkinmonitor.model.UnidadeManhattan;
import br.hue.hue.inf008.kinkinmonitor.model.UnidadeMonitora;
import br.hue.hue.inf008.kinkinmonitor.persistence.DataSource;
import br.hue.hue.inf008.kinkinmonitor.ui.model.AreaMonitoradaTableModel;
import br.hue.hue.inf008.kinkinmonitor.ui.model.UnidadeMonitoraTableModel;
import java.awt.Font;
import java.awt.Toolkit;

public class TelaPrincipal {

	protected JFrame frame;

	public TelaPrincipal() {
		initialize();
		AMSelectedAction();
		frame.setLocationRelativeTo(null);
	}

	public static void main(String args[]) {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, e.getMessage(), e);
		}
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					// Inicialização da Base de dados
					new DataSource().initDataBase();
				} catch (Exception e) {
					Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, "Deu pau na inicialização da 'Base de dados'.", e);
					JOptionPane.showMessageDialog(null, "Deu pau na inicialização da 'Base de dados'.\n\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
				TelaPrincipal window = new TelaPrincipal();
				window.frame.setVisible(true);
			}
		});
	}

	private void formWindowOpened(WindowEvent evt) {
		try {
			loadAMTableModel();
			addTableAMSelectionListener();
			addTableUMSelectionListener();
		} catch (Exception e) {
			Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, "Falha na listagem das Áreas monitoradas.", e);
			JOptionPane.showMessageDialog(null, "Falha na listagem das Áreas monitoradas.\n\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		frame.repaint();
	}

	private void loadAMTableModel() throws Exception {
		List<AreaMonitorada> areas = new AreaMonitoradaController().listAll();
		AreaMonitoradaTableModel dtm = new AreaMonitoradaTableModel(areas);
		tabelaAM.setModel(dtm);
	}

	private void loadUMTableModel() throws HeadlessException {
		AreaMonitorada areaSelecionada = (AreaMonitorada) tabelaAM.getModel().getValueAt(tabelaAM.getSelectedRow(), 0);
		try {
			areaSelecionada.setUnidades(new ArrayList<>());
			areaSelecionada.getUnidades().addAll(new UnidadeMonitoraController<>(UnidadeEuclidiana.class).listAllByAreaMonitorada(areaSelecionada));
			areaSelecionada.getUnidades().addAll(new UnidadeMonitoraController<>(UnidadeManhattan.class).listAllByAreaMonitorada(areaSelecionada));
		} catch (Exception e) {
			Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, "Falha na listagem das Unidades Monitoras.", e);
			JOptionPane.showMessageDialog(null, "Falha na listagem das Unidades Monitoras.\n\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		UnidadeMonitoraTableModel dtm = new UnidadeMonitoraTableModel(areaSelecionada.getUnidades());
		panelUMs.setBorder(BorderFactory.createTitledBorder("Unidades Monitoras - Área: " + areaSelecionada.getNome()));
		tabelaUM.setModel(dtm);
		tabelaUM.setEnabled(true);
		tabelaUM.getColumn("object").setWidth(0);
		tabelaUM.getColumn("object").setMinWidth(0);
		tabelaUM.getColumn("object").setMaxWidth(0);

		clearUMMap();

		for (UnidadeMonitora unit : areaSelecionada.getUnidades()) {
			int latitudeUM = unit.getLocalizacao().getLatitude() - 1;
			int longitudeUM = unit.getLocalizacao().getLongitude() - 1;
			tbMap.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			tbMap.setCellSelectionEnabled(true);
			String umIcon = "";
			if (unit instanceof UnidadeEuclidiana) {
				umIcon = "﴾۝﴿";
				tbMap.changeSelection(latitudeUM, longitudeUM, false, false);
				tbMap.setSelectionBackground(new Color(255, 1, 1, 127));
			} else if (unit instanceof UnidadeManhattan) {
				umIcon = "﴾۞﴿";
				tbMap.changeSelection(latitudeUM, longitudeUM, false, false);
				tbMap.setSelectionBackground(new Color(1, 1, 255, 127));
			}
			tbMap.setValueAt(umIcon, latitudeUM, longitudeUM);
		}
		frame.repaint();
	}

	private void AMSelectedAction() {
		UnidadeMonitoraTableModel dtm = new UnidadeMonitoraTableModel(new ArrayList<>(0));
		tabelaUM.setModel(dtm);
		tabelaUM.setEnabled(false);
		panelUMs.setBorder(BorderFactory.createTitledBorder("Unidades Monitoras "));
		panelUMs.setEnabled(false);
		lblMap.setEnabled(false);
		btnUMCreate.setEnabled(false);
		btnUMMonitorar.setEnabled(false);
		btnUMLocalizar.setEnabled(false);
		clearUMMap();
		tabelaUM.getColumn("object").setWidth(0);
		tabelaUM.getColumn("object").setMinWidth(0);
		tabelaUM.getColumn("object").setMaxWidth(0);
		tbMap.clearSelection();
		frame.repaint();
	}

	private void clearUMMap() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				tbMap.setValueAt(null, i, j);
			}
		}
	}

	private void addTableAMSelectionListener() {
		tabelaAM.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				if (tabelaAM.getSelectedRow() > -1) {
					btnAMView.setEnabled(true);
					btnAMEdit.setEnabled(true);
					btnAMDelete.setEnabled(true);
				} else {
					btnAMView.setEnabled(false);
					btnAMEdit.setEnabled(false);
					btnAMDelete.setEnabled(false);
					btnUMCreate.setEnabled(false);
					btnUMMonitorar.setEnabled(false);
					btnUMLocalizar.setEnabled(false);
				}
				frame.repaint();
				AMSelectedAction();
			}
		});
	}

	private void addTableUMSelectionListener() {
		tabelaUM.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				if (tabelaUM.getSelectedRow() > -1) {
					btnUMView.setEnabled(true);
					btnUMEdit.setEnabled(true);
					btnUMDelete.setEnabled(true);
					UnidadeMonitora unit = (UnidadeMonitora) tabelaUM.getValueAt(((DefaultListSelectionModel) event.getSource()).getLeadSelectionIndex(), 7);
					tbMap.setCellSelectionEnabled(true);
					tbMap.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
					if (unit instanceof UnidadeEuclidiana) {
						tbMap.changeSelection(unit.getLocalizacao().getLatitude() - 1, unit.getLocalizacao().getLongitude() - 1, false, false);
						tbMap.setSelectionBackground(new Color(255, 1, 1, 127));
					} else if (unit instanceof UnidadeManhattan) {
						tbMap.changeSelection(unit.getLocalizacao().getLatitude() - 1, unit.getLocalizacao().getLongitude() - 1, false, false);
						tbMap.setSelectionBackground(new Color(1, 1, 255, 127));
					}
					frame.repaint();
				} else {
					btnUMView.setEnabled(false);
					btnUMEdit.setEnabled(false);
					btnUMDelete.setEnabled(false);
					frame.repaint();
				}
			}
		});
	}

	private void btnViewAMActionPerformed(ActionEvent evt) {
		loadUMTableModel();
		tbMap.clearSelection();
		btnUMCreate.setEnabled(true);
		btnUMMonitorar.setEnabled(true);
		btnUMLocalizar.setEnabled(true);
		panelUMs.setEnabled(true);
		lblMap.setEnabled(true);
	}

	private void btnEditAMActionPerformed(ActionEvent evt) {
		AreaMonitorada areaSelecionada = (AreaMonitorada) tabelaAM.getModel().getValueAt(tabelaAM.getSelectedRow(), 0);
		AreaMonitoradaCEForm dialog = new AreaMonitoradaCEForm(new JFrame(), true);
		dialog.frame.setLocationRelativeTo(frame);
		dialog.setArea(areaSelecionada);
		dialog.frame.addWindowListener(new WindowAdapter() {
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
			public void windowClosing(WindowEvent e) {
				super.windowClosed(e);
			}
		});
		dialog.frame.setTitle("Editar Área Monitorada.");
		dialog.frame.setVisible(true);
	}

	private void btnDeleteAMActionPerformed(ActionEvent evt) {
		Object[] options = { "Sim", "Não" };
		int n = JOptionPane.showOptionDialog(frame, "Deseja realmente excluir esta Área Monitorada e suas respectivas Unidades Monitoras?", "Confirmação", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
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
	}

	private void btnCriarAMActionPerformed(ActionEvent evt) {
		AreaMonitoradaCEForm dialog = new AreaMonitoradaCEForm(new JFrame(), true);
		dialog.frame.setLocationRelativeTo(frame);
		dialog.frame.addWindowListener(new WindowAdapter() {
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
			public void windowClosing(WindowEvent e) {
				super.windowClosed(e);
			}
		});
		dialog.frame.setTitle("Criar Área Monitorada");
		dialog.frame.setVisible(true);
		frame.repaint();
	}

	private void btnUMCreateActionPerformed(ActionEvent evt) {
		UnidadeMonitoraCEForm dialog = new UnidadeMonitoraCEForm(new JFrame(), true);
		dialog.frame.setLocationRelativeTo(frame);
		AreaMonitorada areaSelecionada = (AreaMonitorada) tabelaAM.getModel().getValueAt(tabelaAM.getSelectedRow(), 0);
		dialog.setArea(areaSelecionada);
		dialog.frame.addWindowListener(new WindowAdapter() {
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
			public void windowClosing(WindowEvent e) {
				super.windowClosed(e);
			}
		});
		dialog.frame.setTitle("Criar Unidade Monitora.");
		dialog.frame.setVisible(true);
	}

	private void btnUMEditActionPerformed(ActionEvent evt) {
		UnidadeMonitoraCEForm dialog = new UnidadeMonitoraCEForm(new JFrame(), true);
		dialog.frame.setLocationRelativeTo(frame);
		AreaMonitorada areaSelecionada = (AreaMonitorada) tabelaAM.getModel().getValueAt(tabelaAM.getSelectedRow(), 0);
		dialog.setArea(areaSelecionada);
		UnidadeMonitora unidadeSelecionada = (UnidadeMonitora) tabelaUM.getModel().getValueAt(tabelaUM.getSelectedRow(), 7);
		dialog.setUnidade(unidadeSelecionada);
		dialog.frame.addWindowListener(new WindowAdapter() {
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
			public void windowClosing(WindowEvent e) {
				super.windowClosed(e);
			}
		});
		dialog.cbTipoUnidade.setEnabled(false);
		dialog.frame.setTitle("Editar Unidade Monitora.");
		dialog.frame.setVisible(true);
	}

	private void btnUMViewActionPerformed(ActionEvent evt) {
		UnidadeMonitoraVForm dialog = new UnidadeMonitoraVForm(new JFrame(), true);
		dialog.frame.setLocationRelativeTo(frame);
		AreaMonitorada areaSelecionada = (AreaMonitorada) tabelaAM.getModel().getValueAt(tabelaAM.getSelectedRow(), 0);
		dialog.setArea(areaSelecionada);
		UnidadeMonitora unidadeSelecionada = (UnidadeMonitora) tabelaUM.getModel().getValueAt(tabelaUM.getSelectedRow(), 7);
		dialog.setUnidade(unidadeSelecionada);
		dialog.frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				super.windowClosed(e);
			}

			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosed(e);
			}
		});
		dialog.frame.setVisible(true);
	}

	private void btnUMDeleteActionPerformed(ActionEvent evt) {
		Object[] options = { "Sim", "Não" };
		int n = JOptionPane.showOptionDialog(frame, "Deseja realmente excluir esta Unidade Monitora?", "Confirmação", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				options, options[1]);
		if (n == 0) {
			UnidadeMonitora unidadeSelecionada = (UnidadeMonitora) tabelaUM.getModel().getValueAt(tabelaUM.getSelectedRow(), 7);
			try {
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
	}

	private void btnUMMonitorarActionPerformed(ActionEvent evt) {
		UnidadeMonitoraMForm dialog = new UnidadeMonitoraMForm(new JFrame(), true);
		dialog.frame.setLocationRelativeTo(frame);
		AreaMonitorada areaSelecionada = (AreaMonitorada) tabelaAM.getModel().getValueAt(tabelaAM.getSelectedRow(), 0);
		dialog.setArea(areaSelecionada);
		dialog.frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				loadUMTableModel();
				lblMap.repaint();
				super.windowClosed(e);
			}

			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosed(e);
			}
		});
		dialog.frame.setVisible(true);
	}

	private void initialize() {

		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/br/hue/hue/inf008/kinkinmonitor/resources/chart_curve.png")));
		jPanel1 = new JPanel();
		jScrollPane1 = new JScrollPane();
		tabelaAM = new JTable();
		tabelaAM.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAMView = new JButton();
		btnAMEdit = new JButton();
		btnAMDelete = new JButton();
		btnAMCriar = new JButton();
		panelUMs = new JPanel();
		jScrollPane3 = new JScrollPane();
		tabelaUM = new JTable();
		tabelaUM.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUMCreate = new JButton();
		btnUMEdit = new JButton();
		btnUMView = new JButton();
		btnUMDelete = new JButton();

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setTitle("Kinkin Monitor v1.0");
		frame.setMinimumSize(new Dimension(841, 712));
		frame.setPreferredSize(new Dimension(846, 794));
		frame.setResizable(false);
		frame.setSize(new Dimension(846, 797));
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent evt) {
				formWindowOpened(evt);
			}
		});

		jPanel1.setBorder(BorderFactory.createTitledBorder("Áreas Monitoradas"));

		tabelaAM.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
		tabelaAM.setColumnSelectionAllowed(true);
		tabelaAM.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaAM.getTableHeader().setReorderingAllowed(false);
		jScrollPane1.setViewportView(tabelaAM);
		tabelaAM.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		btnAMView.setIcon(new ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/map_magnify.png")));
		btnAMView.setText("Visualisar");
		btnAMView.setEnabled(false);
		btnAMView.setHorizontalAlignment(SwingConstants.LEFT);
		btnAMView.setMaximumSize(null);
		btnAMView.setMinimumSize(null);
		btnAMView.setPreferredSize(null);
		btnAMView.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnViewAMActionPerformed(evt);
			}
		});

		btnAMEdit.setIcon(new ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/map_edit.png")));
		btnAMEdit.setText("Editar");
		btnAMEdit.setEnabled(false);
		btnAMEdit.setHorizontalAlignment(SwingConstants.LEFT);
		btnAMEdit.setMaximumSize(null);
		btnAMEdit.setMinimumSize(null);
		btnAMEdit.setPreferredSize(null);
		btnAMEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnEditAMActionPerformed(evt);
			}
		});

		btnAMDelete.setIcon(new ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/map_delete.png")));
		btnAMDelete.setText("Excluir");
		btnAMDelete.setEnabled(false);
		btnAMDelete.setHorizontalAlignment(SwingConstants.LEFT);
		btnAMDelete.setMaximumSize(null);
		btnAMDelete.setMinimumSize(null);
		btnAMDelete.setPreferredSize(null);
		btnAMDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnDeleteAMActionPerformed(evt);
			}
		});

		btnAMCriar.setIcon(new ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/map_add.png")));
		btnAMCriar.setText("Criar");
		btnAMCriar.setHorizontalAlignment(SwingConstants.LEFT);
		btnAMCriar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnCriarAMActionPerformed(evt);
			}
		});

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addComponent(btnAMView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(btnAMEdit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
						.addComponent(btnAMDelete, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(btnAMCriar))
				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addComponent(btnAMCriar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane1)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(btnAMEdit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnAMDelete, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnAMView, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))));

		btnAMView.getAccessibleContext().setAccessibleName("btnVisualisar");

		panelUMs.setBorder(BorderFactory.createTitledBorder("Unidades Monitoras"));
		panelUMs.setEnabled(false);
		tabelaUM.setEnabled(false);

		tabelaUM.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
		tabelaUM.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jScrollPane3.setViewportView(tabelaUM);

		btnUMCreate.setIcon(new ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/transmit_blue_add.png")));
		btnUMCreate.setText("Criar");
		btnUMCreate.setEnabled(false);
		btnUMCreate.setHorizontalAlignment(SwingConstants.LEFT);
		btnUMCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnUMCreateActionPerformed(evt);
			}
		});

		btnUMEdit.setIcon(new ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/transmit_blue_edit.png")));
		btnUMEdit.setText("Editar");
		btnUMEdit.setEnabled(false);
		btnUMEdit.setHorizontalAlignment(SwingConstants.LEFT);
		btnUMEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnUMEditActionPerformed(evt);
			}
		});

		btnUMView.setIcon(new ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/transmit_blue_magnify.png")));
		btnUMView.setText("Visualizar");
		btnUMView.setEnabled(false);
		btnUMView.setHorizontalAlignment(SwingConstants.LEFT);
		btnUMView.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnUMViewActionPerformed(evt);
			}
		});

		btnUMDelete.setIcon(new ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/transmit_blue_delete.png")));
		btnUMDelete.setText("Excluir");
		btnUMDelete.setEnabled(false);
		btnUMDelete.setHorizontalAlignment(SwingConstants.LEFT);
		btnUMDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnUMDeleteActionPerformed(evt);
			}
		});

		GroupLayout panelUMsLayout = new GroupLayout(panelUMs);
		panelUMsLayout.setHorizontalGroup(panelUMsLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				panelUMsLayout.createSequentialGroup().addGap(2).addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 688, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(panelUMsLayout.createParallelGroup(Alignment.LEADING).addComponent(btnUMCreate, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
								.addComponent(btnUMEdit, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
								.addComponent(btnUMView, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnUMDelete, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
						.addContainerGap()));
		panelUMsLayout.setVerticalGroup(panelUMsLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(panelUMsLayout.createSequentialGroup().addGroup(panelUMsLayout.createParallelGroup(Alignment.BASELINE)
						.addGroup(panelUMsLayout.createSequentialGroup().addComponent(btnUMCreate).addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE).addComponent(btnUMView)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnUMEdit).addPreferredGap(ComponentPlacement.RELATED).addComponent(btnUMDelete))
				.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)).addContainerGap(137, Short.MAX_VALUE)));
		panelUMs.setLayout(panelUMsLayout);

		layeredPane = new JLayeredPane();
		btnUMMonitorar = new JButton();

		btnUMMonitorar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/hue/hue/inf008/kinkinmonitor/resources/transmit_blue_go.png")));
		btnUMMonitorar.setText("Monitorar");
		btnUMMonitorar.setEnabled(false);
		btnUMMonitorar.setHorizontalAlignment(SwingConstants.LEFT);
		btnUMMonitorar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnUMMonitorarActionPerformed(evt);
			}
		});

		btnUMLocalizar = new JButton("Localizar");
		btnUMLocalizar.setEnabled(false);
		btnUMLocalizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnUMLocalizarActionPerformed();
			}
		});
		btnUMLocalizar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/hue/hue/inf008/kinkinmonitor/resources/find.png")));
		btnUMLocalizar.setEnabled(false);

		GroupLayout layout = new GroupLayout(frame.getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 505, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(20, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, layout.createSequentialGroup().addComponent(btnUMMonitorar).addGap(130).addComponent(btnUMLocalizar).addGap(138))
				.addGroup(Alignment.TRAILING, layout.createSequentialGroup().addComponent(panelUMs, GroupLayout.PREFERRED_SIZE, 815, Short.MAX_VALUE).addContainerGap()))));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(16)
						.addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE))
						.addGap(1).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(btnUMMonitorar).addComponent(btnUMLocalizar))
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(panelUMs, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE).addGap(21)));

		tbMap = new JTable();
		tbMap.setFont(new Font("Arial", Font.BOLD, 23));
		tbMap.setEnabled(false);
		layeredPane.setLayer(tbMap, 1);
		tbMap.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null, null, null }, },
				new String[] { "", "", "", "", "", "", "", "", "", "" }) {

			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false, false, true };

			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbMap.getColumnModel().getColumn(0).setResizable(false);
		tbMap.getColumnModel().getColumn(0).setPreferredWidth(50);
		tbMap.getColumnModel().getColumn(0).setMinWidth(50);
		tbMap.getColumnModel().getColumn(0).setMaxWidth(50);
		tbMap.getColumnModel().getColumn(1).setResizable(false);
		tbMap.getColumnModel().getColumn(1).setPreferredWidth(50);
		tbMap.getColumnModel().getColumn(1).setMinWidth(50);
		tbMap.getColumnModel().getColumn(1).setMaxWidth(50);
		tbMap.getColumnModel().getColumn(2).setResizable(false);
		tbMap.getColumnModel().getColumn(2).setPreferredWidth(50);
		tbMap.getColumnModel().getColumn(2).setMinWidth(50);
		tbMap.getColumnModel().getColumn(2).setMaxWidth(50);
		tbMap.getColumnModel().getColumn(3).setResizable(false);
		tbMap.getColumnModel().getColumn(3).setPreferredWidth(50);
		tbMap.getColumnModel().getColumn(3).setMinWidth(50);
		tbMap.getColumnModel().getColumn(3).setMaxWidth(50);
		tbMap.getColumnModel().getColumn(4).setResizable(false);
		tbMap.getColumnModel().getColumn(4).setPreferredWidth(50);
		tbMap.getColumnModel().getColumn(4).setMinWidth(50);
		tbMap.getColumnModel().getColumn(4).setMaxWidth(50);
		tbMap.getColumnModel().getColumn(5).setResizable(false);
		tbMap.getColumnModel().getColumn(5).setPreferredWidth(50);
		tbMap.getColumnModel().getColumn(5).setMinWidth(50);
		tbMap.getColumnModel().getColumn(5).setMaxWidth(50);
		tbMap.getColumnModel().getColumn(6).setResizable(false);
		tbMap.getColumnModel().getColumn(6).setPreferredWidth(50);
		tbMap.getColumnModel().getColumn(6).setMinWidth(50);
		tbMap.getColumnModel().getColumn(6).setMaxWidth(50);
		tbMap.getColumnModel().getColumn(7).setResizable(false);
		tbMap.getColumnModel().getColumn(7).setPreferredWidth(50);
		tbMap.getColumnModel().getColumn(7).setMinWidth(50);
		tbMap.getColumnModel().getColumn(7).setMaxWidth(50);
		tbMap.getColumnModel().getColumn(8).setResizable(false);
		tbMap.getColumnModel().getColumn(8).setPreferredWidth(50);
		tbMap.getColumnModel().getColumn(8).setMinWidth(50);
		tbMap.getColumnModel().getColumn(8).setMaxWidth(50);
		tbMap.getColumnModel().getColumn(9).setResizable(false);
		tbMap.getColumnModel().getColumn(9).setPreferredWidth(50);
		tbMap.getColumnModel().getColumn(9).setMinWidth(50);
		tbMap.getColumnModel().getColumn(9).setMaxWidth(50);
		tbMap.setShowVerticalLines(false);
		tbMap.setShowHorizontalLines(false);
		tbMap.setShowGrid(false);
		tbMap.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbMap.setRowSelectionAllowed(false);
		tbMap.setRowHeight(50);
		tbMap.setBorder(new LineBorder(new Color(0, 0, 0)));
		tbMap.setBackground(new Color(255, 255, 255, 0));
		tbMap.setBounds(0, 0, 502, 502);
		layeredPane.add(tbMap);

		lblMap = new JLabel("");
		lblMap.setEnabled(false);

		clearUMMap();

		lblMap.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/hue/hue/inf008/kinkinmonitor/resources/Dinosaur_Land_-_Super_Mario_World.png")));
		lblMap.setBounds(0, 0, 505, 502);
		layeredPane.add(lblMap, 0);
		frame.getContentPane().setLayout(layout);
	}

	private void btnUMLocalizarActionPerformed() {
		UnidadeMonitoraSForm dialog = new UnidadeMonitoraSForm(new JFrame(), true);
		dialog.frame.setLocationRelativeTo(frame);
		AreaMonitorada areaSelecionada = (AreaMonitorada) tabelaAM.getModel().getValueAt(tabelaAM.getSelectedRow(), 0);
		dialog.setArea(areaSelecionada);
		dialog.frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				loadUMTableModel();
				frame.repaint();
				super.windowClosed(e);
			}

			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosed(e);
			}
		});
		frame.repaint();
		dialog.frame.setVisible(true);
	}

	private JButton btnAMCriar;
	private JButton btnAMDelete;
	private JButton btnAMEdit;
	private JButton btnUMCreate;
	private JButton btnUMDelete;
	private JButton btnUMEdit;
	private JButton btnUMMonitorar;
	private JButton btnUMLocalizar;
	private JButton btnUMView;
	private JButton btnAMView;
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane3;
	private JPanel panelUMs;
	private JTable tabelaAM;
	private JTable tabelaUM;
	private JLayeredPane layeredPane;
	private JTable tbMap;
	private JLabel lblMap;
}

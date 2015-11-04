package br.hue.hue.inf008.kinkinmonitor.ui;

import java.awt.Color;
import java.awt.HeadlessException;
import java.util.ArrayList;

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
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
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

public class TelaPrincipal {

	protected JFrame frame;

	public TelaPrincipal() {
		initialize();
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
	}

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
				frame.repaint();
				AMSelectedAction();
			}
		});
	}

	private void AMSelectedAction() {
		UnidadeMonitoraTableModel dtm = new UnidadeMonitoraTableModel(new ArrayList<>(0));
		tabelaUM.setModel(dtm);
		panelUMs.setBorder(BorderFactory.createTitledBorder("Unidades Monitoras "));
		panelUMs.setEnabled(false);
		lblMap.setEnabled(false);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				tbMap.setValueAt(null, i, j);
				tbMap.changeSelection(i, j, false, false);
				tbMap.getCellEditor(i, j).getTableCellEditorComponent(tbMap, tbMap.getValueAt(i, j), true, i, j)
					.setForeground(new Color(255, 255, 255, 1));
			}
		}
		tabelaUM.getColumn("tipo").setWidth(0);
		tabelaUM.getColumn("tipo").setMinWidth(0);
		tabelaUM.getColumn("tipo").setMaxWidth(0);
		frame.repaint();
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

	private void btnViewAMActionPerformed(java.awt.event.ActionEvent evt) {
		loadUMTableModel();
		btnUMCreate.setEnabled(true);
		btnUMMonitorar.setEnabled(true);
		panelUMs.setEnabled(true);
		lblMap.setEnabled(true);
	}

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
		panelUMs.setBorder(BorderFactory.createTitledBorder("Unidades Monitoras - Área: " + areaSelecionada.getNome()));
		tabelaUM.setModel(dtm);
		tabelaUM.getColumn("tipo").setWidth(0);
		tabelaUM.getColumn("tipo").setMinWidth(0);
		tabelaUM.getColumn("tipo").setMaxWidth(0);

		// XXX
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				tbMap.setValueAt(null, i, j);
				tbMap.getCellEditor(i, j).getTableCellEditorComponent(tbMap, tbMap.getValueAt(i, j), true, i, j)
					.setForeground(new Color(255, 255, 255, 1));
			}
		}

		for (UnidadeMonitora unit : areaSelecionada.getUnidades()) {
			String tipoUM = "Unidade\n";
			if (unit instanceof UnidadeEuclidiana) {
				tbMap.changeSelection(unit.getLocalizacao().getLatitude() - 1, unit.getLocalizacao().getLongitude() - 1, false, false);
				tbMap.getCellEditor(unit.getLocalizacao().getLatitude() - 1, unit.getLocalizacao().getLongitude() - 1)
					.getTableCellEditorComponent(tbMap, tbMap.getValueAt(unit.getLocalizacao().getLatitude() - 1, unit.getLocalizacao().getLongitude() - 1),
						true, unit.getLocalizacao().getLatitude() - 1, unit.getLocalizacao().getLongitude() - 1)
					.setForeground(new Color(255, 1, 1, 127));
				tipoUM = "Un. M\n";
			} else if (unit instanceof UnidadeManhattan) {
				tbMap.getCellEditor(unit.getLocalizacao().getLatitude() - 1, unit.getLocalizacao().getLongitude() - 1)
					.getTableCellEditorComponent(tbMap, tbMap.getValueAt(unit.getLocalizacao().getLatitude() - 1, unit.getLocalizacao().getLongitude() - 1),
						true, unit.getLocalizacao().getLatitude() - 1, unit.getLocalizacao().getLongitude() - 1)
					.setForeground(new Color(1, 1, 255, 127));
				tipoUM = "Un. E\n";
			}
			JLabel lbl = new JLabel();
			lbl.setText("");
			lbl.setIcon(
				new ImageIcon("br/hue/hue/inf008/kinkinmonitor/resources/transmit.png") // XXX
			);
			ImageIcon icon = new ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/transmit.png"));

			tbMap.setValueAt(lbl, unit.getLocalizacao().getLatitude() - 1, unit.getLocalizacao().getLongitude() - 1);

			frame.repaint();
		}
		frame.repaint();
	}

	private void btnEditAMActionPerformed(java.awt.event.ActionEvent evt) {
		AreaMonitorada areaSelecionada = (AreaMonitorada) tabelaAM.getModel().getValueAt(tabelaAM.getSelectedRow(), 0);
		AreaMonitoradaCEForm dialog = new AreaMonitoradaCEForm(new JFrame(), true);
		dialog.frame.setLocationRelativeTo(frame);
		dialog.setArea(areaSelecionada);
		dialog.frame.addWindowListener(new java.awt.event.WindowAdapter() {
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

	private void btnDeleteAMActionPerformed(java.awt.event.ActionEvent evt) {
		Object[] options = {"Sim", "Não"};
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

	private void btnCriarAMActionPerformed(java.awt.event.ActionEvent evt) {
		AreaMonitoradaCEForm dialog = new AreaMonitoradaCEForm(new JFrame(), true);
		dialog.frame.setLocationRelativeTo(frame);
		dialog.frame.addWindowListener(new java.awt.event.WindowAdapter() {
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
		dialog.frame.setVisible(true);
	}

	private void btnUMCreateActionPerformed(java.awt.event.ActionEvent evt) {
		UnidadeMonitoraCEForm dialog = new UnidadeMonitoraCEForm(new JFrame(), true);
		dialog.frame.setLocationRelativeTo(frame);
		AreaMonitorada areaSelecionada = (AreaMonitorada) tabelaAM.getModel().getValueAt(tabelaAM.getSelectedRow(), 0);
		dialog.setArea(areaSelecionada);
		dialog.frame.addWindowListener(new java.awt.event.WindowAdapter() {
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
		dialog.frame.setVisible(true);
	}

	private void btnUMEditActionPerformed(java.awt.event.ActionEvent evt) {
		UnidadeMonitoraCEForm dialog = new UnidadeMonitoraCEForm(new JFrame(), true);
		dialog.frame.setLocationRelativeTo(frame);
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
		dialog.frame.addWindowListener(new java.awt.event.WindowAdapter() {
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

	private void btnUMViewActionPerformed(java.awt.event.ActionEvent evt) {
		UnidadeMonitoraVForm dialog = new UnidadeMonitoraVForm(new JFrame(), true);
		dialog.frame.setLocationRelativeTo(frame);
		AreaMonitorada areaSelecionada = (AreaMonitorada) tabelaAM.getModel().getValueAt(tabelaAM.getSelectedRow(), 0);
		dialog.setArea(areaSelecionada);
		String nomeUnidade = tabelaUM.getModel().getValueAt(tabelaUM.getSelectedRow(), 0).toString();
		String tipo = tabelaUM.getModel().getValueAt(tabelaUM.getSelectedRow(), 6).toString();
		UnidadeMonitora unidadeSelecionada = null;
		try {
			Class<?> classTipounidade = UnidadeMonitora.class;
			if (tipo.equalsIgnoreCase("br.hue.hue.inf008.kinkinmonitor.model.UnidadeManhattan")) {
				classTipounidade = UnidadeManhattan.class;
			} else if (tipo.equalsIgnoreCase("br.hue.hue.inf008.kinkinmonitor.model.UnidadeEuclidiana")) {
				classTipounidade = UnidadeEuclidiana.class;
			}
			unidadeSelecionada = (UnidadeMonitora) new UnidadeMonitoraController<>(classTipounidade).findById(nomeUnidade);
		} catch (Exception e) {
			Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, "Erro inesperado.", e);
		}
		dialog.setUnidade(unidadeSelecionada);
		dialog.frame.addWindowListener(new java.awt.event.WindowAdapter() {
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

	private void btnUMDeleteActionPerformed(java.awt.event.ActionEvent evt) {
		Object[] options = {"Sim", "Não"};
		int n = JOptionPane.showOptionDialog(frame, "Deseja realmente excluir esta Unidade Monitora?", "Confirmação", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
			options, options[1]);
		if (n == 0) {
			String nomeUnidade = tabelaUM.getModel().getValueAt(tabelaUM.getSelectedRow(), 0).toString();
			String tipo = tabelaUM.getModel().getValueAt(tabelaUM.getSelectedRow(), 6).toString();
			UnidadeMonitora unidadeSelecionada;
			try {
				Class<?> classTipounidade = UnidadeMonitora.class;
				if (tipo.equalsIgnoreCase("br.hue.hue.inf008.kinkinmonitor.model.UnidadeManhattan")) {
					classTipounidade = UnidadeManhattan.class;
				} else if (tipo.equalsIgnoreCase("br.hue.hue.inf008.kinkinmonitor.model.UnidadeEuclidiana")) {
					classTipounidade = UnidadeEuclidiana.class;
				}
				unidadeSelecionada = (UnidadeMonitora) new UnidadeMonitoraController<>(classTipounidade).findById(nomeUnidade);
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

	private void btnUMMonitorarActionPerformed(java.awt.event.ActionEvent evt) {
		UnidadeMonitoraMForm dialog = new UnidadeMonitoraMForm(new JFrame(), true);
		dialog.frame.setLocationRelativeTo(frame);
		AreaMonitorada areaSelecionada = (AreaMonitorada) tabelaAM.getModel().getValueAt(tabelaAM.getSelectedRow(), 0);
		dialog.setArea(areaSelecionada);
		dialog.frame.addWindowListener(new java.awt.event.WindowAdapter() {
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

	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initialize() {

		frame = new JFrame();
		jPanel1 = new JPanel();
		jScrollPane1 = new JScrollPane();
		tabelaAM = new JTable();
		btnViewAM = new JButton();
		btnEditAM = new JButton();
		btnDeleteAM = new JButton();
		btnCriarAM = new JButton();
		panelUMs = new JPanel();
		jScrollPane3 = new JScrollPane();
		tabelaUM = new JTable();
		btnUMCreate = new JButton();
		btnUMEdit = new JButton();
		btnUMView = new JButton();
		btnUMDelete = new JButton();
		btnUMMonitorar = new JButton();

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setTitle("Kinkin Monitor v1.0");
		frame.setMinimumSize(new Dimension(841, 712));
		frame.setPreferredSize(new Dimension(846, 794));
		frame.setResizable(false);
		frame.setSize(new Dimension(841, 785));
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent evt) {
				formWindowOpened(evt);
			}
		});

		jPanel1.setBorder(BorderFactory.createTitledBorder("Áreas Monitoradas"));

		tabelaAM.setModel(new DefaultTableModel(new Object[][]{}, new String[]{}));
		tabelaAM.setColumnSelectionAllowed(true);
		tabelaAM.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaAM.getTableHeader().setReorderingAllowed(false);
		jScrollPane1.setViewportView(tabelaAM);
		tabelaAM.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		btnViewAM.setIcon(new ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/map_magnify.png"))); // NOI18N
		btnViewAM.setText("Visualisar");
		btnViewAM.setEnabled(false);
		btnViewAM.setHorizontalAlignment(SwingConstants.LEFT);
		btnViewAM.setMaximumSize(null);
		btnViewAM.setMinimumSize(null);
		btnViewAM.setPreferredSize(null);
		btnViewAM.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnViewAMActionPerformed(evt);
			}
		});

		btnEditAM.setIcon(new ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/map_edit.png"))); // NOI18N
		btnEditAM.setText("Editar");
		btnEditAM.setEnabled(false);
		btnEditAM.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditAM.setMaximumSize(null);
		btnEditAM.setMinimumSize(null);
		btnEditAM.setPreferredSize(null);
		btnEditAM.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnEditAMActionPerformed(evt);
			}
		});

		btnDeleteAM.setIcon(new ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/map_delete.png"))); // NOI18N
		btnDeleteAM.setText("Excluir");
		btnDeleteAM.setEnabled(false);
		btnDeleteAM.setHorizontalAlignment(SwingConstants.LEFT);
		btnDeleteAM.setMaximumSize(null);
		btnDeleteAM.setMinimumSize(null);
		btnDeleteAM.setPreferredSize(null);
		btnDeleteAM.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDeleteAMActionPerformed(evt);
			}
		});

		btnCriarAM.setIcon(new ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/map_add.png"))); // NOI18N
		btnCriarAM.setText("Criar");
		btnCriarAM.setHorizontalAlignment(SwingConstants.LEFT);
		btnCriarAM.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCriarAMActionPerformed(evt);
			}
		});

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
			.setHorizontalGroup(
				jPanel1Layout
				.createParallelGroup(
					GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addComponent(btnViewAM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(btnEditAM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
					.addComponent(btnDeleteAM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(btnCriarAM))
				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(jPanel1Layout.createSequentialGroup().addComponent(btnCriarAM).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane1)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(btnEditAM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDeleteAM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addComponent(btnViewAM, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))));

		btnViewAM.getAccessibleContext().setAccessibleName("btnVisualisar");

		panelUMs.setBorder(BorderFactory.createTitledBorder("Unidades Monitoras"));
		panelUMs.setEnabled(false);

		tabelaUM.setModel(new DefaultTableModel(new Object[][]{}, new String[]{}));
		tabelaUM.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jScrollPane3.setViewportView(tabelaUM);

		btnUMCreate.setIcon(new ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/transmit_blue_add.png")));
		btnUMCreate.setText("Criar");
		btnUMCreate.setEnabled(false);
		btnUMCreate.setHorizontalAlignment(SwingConstants.LEFT);
		btnUMCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnUMCreateActionPerformed(evt);
			}
		});

		btnUMEdit.setIcon(new ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/transmit_blue_edit.png")));
		btnUMEdit.setText("Editar");
		btnUMEdit.setEnabled(false);
		btnUMEdit.setHorizontalAlignment(SwingConstants.LEFT);
		btnUMEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnUMEditActionPerformed(evt);
			}
		});

		btnUMView.setIcon(new ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/transmit_blue_magnify.png")));
		btnUMView.setText("Visualizar");
		btnUMView.setEnabled(false);
		btnUMView.setHorizontalAlignment(SwingConstants.LEFT);
		btnUMView.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnUMViewActionPerformed(evt);
			}
		});

		btnUMDelete.setIcon(new ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/transmit_blue_delete.png")));
		btnUMDelete.setText("Excluir");
		btnUMDelete.setEnabled(false);
		btnUMDelete.setHorizontalAlignment(SwingConstants.LEFT);
		btnUMDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnUMDeleteActionPerformed(evt);
			}
		});

		btnUMMonitorar.setIcon(new ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/transmit_blue_go.png")));
		btnUMMonitorar.setText("Monitorar");
		btnUMMonitorar.setEnabled(false);
		btnUMMonitorar.setHorizontalAlignment(SwingConstants.LEFT);
		btnUMMonitorar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnUMMonitorarActionPerformed(evt);
			}
		});

		GroupLayout panelUMsLayout = new GroupLayout(panelUMs);
		panelUMs.setLayout(panelUMsLayout);
		panelUMsLayout.setHorizontalGroup(panelUMsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(panelUMsLayout.createSequentialGroup().addComponent(jScrollPane3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(panelUMsLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
					.addComponent(btnUMEdit, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnUMCreate, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnUMView, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnUMDelete, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnUMMonitorar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGap(2, 2, 2)));
		panelUMsLayout.setVerticalGroup(panelUMsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(panelUMsLayout.createSequentialGroup().addComponent(btnUMCreate).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(btnUMMonitorar)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btnUMView)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(btnUMEdit).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(btnUMDelete).addContainerGap())
			.addGroup(panelUMsLayout.createSequentialGroup().addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE).addGap(0, 0,
					Short.MAX_VALUE)));

		layeredPane = new JLayeredPane();

		GroupLayout layout = new GroupLayout(frame.getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
			.addGroup(layout.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
					.addGroup(layout.createSequentialGroup().addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 505, GroupLayout.PREFERRED_SIZE))
					.addComponent(panelUMs, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
			.addGroup(layout.createSequentialGroup().addGap(16)
				.addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(panelUMs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(34, Short.MAX_VALUE)));

		tbMap = new JTable();
		tbMap.setEnabled(false);
		layeredPane.setLayer(tbMap, 1);
		tbMap.setModel(new DefaultTableModel(
			new Object[][]{
				{null, null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null, null},},
			new String[]{"", "", "", "", "", "", "", "", "", ""}) {
				private static final long serialVersionUID = 1L;
				boolean[] columnEditables = new boolean[]{false, false, false, false, false, false, false, false, false, true};

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

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				tbMap.setValueAt(null, i, j);
				tbMap.changeSelection(i, j, false, false);
				tbMap.getCellEditor(i, j).getTableCellEditorComponent(tbMap, tbMap.getValueAt(i, j), true, i, j)
					.setForeground(new Color(255, 255, 255, 1));
			}
		}

		lblMap.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/hue/hue/inf008/kinkinmonitor/resources/Dinosaur_Land_-_Super_Mario_World.png")));
		lblMap.setBounds(0, 0, 505, 502);
		layeredPane.add(lblMap, 0);
		frame.getContentPane().setLayout(layout);
	}//</editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Variables declaration">
	// Variables declaration - do not modify
	private JButton btnCriarAM;
	private JButton btnDeleteAM;
	private JButton btnEditAM;
	private JButton btnUMCreate;
	private JButton btnUMDelete;
	private JButton btnUMEdit;
	private JButton btnUMMonitorar;
	private JButton btnUMView;
	private JButton btnViewAM;
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane3;
	private JPanel panelUMs;
	private JTable tabelaAM;
	private JTable tabelaUM;
	private JLayeredPane layeredPane;
	private JTable tbMap;
	private JLabel lblMap;
// </editor-fold >
}

package br.hue.hue.inf008.kinkinmonitor.ui;

import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.hue.hue.inf008.kinkinmonitor.controller.UnidadeMonitoraController;
import br.hue.hue.inf008.kinkinmonitor.model.AreaMonitorada;
import br.hue.hue.inf008.kinkinmonitor.model.UnidadeEuclidiana;
import br.hue.hue.inf008.kinkinmonitor.model.UnidadeManhattan;
import br.hue.hue.inf008.kinkinmonitor.model.UnidadeMonitora;

public class UnidadeMonitoraSForm {

	protected JDialog frame;

	private AreaMonitorada area;

	public UnidadeMonitoraSForm(Frame parent, boolean modal) {
		frame = new JDialog(parent, modal);
		initComponents();
	}

	public AreaMonitorada getArea() {
		return area;
	}

	public void setArea(AreaMonitorada area) {
		this.area = area;
	}
	
	private void searchUnidadeMonitora() {
		frame.getParent().repaint();
		try {
			UnidadeMonitora unidade = new UnidadeMonitoraController<>(UnidadeMonitora.class).findById(textField.getText());
			if (unidade != null) {
				String tipo = null;
				if (unidade instanceof UnidadeEuclidiana) {
					tipo = "Unidade Euclidiana";
				} else if (unidade instanceof UnidadeManhattan) {
					tipo = "Unidade Manhattan";
				}
				String infos =
					"Identificador: " + unidade.getNome() +",\n\n" +
					"Tipo: " + tipo +",\n" + 
					"Localização: " + unidade.getLocalizacao().toString() +",\n\n" +
					"Possui Câmera: " + (unidade.isCamera() ? "Sim" : "Não") +",\n" +
					"Possui Termômetro: " + (unidade.isTermometro() ? "Sim" : "Não") + ",\n" +
					"Possui Medidor CO2: " + (unidade.isMedidorCO2() ? "Sim" : "Não") + ",\n" +
					"Possui Medidor CH4: " + (unidade.isMedidorCH4() ? "Sim" : "Não");
				JOptionPane.showMessageDialog(null, "Unidade Monitora localizada!.\n\n" + infos + "\n", "Detalhes", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Nenhuma Unidade Monitora com este identificador.\n\n" + textField.getText(), "Erro", JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception e) {
			Logger.getLogger(UnidadeMonitoraSForm.class.getName()).log(Level.SEVERE, "Falha na localização da Unidade Monitora.", e);
			JOptionPane.showMessageDialog(null, "Falha na localização da Unidade Monitora.\n\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		frame = new JDialog();
		frame.setResizable(false);
		btnLocalizar = new javax.swing.JButton();
		btnCancelar = new javax.swing.JButton();

		frame.setTitle("Localizar");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(UnidadeMonitoraSForm.class.getResource("/br/hue/hue/inf008/kinkinmonitor/resources/transmit.png")));

		btnLocalizar.setIcon(new ImageIcon(UnidadeMonitoraSForm.class.getResource("/br/hue/hue/inf008/kinkinmonitor/resources/find.png")));
		btnLocalizar.setText("Localizar");
		btnLocalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				searchUnidadeMonitora();
			}

		});

		btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/cancel.png")));
		btnCancelar.setText("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnCancelarActionPerformed(evt);
			}
		});

		JLabel lblIdentificador = new JLabel("Identificador");

		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING,
										groupLayout.createSequentialGroup().addContainerGap().addComponent(btnLocalizar).addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(btnCancelar))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(textField, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblIdentificador))).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblIdentificador).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnCancelar).addComponent(btnLocalizar)).addContainerGap()));
		frame.getContentPane().setLayout(groupLayout);

		frame.pack();
	}

	private void btnCancelarActionPerformed(ActionEvent evt) {
		frame.setVisible(false);
	}

	private javax.swing.JButton btnCancelar;
	private javax.swing.JButton btnLocalizar;
	private JTextField textField;
}

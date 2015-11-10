package br.hue.hue.inf008.kinkinmonitor.ui;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import br.hue.hue.inf008.kinkinmonitor.controller.AreaMonitoradaController;
import br.hue.hue.inf008.kinkinmonitor.model.AreaMonitorada;
import java.awt.Toolkit;

public class AreaMonitoradaCEForm {

	protected JDialog frame;

	private AreaMonitorada area = new AreaMonitorada();

	public AreaMonitoradaCEForm(Frame parent, boolean modal) {
		frame = new JDialog(parent, modal);
		initComponents();
	}

	public AreaMonitorada getArea() {
		return area;
	}

	public void setArea(AreaMonitorada area) {
		this.area = area;
		this.jtfNome.setText(area.getNome());
	}

	private void initComponents() {
		frame = new JDialog();

		jLabel1 = new JLabel();
		jtfNome = new JTextField();
		btnConfirmar = new JButton();
		btnCancelar = new JButton();

		frame.setTitle("Incluir Área Monitorada");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(AreaMonitoradaCEForm.class.getResource("/br/hue/hue/inf008/kinkinmonitor/resources/map.png")));

		jLabel1.setText("Identificador");
		jLabel1.setToolTipText("Identificador");

		jtfNome.setMaximumSize(new Dimension(6, 20));

		btnConfirmar.setIcon(new ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/accept.png")));
		btnConfirmar.setText("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnConfirmarActionPerformed(evt);
			}
		});

		btnCancelar.setIcon(new ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/cancel.png")));
		btnCancelar.setText("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnCancelarActionPerformed(evt);
			}
		});

		GroupLayout layout = new GroupLayout(frame.getContentPane());
		frame.getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jtfNome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup().addComponent(jLabel1).addGap(0, 0, Short.MAX_VALUE)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addGap(0, 51, Short.MAX_VALUE).addComponent(btnConfirmar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(btnCancelar)))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jtfNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(btnConfirmar).addComponent(btnCancelar)).addContainerGap()));

		frame.pack();
	}

	private void btnConfirmarActionPerformed(ActionEvent evt) {
		Object[] options = { "Sim", "Não" };
		int n = JOptionPane.showOptionDialog(frame, "Confirma os dados entrados no formulário?", "Confirmação", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		if (n == 0) {
			String operacao = "Operação";
			try {
				area.setNome(this.jtfNome.getText());
				if (area.getId() != 0) {
					operacao = "Inclusão";
					n = new AreaMonitoradaController().update(area);
				} else {
					operacao = "Atualização";
					n = new AreaMonitoradaController().insert(area);
				}
				if (n == 1) {
					JOptionPane.showMessageDialog(frame, operacao + " realisada com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
					Logger.getLogger(AreaMonitoradaCEForm.class.getName()).log(Level.INFO, operacao + " realisada com sucesso.", area);
				}
				frame.setVisible(false);
				frame.getParent().repaint();
				frame.dispose();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(frame, operacao + "  não realisada.\n\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				Logger.getLogger(AreaMonitoradaCEForm.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
			}
		}
	}

	private void btnCancelarActionPerformed(ActionEvent evt) {
		frame.setVisible(false);
		frame.getParent().repaint();
	}

	private JButton btnCancelar;
	private JButton btnConfirmar;
	private JLabel jLabel1;
	private JTextField jtfNome;
}

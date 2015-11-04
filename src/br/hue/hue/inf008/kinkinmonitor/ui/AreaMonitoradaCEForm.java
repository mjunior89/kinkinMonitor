package br.hue.hue.inf008.kinkinmonitor.ui;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.hue.hue.inf008.kinkinmonitor.controller.AreaMonitoradaController;
import br.hue.hue.inf008.kinkinmonitor.model.AreaMonitorada;

public class AreaMonitoradaCEForm {

	protected JDialog frame;

	private AreaMonitorada area = new AreaMonitorada();

	public AreaMonitoradaCEForm(java.awt.Frame parent, boolean modal) {
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

	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		frame = new JDialog();

		jLabel1 = new javax.swing.JLabel();
		jtfNome = new javax.swing.JTextField();
		btnConfirmar = new javax.swing.JButton();
		btnCancelar = new javax.swing.JButton();

		frame.setTitle("Incluir Área Monitorada");
		frame.setIconImage(null);

		jLabel1.setText("Identificador");
		jLabel1.setToolTipText("Identificador");

		jtfNome.setMaximumSize(new java.awt.Dimension(6, 20));

		btnConfirmar.setIcon(new javax.swing.ImageIcon(
				getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/accept.png"))); // NOI18N
		btnConfirmar.setText("Confirmar");
		btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnConfirmarActionPerformed(evt);
			}
		});

		btnCancelar.setIcon(new javax.swing.ImageIcon(
				getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/cancel.png"))); // NOI18N
		btnCancelar.setText("Cancelar");
		btnCancelar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCancelarActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
		frame.getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jtfNome, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup().addComponent(jLabel1).addGap(0, 0, Short.MAX_VALUE))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addGap(0, 51, Short.MAX_VALUE).addComponent(btnConfirmar)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btnCancelar)))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(btnConfirmar).addComponent(btnCancelar)).addContainerGap()));

		frame.pack();
	}// </editor-fold>//GEN-END:initComponents

	private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnConfirmarActionPerformed
		Object[] options = { "Sim", "Não" };
		int n = JOptionPane.showOptionDialog(frame, "Confirma os dados entrados no formulário?", "Confirmação",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
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
					JOptionPane.showMessageDialog(frame, operacao + " realisada com sucesso.", "Sucesso",
							JOptionPane.INFORMATION_MESSAGE);
					Logger.getLogger(AreaMonitoradaCEForm.class.getName()).log(Level.INFO,
							operacao + " realisada com sucesso.", area);
				}
				frame.setVisible(false);
				frame.dispose();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(frame, operacao + "  não realisada.\n\n" + ex.getMessage(), "Erro",
						JOptionPane.ERROR_MESSAGE);
				Logger.getLogger(AreaMonitoradaCEForm.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
			}
		}
	}// GEN-LAST:event_btnConfirmarActionPerformed

	private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelarActionPerformed
		frame.setVisible(false);
	}// GEN-LAST:event_btnCancelarActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnCancelar;
	private javax.swing.JButton btnConfirmar;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JTextField jtfNome;
	// End of variables declaration//GEN-END:variables
}

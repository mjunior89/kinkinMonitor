package br.hue.hue.inf008.kinkinmonitor.ui;

import java.awt.Frame;

import javax.swing.JDialog;

import br.hue.hue.inf008.kinkinmonitor.model.AreaMonitorada;
import br.hue.hue.inf008.kinkinmonitor.model.UnidadeMonitora;
import br.hue.hue.inf008.kinkinmonitor.utils.PontoLocalizacao;

public class UnidadeMonitoraVForm {

	protected JDialog frame;

	private AreaMonitorada area;
	private UnidadeMonitora unidade;

	public UnidadeMonitoraVForm(Frame parent, boolean modal) {
		frame = new JDialog(parent, modal);
		initComponents();
	}

	public AreaMonitorada getArea() {
		return area;
	}

	public void setArea(AreaMonitorada area) {
		this.area = area;
	}

	public UnidadeMonitora getUnidade() {
		return unidade;
	}

	public void setUnidade(UnidadeMonitora unidade) {
		this.unidade = unidade;
		this.txtNome.setText(unidade.getNome());
		this.chbCamera.setSelected(unidade.isCamera());
		this.chbMedidorCH4.setSelected(unidade.isMedidorCH4());
		this.chbMedidorCO2.setSelected(unidade.isMedidorCO2());
		this.chbTermometro.setSelected(unidade.isTermometro());
		this.spLatitude.setValue(unidade.getLocalizacao().getLatitude());
		this.spLongitude.setValue(unidade.getLocalizacao().getLongitude());
		if (unidade.getClass().getCanonicalName()
				.equalsIgnoreCase("br.hue.hue.inf008.kinkinmonitor.model.UnidadeEuclidiana")) {
			cbTipoUnidade.setSelectedIndex(0);
		} else if (unidade.getClass().getCanonicalName()
				.equalsIgnoreCase("br.hue.hue.inf008.kinkinmonitor.model.UnidadeManhattan")) {
			cbTipoUnidade.setSelectedIndex(1);
		}
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		frame = new JDialog();
		jLabel1 = new javax.swing.JLabel();
		txtNome = new javax.swing.JTextField();
		btnConfirmar = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		cbTipoUnidade = new javax.swing.JComboBox();
		jPanel1 = new javax.swing.JPanel();
		chbMedidorCO2 = new javax.swing.JCheckBox();
		chbMedidorCH4 = new javax.swing.JCheckBox();
		chbTermometro = new javax.swing.JCheckBox();
		chbCamera = new javax.swing.JCheckBox();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		spLatitude = new javax.swing.JSpinner();
		spLongitude = new javax.swing.JSpinner();

		frame.setTitle("Visualizar Unidade Monitora");
		frame.setIconImage(null);
		frame.setResizable(false);

		jLabel1.setText("Identificador");
		jLabel1.setToolTipText("Identificador");

		txtNome.setEditable(false);
		txtNome.setEnabled(false);
		txtNome.setMaximumSize(new java.awt.Dimension(6, 20));

		btnConfirmar.setIcon(new javax.swing.ImageIcon(
				getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/accept.png"))); // NOI18N
		btnConfirmar.setText("Confirmar");
		btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnConfirmarActionPerformed(evt);
			}
		});

		jLabel2.setText("Tipo Unidade");

		cbTipoUnidade.setModel(
				new javax.swing.DefaultComboBoxModel(new String[] { "Unidade Euclidiana", "Unidade Manhattan" }));
		cbTipoUnidade.setEnabled(false);

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuração da Unidade Monitora"));

		chbMedidorCO2.setText("Medidor CO2");
		chbMedidorCO2.setEnabled(false);

		chbMedidorCH4.setText("Medidor CH4");
		chbMedidorCH4.setEnabled(false);

		chbTermometro.setText("Termômetro");
		chbTermometro.setEnabled(false);

		chbCamera.setText("Câmera");
		chbCamera.setEnabled(false);

		jLabel3.setIcon(new javax.swing.ImageIcon(
				getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/Camera.png"))); // NOI18N

		jLabel4.setIcon(new javax.swing.ImageIcon(
				getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/CO2.png"))); // NOI18N

		jLabel5.setIcon(new javax.swing.ImageIcon(
				getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/CH4.png"))); // NOI18N

		jLabel6.setIcon(new javax.swing.ImageIcon(
				getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/Thermometer.png"))); // NOI18N

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel1Layout.createSequentialGroup().addContainerGap()
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(jLabel3).addComponent(jLabel6))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(chbCamera).addComponent(chbTermometro))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(chbMedidorCO2).addComponent(chbMedidorCH4))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(19, 19, 19).addComponent(chbMedidorCO2))
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addGroup(jPanel1Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(jPanel1Layout.createSequentialGroup().addGap(19, 19, 19)
												.addComponent(chbCamera).addGap(9, 9, 9))
								.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel1Layout.createSequentialGroup().addGap(26, 26, 26)
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(chbTermometro).addComponent(chbMedidorCH4)))
										.addGroup(jPanel1Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(
												jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jLabel5)))))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Localização"));

		jLabel7.setText("Latitude");
		jLabel7.setToolTipText("Identificador");

		jLabel8.setText("Longitude");
		jLabel8.setToolTipText("Identificador");

		spLatitude.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
		spLatitude.setEnabled(false);

		spLongitude.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
		spLongitude.setEnabled(false);

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(spLatitude))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										jPanel2Layout.createSequentialGroup()
												.addComponent(spLongitude, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addContainerGap()))));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel8).addComponent(jLabel7))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(spLatitude, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(spLongitude, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
		frame.getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(cbTipoUnidade, javax.swing.GroupLayout.PREFERRED_SIZE,
														164, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.PREFERRED_SIZE, 164,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addComponent(jLabel2).addGap(122, 122, 122)))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(btnConfirmar).addComponent(jPanel1,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap().addComponent(jLabel2)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addGroup(layout.createSequentialGroup()
								.addComponent(cbTipoUnidade, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel1)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnConfirmar)
				.addContainerGap()));

		frame.pack();
	}// </editor-fold>//GEN-END:initComponents

	private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnConfirmarActionPerformed
		frame.setVisible(false);
		frame.dispose();
	}// GEN-LAST:event_btnConfirmarActionPerformed

	private void buildUnidadeMonitora() throws NumberFormatException {
		unidade.setNome(this.txtNome.getText());
		PontoLocalizacao location = new PontoLocalizacao(Integer.valueOf(spLatitude.getValue().toString()),
				Integer.valueOf(spLongitude.getValue().toString()));
		unidade.setLocalizacao(location);
		unidade.setCamera(this.chbCamera.isSelected());
		unidade.setMedidorCH4(this.chbMedidorCH4.isSelected());
		unidade.setMedidorCO2(this.chbMedidorCO2.isSelected());
		unidade.setTermometro(this.chbTermometro.isSelected());
		unidade.setAreaMonitorada(area);
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnConfirmar;
	private javax.swing.JComboBox cbTipoUnidade;
	private javax.swing.JCheckBox chbCamera;
	private javax.swing.JCheckBox chbMedidorCH4;
	private javax.swing.JCheckBox chbMedidorCO2;
	private javax.swing.JCheckBox chbTermometro;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JSpinner spLatitude;
	private javax.swing.JSpinner spLongitude;
	private javax.swing.JTextField txtNome;
	// End of variables declaration//GEN-END:variables
}

package br.hue.hue.inf008.kinkinmonitor.ui;

import br.hue.hue.inf008.kinkinmonitor.controller.UnidadeMonitoraController;
import br.hue.hue.inf008.kinkinmonitor.model.AreaMonitorada;
import br.hue.hue.inf008.kinkinmonitor.model.UnidadeEuclidiana;
import br.hue.hue.inf008.kinkinmonitor.model.UnidadeMonitora;
import br.hue.hue.inf008.kinkinmonitor.model.UnidadeMonitora.EnumUnidadeMonitora;
import br.hue.hue.inf008.kinkinmonitor.utils.PontoLocalizacao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UnidadeMonitoraMForm extends javax.swing.JDialog {

	private AreaMonitorada area;
	private UnidadeMonitora unidade;

	public UnidadeMonitoraMForm(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
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
		this.chbCamera.setSelected(unidade.isCamera());
		this.chbMedidorCH4.setSelected(unidade.isMedidorCH4());
		this.chbMedidorCO2.setSelected(unidade.isMedidorCO2());
		this.chbTermometro.setSelected(unidade.isTermometro());
		this.spLatitude.setValue(unidade.getLocalizacao().getLatitude());
		this.spLongitude.setValue(unidade.getLocalizacao().getLongitude());
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
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

        setTitle("Incluir Unidade Monitora");
        setIconImage(null);
        setResizable(false);

        btnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/magnifier.png"))); // NOI18N
        btnConfirmar.setText("Consultar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuração da Unidade Monitora"));

        chbMedidorCO2.setText("Medidor CO2");

        chbMedidorCH4.setText("Medidor CH4");

        chbTermometro.setText("Termômetro");

        chbCamera.setText("Câmera");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/Camera.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/CO2.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/CH4.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/Thermometer.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chbCamera)
                    .addComponent(chbTermometro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chbMedidorCO2)
                    .addComponent(chbMedidorCH4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(chbMedidorCO2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(chbCamera)
                                .addGap(9, 9, 9))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(chbTermometro)
                                    .addComponent(chbMedidorCH4)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Localização"));

        jLabel7.setText("Latitude");
        jLabel7.setToolTipText("Identificador");

        jLabel8.setText("Longitude");
        jLabel8.setToolTipText("Identificador");

        spLatitude.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));

        spLongitude.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spLatitude))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(spLongitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spLatitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spLongitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnConfirmar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCancelar))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
		buildUnidadeMonitora();
		ArrayList<EnumUnidadeMonitora> confsMinima = buildMinimalConfiguraions();
		double distancia = Double.MAX_VALUE;
		UnidadeMonitora unidadeSelecionada = null;
		for (UnidadeMonitora unit : area.getUnidades()) {
			if (unit.possuiConfiguracaoMinima(confsMinima)) {
				if (distancia == 0d || distancia > unit.calcularDistancia(unidade.getLocalizacao())) {
					distancia = unit.calcularDistancia(unidade.getLocalizacao());
					unidadeSelecionada = unit;
				}
			}
		}
		if (unidadeSelecionada != null) {
			Object[] options = {"Sim", "Não"};

			int n = JOptionPane.showOptionDialog(this, "A Unidade: '" + unidadeSelecionada.getNome() + "', é a mais próxima do local informado\ncom as configurações mínimas selecionadas.\nDeseja move-la para o local?", "Confirmação",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
			if (n == 0) {
				try {
					unidadeSelecionada.setLocalizacao(unidade.getLocalizacao());
					int r = new UnidadeMonitoraController(unidadeSelecionada.getClass()).update(unidadeSelecionada);
					if (r > 0) {
						JOptionPane.showMessageDialog(this, "Operação realisada com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
						Logger.getLogger(UnidadeMonitoraMForm.class.getName()).log(Level.INFO, "Operação realisada com sucesso.", unidadeSelecionada);
					}
					this.setVisible(false);
					this.dispose();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, "Erro inesperado. Operação não realisada.\n\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
					Logger.getLogger(UnidadeMonitoraMForm.class.getName()).log(Level.SEVERE, e.getMessage(), e);
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Não há Unidades diponíveis ou que atenda as configurações mínimas..", "Informação", JOptionPane.WARNING_MESSAGE);
			Logger.getLogger(UnidadeMonitoraMForm.class.getName()).log(Level.INFO, "", unidadeSelecionada);
		}
    }//GEN-LAST:event_btnConfirmarActionPerformed

	private ArrayList<EnumUnidadeMonitora> buildMinimalConfiguraions() {
		ArrayList<EnumUnidadeMonitora> confsMinima = new ArrayList<>(0);
		if (unidade.isCamera()) {
			confsMinima.add(EnumUnidadeMonitora.CAMERA);
		}
		if (unidade.isMedidorCH4()) {
			confsMinima.add(EnumUnidadeMonitora.MEDIDORCH4);
		}
		if (unidade.isMedidorCO2()) {
			confsMinima.add(EnumUnidadeMonitora.MEDIDORCO2);
		}
		if (unidade.isTermometro()) {
			confsMinima.add(EnumUnidadeMonitora.TERMOMETRO);
		}
		return confsMinima;
	}

	private void buildUnidadeMonitora() throws NumberFormatException {
		unidade = new UnidadeEuclidiana();
		PontoLocalizacao location = new PontoLocalizacao(Integer.valueOf(spLatitude.getValue().toString()), Integer.valueOf(spLongitude.getValue().toString()));
		unidade.setLocalizacao(location);
		unidade.setCamera(this.chbCamera.isSelected());
		unidade.setMedidorCH4(this.chbMedidorCH4.isSelected());
		unidade.setMedidorCO2(this.chbMedidorCO2.isSelected());
		unidade.setTermometro(this.chbTermometro.isSelected());
		unidade.setAreaMonitorada(area);
	}

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
		this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JCheckBox chbCamera;
    private javax.swing.JCheckBox chbMedidorCH4;
    private javax.swing.JCheckBox chbMedidorCO2;
    private javax.swing.JCheckBox chbTermometro;
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
    // End of variables declaration//GEN-END:variables
}

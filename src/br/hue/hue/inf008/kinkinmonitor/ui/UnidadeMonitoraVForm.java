package br.hue.hue.inf008.kinkinmonitor.ui;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;

import br.hue.hue.inf008.kinkinmonitor.model.AreaMonitorada;
import br.hue.hue.inf008.kinkinmonitor.model.UnidadeEuclidiana;
import br.hue.hue.inf008.kinkinmonitor.model.UnidadeManhattan;
import br.hue.hue.inf008.kinkinmonitor.model.UnidadeMonitora;
import br.hue.hue.inf008.kinkinmonitor.utils.PontoLocalizacao;
import java.awt.Toolkit;

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
		if (unidade instanceof UnidadeEuclidiana) {
			cbTipoUnidade.setSelectedIndex(0);
		} else if (unidade instanceof UnidadeManhattan) {
			cbTipoUnidade.setSelectedIndex(1);
		}
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		frame = new JDialog();
		jLabel1 = new JLabel();
		txtNome = new JTextField();
		btnConfirmar = new JButton();
		jLabel2 = new JLabel();
		cbTipoUnidade = new JComboBox();
		jPanel1 = new JPanel();
		chbMedidorCO2 = new JCheckBox();
		chbMedidorCH4 = new JCheckBox();
		chbTermometro = new JCheckBox();
		chbCamera = new JCheckBox();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		jLabel6 = new JLabel();
		jPanel2 = new JPanel();
		jLabel7 = new JLabel();
		jLabel8 = new JLabel();
		spLatitude = new JSpinner();
		spLongitude = new JSpinner();

		frame.setTitle("Visualizar Unidade Monitora");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(UnidadeMonitoraVForm.class.getResource("/br/hue/hue/inf008/kinkinmonitor/resources/transmit_blue.png")));
		frame.setResizable(false);

		jLabel1.setText("Identificador");
		jLabel1.setToolTipText("Identificador");

		txtNome.setEditable(false);
		txtNome.setEnabled(false);
		txtNome.setMaximumSize(new Dimension(6, 20));

		btnConfirmar.setIcon(new ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/accept.png")));
		btnConfirmar.setText("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnConfirmarActionPerformed(evt);
			}
		});

		jLabel2.setText("Tipo Unidade");

		cbTipoUnidade.setModel(new DefaultComboBoxModel(new String[] { "Unidade Euclidiana", "Unidade Manhattan" }));
		cbTipoUnidade.setEnabled(false);

		jPanel1.setBorder(BorderFactory.createTitledBorder("Configuração da Unidade Monitora"));

		chbMedidorCO2.setText("Medidor CO2");
		chbMedidorCO2.setEnabled(false);

		chbMedidorCH4.setText("Medidor CH4");
		chbMedidorCH4.setEnabled(false);

		chbTermometro.setText("Termômetro");
		chbTermometro.setEnabled(false);

		chbCamera.setText("Câmera");
		chbCamera.setEnabled(false);

		jLabel3.setIcon(new ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/Camera.png")));

		jLabel4.setIcon(new ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/CO2.png")));

		jLabel5.setIcon(new ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/CH4.png")));

		jLabel6.setIcon(new ImageIcon(getClass().getResource("/br/hue/hue/inf008/kinkinmonitor/resources/Thermometer.png")));

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(
						jPanel1Layout
								.createParallelGroup(
										GroupLayout.Alignment.LEADING)
								.addGroup(GroupLayout.Alignment.TRAILING,
										jPanel1Layout.createSequentialGroup().addContainerGap()
												.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(jLabel3).addComponent(jLabel6))
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(chbCamera).addComponent(chbTermometro))
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
														.addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(chbMedidorCO2).addComponent(chbMedidorCH4))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel1Layout
				.setVerticalGroup(
						jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(jPanel1Layout.createSequentialGroup().addGap(19, 19, 19).addComponent(chbMedidorCO2))
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
																.addGroup(jPanel1Layout.createSequentialGroup().addGap(19, 19, 19).addComponent(chbCamera).addGap(9, 9, 9))
																.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
																		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
																				.addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																		.addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
								.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(jPanel1Layout.createSequentialGroup().addGap(26, 26, 26)
												.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(chbTermometro)
														.addComponent(chbMedidorCH4)))
										.addGroup(jPanel1Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(jLabel6, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jLabel5)))))
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jPanel2.setBorder(BorderFactory.createTitledBorder("Localização"));

		jLabel7.setText("Latitude");
		jLabel7.setToolTipText("Identificador");

		jLabel8.setText("Longitude");
		jLabel8.setToolTipText("Identificador");

		spLatitude.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spLatitude.setEnabled(false);

		spLongitude.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spLongitude.setEnabled(false);

		GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup()
								.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(spLatitude))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jLabel8, GroupLayout.Alignment.TRAILING)
								.addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
										.addComponent(spLongitude, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addContainerGap()))));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING,
				jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel8).addComponent(jLabel7))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(spLatitude, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(spLongitude, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))));

		GroupLayout layout = new GroupLayout(frame.getContentPane());
		frame.getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
						.createParallelGroup(
								GroupLayout.Alignment.LEADING)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
												.addComponent(cbTipoUnidade, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE).addComponent(txtNome,
														GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))
								.addComponent(jLabel1, GroupLayout.Alignment.LEADING)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addComponent(jLabel2).addGap(122, 122, 122)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(btnConfirmar).addComponent(jPanel1, GroupLayout.PREFERRED_SIZE,
						GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel2)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout
						.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addGroup(layout.createSequentialGroup()
								.addComponent(cbTipoUnidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(btnConfirmar).addContainerGap()));

		frame.pack();
	}

	private void btnConfirmarActionPerformed(ActionEvent evt) {
		frame.setVisible(false);
		frame.dispose();
	}

	private void buildUnidadeMonitora() throws NumberFormatException {
		unidade.setNome(this.txtNome.getText());
		PontoLocalizacao location = new PontoLocalizacao(Integer.valueOf(spLatitude.getValue().toString()), Integer.valueOf(spLongitude.getValue().toString()));
		unidade.setLocalizacao(location);
		unidade.setCamera(this.chbCamera.isSelected());
		unidade.setMedidorCH4(this.chbMedidorCH4.isSelected());
		unidade.setMedidorCO2(this.chbMedidorCO2.isSelected());
		unidade.setTermometro(this.chbTermometro.isSelected());
		unidade.setAreaMonitorada(area);
	}

	private JButton btnConfirmar;
	private JComboBox cbTipoUnidade;
	private JCheckBox chbCamera;
	private JCheckBox chbMedidorCH4;
	private JCheckBox chbMedidorCO2;
	private JCheckBox chbTermometro;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JLabel jLabel8;
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JSpinner spLatitude;
	private JSpinner spLongitude;
	private JTextField txtNome;
}

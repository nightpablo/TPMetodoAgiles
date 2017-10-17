package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class ModificacionTitular extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_2;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	
	
	public ModificacionTitular(JFrame principal, Integer id) {
		super(principal);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(7, 7, 7, 7));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 87, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 10, 0, 0, 21, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblAltaTitular = new JLabel("Nuevo Titular");
		lblAltaTitular.setFont(new Font("Arial", Font.BOLD, 25));
		GridBagConstraints gbc_lblAltaTitular = new GridBagConstraints();
		gbc_lblAltaTitular.gridheight = 3;
		gbc_lblAltaTitular.gridwidth = 9;
		gbc_lblAltaTitular.insets = new Insets(0, 0, 5, 0);
		gbc_lblAltaTitular.gridx = 1;
		gbc_lblAltaTitular.gridy = 0;
		panel.add(lblAltaTitular, gbc_lblAltaTitular);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"DNI", "LCI", "LU\t "}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.EAST;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 3;
		panel.add(comboBox, gbc_comboBox);
		
		textField = new JTextField();
		textField.setToolTipText("Ingrese el n\u00BA de documento");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 5;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 3;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 8;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 8;
		gbc_panel_1.gridy = 3;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JCheckBox chckbxClaseA = new JCheckBox("Clase A");
		chckbxClaseA.setToolTipText("Ciclomotores, motocicletas y triciclos motorizados.");
		GridBagConstraints gbc_chckbxClaseA = new GridBagConstraints();
		gbc_chckbxClaseA.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxClaseA.gridx = 0;
		gbc_chckbxClaseA.gridy = 0;
		panel_1.add(chckbxClaseA, gbc_chckbxClaseA);
		
		JCheckBox chckbxClaseB = new JCheckBox("Clase B");
		chckbxClaseB.setToolTipText("Autom\u00F3viles y camionetas con acoplado.");
		GridBagConstraints gbc_chckbxClaseB = new GridBagConstraints();
		gbc_chckbxClaseB.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxClaseB.gridx = 0;
		gbc_chckbxClaseB.gridy = 1;
		panel_1.add(chckbxClaseB, gbc_chckbxClaseB);
		
		JCheckBox chckbxClaseC = new JCheckBox("Clase C");
		chckbxClaseC.setToolTipText("Camiones sin acoplado y los comprendidos en la clase B.");
		GridBagConstraints gbc_chckbxClaseC = new GridBagConstraints();
		gbc_chckbxClaseC.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxClaseC.gridx = 0;
		gbc_chckbxClaseC.gridy = 2;
		panel_1.add(chckbxClaseC, gbc_chckbxClaseC);
		
		JCheckBox chckbxClaseD = new JCheckBox("Clase D");
		chckbxClaseD.setToolTipText("Servicio de transporte de pasajeros, emergencia, seguridad y los comprendidos en la clase B o C, seg\u00FAn el caso.");
		GridBagConstraints gbc_chckbxClaseD = new GridBagConstraints();
		gbc_chckbxClaseD.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxClaseD.gridx = 0;
		gbc_chckbxClaseD.gridy = 3;
		panel_1.add(chckbxClaseD, gbc_chckbxClaseD);
		
		JCheckBox chckbxClaseE = new JCheckBox("Clase E");
		chckbxClaseE.setToolTipText("Camiones articulados o con acoplado, maquinaria especial no agr\u00EDcola y los comprendidos en la clase B y C.");
		GridBagConstraints gbc_chckbxClaseE = new GridBagConstraints();
		gbc_chckbxClaseE.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxClaseE.gridx = 0;
		gbc_chckbxClaseE.gridy = 4;
		panel_1.add(chckbxClaseE, gbc_chckbxClaseE);
		
		JCheckBox chckbxClaseF = new JCheckBox("Clase F");
		chckbxClaseF.setToolTipText("Automotores especialmente adaptados para discapacitados.");
		GridBagConstraints gbc_chckbxClaseF = new GridBagConstraints();
		gbc_chckbxClaseF.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxClaseF.gridx = 0;
		gbc_chckbxClaseF.gridy = 5;
		panel_1.add(chckbxClaseF, gbc_chckbxClaseF);
		
		JCheckBox chckbxClaseG = new JCheckBox("Clase G");
		chckbxClaseG.setToolTipText("Tractores agr\u00EDcolas y maquinaria especial agr\u00EDcola.");
		GridBagConstraints gbc_chckbxClaseG = new GridBagConstraints();
		gbc_chckbxClaseG.gridx = 0;
		gbc_chckbxClaseG.gridy = 6;
		panel_1.add(chckbxClaseG, gbc_chckbxClaseG);
		
		JLabel lblNombre = new JLabel("Nombres:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 4;
		panel.add(lblNombre, gbc_lblNombre);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("Ingrese los nombres completos");
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 5;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 4;
		panel.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellidos:");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.EAST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 1;
		gbc_lblApellido.gridy = 5;
		panel.add(lblApellido, gbc_lblApellido);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Ingrese los apellidos paterno y materno");
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 5;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 5;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Domicilio:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 6;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField_7 = new JTextField();
		textField_7.setToolTipText("Ingrese el domicilio");
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.gridwidth = 5;
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 2;
		gbc_textField_7.gridy = 6;
		panel.add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);
		
		JLabel lblLugarDeNacimiento = new JLabel("Lugar de emisi\u00F3n:");
		GridBagConstraints gbc_lblLugarDeNacimiento = new GridBagConstraints();
		gbc_lblLugarDeNacimiento.anchor = GridBagConstraints.EAST;
		gbc_lblLugarDeNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblLugarDeNacimiento.gridx = 1;
		gbc_lblLugarDeNacimiento.gridy = 7;
		panel.add(lblLugarDeNacimiento, gbc_lblLugarDeNacimiento);
		
		textField_9 = new JTextField();
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.gridwidth = 5;
		gbc_textField_9.insets = new Insets(0, 0, 5, 5);
		gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_9.gridx = 2;
		gbc_textField_9.gridy = 7;
		panel.add(textField_9, gbc_textField_9);
		textField_9.setColumns(10);
		
		JLabel lblLocalidad = new JLabel("Localidad:");
		GridBagConstraints gbc_lblLocalidad = new GridBagConstraints();
		gbc_lblLocalidad.anchor = GridBagConstraints.EAST;
		gbc_lblLocalidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblLocalidad.gridx = 1;
		gbc_lblLocalidad.gridy = 8;
		panel.add(lblLocalidad, gbc_lblLocalidad);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("Ingrese la localidad");
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 5;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 8;
		panel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Fecha de nacimiento:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 9;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("Ingrese el dia");
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 9;
		panel.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("/");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 9;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_5 = new JTextField();
		textField_5.setToolTipText("Ingrese el mes");
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.gridx = 4;
		gbc_textField_5.gridy = 9;
		panel.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("/");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 5;
		gbc_lblNewLabel_2.gridy = 9;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_6 = new JTextField();
		textField_6.setToolTipText("Ingrese el a\u00F1o");
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.gridx = 6;
		gbc_textField_6.gridy = 9;
		panel.add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		GridBagConstraints gbc_lblObservaciones = new GridBagConstraints();
		gbc_lblObservaciones.anchor = GridBagConstraints.EAST;
		gbc_lblObservaciones.insets = new Insets(0, 0, 5, 5);
		gbc_lblObservaciones.gridx = 1;
		gbc_lblObservaciones.gridy = 10;
		panel.add(lblObservaciones, gbc_lblObservaciones);
		
		textField_8 = new JTextField();
		textField_8.setToolTipText("Ingrese las observaciones");
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.gridwidth = 5;
		gbc_textField_8.insets = new Insets(0, 0, 5, 5);
		gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_8.gridx = 2;
		gbc_textField_8.gridy = 10;
		panel.add(textField_8, gbc_textField_8);
		textField_8.setColumns(10);
		
		JLabel lblGrupo = new JLabel("Grupo:");
		GridBagConstraints gbc_lblGrupo = new GridBagConstraints();
		gbc_lblGrupo.anchor = GridBagConstraints.EAST;
		gbc_lblGrupo.insets = new Insets(0, 0, 5, 5);
		gbc_lblGrupo.gridx = 1;
		gbc_lblGrupo.gridy = 11;
		panel.add(lblGrupo, gbc_lblGrupo);
		
		textField_10 = new JTextField();
		textField_10.setToolTipText("Ingrese el grupo de sangre");
		GridBagConstraints gbc_textField_10 = new GridBagConstraints();
		gbc_textField_10.gridwidth = 2;
		gbc_textField_10.insets = new Insets(0, 0, 5, 5);
		gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_10.gridx = 2;
		gbc_textField_10.gridy = 11;
		panel.add(textField_10, gbc_textField_10);
		textField_10.setColumns(10);
		
		JLabel lblFactor = new JLabel("Factor:");
		GridBagConstraints gbc_lblFactor = new GridBagConstraints();
		gbc_lblFactor.anchor = GridBagConstraints.EAST;
		gbc_lblFactor.insets = new Insets(0, 0, 5, 5);
		gbc_lblFactor.gridx = 4;
		gbc_lblFactor.gridy = 11;
		panel.add(lblFactor, gbc_lblFactor);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("\u00BFPositivo o Negativo?");
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"+", "-"}));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 2;
		gbc_comboBox_1.anchor = GridBagConstraints.WEST;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.gridx = 5;
		gbc_comboBox_1.gridy = 11;
		panel.add(comboBox_1, gbc_comboBox_1);
		
		JLabel lblDonanteDerganos = new JLabel("Donante de \u00F3rganos:");
		GridBagConstraints gbc_lblDonanteDerganos = new GridBagConstraints();
		gbc_lblDonanteDerganos.anchor = GridBagConstraints.EAST;
		gbc_lblDonanteDerganos.insets = new Insets(0, 0, 5, 5);
		gbc_lblDonanteDerganos.gridx = 1;
		gbc_lblDonanteDerganos.gridy = 12;
		panel.add(lblDonanteDerganos, gbc_lblDonanteDerganos);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("No");
		chckbxNewCheckBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(chckbxNewCheckBox.isSelected())
					chckbxNewCheckBox.setText("Si");
				else
					chckbxNewCheckBox.setText("No");
			}
		});
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 2;
		gbc_chckbxNewCheckBox.gridy = 12;
		panel.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("Crear");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 7;
		gbc_btnNewButton.gridy = 13;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 8;
		gbc_btnCancelar.gridy = 13;
		panel.add(btnCancelar, gbc_btnCancelar);
		
		
		
		
		pack();
	}
	
	
	
}

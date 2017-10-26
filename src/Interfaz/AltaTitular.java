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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import Control.TitularJSON;
import Entidad.Titular;
import Utils.GestionCampos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class AltaTitular extends JDialog {
	
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4; //Dia
	private JTextField textField_5; //Mes
	private JTextField textField_6; //Año
	private JTextField textField_7;
	
	
	public AltaTitular(JFrame principal) {
		super(principal);
		setTitle("Creación de nuevo titular");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{835, 0};
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
		gbl_panel.columnWidths = new int[]{0, 0, 175, -3, 175, 0, 175, 63, 119, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 35, 35, 35, 35, 35, 35, 0, 35, 35, 35, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		setSize(841, 427);
		
		
		
		JLabel lblAltaTitular = new JLabel("Nuevo Titular");
		lblAltaTitular.setFont(new Font("Arial", Font.BOLD, 30));
		GridBagConstraints gbc_lblAltaTitular = new GridBagConstraints();
		gbc_lblAltaTitular.gridheight = 3;
		gbc_lblAltaTitular.gridwidth = 8;
		gbc_lblAltaTitular.insets = new Insets(0, 0, 5, 5);
		gbc_lblAltaTitular.gridx = 1;
		gbc_lblAltaTitular.gridy = 0;
		panel.add(lblAltaTitular, gbc_lblAltaTitular);
		
		Font fuenteelegida = new Font("Arial", Font.PLAIN, 18);
		
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setFont(fuenteelegida);
		comboBox.setToolTipText("Selecione el tipo de documento");
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"DNI", "CI", "LE", "LC\t "}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.EAST;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 3;
		panel.add(comboBox, gbc_comboBox);
		
		textField = new JTextField();
		textField.setFont(fuenteelegida);
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
		
		JCheckBox checkBox = new JCheckBox("Clase A");
		checkBox.setToolTipText("Ciclomotores, motocicletas y triciclos motorizados.");
		checkBox.setFont(fuenteelegida);
		GridBagConstraints gbc_checkBox = new GridBagConstraints();
		gbc_checkBox.insets = new Insets(0, 0, 5, 0);
		gbc_checkBox.gridx = 0;
		gbc_checkBox.gridy = 0;
		panel_1.add(checkBox, gbc_checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("Clase B");
		checkBox_1.setToolTipText("Autom\u00F3viles y camionetas con acoplado.");
		checkBox_1.setFont(fuenteelegida);
		GridBagConstraints gbc_checkBox_1 = new GridBagConstraints();
		gbc_checkBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_checkBox_1.gridx = 0;
		gbc_checkBox_1.gridy = 1;
		panel_1.add(checkBox_1, gbc_checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("Clase C");
		checkBox_2.setToolTipText("Camiones sin acoplado y los comprendidos en la clase B.");
		checkBox_2.setFont(fuenteelegida);
		GridBagConstraints gbc_checkBox_2 = new GridBagConstraints();
		gbc_checkBox_2.insets = new Insets(0, 0, 5, 0);
		gbc_checkBox_2.gridx = 0;
		gbc_checkBox_2.gridy = 2;
		panel_1.add(checkBox_2, gbc_checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("Clase D");
		checkBox_3.setToolTipText("Servicio de transporte de pasajeros, emergencia, seguridad y los comprendidos en la clase B o C, seg\u00FAn el caso.");
		checkBox_3.setFont(fuenteelegida);
		GridBagConstraints gbc_checkBox_3 = new GridBagConstraints();
		gbc_checkBox_3.insets = new Insets(0, 0, 5, 0);
		gbc_checkBox_3.gridx = 0;
		gbc_checkBox_3.gridy = 3;
		panel_1.add(checkBox_3, gbc_checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox("Clase E");
		checkBox_4.setToolTipText("Camiones articulados o con acoplado, maquinaria especial no agr\u00EDcola y los comprendidos en la clase B y C.");
		checkBox_4.setFont(fuenteelegida);
		GridBagConstraints gbc_checkBox_4 = new GridBagConstraints();
		gbc_checkBox_4.insets = new Insets(0, 0, 5, 0);
		gbc_checkBox_4.gridx = 0;
		gbc_checkBox_4.gridy = 4;
		panel_1.add(checkBox_4, gbc_checkBox_4);
		
		JCheckBox checkBox_5 = new JCheckBox("Clase F");
		checkBox_5.setToolTipText("Automotores especialmente adaptados para discapacitados.");
		checkBox_5.setFont(fuenteelegida);
		GridBagConstraints gbc_checkBox_5 = new GridBagConstraints();
		gbc_checkBox_5.insets = new Insets(0, 0, 5, 0);
		gbc_checkBox_5.gridx = 0;
		gbc_checkBox_5.gridy = 5;
		panel_1.add(checkBox_5, gbc_checkBox_5);
		
		JCheckBox checkBox_6 = new JCheckBox("Clase G");
		checkBox_6.setToolTipText("Tractores agr\u00EDcolas y maquinaria especial agr\u00EDcola.");
		checkBox_6.setFont(fuenteelegida);
		GridBagConstraints gbc_checkBox_6 = new GridBagConstraints();
		gbc_checkBox_6.gridx = 0;
		gbc_checkBox_6.gridy = 6;
		panel_1.add(checkBox_6, gbc_checkBox_6);
		
		JLabel lblNombre = new JLabel("Nombres:");
		lblNombre.setFont(fuenteelegida);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 4;
		panel.add(lblNombre, gbc_lblNombre);
		
		textField_3 = new JTextField();
		textField_3.setFont(fuenteelegida);
		textField_3.setToolTipText("Ingrese el nombre completo");
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 5;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 4;
		panel.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellidos:");
		lblApellido.setFont(fuenteelegida);
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.EAST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 1;
		gbc_lblApellido.gridy = 5;
		panel.add(lblApellido, gbc_lblApellido);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Ingrese los apellidos");
		textField_1.setFont(fuenteelegida);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 5;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 5;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Direccion:");
		lblNewLabel_3.setFont(fuenteelegida);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 6;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField_7 = new JTextField();
		textField_7.setFont(fuenteelegida);
		textField_7.setToolTipText("Ingrese el domicilio (vera 3229 dpto 1)");
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.gridwidth = 5;
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 2;
		gbc_textField_7.gridy = 6;
		panel.add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);
		
		JLabel lblLocalidad = new JLabel("Localidad:");
		lblLocalidad.setFont(fuenteelegida);
		GridBagConstraints gbc_lblLocalidad = new GridBagConstraints();
		gbc_lblLocalidad.anchor = GridBagConstraints.EAST;
		gbc_lblLocalidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblLocalidad.gridx = 1;
		gbc_lblLocalidad.gridy = 7;
		panel.add(lblLocalidad, gbc_lblLocalidad);
		
		JComboBox<String> comboBox_3 = new JComboBox<>();
		comboBox_3.setFont(fuenteelegida);
		comboBox_3.setToolTipText("Elija la localidad");
		comboBox_3.setModel(new DefaultComboBoxModel<String>(new String[] {"Santa Fe","Belgrano","Caseros","Castellanos","Constitucion","Garay","Gral Lopez",
				"Gral Obligado","Iriondo","La Capital","Las Colonias","San Cristobal","San Javier","San Jeronimo","San Justo\t "}));
		GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.gridwidth = 5;
		gbc_comboBox_3.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_3.gridx = 2;
		gbc_comboBox_3.gridy = 7;
		panel.add(comboBox_3, gbc_comboBox_3);
		
		JLabel lblNewLabel = new JLabel("Fecha de nacimiento:");
		lblNewLabel.setFont(fuenteelegida);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 8;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		textField_4 = new JTextField();
		textField_4.setFont(fuenteelegida);
		textField_4.setToolTipText("Ingrese el dia (1<=dd<=31)");
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 8;
		panel.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("/");
		lblNewLabel_1.setFont(fuenteelegida);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 8;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(fuenteelegida);
		textField_5.setToolTipText("Ingrese el mes (1<=mm<=12)");
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.gridx = 4;
		gbc_textField_5.gridy = 8;
		panel.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("/");
		lblNewLabel_2.setFont(fuenteelegida);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 5;
		gbc_lblNewLabel_2.gridy = 8;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_6 = new JTextField();
		textField_6.setFont(fuenteelegida);
		textField_6.setToolTipText("Ingrese el a\u00F1o (1900<=aaaa)");
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.gridx = 6;
		gbc_textField_6.gridy = 8;
		panel.add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
		
		JLabel lblddmmaaaa = new JLabel("(dd/mm/aaaa)");
		GridBagConstraints gbc_lblddmmaaaa = new GridBagConstraints();
		gbc_lblddmmaaaa.insets = new Insets(0, 0, 5, 5);
		gbc_lblddmmaaaa.gridx = 1;
		gbc_lblddmmaaaa.gridy = 9;
		panel.add(lblddmmaaaa, gbc_lblddmmaaaa);
		
		JLabel lblGrupo = new JLabel("Grupo:");
		lblGrupo.setFont(fuenteelegida);
		GridBagConstraints gbc_lblGrupo = new GridBagConstraints();
		gbc_lblGrupo.anchor = GridBagConstraints.EAST;
		gbc_lblGrupo.insets = new Insets(0, 0, 5, 5);
		gbc_lblGrupo.gridx = 1;
		gbc_lblGrupo.gridy = 10;
		panel.add(lblGrupo, gbc_lblGrupo);
		
		JComboBox<String> comboBox_2 = new JComboBox<>();
		comboBox_2.setFont(fuenteelegida);
		comboBox_2.setToolTipText("Elija el factor");
		comboBox_2.setModel(new DefaultComboBoxModel<String>(new String[] {"A", "AB", "B", "0"}));
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.anchor = GridBagConstraints.WEST;
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.gridx = 2;
		gbc_comboBox_2.gridy = 10;
		panel.add(comboBox_2, gbc_comboBox_2);
		
		JLabel lblFactor = new JLabel("Factor:");
		lblFactor.setFont(fuenteelegida);
		lblFactor.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblFactor = new GridBagConstraints();
		gbc_lblFactor.anchor = GridBagConstraints.EAST;
		gbc_lblFactor.insets = new Insets(0, 0, 5, 5);
		gbc_lblFactor.gridx = 4;
		gbc_lblFactor.gridy = 10;
		panel.add(lblFactor, gbc_lblFactor);
		
		JComboBox<String> comboBox_1 = new JComboBox<>();
		comboBox_1.setFont(fuenteelegida);
		comboBox_1.setToolTipText("\u00BFPositivo o Negativo?");
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"+", "-"}));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 3;
		gbc_comboBox_1.anchor = GridBagConstraints.WEST;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.gridx = 5;
		gbc_comboBox_1.gridy = 10;
		panel.add(comboBox_1, gbc_comboBox_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("No");
		chckbxNewCheckBox.setFont(fuenteelegida);
		chckbxNewCheckBox.setToolTipText("\u00BFEs donante?");
		chckbxNewCheckBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(chckbxNewCheckBox.isSelected())
					chckbxNewCheckBox.setText("Si");
				else
					chckbxNewCheckBox.setText("No");
			}
		});
		
		JLabel lblDonanteDerganos = new JLabel("Donante de \u00F3rganos:");
		lblDonanteDerganos.setFont(fuenteelegida);
		GridBagConstraints gbc_lblDonanteDerganos = new GridBagConstraints();
		gbc_lblDonanteDerganos.anchor = GridBagConstraints.EAST;
		gbc_lblDonanteDerganos.insets = new Insets(0, 0, 5, 5);
		gbc_lblDonanteDerganos.gridx = 1;
		gbc_lblDonanteDerganos.gridy = 11;
		panel.add(lblDonanteDerganos, gbc_lblDonanteDerganos);
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 2;
		gbc_chckbxNewCheckBox.gridy = 11;
		panel.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		
		JLabel lblCamposObligatorios = new JLabel("Nota: Todos los Campos son Obligatorios");
		lblCamposObligatorios.setForeground(Color.DARK_GRAY);
		lblCamposObligatorios.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GridBagConstraints gbc_lblCamposObligatorios = new GridBagConstraints();
		gbc_lblCamposObligatorios.gridwidth = 2;
		gbc_lblCamposObligatorios.insets = new Insets(0, 0, 0, 5);
		gbc_lblCamposObligatorios.gridx = 1;
		gbc_lblCamposObligatorios.gridy = 12;
		panel.add(lblCamposObligatorios, gbc_lblCamposObligatorios);
		
		JButton btnNewButton = new JButton("  Crear  ");
		btnNewButton.setPreferredSize(new Dimension(140, 40));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Object[] objetos = GestionCampos.evaluarTodosLosCampos(
						new String[] {
								textField.getText(), //dni
								textField_3.getText(), //nombres
								textField_1.getText(), //apellidos
								textField_7.getText(), //direccion
								textField_4.getText(), //dia
								textField_5.getText(), //mes
								textField_6.getText() //año
						}, 
						new String[] {
								"dni",
								"letras",
								"letras",
								"alfanumerico",
								"dia",
								"mes",
								"año"
						});
				
				if((int)objetos[1] != 0) {
					int j = 0;
					JTextField[] listaCampos = new JTextField[] {textField,textField_3,textField_1,textField_7,textField_4,textField_5,textField_6};
					String str = "";
					switch((int)objetos[1]) {
						case 1: // Se refiere a que algun campo está vacio
							
							for(boolean i: (boolean[]) objetos[0]) {
								if(i) 
									listaCampos[j].setBackground(Color.WHITE);
								else {
									listaCampos[j].setBackground(new Color(240,128,128));
									switch(j) {
										case 0:
											str+="\ndni";
											break;
										case 1:
											str+="\nnombres";
											break;
										case 2:
											str+="\napellidos";
											break;
										case 3:
											str+="\ndireccion";
											break;
										case 4:
											str+="\ndia";
											break;
										case 5:
											str+="\nmes";
											break;
										case 6:
											str+="\naño";
											break;
										default:
											break;
									}
								}
								j++;
							}
							
							JOptionPane.showMessageDialog(null, "Algunos de los campos están vacios"+str);
							break;
						case 2: // Se refiere a que algun campo no cumple la variación correspodiente
							for(boolean i: (boolean[]) objetos[0]) {
								if(i) 
									listaCampos[j].setBackground(new Color(173,255,47));
								else {
									listaCampos[j].setBackground(new Color(240,128,128));
									switch(j) {
										case 0:
											str+="\ndni";
											break;
										case 1:
											str+="\nnombres";
											break;
										case 2:
											str+="\napellidos";
											break;
										case 3:
											str+="\ndireccion";
											break;
										case 4:
											str+="\ndia";
											break;
										case 5:
											str+="\nmes";
											break;
										case 6:
											str+="\naño";
											break;
										default:
											break;
									}
								}
								j++;
							}
							JOptionPane.showMessageDialog(null, "Algunos de los campos no cumple la variación"+str);
							break;
						default:
							break;
					}
					return;
				}
				
				
				Titular nuevotitular = new TitularJSON().crear(
						(String)comboBox.getSelectedItem(),
						textField.getText(),
						textField_3.getText(),
						textField_1.getText(),
						textField_7.getText(),
						(String)comboBox_3.getSelectedItem(),
						textField_4.getText(), textField_5.getText(), textField_6.getText(),
						(String)comboBox_2.getSelectedItem(), (String)comboBox_1.getSelectedItem(),
						chckbxNewCheckBox.getText());
				
				if(new TitularJSON().existeTitular(nuevotitular)) {
					JOptionPane.showMessageDialog(null, "¡El DNI ya existe!");
					return;
				}
				
				new EmitirLicencia(principal,
						nuevotitular
						,new boolean[] {
						checkBox.isSelected(),
						checkBox_1.isSelected(),
						checkBox_2.isSelected(),
						checkBox_3.isSelected(),
						checkBox_4.isSelected(),
						checkBox_5.isSelected(),
						checkBox_6.isSelected()}).setVisible(true);
				dispose();
			
			}
		});
		
		
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 6;
		gbc_btnNewButton.gridy = 12;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setPreferredSize(new Dimension(140, 40));
		btnCancelar.setFont(fuenteelegida);
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AltaTitular.this.dispose();
			}
		});
		
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 7;
		gbc_btnCancelar.gridy = 12;
		panel.add(btnCancelar, gbc_btnCancelar);
		
		pack();
	}

	
	
}

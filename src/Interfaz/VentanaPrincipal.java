package Interfaz;


import javax.swing.JFrame;

import Utils.GestionCampos;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaPrincipal extends JFrame {

	public static void main(String[] args) {
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		
		ventanaPrincipal.setVisible(true);
	}
	
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JButton btnNewButton = new JButton("AltaTitular");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AltaTitular altaTitular = new AltaTitular(VentanaPrincipal.this);
				altaTitular.setVisible(true);
				
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		pack();
		
		
		// Pruebas Ctrl + Shift + C para descomentar/comentar
		
//		System.out.println("Email: pablo_barragan@hotmail.com existe? "+(new GestionCampos()).evaluarEmail("pablo_barragan@hotmail.com"));
//		System.out.println("Email: pbarragan@frsf.utn.edu.com existe? "+(new GestionCampos()).evaluarEmail("pbarragan@frsf.utn.edu.ar"));
//		System.out.println("Email: pablo_barragan@asd@hotmail.com existe? "+(new GestionCampos()).evaluarEmail("pablo_barragan@asd@hotmail.com"));
		
//		System.out.println("Num�rico: holiscomov�� es s�lo numero? "+(new GestionCampos()).evaluarNum�rico("holiscomov��"));
//		System.out.println("Num�rico: holiscomov�� es s�lo letras? "+(new GestionCampos()).evaluarLetras("holiscomov��"));
//		System.out.println("Num�rico: holiscomov�� contiene numeros y letras? "+(new GestionCampos()).evaluarAlfanum�rico("holiscomov��")+"\n");
//		
//		System.out.println("Num�rico: 123131 es s�lo numero? "+(new GestionCampos()).evaluarNum�rico("123131"));
//		System.out.println("Num�rico: 123131 es s�lo letras? "+(new GestionCampos()).evaluarLetras("123131"));
//		System.out.println("Num�rico: 123131 contiene numeros y letras? "+(new GestionCampos()).evaluarAlfanum�rico("123131")+"\n");
//		
//		System.out.println("Num�rico: holis123aka es s�lo numero? "+(new GestionCampos()).evaluarNum�rico("holis123aka"));
//		System.out.println("Num�rico: holis123aka es s�lo letras? "+(new GestionCampos()).evaluarLetras("holis123aka"));
//		System.out.println("Num�rico: holis123aka contiene numeros y letras? "+(new GestionCampos()).evaluarAlfanum�rico("holis123aka"));
	}

}

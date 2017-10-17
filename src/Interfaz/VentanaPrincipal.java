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
		
//		System.out.println("Numérico: holiscomováñ es sólo numero? "+(new GestionCampos()).evaluarNumérico("holiscomováñ"));
//		System.out.println("Numérico: holiscomováñ es sólo letras? "+(new GestionCampos()).evaluarLetras("holiscomováñ"));
//		System.out.println("Numérico: holiscomováñ contiene numeros y letras? "+(new GestionCampos()).evaluarAlfanumérico("holiscomováñ")+"\n");
//		
//		System.out.println("Numérico: 123131 es sólo numero? "+(new GestionCampos()).evaluarNumérico("123131"));
//		System.out.println("Numérico: 123131 es sólo letras? "+(new GestionCampos()).evaluarLetras("123131"));
//		System.out.println("Numérico: 123131 contiene numeros y letras? "+(new GestionCampos()).evaluarAlfanumérico("123131")+"\n");
//		
//		System.out.println("Numérico: holis123aka es sólo numero? "+(new GestionCampos()).evaluarNumérico("holis123aka"));
//		System.out.println("Numérico: holis123aka es sólo letras? "+(new GestionCampos()).evaluarLetras("holis123aka"));
//		System.out.println("Numérico: holis123aka contiene numeros y letras? "+(new GestionCampos()).evaluarAlfanumérico("holis123aka"));
	}

}

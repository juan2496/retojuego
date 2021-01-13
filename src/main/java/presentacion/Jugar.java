package presentacion;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import co.com.sofka.cargame.domain.juego.Juego;
import co.com.sofka.cargame.domain.values.Pista;
import java.awt.Component;
import java.awt.Dimension;

public class Jugar extends JFrame{

	String ruta = "src/caras/";
	String pista = "src/pistas/pista1";
	String podio = "src/pistas/podio";
	String carrouno = "src/autos/auto1";
	String carrodos = "src/autos/auto2";
	String carrotres = "src/autos/auto3";
	String carrocuatro = "src/autos/auto4";
	String fondo = "src/fondo/fondoinicio";
	
	
	public JFrame frame;
	private JLabel label;
	private JLabel labelp;
	private Juego nuevoJuego;
	private int numeroTotalJugador;
	private int turno;
	private JLabel label2 = new JLabel();
	private JLabel label3 = new JLabel();
	private JLabel label4 = new JLabel();
	
	private JLabel carro1 = new JLabel();
	private JLabel carro2 = new JLabel();
	private JLabel carro3 = new JLabel();
	private JLabel carro4 = new JLabel();
	
	private JLabel nombre1; 
	private JLabel nombre2; 
	private JLabel nombre3;
	private JLabel nombre4; 
	
	public Jugar() {
		iniciarJuego();
		initialize();
	}

	private void iniciarJuego() {
		
		//Crear Juego
		nuevoJuego = new Juego();
		
		
		//Crear pista
		Pista pistaUno = new Pista(1000, "Pista Uno");
		nuevoJuego.setPista(pistaUno);
		
		//crear jugadore
		nuevoJuego.crearJugador(1,"Daniel");
		nuevoJuego.crearJugador(2,"Andres");
		nuevoJuego.crearJugador(3,"Juan");		
		nuevoJuego.crearJugador(4,"Alejandra");	
		
		numeroTotalJugador = nuevoJuego.getJugadores().size();
		turno = 0;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {				
		frame = new JFrame();
		frame.setBounds(100, 100, 682, 479);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		label = new JLabel("");
		label.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		label.setBounds(10, 334, 100, 100);
		frame.getContentPane().add(label);
		
		JButton btnNewButton = new JButton("TIRAR DADO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				
				if(nuevoJuego.isJugando()) {
					int tiro = 1 + (int)(Math.random()*6);				
					ImageIcon in = new ImageIcon(ruta + tiro + ".png");
					label.setIcon(in);							
					
					nuevoJuego.movimientoJugador(turno, tiro);
					
					//Metodo que pinte carro y refresque
					moverCarro(turno,nuevoJuego.posicionActualCarro(turno));
					
					//Turno del siguinete jugador
					if(turno == numeroTotalJugador-1) {
						turno = 0;
					}else {
						turno++;
					}					
					
					
				}else {
					//Pintar el podio
					pintarPodio();
					
				}	
				
			}
			
		});
		
		
		JButton btnNewButton2 = new JButton("REINICIAR CARRERA");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				nuevoJuego.reiniciar();
				reiniciar();
				
			}
				
		
		});
		
		
		
		btnNewButton.setBounds(120, 411, 151, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton2.setBounds(300, 411, 151, 23);
		frame.getContentPane().add(btnNewButton2);
		label2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		label2.setForeground(Color.WHITE);
		label2.setBounds(137, 215, 83, 14);
		frame.getContentPane().add(label2);
		label3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		label3.setForeground(Color.WHITE);
		label3.setBounds(259, 153, 83, 14);
		frame.getContentPane().add(label3);
		label4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		label4.setForeground(Color.WHITE);
		label4.setBounds(375, 189, 83, 14);
		frame.getContentPane().add(label4);
		
		labelp = new JLabel("");		
		labelp.setFont(new Font("Tahoma", Font.PLAIN, 51));
		labelp.setBounds(10, 11, 556, 293);		
		ImageIcon on = new ImageIcon(pista +  ".png");
		labelp.setIcon(on);
		labelp.setOpaque(true);		
		frame.getContentPane().add(labelp);				
		
		nombre1 = new JLabel(nuevoJuego.getJugadores().get(0).getNombre());
		nombre1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nombre1.setBounds(576, 26, 80, 14);
		frame.getContentPane().add(nombre1);
		
		nombre2 = new JLabel(nuevoJuego.getJugadores().get(1).getNombre());
		nombre2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nombre2.setBounds(576, 100, 80, 14);
		frame.getContentPane().add(nombre2);
		
		nombre3 = new JLabel(nuevoJuego.getJugadores().get(2).getNombre());
		nombre3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nombre3.setBounds(576, 173, 80, 14);
		frame.getContentPane().add(nombre3);
		
		nombre4 = new JLabel(nuevoJuego.getJugadores().get(3).getNombre());
		nombre4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nombre4.setBounds(576, 248, 83, 14);
		frame.getContentPane().add(nombre4);
		
		
		pintarCarros();						
		
	}
	
	protected void reiniciar() {
		frame.getContentPane().add(labelp);
		ImageIcon on = new ImageIcon(pista +  ".png");
		labelp.setIcon(on);		

		carro1.setVisible(true);
		carro2.setVisible(true);
		carro3.setVisible(true);
		carro4.setVisible(true);
		
		nombre1.setVisible(true);
		nombre2.setVisible(true);
		nombre3.setVisible(true);
		nombre4.setVisible(true);
		
		carro1.setBounds(20, 26, 46, 14);	
		carro2.setBounds(20, 100, 46, 14);		
		carro3.setBounds(20, 173, 46, 14);
		carro4.setBounds(20, 248, 46, 14);
		
		label2.setText("");
		label3.setText("");
		label4.setText("");
		
		frame.repaint();
	}

	public void pintarCarros() {
		carro1.setSize(new Dimension(0, 16));
		
		carro1.setBounds(20, 26, 46, 14);		
		ImageIcon en = new ImageIcon(carrouno +  ".png");
		carro1.setIcon(en);
		labelp.add(carro1);
		
		carro2.setBounds(20, 100, 46, 14);		
		ImageIcon an = new ImageIcon(carrodos +  ".png");
		carro2.setIcon(an);
		labelp.add(carro2);		
		
		carro3.setBounds(20, 173, 46, 14);		
		ImageIcon un = new ImageIcon(carrotres +  ".png");
		carro3.setIcon(un);
		labelp.add(carro3);
		
		carro4.setBounds(20, 248, 46, 14);		
		ImageIcon rn = new ImageIcon(carrocuatro +  ".png");
		carro4.setIcon(rn);
		labelp.add(carro4);
		
		frame.repaint();		
		
	}
	
	public void moverCarro(int numeroCarro,int movimiento) {
		int posicion = 20+movimiento;
		switch (numeroCarro) {
		case 0:			
			if(posicion >= nuevoJuego.getPista().getKilometros()) {
				carro1.setBounds(500, 26, 46, 14);
			}else {
				carro1.setBounds(posicion/2, 26, 46, 14);
			}
			
			break;
		case 1:
			if(posicion >= nuevoJuego.getPista().getKilometros()) {
				carro2.setBounds(500, 100, 46, 14);
			}else {
				carro2.setBounds(posicion/2, 100, 46, 14);	
			}
				
			break;
		case 2:
			if(posicion >= nuevoJuego.getPista().getKilometros()) {
				carro3.setBounds(500, 173, 46, 14);
			}else {
				carro3.setBounds(posicion/2, 173, 46, 14);	
			}
			break;
		case 3:
			if(posicion >= nuevoJuego.getPista().getKilometros()) {
				carro4.setBounds(500, 248, 46, 14);
			}else {
				carro4.setBounds(posicion/2, 248, 46, 14);
			}		
			break;
		default:
			break;
		}
		frame.repaint();	
	}

	public void pintarPodio() {
		
		carro1.setVisible(false);
		carro2.setVisible(false);
		carro3.setVisible(false);
		carro4.setVisible(false);
		
		nombre1.setVisible(false);
		nombre2.setVisible(false);
		nombre3.setVisible(false);
		nombre4.setVisible(false);
		
		ImageIcon on = new ImageIcon(podio +  ".png");
		labelp.setIcon(on);
		labelp.setOpaque(true);
		
		String primerPuesto = nuevoJuego.getPodio().getPrimerPuesto().getNombre();
		String segundoPuesto = nuevoJuego.getPodio().getSegundoPuesto().getNombre();
		String tercerPuesto = nuevoJuego.getPodio().getTercerPuesto().getNombre();
		
		System.out.println(nuevoJuego.getPodio().toString());
		
		label2.setText(tercerPuesto);
		label3.setText(primerPuesto);
		label4.setText(segundoPuesto);
		
		frame.repaint();
		
	
	}
	
	
}

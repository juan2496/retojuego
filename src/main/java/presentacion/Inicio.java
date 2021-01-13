package presentacion;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;

public class Inicio  extends JFrame{
	
	String fondos= "src/fondo/fondoinicio";
	private JButton btnJugar;

	public JFrame frame;
	public JLabel labelf;
	
	public Inicio() {
		initialize();	
		accionJugar();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel labelf = new JLabel("");
		labelf.setBounds(10, 11, 414, 239);
		frame.getContentPane().add(labelf);
		
		frame.getContentPane().add(labelf);
		ImageIcon on = new ImageIcon(fondos +  ".png");
		labelf.setIcon(on);	
		
		btnJugar = new JButton("Jugar");
		btnJugar.setBounds(318, 227, 89, 23);
		frame.getContentPane().add(btnJugar);
		
	}
	
	private void accionJugar() {
		btnJugar.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						Jugar p=new Jugar();
						frame.setVisible(false);
						p.frame.setVisible(true);
					}
				});
	}
	
}

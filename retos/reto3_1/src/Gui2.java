import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Gui2 extends JFrame implements ActionListener{

	JLabel lbTitulo;
	JButton btnP1, btnP2, btnInterno;
	JTextArea textArea;
	JPanel p1, p2;
	JTextField campo;
	
	
	public Gui2() throws HeadlessException {
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(387, 365);
		setTitle("Ejemplo jpanel basico");
		setLayout(null);
		
		setLocationRelativeTo(null);
		iniciarComponentes();
		
	}
	
	private void iniciarComponentes() {
		p1 = new JPanel();
		p1.setBackground(Color.CYAN);
		p1.setBounds(5,112,370,200);
		p1.setLayout(null);
		p1.setVisible(true);
		
		p2 = new JPanel();
		p2.setBackground(Color.GREEN);
		p2.setBounds(5,112,370,200);
		p2.setLayout(null);
		p2.setVisible(false);
		
		lbTitulo = new JLabel("ejemplo jpanel");
		//lbTitulo.setFont(getFont());
		lbTitulo.setBounds(10,14,221,51);
		
		btnP1 = new JButton("Panel 1");
		btnP1.setBounds(10,76,89,23);
		btnP1.addActionListener(this);
		
		btnP2 = new JButton("Panel 2");
		btnP2.setBounds(109,76,89,23);
		btnP2.addActionListener(this);
		
		
		cargarComponentesP1();
		cargarComponentesP2();
		
		add(btnP1);
		add(btnP2);
		add(lbTitulo);
		
		add(p2);
		add(p1);
		
	}
	private void cargarComponentesP1() {
		textArea = new JTextArea();
		textArea.setBounds(10,10,350,181);
		String texto = "texto";
		textArea.setText(texto);
		p1.add(textArea);
	}
	
	private void cargarComponentesP2() {
		btnInterno = new JButton();
		btnInterno.setText("Enviar");
		btnInterno.setBounds(200,10,90,25);
		btnInterno.addActionListener(this);
		
		campo = new JTextField();
		campo.setBounds(10,10,180,25);
		p2.add(btnInterno);
		p2.add(campo);
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnP1) {
			p1.setVisible(true);
			p2.setVisible(false);
		}
		if (e.getSource() == btnP2) {
			p1.setVisible(false);
			p2.setVisible(true);
		}
		if (e.getSource() == btnInterno) {
			JOptionPane.showMessageDialog(null, "entrada de usuario: "+campo.getText());
		}
	}
}
  
	
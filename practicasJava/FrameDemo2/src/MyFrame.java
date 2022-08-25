import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class MyFrame extends JFrame implements ActionListener {
 
        //Create a frame with a button.
	JButton button;
        public MyFrame() {
            super("A window");
            
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
 
            //This button lets you close even an undecorated window.
            button = new JButton("Close window");
            button.addActionListener(this);
 
            //Place the button near the bottom of the window.
            Container contentPane = getContentPane();
            contentPane.setLayout(new BoxLayout(contentPane,
                                                BoxLayout.PAGE_AXIS));
            contentPane.add(Box.createVerticalGlue()); //takes all extra space
            contentPane.add(button);
            button.setAlignmentX(Component.CENTER_ALIGNMENT); //horizontally centered
            contentPane.add(Box.createVerticalStrut(5)); //spacer
        }
        
       /*void addMensaje(ActionListener mal) {
            button.addActionListener(mal);
        }*/

		@Override
		public void actionPerformed(ActionEvent e) {
            //mf.setVisible(false);
            //mf.dispose();
            JOptionPane.showMessageDialog(null, "boton segundo frame");
            
        }
 
        //Make the button do the same thing as the default close operation
        //(DISPOSE_ON_CLOSE).
        
    }
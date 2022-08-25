import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class Login extends JFrame {
    JButton applyButton = new JButton("Iniciar sesión");
    GridLayout experimentLayout = new GridLayout(3,2);
    
     
    public Login(String name) {
        super(name);
        setResizable(false);
    }
     
    public void addComponentsToPane(final Container pane) {
        final JPanel titulo = new JPanel();
    	titulo.setLayout(new FlowLayout());
    	titulo.add(new JLabel("Almacen"));
        final JPanel compsToExperiment = new JPanel();
        experimentLayout.setHgap(10);
        experimentLayout.setVgap(10);
        experimentLayout.layoutContainer(compsToExperiment);
        compsToExperiment.setLayout(experimentLayout);
        JPanel controls = new JPanel();
        controls.setBackground(Color.YELLOW);
        controls.setLayout(new GridLayout(0,1));
         
        //Set up components preferred size
        //JButton b = new JButton("Just fake button");
        //Dimension buttonSize = b.getPreferredSize();
        /*compsToExperiment.setPreferredSize(
        		new Dimension((int)(buttonSize.getWidth() * 2.5)+maxGap,
        					  (int)(buttonSize.getHeight() * 3.5)+maxGap * 2));*/
         
        //Add buttons to experiment with Grid Layout
        
        //compsToExperiment.add(new JLabel(" "));
        compsToExperiment.add(new JLabel("Usuario: "));
        JTextField jtf1 = new JTextField();
        compsToExperiment.add(jtf1);
        compsToExperiment.add(new JLabel("Contraseña: "));
        JPasswordField jpf = new JPasswordField();
        compsToExperiment.add(jpf);
        
         
        //Add controls to set up horizontal and vertical gaps
        JLabel error = new JLabel("", SwingConstants.CENTER);
        
        error.setForeground(Color.RED);
		controls.add(error);
		controls.add(applyButton);
         
        //Process the Apply gaps button press
        applyButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
            	if (jtf1.getText().equals("prueba")) {
            		error.setText("Usuario no valido");
				}
            	else if (String.valueOf(jpf.getPassword()).length() < 6) {
            		error.setText("pswd debe tener mas de 6");
				}
            	else if (jtf1.getText().equals(String.valueOf(jpf.getPassword()))) {
					error.setText("Contraseña no debe ser igual a usuario");
				}
            	else {
					JFrame jf = new JFrame();
					jf.setSize(300,220);
					jf.add(new JLabel("Bienvenidos", SwingConstants.CENTER));
					jf.setVisible(true);
					
				}
            }
        });
        pane.setBackground(Color.GREEN);
        pane.add(titulo, BorderLayout.NORTH);
        pane.add(compsToExperiment, BorderLayout.CENTER);
        pane.add(controls, BorderLayout.SOUTH);
    }
     
    /**
     * Create the GUI and show it.  For thread safety,
     * this method is invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
    	Login frame = new Login("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        frame.addComponentsToPane(frame.getContentPane());
        //Display the window.
        frame.pack();
        frame.setSize(300,220);
        frame.setVisible(true);
    }
     
    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
         
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

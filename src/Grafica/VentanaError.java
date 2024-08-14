package Grafica;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaError extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaError frame = new VentanaError("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


    public VentanaError(String mensaje) {
        setTitle("Error");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana al presionar cerrar
        setSize(300, 150);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        getContentPane().setLayout(null);


        JLabel etiqueta = new JLabel(mensaje, SwingConstants.CENTER);
        etiqueta.setBounds(0, 19, 300, 68);
        getContentPane().add(etiqueta);
        
        JButton btnNewButton = new JButton("Cerrar");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        btnNewButton.setBounds(63, 99, 167, 29);
        getContentPane().add(btnNewButton);
    }
    

}

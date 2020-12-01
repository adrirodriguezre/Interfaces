import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Panel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class EjercicioExamen {

	private JFrame frame;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JButton btnImagen;
	private JComboBox cbTipoUsuario;
	private String rutaImagenSeleccionada="";
	private JTextArea txtDireccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjercicioExamen window = new EjercicioExamen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EjercicioExamen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(600, 500));
		frame.setBounds(100, 100, 848, 535);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pnImagenAlumno = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnImagenAlumno.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frame.getContentPane().add(pnImagenAlumno, BorderLayout.NORTH);
		
		Panel pnImagen = new Panel();
		pnImagen.setPreferredSize(new Dimension(200, 200));
		pnImagenAlumno.add(pnImagen);
		pnImagen.setLayout(new BorderLayout(0, 0));
		
		btnImagen = new JButton("New button");
		btnImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Mostrar Dialogo y asignar imagen
				seleccionarImagenUsuario();
				
			}
		});
		btnImagen.setBackground(Color.WHITE);
		btnImagen.setToolTipText("Imagen de usuario");
		btnImagen.setPreferredSize(new Dimension(200, 200));
		
		
		ImageIcon imageIcon = new ImageIcon(EjercicioExamen.class.getResource("/imagen/usuario.png")); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		btnImagen.setIcon(imageIcon);
		
		
		pnImagen.add(btnImagen, BorderLayout.NORTH);
		
		JButton btnSeleccionarImagen = new JButton("Seleccionar imagen");
		btnSeleccionarImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Mostrar Dialogo y asignar imagen
				seleccionarImagenUsuario();
			}
		});
		pnImagenAlumno.add(btnSeleccionarImagen);
		
		JPanel pnBotonera = new JPanel();
		frame.getContentPane().add(pnBotonera, BorderLayout.SOUTH);
		pnBotonera.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombre.getText();
				String apellidos= txtApellidos.getText();
				String tipo= cbTipoUsuario.getSelectedItem()!=null?cbTipoUsuario.getSelectedItem().toString():"";
				String direccion= txtDireccion.getText();
				
				String rutaImagen= rutaImagenSeleccionada;
				String mensaje="";
				if(nombre.compareToIgnoreCase("")==0||apellidos.compareToIgnoreCase("")==0||tipo.compareToIgnoreCase("")==0||
						direccion.compareToIgnoreCase("")==0||rutaImagen.compareToIgnoreCase("")==0) {
					mensaje="Comprueba que has introducido todos los datos y la imagen";
					mostrarErrorGuardado(mensaje);
				}
				else
				{
					mensaje=String.format("Se han guardado los siguientes datos:\n\nImagen: %s\nNombre: %s\nApellidos: %s\nTipo: %s\nDireccion:%s", 
							rutaImagen,nombre,apellidos,tipo,direccion);
					mostrarMensajeGuardado(mensaje);
				}
				
			}
		});
		pnBotonera.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cerrar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		pnBotonera.add(btnCancelar);
		
		JPanel pnDatosAlumno = new JPanel();
		frame.getContentPane().add(pnDatosAlumno, BorderLayout.CENTER);
		pnDatosAlumno.setLayout(new BorderLayout(0, 0));
		
		
		
		
		
		JPanel pnDatosFijos = new JPanel();
		pnDatosFijos.setPreferredSize(new Dimension(30, 120));
		pnDatosAlumno.add(pnDatosFijos,BorderLayout.NORTH);
		pnDatosFijos.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 13, 72, 25);
		pnDatosFijos.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(108, 12, 265, 25);
		pnDatosFijos.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(12, 47, 72, 25);
		pnDatosFijos.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(108, 47, 265, 25);
		pnDatosFijos.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		JLabel lblTipoUsuario = new JLabel("Tipo");
		lblTipoUsuario.setBounds(12, 81, 72, 25);
		pnDatosFijos.add(lblTipoUsuario);
		
		cbTipoUsuario = new JComboBox();
		cbTipoUsuario.setModel(new DefaultComboBoxModel(new String[] {"", "Administrador", "SuperAdministrador", "Usuario"}));
		cbTipoUsuario.setBounds(108, 82, 265, 22);
		pnDatosFijos.add(cbTipoUsuario);
		
		JPanel pnDireccion = new JPanel();
		pnDireccion.setBorder(new EmptyBorder(10, 12, 10, 12));
		pnDatosAlumno.add(pnDireccion,BorderLayout.CENTER);
		pnDireccion.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(new Rectangle(12, 0, 0, 0));
		pnDireccion.add(lblDireccion, BorderLayout.NORTH);
		JScrollPane spDireccion = new JScrollPane();
		//pnDireccion.add(txtDireccion, BorderLayout.CENTER);
		
		
		pnDireccion.add(spDireccion, BorderLayout.CENTER);
		
		txtDireccion = new JTextArea();
		spDireccion.setViewportView(txtDireccion);
		
		
		
	}
	
	//MÉTODOS
	
	private void seleccionarImagenUsuario() {
		JFileChooser fs = new JFileChooser();
		if(fs.showOpenDialog(null) == JFileChooser.APPROVE_OPTION ) {
			//Obtener imagen y asignarla al control
			rutaImagenSeleccionada=fs.getSelectedFile().getAbsolutePath();
			ImageIcon imageIcon = new ImageIcon(rutaImagenSeleccionada);
			Image image = imageIcon.getImage(); 
			Image newimg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); 
			imageIcon = new ImageIcon(newimg); 
			btnImagen.setIcon(imageIcon);
		}
	}
	
	private void mostrarMensajeGuardado(String mensaje) {
		JOptionPane.showMessageDialog(this.frame, mensaje, "Usuario guardado", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void mostrarErrorGuardado(String mensaje) {
		JOptionPane.showMessageDialog(this.frame, mensaje, "Error en guardado", JOptionPane.ERROR_MESSAGE);
	}
}

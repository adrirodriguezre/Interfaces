import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextPane;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.DefaultEditorKit.CutAction;

import java.awt.BorderLayout;
import java.awt.Desktop.Action;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class EditorTexto {

	private JFrame frame;
	private JButton btnNewButton;

	/**
	 * Launch the application....
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditorTexto window = new EditorTexto();
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
	public EditorTexto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame("Editor de texto");
		
		frame.setBounds(100, 100, 487, 369);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		JToolBar toolBar = new JToolBar();
		scrollPane.setColumnHeaderView(toolBar);
		
		

		
		
		
		//BOTONES CON IMAGENES
		
		//NUEVO
		btnNewButton = new JButton("");
		toolBar.add(btnNewButton);
		btnNewButton.setToolTipText("Nuevo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(EditorTexto.class.getResource("/img/favicon-16x16nuevo.png")));
		
		//GUARDAR
		JButton btnGuardar = new JButton();
		toolBar.add(btnGuardar);
		btnGuardar.setToolTipText("Guardar");
		btnGuardar.setIcon(new ImageIcon(EditorTexto.class.getResource("/img/favicon-16x16guard.png")));
		btnGuardar.setText("");
		
		//COPIAR
		JButton btnCopiar = new JButton(new DefaultEditorKit.CopyAction());
		toolBar.add(btnCopiar);
		btnCopiar.setToolTipText("Copiar");
		btnCopiar.setIcon(new ImageIcon(EditorTexto.class.getResource("/img/favicon-16x16111.png")));
		btnCopiar.setText("");
		
		//CORTAR
		JButton btnCortar = new JButton(new DefaultEditorKit.CutAction());
		toolBar.add(btnCortar);
		btnCortar.setToolTipText("Cortar");
		btnCortar.setIcon(new ImageIcon(EditorTexto.class.getResource("/img/favicon-16x16cort.png")));
		btnCortar.setText("");
		
		//PEGAR
		JButton btnPegar = new JButton(new DefaultEditorKit.PasteAction());
		toolBar.add(btnPegar);
		btnPegar.setText("");
		btnPegar.setToolTipText("Pegar");
		btnPegar.setIcon(new ImageIcon(EditorTexto.class.getResource("/img/favicon-16x16peg.png")));
		
		
		//AL PULSAR CERRAR
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrar(textPane);
			}
		});
		
		
		//MENÚS
		
				JMenu mnNewMenu = new JMenu("Fichero");
				menuBar.add(mnNewMenu);
				
				JMenu mnNewMenu_1 = new JMenu("Editor");
				menuBar.add(mnNewMenu_1);
				
				JMenu mnNewMenu_2 = new JMenu("Fuentes");
				mnNewMenu_1.add(mnNewMenu_2);
				
		
		//NUEVO
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Nuevo");		
		mntmNewMenuItem.addActionListener(new ActionListener() {
					
			public void actionPerformed(ActionEvent arg0) {
				nuevo(textPane,mntmNewMenuItem);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		
		//ABRIR
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Abrir");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*abrir(textPane);*/
				abrir2(textPane);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		
		//GUARDAR
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Guardar");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar(textPane);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		
		//GUARDAR COMO
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Guardar como");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardarComo(textPane);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		
		
		//FUENTE COMIC SANS
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Comic Sans");
		mntmNewMenuItem_5.setFont(new Font("Comic Sans MS" , Font.PLAIN, 14));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPane.setFont(new Font("Comic Sans MS" , Font.PLAIN, 14));
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		//FUENTE TIMES NEW ROMAN
		
				JMenuItem mntmNewMenuItem_4 = new JMenuItem("Times New Roman");
				mntmNewMenuItem_4.setFont(new Font("Times New Roman" , Font.PLAIN, 14));
				mntmNewMenuItem_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						textPane.setFont(new Font("Times New Roman" , Font.PLAIN, 14));
						/*JOptionPane.showConfirmDialog(null, "message");*/
					}
				});
				mnNewMenu_2.add(mntmNewMenuItem_4);
				
		//CORTAR
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem(new DefaultEditorKit.CutAction());
		mntmNewMenuItem_6.setText("Cortar");
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		//PEGAR
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem(new DefaultEditorKit.PasteAction());
		mntmNewMenuItem_7.setText("Pegar");
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		//COPIAR
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem(new DefaultEditorKit.CopyAction());
		mntmNewMenuItem_8.setText("Copiar");
		mnNewMenu_1.add(mntmNewMenuItem_8);
		
		
		
	}
	
	//MÉTODOS
	
	//método para guardar
	
	public void guardar(JTextPane textPane){
		
		try {
			
			
			String texto= textPane.getText();
			String direccion1 = JOptionPane.showInputDialog("Escribe la ruta donde guardar el archivo");
			String direccion2="/Texto.txt";
			String direccion3=direccion1+direccion2;
			
			File direccionFile= new File(direccion3);
			
			direccionFile.createNewFile();
			
			FileWriter f= new FileWriter(direccion3);
			BufferedWriter bw = new BufferedWriter(f);
			
			bw.write(texto);
			bw.close();

		} catch (IOException e) {
			
			/*e.printStackTrace();*/
		}
		
		
		
		
	

}
	
	
	
	
	//método para guardar como
	
	public void guardarComo(JTextPane textPane){
		
		try {
			
			
			String texto= textPane.getText();
			String direccion1 = JOptionPane.showInputDialog("Escribe la ruta donde guardar el archivo");
			String direccion2= JOptionPane.showInputDialog("Ponle un nombre al archivo");
			String direccion3= ".txt";
			String direccion4=direccion1+"/"+direccion2+direccion3;
			
			
			File direccionFile= new File(direccion4);
			
			direccionFile.createNewFile();
			
			FileWriter f= new FileWriter(direccion4);
			BufferedWriter bw = new BufferedWriter(f);
			bw.write(texto);
			bw.close();

		} catch (IOException e) {
			
			/*e.printStackTrace();*/
		}
		
		
		
		
	

}
	//metodo para crear un texto nuevo
	
	public void nuevo(JTextPane textPane,JMenuItem mntmNewMenuItem) {
	
		//mira si hay algo escrito
		String texto= textPane.getText();
		int digitos=texto.length();
		
		if (digitos!=0) {	//si hay algo escrito
			int eleccion = JOptionPane.showConfirmDialog(
					mntmNewMenuItem, "Si creas un archivo nuevo se borrara lo que no hayas guardado", "Crear un texto nuevo",
	                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (eleccion==0) {
				textPane.setText("");
			}
		}
		else {
			textPane.setText("");
		}
	
	
	}
	
	
	//método para abrir
	
	public void abrir(JTextPane textPane) {

		
		try {
			String texto;
			String direccion = JOptionPane.showInputDialog("Escribe la ruta del archivo");
			if(direccion!=null) {
				FileReader f = new FileReader(direccion); //FileReader sirve para leer archivos
				BufferedReader b = new BufferedReader(f); //BufferedReader sirve para leer texto de un archivo
				texto = b.readLine();
				textPane.setText(texto);
				b.close();
			}
			

		}
		catch (IOException e){
			
		}
		
	}
	
	//metodo para abrir seleccionando la ruta
	
	public void abrir2(JTextPane textPane){
		String aux="";   
		 String texto="";
		 JFileChooser fc = new JFileChooser();
		 int seleccion = fc.showOpenDialog(textPane);
		 if(seleccion==JFileChooser.APPROVE_OPTION){
			 File fichero=fc.getSelectedFile();

			  System.out.println(fichero.getAbsolutePath());
			  try(FileReader fr=new FileReader(fichero)){
			        String cadena="";
			        int valor=fr.read();
			        int contador=0;
			        while(valor!=-1){
			            cadena=cadena+(char)valor;
			            valor=fr.read();
			            //cuenta cada dígito para evitar que se lean archivos que rompan el programa
			            contador++;
			            if(contador>10000) {
			            	System.out.println("Demasiado texto para el programa");
			            	break;
			            }
			        }
			        textPane.setText(cadena);
			    } catch (IOException e1) {
			        e1.printStackTrace();
			    }
			  
		  }
		  
		
		
	}
	
	
	
	//método para cerrar
	public void cerrar(JTextPane textPane) {
		//mira si hay texto o no
		String texto= textPane.getText();
		int digitos=texto.length();
		if (digitos==0) {
			System.exit(0);
		}
		if (digitos!=0) { //si hay algo escrito no deja cerrar al momento
			int eleccion = JOptionPane.showConfirmDialog( null, "Hay texto escrito ¿Seguro que quieres cerrar?", "Cerrar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (eleccion==0) {
				System.exit(0);

					
				}
			}
		}
	 
	 
}
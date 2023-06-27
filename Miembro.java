
package proyectois;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Miembro extends JFrame {
    private Container contenedor;
    
     private JTextField jTId;
     private JLabel jLId;
     private JButton bBuscar;
     private JButton bCancelar;
     private JButton bEliminar;
     
     String FilePath = "C:\\Users\\Toshiba\\Desktop\\Trimestre 23 - Invierno\\Integracion de sistemas\\Proyecto\\ProyectoIS\\src\\proyectois\\sistema.xml";
    
     int rojo = 158;   // componente rojo (0-255)
     int verde = 185;   // componente verde (0-255)
     int azul = 185;    // componente azul (0-255)
     Color cancelar = new Color(rojo, verde, azul);
    
    int r = 75;   // componente rojo (0-255)
    int g = 173;   // componente verde (0-255)
    int b = 255;    // componente azul (0-255)
    Color buscar = new Color(r, g, b);
    
    int red = 255;   // componente rojo (0-255)
    int green = 56;   // componente verde (0-255)
    int blue = 56;    // componente azul (0-255)
    Color eliminar = new Color(red, green, blue);
    
    
    public Miembro() {
        interfaz();
    }
    
    private void interfaz() {
        contenedor = getContentPane();
        getContentPane().setLayout ( null );
        setTitle ( "Miembro" );
        setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        setSize ( 380, 200 );
        setLocationRelativeTo ( null );
        setResizable ( false );
        etiquetaID();
        campoID();
        botonBuscar();
        botonCancelar();
        botonEliminar();
    }
    
    private void etiquetaID() {
        jLId = new JLabel ( "   FOLIO :  " );
        jLId.setBounds ( 140, 20, 120, 30 );
        contenedor.add ( jLId );
    }
   private void campoID() {
        jTId = new JTextField ( 20 );
        jTId.setBounds ( 120, 48, 100, 25 );
        jTId.setEnabled ( true );
        contenedor.add(jTId);
   }
   
   
   private void botonCancelar(){
        bCancelar = new JButton();
        bCancelar.setText ( "Cancelar" );
        bCancelar.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 12));
        bCancelar.setBounds ( 38, 100, 90, 33 );
        bBuscar.setMnemonic ( 'B' );
        bCancelar.setBackground(cancelar);
        bCancelar.setForeground(Color.BLACK);
        bCancelar.addActionListener((ActionEvent e) -> {
            dispose(); // Cierra la ventana
        });  
        contenedor.add(bCancelar);
    }
    
    private void botonBuscar(){
        bBuscar = new JButton();
        bBuscar.setText ( "Buscar" );
        bBuscar.setBounds ( 140, 100, 90, 33 );
        bBuscar.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 12));
        bBuscar.setBackground(buscar);
        bBuscar.setForeground(Color.BLACK);
        bBuscar.setMnemonic ( 'A' );
        bBuscar.addActionListener((ActionEvent evt) -> {
        try {
            Buscar bus = new Buscar(); // Instanciar Buscar aquí
            bus.imprimir(FilePath, jTId.getText());
        } catch (HeadlessException e) {
            e.printStackTrace();
        }
    });
    contenedor.add(bBuscar);
    }
    
    private void botonEliminar(){
        bEliminar = new JButton();
        bEliminar.setText ( "Eliminar" );
        bEliminar.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 12));
        bEliminar.setBackground(eliminar);
        bBuscar.setMnemonic ( 'E' );
        bEliminar.setBounds ( 245, 100, 90, 33 );
        bEliminar.setForeground(Color.BLACK);
        bEliminar.addActionListener((ActionEvent evt) -> {
        try {
            Eliminar remove = new Eliminar(); // Instanciar Eliminar aquí
            remove.eliminarId(FilePath, jTId.getText());
        } catch (HeadlessException e) {
            e.printStackTrace();
        }
    });
    contenedor.add(bEliminar);    
    }
}

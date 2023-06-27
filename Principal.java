package proyectois;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Principal extends JFrame {
    private Container contenedor;
    private JButton ingresos;
    private JButton miembros;
    
    
     
     
     int r = 102;   // componente rojo (0-255)
     int g = 205;   // componente verde (0-255)
     int b = 170;    // componente azul (0-255)
     Color color2 = new Color(r, g, b);
     
     int rojo = 221;   // componente rojo (0-255)
     int verde = 160;   // componente verde (0-255)
     int azul = 221;    // componente azul (0-255)
     Color color3 = new Color(rojo, verde, azul);
     
     int red = 52;   // componente rojo (0-255)
     int green = 73;   // componente verde (0-255)
     int blue = 94;    // componente azul (0-255)
     Color backgroundColor = new Color(red, green, blue);
     
    
    public Principal(){
        interfaz();
    } 
    
    
    private void interfaz(){
     contenedor = getContentPane();
     getContentPane().setLayout(null);
     setTitle("Academia Titanes");
     setSize(350, 200);
     setResizable(false);
     setLocationRelativeTo(null);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     contenedor.setBackground(backgroundColor);
        
     miembro();
     nuevoIngreso();
        
    }
    
    
    private void miembro(){
        
        miembros = new JButton("Miembros");
        miembros.setBounds(100, 40, 130, 35);
        miembros.setFont(new Font("Tahoma", Font.BOLD, 14));
        miembros.setSelected(false);
        miembros.addActionListener((ActionEvent e) -> {
            Miembro miemb = new Miembro();
            miemb.setVisible(true);
            
        });
        miembros.setForeground(Color.BLACK);
        miembros.setBackground(color2);
        contenedor.add(miembros);
    }
    
    private void nuevoIngreso(){
        
        ingresos = new JButton("Nuevo Ingreso");
        ingresos.setFont(new Font("Tahoma", Font.BOLD, 13));
        ingresos.setBounds(100, 90, 130, 35);
        ingresos.setSelected(false);
        ingresos.addActionListener((ActionEvent evt) -> {
            try{
                NuevoIngreso nuevoIn = new NuevoIngreso();
                nuevoIn.setVisible(true);
                
            }catch (HeadlessException e){
                JOptionPane.showMessageDialog(null, "No se logró direccionarlo al formulario  ", "ERROR", JOptionPane.ERROR_MESSAGE );
            }
        });
        ingresos.setBackground(color3);
        ingresos.setForeground(Color.BLACK);
        contenedor.add(ingresos);
    }
    
    
}

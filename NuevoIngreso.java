package proyectois;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NuevoIngreso extends JFrame{
    private Container contenedor;
    private JButton bCancelar;
    private JButton bAlmacenar;
    private JButton bLimpiar;
    private JLabel jLEdad;
    private JLabel jLNombre;
    private JLabel jLTelefono;
    private JLabel jLCategoria;
    private JLabel jLProfesor;
    private JLabel jLHorario;
    private JLabel jLHora;
    private JLabel jLDia;
    private JLabel jLPrecio;
    private JSpinner jSEdad;
    private JComboBox jCHora;
    private JComboBox jCDia;
    private JComboBox jCPrecio;
    private JComboBox jCCategoria;
    private JTextField jTNombre;
    private JTextField jTTelefono;
    private JComboBox jCProfesor;
    
     int r = 236;   // componente rojo (0-255)
     int g = 236;   // componente verde (0-255)
     int b = 236;    // componente azul (0-255)
     Color fondo = new Color(r,g,b);
     
     int red = 255;   // componente rojo (0-255)
     int green = 40;   // componente verde (0-255)
     int blue = 14;    // componente azul (0-255)
     Color cancelar = new Color(red, green, blue);
     
      int rojo = 163;   // componente rojo (0-255)
    int verde = 245;   // componente verde (0-255)
    int azul = 0;    // componente azul (0-255)
    Color almacenar = new Color(rojo, verde, azul);
    
    int ro = 126;   // componente rojo (0-255)
    int v = 208;   // componente verde (0-255)
    int a = 255;    // componente azul (0-255)
    Color limpiar = new Color(ro,v,a);
    
    public NuevoIngreso() {
        interfaz();
    }
    
    private void interfaz() {
        contenedor = getContentPane();
        getContentPane().setLayout ( null );
        setTitle ( "Nuevo Ingreso" );
        setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        setSize ( 385, 335 );
        setLocationRelativeTo ( null );
        setResizable ( false );
        contenedor.setBackground(fondo);
        etiquetaNombre();
        campoNombre();
        etiquetaEdad();
        campoEdad();
        etiquetaTelefono();
        campoTelefono();
        etiquetaCategoria();
        campoCategoria();
        etiquetaPrecio();
        campoPrecio();
        etiquetaHorario();
        etiquetaHora();
        campoHora();
        etiquetaDia();
        campoDia();
        etiquetaProfesor();
        campoProfesor();
        botonAlmacenar();
        botonCancelar();
        botonLimpiar();
    }
    
    
    
   private void etiquetaNombre() {
        jLNombre = new JLabel ( "Nombre Completo:" );
        jLNombre.setBounds ( 15, 10, 110, 20 );
        jLNombre.setForeground(Color.BLACK);
        jLNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
        contenedor.add ( jLNombre );
    }
   private void campoNombre() {
        jTNombre = new JTextField ( 20 );
        jTNombre.setBounds ( 140, 10, 160, 20 );
        jTNombre.setForeground(Color.BLACK);
        jTNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jTNombre.setEnabled ( true );
        contenedor.add(jTNombre);
   }
    
    private void etiquetaEdad() {
        jLEdad = new JLabel ( "Edad:" );
        jLEdad.setBounds ( 15, 40, 110, 20 );
        jLEdad.setForeground(Color.BLACK);
        jLEdad.setFont(new Font("Tahoma", Font.PLAIN, 13));
        contenedor.add ( jLEdad );
    }
    private void campoEdad() {
        jSEdad = new JSpinner ();
        jSEdad.setBounds ( 60, 40, 80, 20 );
        jSEdad.setForeground(Color.BLACK);
        jSEdad.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jSEdad.setEnabled ( true );
        contenedor.add(jSEdad);
   }
    
    
    private void etiquetaTelefono() {
        jLTelefono = new JLabel ( "Teléfono:" );
        jLTelefono.setBounds ( 150, 40, 110, 20 );
        jLTelefono.setForeground(Color.BLACK);
        jLTelefono.setFont(new Font("Tahoma", Font.PLAIN, 13));
        contenedor.add ( jLTelefono );
    }
    private void campoTelefono() {
        jTTelefono = new JTextField ( 20 );
        jTTelefono.setBounds ( 210, 40, 100, 20 );
        jTTelefono.setForeground(Color.BLACK);
        jTTelefono.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jTTelefono.setEnabled ( true );
        contenedor.add(jTTelefono);
   }
    
    
    private void etiquetaCategoria() {
        jLCategoria = new JLabel ( "Categoria:" );
        jLCategoria.setBounds ( 15, 70, 100, 20 );
        jLCategoria.setForeground(Color.BLACK);
        jLCategoria.setFont(new Font("Tahoma", Font.PLAIN, 13));
        contenedor.add ( jLCategoria );
    }
    private void campoCategoria() {
        jCCategoria = new JComboBox();
        jCCategoria.addItem("Elige una opcion: ");
        jCCategoria.addItem("Principiante");
        jCCategoria.addItem("Intermedio");
        jCCategoria.addItem("Avanzado");
        jCCategoria.setForeground(Color.BLACK);
        jCCategoria.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jCCategoria.setBounds ( 15, 94, 130, 20 );
        jCCategoria.setEnabled ( true );
        contenedor.add(jCCategoria);
   }
    private void etiquetaPrecio() {
        jLPrecio = new JLabel ( "Precio: " );
        jLPrecio.setBounds ( 190, 70, 50, 20 );
        jLPrecio.setForeground(Color.BLACK);
        jLPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
        contenedor.add ( jLPrecio );
    }
    
    private void campoPrecio() {
        jCPrecio = new JComboBox();
        jCPrecio.addItem("Elige una opcion: ");
        jCPrecio.addItem("P: $399");
        jCPrecio.addItem("I: $560");
        jCPrecio.addItem("A: $799");
        jCPrecio.setForeground(Color.BLACK);
        jCPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jCPrecio.setBounds ( 190, 94, 160, 20 );
        jCPrecio.setEnabled ( true);
        contenedor.add(jCPrecio);
   }
    
    private void etiquetaHorario() {
        jLHorario = new JLabel ( "Horario " );
        jLHorario.setForeground(Color.BLACK);
        jLHorario.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jLHorario.setBounds ( 15, 120, 110, 20 );
        contenedor.add ( jLHorario );
    }
    
    private void etiquetaDia() {
        jLDia = new JLabel ( "Día:  " );
        jLDia.setForeground(Color.BLACK);
        jLDia.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jLDia.setBounds ( 15, 145, 70, 20 );
        contenedor.add ( jLDia );
    }
    private void campoDia() {
        jCDia = new JComboBox();
        jCDia.addItem("Elige una opción:  ");
        jCDia.addItem("Lunes, Martes y Miercoles");
        jCDia.addItem("Martes y Jueves");
        jCDia.addItem("Sabado y Domingo");
        jCDia.setForeground(Color.BLACK);
        jCDia.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jCDia.setBounds ( 15, 168, 160, 20 );
        jCDia.setEnabled ( true);
        contenedor.add(jCDia);
   }
    
    private void etiquetaHora() {
        jLHora = new JLabel ( "Hora: " );
        jLHora.setForeground(Color.BLACK);
        jLHora.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jLHora.setBounds ( 230, 145, 70, 20 );
        contenedor.add ( jLHora );
    }
    private void campoHora() {
        jCHora = new JComboBox();
        jCHora.addItem("Elige una opción: ");
        jCHora.addItem("12:00 a 16:00");
        jCHora.addItem("11:00 a 14:00");
        jCHora.addItem("15:00 a 18:00");
        jCHora.setForeground(Color.BLACK);
        jCHora.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jCHora.setBounds ( 230, 168, 100, 20 );
        jCHora.setEnabled ( true);
        contenedor.add(jCHora);
   }
    
    private void etiquetaProfesor() {
        jLProfesor = new JLabel ( "Profesor:" );
        jLProfesor.setForeground(Color.BLACK);
        jLProfesor.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jLProfesor.setBounds ( 15, 204, 110, 20 );
        contenedor.add ( jLProfesor );
    }
    private void campoProfesor() {
        jCProfesor = new JComboBox();
        jCProfesor.addItem("Elige una opcion: ");
        jCProfesor.addItem("Luis Mauricio Reyes Martinez");
        jCProfesor.addItem("Javier Lopez Hernandez");
        jCProfesor.addItem("Alejandra Velazquez Quiroga");
        jCProfesor.setForeground(Color.BLACK);
        jCProfesor.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jCProfesor.setBounds ( 80, 204, 175, 20 );
        jCProfesor.setEnabled ( true );
        contenedor.add(jCProfesor);
   }
    
     private void botonCancelar(){
        bCancelar = new JButton();
        bCancelar.setText ( "Cancelar" );
        bCancelar.setBounds ( 20, 250, 100, 30 );
        bCancelar.setBackground(cancelar);
        bCancelar.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 12));
        bCancelar.setForeground(Color.BLACK);
        bCancelar.addActionListener((ActionEvent evt) -> {
            dispose(); // Cierra la ventana
        });  
        contenedor.add(bCancelar);
    
    }
     
    
    private void botonAlmacenar(){
        bAlmacenar = new JButton();
        bAlmacenar.setText ( "Almacenar" );
        bAlmacenar.setBounds ( 135, 250, 100, 30 );
        bAlmacenar.setBackground(almacenar);
        bAlmacenar.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 12));
        bAlmacenar.setForeground(Color.BLACK);
        bAlmacenar.setMnemonic ( 'A' );
        bAlmacenar.addActionListener((ActionEvent evt) -> {
             bAlmacenar.setEnabled(true);
            try{
               
                bCancelar.setEnabled(true);
                
                String xmlFilePath = "C:\\Users\\Toshiba\\Desktop\\Trimestre 23 - Invierno\\Integracion de sistemas\\Proyecto\\ProyectoIS\\src\\proyectois\\sistema.xml";
                String xsdFilePath = "C:\\Users\\Toshiba\\Desktop\\Trimestre 23 - Invierno\\Integracion de sistemas\\Proyecto\\ProyectoIS\\src\\proyectois\\sistemas.xsd";
                
                // Validar el archivo XML con el esquema XSD
                Validacion xmlValidar = new Validacion();
                boolean isValid = xmlValidar.validarXML(xmlFilePath, xsdFilePath);
                
                if (isValid) {
                    JOptionPane.showMessageDialog(null, "El XML es valido segun el esquema XSD ", "Atencion", JOptionPane.INFORMATION_MESSAGE );
                    
                } else {
                    
                    JOptionPane.showMessageDialog(null, "El XML no es valido segun el esquema XSD ", "Error", JOptionPane.ERROR_MESSAGE );
                    
                }
                
                // Agregar datos al archivo XML
                AgregarInfo dataAdder = new AgregarInfo();
                dataAdder.agregarInfo(xmlFilePath, jTNombre.getText(),jSEdad.getValue().toString(), jTTelefono.getText() , jCCategoria.getSelectedItem().toString(), jCPrecio.getSelectedItem().toString(), jCDia.getSelectedItem().toString(), jCHora.getSelectedItem().toString(), jCProfesor.getSelectedItem().toString()  );
                
                
            }catch (HeadlessException e){
                JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE );
            }
        }); 
        contenedor.add(bAlmacenar);
    
    }
    
    private void botonLimpiar() {
        bLimpiar = new JButton("Limpiar");
        bLimpiar.setBounds(250, 250, 80, 30);
        bLimpiar.setBackground(limpiar);
        bLimpiar.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 12));
         bLimpiar.setForeground(Color.BLACK);
        bLimpiar.addActionListener((ActionEvent e) -> {
            limpiarCampos();
        });
        contenedor.add(bLimpiar);
    }

    private void limpiarCampos() {
        jTNombre.setText("");
        jSEdad.setValue(0);
        jTTelefono.setText("");
        jCCategoria.setSelectedIndex(0);
        jCPrecio.setSelectedIndex(0);
        jCDia.setSelectedIndex(0);
        jCHora.setSelectedIndex(0);
        jCProfesor.setSelectedIndex(0);
    }
 
}

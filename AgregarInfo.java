/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectois;

import java.io.IOException;
import javax.swing.JOptionPane;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

public class AgregarInfo {
    private static int clienteID = 1200;

    public void agregarInfo(String xmlFilePath, String nombre, String edad, String numero, String categoria, String precio, String dias, String horas, String profesor) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlFilePath);

            // Obtener el elemento raíz del XML
            Element sistema = doc.getDocumentElement();

            // Obtener el elemento "clientes" dentro del elemento raíz
            Element clientes = (Element) sistema.getElementsByTagName("clientes").item(0);
            
            Element nuevoCliente = doc.createElement("cliente");
            
             // Asignar el atributo ID automáticamente
            nuevoCliente.setAttribute("id", String.valueOf(clienteID));
            clienteID++; // Incrementar el contador de ID para el próximo cliente


            // Crear el nuevo elemento y sus nodos hijos
            
            Element nuevoNombre = doc.createElement("nombrecompleto");
            nuevoNombre.setTextContent(nombre);
            Element nuevaEdad = doc.createElement("edad");
            nuevaEdad.setTextContent(edad);
            Element nuevoNumero = doc.createElement("numero");
            nuevoNumero.setTextContent(numero);
            Element nuevaCategoria = doc.createElement("categoria");
            nuevaCategoria.setTextContent(categoria);
            Element nuevoPrecio = doc.createElement("precio");
            nuevoPrecio.setTextContent(precio);
            Element nuevoDia = doc.createElement("dias");
            nuevoDia.setTextContent(dias);
            Element nuevaHora = doc.createElement("horas");
            nuevaHora.setTextContent(horas);
            Element nuevoProfesor = doc.createElement("profesor");
            nuevoProfesor.setTextContent(profesor);

            // Agregar los nodos hijos al nuevo elemento
            nuevoCliente.appendChild(nuevoNombre);
            nuevoCliente.appendChild(nuevaEdad);
            nuevoCliente.appendChild(nuevoNumero);
            nuevoCliente.appendChild(nuevaCategoria);
            nuevoCliente.appendChild(nuevoPrecio);
            nuevoCliente.appendChild(nuevoDia);
            nuevoCliente.appendChild(nuevaHora);
            nuevoCliente.appendChild(nuevoProfesor);

            // Agregar el nuevo elemento "cliente" al elemento "clientes"
            clientes.appendChild(nuevoCliente);

            // Guardar los cambios en el archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(xmlFilePath);
            transformer.transform(source, result);

            
            JOptionPane.showMessageDialog(null, "Tus datos fueron agregados al archivo XML exitosamente \nTu FOLIO es: " + clienteID, "Atencion", JOptionPane.INFORMATION_MESSAGE );
            
            
        } catch (IOException | IllegalArgumentException | ParserConfigurationException | TransformerException | DOMException | SAXException e) {
            JOptionPane.showMessageDialog(null, "Tus datos no fueron agregados al archivo XML ", "ERROR", JOptionPane.ERROR_MESSAGE );
        
        }
    }
}

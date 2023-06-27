/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectois;

import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import org.xml.sax.SAXException;


public class Eliminar{
    
    public void eliminarId(String filePath, String id) {
        SwingUtilities.invokeLater(() -> {
           eliminarDatos(filePath, id);
        });
    }
    
    private void eliminarDatos(String filePath, String id) {
        try {
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(filePath);

            // Obtener el elemento con el ID especificado
            NodeList nodeList = doc.getElementsByTagName("cliente");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                String elementID = element.getAttribute("id");
                if (elementID.equals(id)) {
                    // Eliminar el elemento
                    Node parent = element.getParentNode();
                    parent.removeChild(element);
                    break; // Detener el bucle una vez que se elimina el elemento
                }
            }

            // Guardar los cambios en el archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(filePath);
            transformer.transform(source, result);
            

            JOptionPane.showMessageDialog(null, "Tus datos fueron eliminados exitosamente", "Atencion", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (IOException | ParserConfigurationException | TransformerException | DOMException | SAXException e) {
           
            JOptionPane.showMessageDialog(null, "ERROR: al eliminar los datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
 
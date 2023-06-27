/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectois;

import java.io.IOException;
import javax.swing.*;
import javax.swing.table.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class Buscar extends JFrame{
    
    private JTable table;

    public void imprimir(String filePath, String id) {
        SwingUtilities.invokeLater(() -> {
           mostrarCrear(filePath, id);
        });
    }

    private void mostrarCrear(String filePath, String id) {
        setTitle("Información de Inscripción");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 300);
        setLocationRelativeTo ( null );
        setResizable ( true );

        JPanel panel = new JPanel();
        panel.setLayout(new java.awt.BorderLayout());

        DefaultTableModel tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, java.awt.BorderLayout.CENTER);
        
        // Obtener los datos del XML y agregarlos a la tabla
        mostrarTabla(tableModel, filePath, id);

        getContentPane().add(panel);
        pack();
        setVisible(true);
    }

    private void mostrarTabla(DefaultTableModel tableModel, String filePath, String id) {
        try {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(filePath);

        // Obtener la lista de elementos
        NodeList nodeList = document.getElementsByTagName("cliente");

        // Obtener los nombres de las columnas de la tabla
        Element firstElement = (Element) nodeList.item(0);
        NodeList children = firstElement.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            if (children.item(i).getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                Element childElement = (Element) children.item(i);
                String columnName = childElement.getTagName();
                tableModel.addColumn(columnName);
            }
        }

        boolean encontrado = false;
        // Buscar el elemento por el ID y agregar los datos a la tabla
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            String elementID = element.getAttribute("id");
            if (elementID.equals(id)) {
                encontrado = true;
                Object[] rowData = new Object[tableModel.getColumnCount()];
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
                    String columnName = tableModel.getColumnName(j);
                    String cellValue = element.getElementsByTagName(columnName).item(0).getTextContent();
                    rowData[j] = cellValue;
                }
                 
                tableModel.addRow(rowData);
                break; // Detener el bucle si se encuentra el elemento buscado
            }
        }
        
        if (!encontrado) {
            // Realizar alguna acción si el ID no se encuentra, como mostrar un mensaje al usuario
            JOptionPane.showMessageDialog(this, "Su ID no tiene una Inscripcion a esta Academia ", "Atencion", JOptionPane.INFORMATION_MESSAGE );
            SwingUtilities.invokeLater(() -> {
                    setVisible(false);
                    dispose();
                });
        }
        
            TableColumn column;
            for (int i = 0; i < tableModel.getColumnCount(); i++) {
            column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(150); // Establecer el ancho deseado aquí
            }
        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
            e.printStackTrace();
        }
    } 
} 
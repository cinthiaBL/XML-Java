/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectois;


import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import org.xml.sax.*;

public class Validacion {
    
    public boolean validarXML(String xmlFilePath, String xsdFilePath) {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new StreamSource(xsdFilePath));
            Validator validator = schema.newValidator();

            // Personalizar el ErrorHandler para mostrar los errores de validación
            CustomErrorHandler errorHandler = new CustomErrorHandler();
            validator.setErrorHandler(errorHandler);

            Source source = new StreamSource(xmlFilePath);
            validator.validate(source);

            return !errorHandler.hasErrors();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static class CustomErrorHandler implements ErrorHandler {
        private boolean hasErrors = false;

        public boolean hasErrors() {
            return hasErrors;
        }

        @Override
        public void warning(SAXParseException exception) throws SAXException {
            System.out.println("Advertencia: " + exception.getMessage());
        }

        @Override
        public void error(SAXParseException exception) throws SAXException {
            hasErrors = true;
            System.out.println("Error: " + exception.getMessage());
        }

        @Override
        public void fatalError(SAXParseException exception) throws SAXException {
            hasErrors = true;
            System.out.println("Error fatal: " + exception.getMessage());
        }
    }
}


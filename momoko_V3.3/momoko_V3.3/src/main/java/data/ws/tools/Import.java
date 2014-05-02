
package data.ws.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

public class Import<T> {

	/**
	* @author Christophe de Batz - christophe@debatz.fr
	* @return list that are contained in the XML configuration
	*/
    public static <T> List<T> entitiesFromXML(Class<T> entityClass, String xmlLocation) {
        try {
            JAXBContext jc;
            synchronized (JAXBContext.class) {
                jc = JAXBContext.newInstance(Wrapper.class, entityClass);
            }
            
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                    Import.class.getClassLoader().getResourceAsStream(xmlLocation)));

            Wrapper<T> wrapper = (Wrapper<T>) unmarshaller.unmarshal(
                    new StreamSource(br),
                    Wrapper.class
            ).getValue();

            return wrapper.getItems();

        } catch (JAXBException ex) {
            Logger.getLogger(Import.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
	* @author Christophe de Batz - christophe@debatz.fr
	* @return item that are contained in the XML configuration
	*/
    public static <T> T entityFromXML(Class<T> entityClass, String xmlLocation) {
        try {
            JAXBContext jc;
            synchronized (JAXBContext.class) {
                jc = JAXBContext.newInstance(entityClass);
            }
            
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            
             File file = new File(System.getProperty("user.dir") + "/" + xmlLocation);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                    try (BufferedWriter output = new BufferedWriter(new FileWriter(file, true))) {
                        output.write(
                                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                                    "<config>\n" +
                                    "    <pageSize>10</pageSize>\n" +
                                    "    <paramSeparator>,</paramSeparator>\n" +
                                    "    <linkPreviousName>prev</linkPreviousName>\n" +
                                    "    <linkNextName>next</linkNextName>\n" +
                                    "</config>\n" +
                                    "");
                        output.flush();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Import.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                    new FileInputStream(file)));
            
            T entity = (T) unmarshaller.unmarshal(new StreamSource(br));
            
            return entity;
        } catch (JAXBException | FileNotFoundException ex) {
            Logger.getLogger(Import.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

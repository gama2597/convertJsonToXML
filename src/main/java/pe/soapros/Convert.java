package pe.soapros;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

import java.io.*;

public class Convert {

    public String convertJsonToXML(File archivo) {

        String xml = "";
        ObjectMapper jsonMapper = new ObjectMapper();

        try {
            JsonNode node = jsonMapper.readValue(archivo, JsonNode.class);
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
            xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_1_1, true);
            StringWriter sw = new StringWriter();
            xmlMapper.writeValue(sw, node);
            xml = sw.toString().replace("<ObjectNode>", "").replace("</ObjectNode>","");

        } catch (IOException e) {
            return e.getMessage();
        }

        return xml;
    }

    public void generateXML(String archivo, String path){
        try{

            File fileInput = new File(archivo);

            String content = convertJsonToXML(fileInput);

            String fullPath = path + "input.xml";

            File file = new File(fullPath);

            if (!file.exists()){
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();

            System.out.println("Archivo generado: " + fullPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

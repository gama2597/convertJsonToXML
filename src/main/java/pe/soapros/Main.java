package pe.soapros;

public class Main {
    public static void main(String[] args) {

        Convert convert = new Convert();

        convert.generateXML(args[0], args[1]);
        //convert.generateXML("C:\\GABRIEL\\PROYECTOS\\ProyectoSunat\\Migración_CS16\\Recursos\\Inputs_GWS\\200001.json","C:\\GABRIEL\\PROYECTOS\\ProyectoSunat\\Migración_CS16\\Recursos\\Inputs_GWS\\");

    }
}
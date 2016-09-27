import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.Scanner;
import java.util.*;

/**
 * Clase principal,
 * @author Eric Mendoza 15002
 * @author Jonnathan Juarez 15377
 * @since 21/09/2016
 * @version 1.0
 */

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner ingreso = new Scanner(System.in);
        ArrayList<String> diccionario;
        diccionario = new ArrayList<String>();

        System.out.println("Bienvenido!\nSeleccione el archivo .TXT que contiene el Diccionario\n(presiona ENTER para continuar)");
        ingreso.nextLine();
        /*
         codigo tomado de :
         http://stackoverflow.com/questions/7494478/jfilechooser-from-a-command-line-program-and-popping-up-underneath-all-windows
         */
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("./src"));
        chooser.setDialogTitle("Seleccione su archivo");
        chooser.setFileFilter(new FileNameExtensionFilter("Text files (.txt)", "txt"));
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {

            try {
						/*Lee el archivo y obtiene la cadena*/
                FileInputStream fstream = new FileInputStream(chooser.getSelectedFile().getAbsolutePath());
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

                String strLine;
                while ((strLine = br.readLine()) != null) {
                    diccionario.add(strLine); //agregar cada linea al diccionario
                }

                /* Separar cadenas y hacer asociacion */
                for (int i = 0; i < diccionario.size(); i++) {
                    String temp = diccionario.get(i).substring(1, diccionario.get(i).length() - 1);
                    String[] partes = temp.split(", ");
                }
            } catch (Exception e) {
                System.out.println("Archivo no valido!!!");
            }
        }
    }
}
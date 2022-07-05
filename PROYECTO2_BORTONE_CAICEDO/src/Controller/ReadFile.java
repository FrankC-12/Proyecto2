/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import main.Summary;

/**
 *
 * @author giubo
 */
public class ReadFile {

    public Summary readFile() {
        String line;
        String data = "";
        String autors = "";
        String tittle = "";
        boolean body = false;
        boolean writers = false;
        boolean titulo = true;

        try {

            JFileChooser file = new JFileChooser();
            file.showOpenDialog(null);
            File abre = file.getSelectedFile();

            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader br = new BufferedReader(archivos);
                while ((line = br.readLine()) != null) {
                    if (!line.isEmpty()) {

                        if (line.equalsIgnoreCase("Autores")) {
                            writers = true;
                            titulo = false;

                        } else if (line.equalsIgnoreCase("Resumen")) {
                            body = true;
                            writers = false;

                        }

                        if (titulo == true) {
                            tittle += line + "\n";
                        }

                        if (writers == true) {
                            autors += line + "\n";

                        }

                        if (body == true) {
                            data += line + "\n";
                        }

                    }
                }

                if ((!"".equals(autors)) && (!"".equals(data))) {
                    String[] split_autores = autors.split("Autores");
                    String[] split_autores_final = split_autores[1].split("\n");
                    String[] split_data = data.split("Palabras claves:");
                    String[] split_data_final = split_data[0].split("Resumen");
                    String[] split_key_words = split_data[1].split(",");

                    try {
                        Summary resumen = new Summary(tittle, split_autores_final, split_data_final[1], split_key_words);
                        return resumen;
                       

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error al guardar los datos ");
                    }
                }

                br.close();

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al leer el txt" + e);
        }
        return null;
    }

}

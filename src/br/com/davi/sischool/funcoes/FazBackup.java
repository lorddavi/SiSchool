/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.funcoes;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;
import javax.swing.JOptionPane;

/**
 *
 * @author Davi
 */
public class FazBackup {

    public FazBackup() {
    }
    
    public void backup() {
        try {
            /*NOTE: Used to create a cmd command*/
            String executeCmd = "cmd.exe /c \"C:\\Users\\Davi\\Downloads\\Eduvale\\TCC\\SiSchool\\Arquivos\\backup\\mysqldump --opt --flush-logs --triggers --port=3306 " +
                    "--user=root --password= --result-file=C:\\Users\\Davi\\Downloads\\Eduvale\\TCC\\SiSchool\\Arquivos\\backup\\backup.sql --databases sischoolbd\"";

            /*NOTE: Executing the command here*/
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
            if (processComplete == 0) {
                System.out.println("Backup Completo");
                JOptionPane.showMessageDialog(null, "Backup realizado com sucesso!");
            } else {
                System.out.println("Falha no backup");
            }
        } catch (IOException | InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Erro no backup. " + ex.getMessage());
        }
    }
    
    public void restaurar() {
        try {
            String executeCmd = "cmd.exe /c C:\\Users\\Davi\\Downloads\\Eduvale\\TCC\\SiSchool\\Arquivos\\backup\\mysql -u root sischoolbd" +
                        " < C:\\Users\\Davi\\Downloads\\Eduvale\\TCC\\SiSchool\\Arquivos\\backup\\backup.sql";

            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
            if (processComplete == 0) {
                JOptionPane.showMessageDialog(null, "Restaurado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao restaurar!");
            }


        } catch (IOException | InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao restaurar: " + ex.getMessage());
        }

    }
    
}

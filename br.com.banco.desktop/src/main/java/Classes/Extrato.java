/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.swing.JOptionPane;

/**
 *
 * @author fabio
 */
@Entity
@Table(name = "extrato")
@SequenceGenerator(name = "seqExtrato", sequenceName = "seq_extrato")
public class Extrato implements Serializable{
    private static final long serialVersionUID = -2L;
    

    @Id @GeneratedValue
    private Long ID;

    public Extrato() {

    }

    public String retiraExtrato(String conta) {
        String dados = "";
        Conta c = new Conta();
        File arquivos[];
        File dir = new File("C:\\Users\\FábioJunior\\Documents\\Contas\\" + conta.trim() + "\\Extrato\\");
        arquivos = dir.listFiles();

        for (File arquivo : arquivos) {
            try {
                FileReader fr = new FileReader("C:\\Users\\FábioJunior\\Documents\\Contas\\" + conta + "\\Extrato\\"
                        + arquivo.getName().trim());
                BufferedReader br = new BufferedReader(fr);
                String linha = br.readLine();
                while (linha != null) {
                    dados += linha + "\n";
                    linha = br.readLine();
                }

            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "nao deu bom");
                return null;
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "deu merda");
                return null;
            }

        }

        return dados;
    }

    public void gravaLog(String conta, String dados) {
        Calendar c = Calendar.getInstance();
        int mes;
        mes = c.get(Calendar.MONTH) + 1;
        String data = "" + c.get(Calendar.DAY_OF_MONTH) + "." + mes + "." + c.get(Calendar.YEAR);
        String file = "C:\\Users\\FábioJunior\\Documents\\Contas\\" + conta.trim() + "\\Extrato\\" + data + ".txt";
        try {
            FileWriter fw = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fw);
            c.getInstance().getTime();
            pw.write(c.getTime().toString() + "\n");
            pw.write(dados);
            pw.close();
        } catch (IOException e) {

        }
    }

    public Date converteData(String data) {
        try {
            String dta = data;
            dta = dta.replace("/", "/");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dt = sdf.parse(dta);
            return dt;
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Data inválida!");
            return null;
        }

    }

    public String extratoPeriodo(String conta, String inicio, String fim) {
        File arquivos[];
        File dir = new File("C:\\Users\\FábioJunior\\Documents\\Contas\\" + conta.trim() + "\\Extrato\\");
        arquivos = dir.listFiles();
        String dados = "";
        Date data;
        Date data2 = converteData(fim);

        for (File arquivo : arquivos) {
            //JOptionPane.showMessageDialog(null, arquivo.getName());
            data = converteData(arquivo.getName());
            if (converteData(arquivo.getName()).after(converteData(inicio))
                    && converteData(arquivo.getName()).before(converteData(fim))) {
                //JOptionPane.showMessageDialog(null, "Achou Algo");

                try {

                    FileReader fr = new FileReader("C:\\Users\\FábioJunior\\Documents\\Contas\\" + conta + "\\Extrato\\"
                            + arquivo.getName().trim());
                    BufferedReader br = new BufferedReader(fr);
                    String linha = br.readLine();
                    while (linha != null) {
                        dados += linha + "\n";
                        linha = br.readLine();
                    }

                } catch (FileNotFoundException e) {
                    JOptionPane.showMessageDialog(null, "nao deu bom");
                    return null;
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "deu merda");
                    return null;
                } catch(NullPointerException e) {
                    
                }

            }

        }
        return dados;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

}

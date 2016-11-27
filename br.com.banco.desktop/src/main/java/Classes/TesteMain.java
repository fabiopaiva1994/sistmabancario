/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import javax.swing.JOptionPane;
import org.hibernate.Session;
import Hibernate.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 *
 * @author FábioJunior
 */
public class TesteMain {

    public static void main(String[] args) {
        //Session sessao = null;
        //sessao = HibernateUtil.getSessionFactory().openSession();
        Transacao ex = new Transacao();
        ContaCorrenteComum ccc = new ContaCorrenteComum();
        Date date = ex.converteData("23/02/1994");
        Endereco endereco = new Endereco("rua", "50", "complemento", "bairro", "cidade", "estado", "pais", "cep");
        List<Transacao> tr = null;

        Cliente cli = new Cliente("Fabio", "", "", "lefone", date, 20, endereco);
        ContaPoupanca cp = new ContaPoupanca();//(date, "159159", "001", 50, "Poupança", "123", "email", 500, true, cli, tr);
        ClasseDAO cd = new ClasseDAO();
        /*try {
            if(ContaPoupanca)cd.procuraConta(cp, "153", "001") == null) {*/
        //cd.cadastrar(cp);
        /*}
        } catch (TransactionException e) {

        }*/
        //cp = cd.procuraCp("159159");
        //cp.deposita("159159", "001", 5000, "96021424");
        //cp = (ContaPoupanca) cd.procuraConta(cp, "159159", "001");
        //cp = (ContaPoupanca) cd.procuraCp("159159");
        //cp.deposita("159159", "001", 213, "96021424");
        //cp.retirada(cp, 10000);
        //cp = (ContaPoupanca) cd.procuraCp("159159");
        ContaCorrenteComum cccp = new ContaCorrenteComum();
        cccp = (ContaCorrenteComum) cd.procuraConta(cccp, "456456", "001");
        //JOptionPane.showMessageDialog(null, cp.toString());
        
         ArrayList<Transacao> tt = new ArrayList<>();
        /*for (int i = 0; i <= cp.getExtrato().size(); i++ ) {           
            tt.add(cp.getExtrato().get(i));
            i ++;
        }
        Transacao tx = new Transacao();
        int i = 0;
        String data = "27/11/16";
        /*while(tt.get(i).getData().after(tx.converteData(data))) {
            JOptionPane.showMessageDialog(null, tt.get(i));
            i ++;
        }*/

        JOptionPane.showMessageDialog(null, cccp.getExtrato());
        //sessao.close();
        System.exit(1);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import javax.swing.JOptionPane;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import Hibernate.*;
import java.util.Date;

/**
 *
 * @author FábioJunior
 */
public class TesteMain {
    public static void main(String []args) {
        Session sessao = null;
        sessao = HibernateUtil.getSessionFactory().openSession();
        Extrato ex = new Extrato();
        
        Date date = ex.converteData("23/02/1994");
        Endereco endereco = new Endereco("rua", "50", "complemento", "bairro", "cidade", "estado", "pais", "cep");
        Cliente cli = new Cliente("Fabio", "", "", "lefone",date , 20, endereco);
        ContaPoupanca cp = new ContaPoupanca(date, "159159", "001", 50, "Poupança", "123", "email", 500, true, cli);
        ClasseDAO cd = new ClasseDAO();
        cd.cadastrar(cp);
        
        
        JOptionPane.showMessageDialog(null, "Conectou");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Hibernate.ClasseDAO;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.swing.JOptionPane;

/**
 *
 * @author fabio
 */
@Entity
@Table(name = "extrato")
@SequenceGenerator(name = "seqExtrato", sequenceName = "seq_extrato")
public class Transacao implements Serializable {

    private static final long serialVersionUID = -2L;
    @Column(name = "dados", nullable = false)
    private String dados;
    @Column(name = "data", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    @Id
    @GeneratedValue
    private Long ID;

    public Transacao(String dados, Date data) {
        this.dados = dados;
        this.data = data;
    }

    public Transacao() {

    }

    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Object gravaExtrato(Object conta, String dados, String numero, String agencia, Date data) {
        ClasseDAO cd = new ClasseDAO();
        Transacao ex = new Transacao();
        Object obj = new Object();
        if (conta instanceof ContaPoupanca) {
            ex = new Transacao(dados, data);
            ContaPoupanca cp = new ContaPoupanca();
            cp = (ContaPoupanca) cd.procuraConta(conta, numero, agencia);
            cp.getExtrato().add(ex);
            obj = cp;
            //cd.atualizar(cp);
            return obj; 
        }
        return null;
    }

    public String toString() {
        String aux;
        return aux = this.dados + "\nData: " + this.data;
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
}

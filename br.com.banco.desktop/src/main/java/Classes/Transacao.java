/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Hibernate.ClasseDAO;
import Interface.TelaExtrato;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        } else if (conta instanceof ContaCorrenteComum) {
            ex = new Transacao(dados, data);
            ContaCorrenteComum ccc = new ContaCorrenteComum();
            ccc = (ContaCorrenteComum) cd.procuraConta(conta, numero, agencia);
            ccc.getExtrato().add(ex);
            obj = ccc;
            return obj;
        } else if (conta instanceof ContaCorrenteLimitada) {
            ex = new Transacao(dados, data);
            ContaCorrenteLimitada ccl = new ContaCorrenteLimitada();
            ccl = (ContaCorrenteLimitada) cd.procuraConta(conta, numero, agencia);
            ccl.getExtrato().add(ex);
            obj = ccl;
            return obj;
        }
        return null;
    }

    @Override
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

    public ArrayList<Transacao> extratoPeriodo(Object cliente) {
        Transacao ex = new Transacao();
        ClasseDAO cd = new ClasseDAO();
        ArrayList<Transacao> ext = new ArrayList<>();
        if (cliente instanceof ContaPoupanca) {
            ContaPoupanca cp = new ContaPoupanca();
            cp = (ContaPoupanca) cliente;
            cp = (ContaPoupanca) cd.procuraConta(cliente, cp.getNumero(), cp.getAgencia());

            for (int i = 0; i <= cp.getExtrato().size() - 1; i++) {
                ext.add(cp.getExtrato().get(i));

            }
            return ext;
        }
        if (cliente instanceof ContaCorrenteComum) {
            ContaCorrenteComum ccc = new ContaCorrenteComum();
            ccc = (ContaCorrenteComum) cliente;
            ccc = (ContaCorrenteComum) cd.procuraConta(cliente, ccc.getNumero(), ccc.getAgencia());

            for (int i = 0; i <= ccc.getExtrato().size() - 1; i++) {
                ext.add(ccc.getExtrato().get(i));

            }
            return ext;
        }
        if (cliente instanceof ContaCorrenteLimitada) {
            ContaCorrenteLimitada ccl = new ContaCorrenteLimitada();
            ccl = (ContaCorrenteLimitada) cliente;
            ccl = (ContaCorrenteLimitada) cd.procuraConta(cliente, ccl.getNumero(), ccl.getAgencia());
            for (int i = 0; i <= ccl.getExtrato().size() - 1; i++) {
                ext.add(ccl.getExtrato().get(i));

            }
            return ext;
        }
        return ext;
    }

    public String imprimeExtratoPeriodo(Object cliente, Date ini, Date fim) {
        Transacao ex = new Transacao();
        ClasseDAO cd = new ClasseDAO();
        ArrayList<Transacao> ext = new ArrayList<>();
        if (cliente instanceof ContaPoupanca) {
            ContaPoupanca cp = new ContaPoupanca();
            cp = (ContaPoupanca) cliente;
            cp = (ContaPoupanca) cd.procuraConta(cliente, cp.getNumero(), cp.getAgencia());
            ext = ex.extratoPeriodo(cp);
            String dados = "";
            try {
                for (int i = 0; i <= ext.size() - 1; i++) {
                    if (ext.get(i).getData().after(ini) && ext.get(i).getData().before(fim)) {
                        dados += ext.get(i) + "\n";
                    }
                }
                return dados;
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Houve um Erro ao Retirar o Extrato!!");
            }
        }
        if (cliente instanceof ContaCorrenteComum) {
            ContaCorrenteComum ccc = new ContaCorrenteComum();
            ccc = (ContaCorrenteComum) cliente;
            ccc = (ContaCorrenteComum) cd.procuraConta(cliente, ccc.getNumero(), ccc.getAgencia());
            ext = ex.extratoPeriodo(ccc);
            String dados = "";
            try {
                for (int i = 0; i <= ext.size() - 1; i++) {
                    if (ext.get(i).getData().after(ini) && ext.get(i).getData().before(fim)) {
                        dados += ext.get(i) + "\n";
                    }
                }
                return dados;
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Houve um Erro ao Retirar o Extrato!!");
            }
        }
        if (cliente instanceof ContaCorrenteLimitada) {
            ContaCorrenteLimitada ccl = new ContaCorrenteLimitada();
            ccl = (ContaCorrenteLimitada) cliente;
            ccl = (ContaCorrenteLimitada) cd.procuraConta(cliente, ccl.getNumero(), ccl.getAgencia());
            ext = ex.extratoPeriodo(ccl);
            String dados = "";
            try {
                for (int i = 0; i <= ext.size() - 1; i++) {
                    if (ext.get(i).getData().after(ini) && ext.get(i).getData().before(fim)) {
                        dados += ext.get(i) + "\n";
                    }
                }
                return dados;
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Houve um Erro ao Retirar o Extrato!!");
            }
        }
        return "";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Hibernate.ClasseDAO;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author FábioJunior
 */
@Entity
@Table(name = "contacorrentelimitada")
@SequenceGenerator(name = "seqccl", sequenceName = "seq_ccl") 
public class ContaCorrenteLimitada extends Conta implements Serializable{
    private static final long serialVersionUID = -2L;
    
    @Column(name = "limite", nullable = false)
    private double limite;
    
    public ContaCorrenteLimitada(double limite,String numero, String agencia, double saldo, String tipo,
            String senha, String email, double rendaMensal, boolean ativo, Cliente cliente, List<Transacao> tx) {
        super(numero, agencia, saldo, tipo, senha, email, rendaMensal, ativo, cliente, tx);
        this.limite = limite;
    }
    
    public ContaCorrenteLimitada() {
        
    }
    
    public void setLimite(double limite) {
        this.limite = limite;
    }
    
    public double getLimite() {
        return this.limite;
    }    
    
    @Override
    public String toString() {
        return super.toString() + "\n" + "Limite = " + this.limite;
    }
    
    public void deposita(String conta, String agencia, double valor, String telefone) {
        ClasseDAO cd = new ClasseDAO();
        Transacao ex = new Transacao();
        Calendar cl = Calendar.getInstance();
        int dia, mes, ano;
        
        mes = cl.get(Calendar.MONTH) + 1;
        dia = cl.get(Calendar.DAY_OF_MONTH);
        ano = cl.get(Calendar.YEAR);
        String dta = "" + dia + "/" + mes + "/" + ano;
        ContaCorrenteLimitada ccl = new ContaCorrenteLimitada();
        ccl = (ContaCorrenteLimitada)cd.procuraConta(ccl, conta, agencia);
        ccl.setSaldo(ccl.getSaldo() + valor);
        cd.modifica(ccl);
        String dados = "Valor depositado: " + valor + "\nTelefone: " + telefone;
        Date dt = ex.converteData(dta);
        ex.gravaExtrato(ccl, dados, conta, agencia, dt);
    }
    
    public static double converteDouble(String valor) {
        try {
            double v = Double.valueOf(valor);
            return v;
        }catch(NumberFormatException e) {
            return 0;
        }
    }
    
    public static int converteInt(String valor) {
        try {
            int v = Integer.valueOf(valor);
            return v;
        }catch(NumberFormatException e) {
            return 0;
        }
    }
}

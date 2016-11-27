/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Hibernate.ClasseDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author FábioJunior
 */
@Entity
@Table(name = "contapoupanca")
@SequenceGenerator(name = "seqpoupanca", sequenceName = "seq_poupanca")
public class ContaPoupanca extends Conta implements Serializable{
    private static final long serialVersionUID = -2L;
    
    @Column(name = "dtaCriacao", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtaCriacao;
    
    public ContaPoupanca(Date dtaCriacao, String numero, String agencia, double saldo, String tipo,
            String senha, String email, double rendaMensal, boolean ativo, Cliente cliente, List<Transacao> ex) {
            super(numero,agencia,saldo,tipo,senha,email,rendaMensal, ativo, cliente, ex);
            this.dtaCriacao = dtaCriacao;
    }
    
    public ContaPoupanca() {
        
    }
    
    public Date getDtaCriacao() {
        return this.dtaCriacao;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n" + "Data da Criação = " + this.dtaCriacao;
    }
    
   public void deposita(String conta, String agencia, double valor, String telefone) {
        ClasseDAO cd = new ClasseDAO();
        Transacao ex = new Transacao();
        Calendar cl = Calendar.getInstance();
        int dia, mes, ano;
        
        mes = cl.get(Calendar.MONTH) + 1;
        dia = cl.get(Calendar.DAY_OF_MONTH);
        ano = cl.get(Calendar.YEAR);
        double sal;
        String dta = "" + dia + "/" + mes + "/" + ano;
        ContaPoupanca cp = new ContaPoupanca();
        cp = cd.procuraCp("159159");
        sal = cp.getSaldo() + valor;
        cp.setSaldo(sal);
        cd.atualizar(cp);
        String dados = "Valor depositado: " + valor + "\nTelefone: " + telefone;
        Date dt = ex.converteData(dta);
        cp = (ContaPoupanca) ex.gravaExtrato(cp, dados, conta, agencia, dt);
        cd.atualizar(cp);

   }
}

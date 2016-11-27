/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.Column;
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
@Table(name = "deposito")
@SequenceGenerator(name = "seqdeposito", sequenceName = "seq_deposito")

public class Deposito implements Serializable{
    private static final long serialVersionUID = -2L;
    
    @Id @GeneratedValue
    private long id;
    @Column(name = "conta", nullable = false)
    private Conta conta;
    @Column(name = "numeroConta", nullable = false)
    private String numeroConta;
    @Column(name = "numeroAgencia", nullable = false)
    private String numeroAgencia;
    @Column(name = "valor", nullable = false)
    private double valor;
    @Column(name = "telefone", nullable = false)
    private String telefone;

    public Deposito(String numeroConta, String numeroAgencia, double valor, String telefone) {
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.valor = valor;
        this.telefone = telefone;
    }

    public Deposito() {

    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void deposita(Deposito deposito, Object conta) {
        //Cliente cli = new Cliente();
        ContaCorrenteComum c1 = new ContaCorrenteComum();
        ContaCorrenteLimitada c2 = new ContaCorrenteLimitada();
        ContaPoupanca c3 = new ContaPoupanca();
        if (conta instanceof ContaCorrenteComum) {
            //c1 = c1.Leitura(deposito.getNumeroConta());
            if (c1.getAgencia().trim().equals(deposito.getNumeroAgencia())) {
                c1.setSaldo(c1.getSaldo() + getValor());
                salva(c1.getNumero(), c1);
            }
        } else if (conta instanceof ContaCorrenteLimitada) {
          //  c2 = c2.Leitura(deposito.getNumeroConta());
            if (c2.getAgencia().trim().equals(deposito.getNumeroAgencia())) {
                c2.setSaldo(c2.getSaldo() + this.valor);
                salva(c2.getNumero(), c2);
            }
        } else if (conta instanceof ContaPoupanca) {
            //c3 = c3.Leitura(deposito.getNumeroConta());
            if (c3.getAgencia().trim().equals(deposito.getNumeroAgencia())) {
                c3.setSaldo(c3.getSaldo() + this.valor);
                salva(c3.getNumero(), c3);
            }
        }

    }

    public void salva(String conta, Object obj) {
        try {
            FileWriter arq = new FileWriter("C:\\Users\\FábioJunior\\Documents\\Contas\\"
                    + conta + "/conta.txt/");
            BufferedWriter pw = new BufferedWriter(arq);
            pw.append(obj.toString());
            pw.close();
            JOptionPane.showMessageDialog(null, "Sucesso");
        } catch (IOException e) {

        }
    }

    public void alteraConta(Object conta) {
        if (conta instanceof ContaPoupanca) {
            ContaPoupanca cp = new ContaPoupanca();
            cp = (ContaPoupanca) conta;
            salva(cp.getNumero(), cp);
        } else if (conta instanceof ContaCorrenteComum) {
            ContaCorrenteComum cp = new ContaCorrenteComum();
            cp = (ContaCorrenteComum) conta;
            salva(cp.getNumero(), cp);
        } else if (conta instanceof ContaCorrenteLimitada) {
            ContaCorrenteLimitada cp = new ContaCorrenteLimitada();
            cp = (ContaCorrenteLimitada) conta;
            salva(cp.getNumero(), cp);
        }
    }
}

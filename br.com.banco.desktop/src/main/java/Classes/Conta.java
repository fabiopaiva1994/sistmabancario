/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 *
 * @author fabio
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "conta")
public class Conta implements Serializable {

    private static final long serialVersionUID = -2L;

    @Id
    @GeneratedValue
    private long id;
    @Column(name = "numero", nullable = false)
    private String numero;
    @Column(name = "agencia", nullable = false)
    private String agencia;
    @Column(name = "saldo", nullable = false)
    private double saldo;
    @Column(name = "tipo", nullable = false)
    private String tipo;
    @Column(name = "senha", nullable = false)
    private String senha;
    @Column(name = "email", nullable = true)
    private String email;
    @Column(name = "rendamensal", nullable = false)
    private double rendaMensal;
    @Column(name = "ativo", nullable = false)
    private boolean ativo;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Cliente_FK")
    private Cliente cli;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "extrato_fk")
    private List<Transacao> extrato;

    public Conta() {

    }

    public Conta(String numero, String agencia, double saldo, String tipo,
            String senha, String email, double rendaMensal, boolean ativo, Cliente cli, List<Transacao> transacao) {
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
        this.tipo = tipo;
        this.senha = senha;
        this.email = email;
        this.rendaMensal = rendaMensal;
        this.ativo = ativo;
        this.cli = cli;
        this.extrato = transacao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Transacao> getExtrato() {
        return extrato;
    }

    public void setExtrato(List<Transacao> extrato) {
        this.extrato = extrato;
    }

    public double getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(double rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        String aux = this.cli.toString() + "agencia = " + this.agencia + "\nnumero da conta = " + this.numero
                + "\ntipo = " + this.tipo + "\nsaldo = " + this.saldo + "\nsenha = " + this.senha
                + "\nemail = " + this.email + "\nRenda Mensal = " + this.rendaMensal + "\nAtivo = " + this.ativo;
        return aux;
    }

    public boolean criaPasta(String local, Object c) {

        try {
            String path = "C:\\Users\\FábioJunior\\Documents\\Contas\\" + local;
            boolean sucess = new java.io.File(path).mkdirs();
            if (!sucess) {
                JOptionPane.showMessageDialog(null, "Não Foi possivel criar a Conta", "", ERROR_MESSAGE);
                return false;
            }
            sucess = new java.io.File(path + "\\Extrato").mkdirs();
            if (!sucess) {
                JOptionPane.showMessageDialog(null, "Não foi possivel criar a Conta!");
                return false;
            }
            path = path += "/conta.txt";
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));

            buffWrite.append(c.toString());
            buffWrite.close();
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel Criar a Conta no momento", "", ERROR_MESSAGE);
        } catch (Exception e) {

        }
        return false;
    }

    public static void visualizarArquivos(String conta) {
        try {
            String diretorio = "C:\\Users\\FábioJunior\\Documents\\Contas\\";
            boolean encontrou = false;
            File file = new File(diretorio);
            for (File f : file.listFiles()) {
                if (f.getName().equals(conta)) {

                    JOptionPane.showMessageDialog(null, "Encontrado");
                    encontrou = true;
                    FileReader fr = new FileReader(f);
                    BufferedReader br = new BufferedReader(fr);
                    while (br.ready()) {
                        JOptionPane.showMessageDialog(null, br.readLine());
                    }

                }

            }
            if (!encontrou) {
                JOptionPane.showMessageDialog(null, "Conta não Encontrada!!", "", ERROR_MESSAGE);
            }
        } catch (IOException e) {
            //JOptionPane.showMessageDialog(null, "Houve um problema, contate o suporte ou tente novamente!");
        }
    }
}

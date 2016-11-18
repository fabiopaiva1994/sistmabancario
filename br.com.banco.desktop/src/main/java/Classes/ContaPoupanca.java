/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.StringTokenizer;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.swing.JOptionPane;

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
            String senha, String email, double rendaMensal, boolean ativo, Cliente cliente) {
            super(numero,agencia,saldo,tipo,senha,email,rendaMensal, ativo, cliente);
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
    
    public static ContaPoupanca Leitura(String conta) {
        String linha = null;

        String cs = "C:\\Users\\FábioJunior\\Documents\\Contas\\" + conta + "/conta.txt";

        try {

            FileReader reader = new FileReader(cs);

            BufferedReader leitor = new BufferedReader(reader);
            StringTokenizer st = null;

            String agencia = "";
            String numero = "";
            String tipo = "";
            String saldo = "";
            String senha = "";  
            String email = "";
            String nome = "";
            String rg = "";
            String cpf = "";
            String telefone = "";
            String rua = "";
            String bairro = "";
            String complemento = "";
            String numero2 = "";
            String cidade = "";
            String estado = "";
            String pais = "";
            String cep = "";
            String dataNasc = "";
            String idade = "";
            String a, b = "";
            String rendaMensal = "";
            String dtaCriacao = "";
            String ativo = "";

            //loop para pular linha
            while ((linha = leitor.readLine()) != null) {

                st = new StringTokenizer(linha, "=");

                String dados;

                while (st.hasMoreTokens()) {

                    dados = st.nextToken();
                    a = dados;

                    dados = st.nextToken();
                    b = dados;

                    if (a.equals("agencia ")) {
                        agencia = b.trim();
                    } else if (a.equals("numero da conta ")) {
                        numero = b.trim();
                    } else if (a.equals("tipo ")) {
                        tipo = b.trim();
                    } else if (a.equals("saldo ")) {
                        saldo = b.trim();
                    } else if (a.equals("senha ")) {
                        senha = b.trim();
                    } else if (a.equals("email ")) {
                        email = b.trim();
                    } else if (a.equals("nome ")) {
                        nome = b.trim();
                    } else if (a.equals("rg ")) {
                        rg = b.trim();
                    } else if (a.equals("cpf ")) {
                        cpf = b.trim();
                    } else if (a.equals("telefone ")) {
                        telefone = b.trim();
                    } else if (a.equals("rua ")) {
                        rua = b.trim();
                    } else if (a.equals("bairro ")) {
                        bairro = b.trim();
                    } else if (a.equals("complemento ")) {
                        complemento = b.trim();
                    } else if (a.equals("numero ")) {
                        numero2 = b.trim();
                    } else if (a.equals("cidade ")) {
                        cidade = b.trim();
                    } else if (a.equals("estado ")) {
                        estado = b.trim();
                    } else if (a.equals("pais ")) {
                        pais = b.trim();
                    } else if (a.equals("cep ")) {
                        cep = b.trim();
                    } else if (a.equals("Data de Nascimento ")) {
                        dataNasc = b.trim();
                    } else if (a.equals("Idade ")) {
                        idade = b.trim();
                    } else if (a.equals("Renda Mensal ")) {
                        rendaMensal = b.trim();
                    }else if(a.equals("Data da Criação ")) {
                        dtaCriacao = b.trim();
                    }else if(a.equals("Ativo ")) {
                        ativo = b.trim();
                    }

                }
            }

            leitor.close();
            reader.close();
            Extrato ex = new Extrato();
            Date d = ex.converteData(dataNasc);
            
            
            Endereco end = new Endereco(rua, numero2, complemento, bairro, cidade, estado, pais, cep);
            Cliente cli = new Cliente( nome, rg, cpf, telefone, d, ContaCorrenteLimitada.converteInt(idade), end);
            d = ex.converteData(dtaCriacao);
            ContaPoupanca c = new ContaPoupanca(d,numero, agencia, ContaCorrenteLimitada.converteDouble(saldo), tipo, senha,
                    email, ContaCorrenteLimitada.converteDouble(rendaMensal), ContaCorrenteComum.verificaAtivo(ativo), cli);
            
            

            return c;
        }catch(FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Deu Ruim!");
            e.printStackTrace();
        }catch(IOException e) {
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

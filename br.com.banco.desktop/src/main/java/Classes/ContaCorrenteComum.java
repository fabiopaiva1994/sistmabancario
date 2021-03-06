/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Classes.Cliente;
import Classes.Endereco;
import Hibernate.ClasseDAO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import javafx.scene.chart.PieChart.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import org.hibernate.engine.jdbc.spi.ExtractedDatabaseMetaData;

/**
 *
 * @author FábioJunior
 */
@Entity
@Table(name = "ContaCorrenteComum")
@SequenceGenerator(name = "seqCCC", sequenceName = "seq_ccc")
public class ContaCorrenteComum extends Conta implements Serializable {

    private static final long serialVersionUID = -2L;

    public ContaCorrenteComum(String numero, String agencia, double saldo, String tipo,
            String senha, String email, double rendaMensal, boolean ativo, Cliente cli, List<Transacao> tx) {
        super(numero, agencia, saldo, tipo, senha, email, rendaMensal, ativo, cli, tx);

    }

    public ContaCorrenteComum() {

    }

    @Override
    public String toString() {
        return super.toString();
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
        ContaCorrenteComum ccc = new ContaCorrenteComum();
        ccc = (ContaCorrenteComum)cd.procuraConta(ccc, conta, agencia);
        ccc.setSaldo(ccc.getSaldo() + valor);
        cd.atualizar(ccc);
        String dados = "Valor depositado: " + valor + "\nTelefone: " + telefone;
        Date dt = ex.converteData(dta);
        ex.gravaExtrato(ccc, dados, conta, agencia, dt);
    }
    
    //public void retirada()

    //metodo para alterar de ativo para inativo
    public static boolean verificaAtivo(String texto) {
        if (texto.trim().equalsIgnoreCase("true")) {
            return true;
        } else {
            return false;
        }
    }
    
    public void retirada(ContaCorrenteComum ccc, double valor) {
        ClasseDAO cd = new ClasseDAO();
        Transacao tx = new Transacao();
        double saldo;
        if (ccc.getSaldo() >= valor) {
            
            Calendar cl = Calendar.getInstance();
            int dia, mes, ano;
            mes = cl.get(Calendar.MONTH) + 1;
            dia = cl.get(Calendar.DAY_OF_MONTH);
            ano = cl.get(Calendar.YEAR);
            String dta = "" + dia + "/" + mes + "/" + ano;
            Date dt = tx.converteData(dta);
            saldo = ccc.getSaldo() - valor;
            ccc.setSaldo(saldo);
            cd.atualizar(ccc);
            String dados = "\nRetirada de R$" + valor;
            ccc = (ContaCorrenteComum) tx.gravaExtrato(ccc,dados, ccc.getNumero(), ccc.getAgencia(), dt);
            cd.atualizar(ccc);

        } else {
            JOptionPane.showMessageDialog(null, "Você não possui Saldo Suficiente, seu saldo é: R$" + ccc.getSaldo(), "", ERROR_MESSAGE);
        }

    }
}

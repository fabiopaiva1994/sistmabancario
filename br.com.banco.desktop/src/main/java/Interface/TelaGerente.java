/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Classes.Cliente;
import Classes.Conta;
import Classes.ContaCorrenteComum;
import Classes.ContaCorrenteLimitada;
import Classes.ContaPoupanca;
import Classes.Deposito;
import Classes.Endereco;
import Classes.Extrato;
import Hibernate.ClasseDAO;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 *
 * @author FábioJunior
 */
public class TelaGerente extends javax.swing.JFrame implements Serializable {

    private static final long serialVersionUID = -2L;

    ClasseDAO dao = new ClasseDAO();

    Extrato extrato = new Extrato();

    public void limpaAtivo() {
        varAtivo2.setSelectedItem("Ativo");
        varNumeroConta3.setText("");
        btnSalvar3.setEnabled(false);
    }

    Object ob = new Object();

    ContaPoupanca c1 = new ContaPoupanca();
    ContaCorrenteComum c2 = new ContaCorrenteComum();
    ContaCorrenteLimitada c3 = new ContaCorrenteLimitada();

    Conta c = new Conta();

    public int converteInt(String txt) {
        int num = Integer.valueOf(txt);
        return num;
    }

    public double converteDouble(String txt) {
        return Double.valueOf(txt);
    }

    public String removeEspaco(String data) {
        data = data.replace(" ", "");
        return data;

    }

    public boolean verificaAtivo(String ativo) {
        try {
            if (ativo.equals("Ativo")) {
                return true;
            } else {
                return false;
            }
        } catch (AbstractMethodError e) {
            return false;
        }
    }

    public boolean verifica() {
        if (varAgencia.getText().isEmpty() || varBairro.getText().isEmpty() || varCep.getText().isEmpty()
                || varCidade.getText().isEmpty() || varComplemento.getText().isEmpty() || varCpf.getText().isEmpty()
                || varDataNascimento.getText().isEmpty() || varEmail.getText().isEmpty() || varEstado.getText().isEmpty()
                || varNome.getText().isEmpty() || varNumero.getText().isEmpty() || varNumeroConta.getText().isEmpty()
                || varPais.getText().isEmpty() || varRendaMensal.getText().isEmpty() || varRg.getText().isEmpty()
                || varRua.getText().isEmpty() || varSaldo.getText().isEmpty() || varSenha.getText().isEmpty()
                || varTelefone.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void preenche(Object c) {

        if (c instanceof ContaCorrenteComum) {
            ContaCorrenteComum cli = new ContaCorrenteComum();
            cli = (ContaCorrenteComum) c;
            varAgencia.setText(cli.getAgencia());
            if (cli.getTipo().equalsIgnoreCase("Poupança")) {
                varTipo.setSelectedItem("Poupanca");
            } else if (cli.getTipo().equalsIgnoreCase("Corrente Comum")) {
                varTipo.setSelectedItem("Corrente Comum");
            } else {
                varTipo.setSelectedItem("Corrente Limitada");
            }
            varBairro.setText(cli.getCli().getEndereco().getBairro());
            varCep.setText(removeEspaco(cli.getCli().getEndereco().getCep()));
            varCidade.setText(cli.getCli().getEndereco().getCidade());
            varComplemento.setText(cli.getCli().getEndereco().getComplemento());
            varCpf.setText(cli.getCli().getCpf());
            varDataNascimento.setText(removeEspaco("" + cli.getCli().getDataNasc()));
            varEmail.setText(cli.getEmail());
            varEstado.setText(cli.getCli().getEndereco().getEstado());
            varIdade.setValue(cli.getCli().getIdade());
            varNome.setText(cli.getCli().getNome());
            varNumero.setText(cli.getCli().getEndereco().getNumero());
            varPais.setText(cli.getCli().getEndereco().getPais());
            varRendaMensal.setText("" + cli.getRendaMensal());
            varRg.setText(cli.getCli().getRg());
            varRua.setText(cli.getCli().getEndereco().getRua());
            varSaldo.setText("" + cli.getSaldo());
            varSenha.setText(cli.getSenha());
            varTelefone.setText(cli.getCli().getTelefone());
            varNumeroConta.setText(cli.getNumero());
            if (cli.isAtivo()) {
                varAtivo.setSelectedItem("Ativo");
            } else {
                varAtivo.setSelectedItem("Inativo");
            }

        } else if (c instanceof ContaPoupanca) {
            ContaPoupanca cli = new ContaPoupanca();
            cli = (ContaPoupanca) c;
            varAgencia.setText(cli.getAgencia());
            if (cli.getTipo().equalsIgnoreCase("Poupança")) {
                varTipo.setSelectedItem("Poupança");
            } else if (cli.getTipo().equalsIgnoreCase("Corrente Comum")) {
                varTipo.setSelectedItem("Corrente Comum");
            } else {
                varTipo.setSelectedItem("Corrente Limitada");
            }
            varBairro.setText(cli.getCli().getEndereco().getBairro());
            varCep.setText(removeEspaco(cli.getCli().getEndereco().getCep()));
            varCidade.setText(cli.getCli().getEndereco().getCidade());
            varComplemento.setText(cli.getCli().getEndereco().getComplemento());
            varCpf.setText(cli.getCli().getCpf());
            varDataNascimento.setText("" + cli.getCli().getDataNasc());
            varEmail.setText(cli.getEmail());
            varEstado.setText(cli.getCli().getEndereco().getEstado());
            varIdade.setValue(cli.getCli().getIdade());
            varNome.setText(cli.getCli().getNome());
            varNumero.setText(cli.getCli().getEndereco().getNumero());
            varPais.setText(cli.getCli().getEndereco().getPais());
            varRendaMensal.setText("" + cli.getRendaMensal());
            varRg.setText(cli.getCli().getRg());
            varRua.setText(cli.getCli().getEndereco().getRua());
            varSaldo.setText("" + cli.getSaldo());
            varSenha.setText(cli.getSenha());
            varTelefone.setText(cli.getCli().getTelefone());
            varNumeroConta.setText(removeEspaco(cli.getNumero()));
            vardtaCriacao.setText(removeEspaco("" + cli.getDtaCriacao()));
            if (cli.isAtivo()) {
                varAtivo.setSelectedItem("Ativo");
            } else {
                varAtivo.setSelectedItem("Inativo");
            }

        } else if (c instanceof ContaCorrenteLimitada) {
            ContaCorrenteLimitada cli = new ContaCorrenteLimitada();
            cli = (ContaCorrenteLimitada) c;
            varAgencia.setText(cli.getAgencia());
            if (cli.getTipo().equalsIgnoreCase("Poupança")) {
                varTipo.setSelectedItem("Poupanca");
            } else if (cli.getTipo().equalsIgnoreCase("Corrente Comum")) {
                varTipo.setSelectedItem("Corrente Comum");
            } else {
                varTipo.setSelectedItem("Corrente Limitada");
            }
            varBairro.setText(cli.getCli().getEndereco().getBairro());
            varCep.setText(removeEspaco(cli.getCli().getEndereco().getCep()));
            varCidade.setText(cli.getCli().getEndereco().getCidade());
            varComplemento.setText(cli.getCli().getEndereco().getComplemento());
            varCpf.setText(cli.getCli().getCpf());
            varDataNascimento.setText(removeEspaco("" + cli.getCli().getDataNasc()));
            varEmail.setText(cli.getEmail());
            varEstado.setText(cli.getCli().getEndereco().getEstado());
            varIdade.setValue(cli.getCli().getIdade());
            varNome.setText(cli.getCli().getNome());
            varNumero.setText(cli.getCli().getEndereco().getNumero());
            varPais.setText(cli.getCli().getEndereco().getPais());
            varRendaMensal.setText("" + cli.getRendaMensal());
            varRg.setText(cli.getCli().getRg());
            varRua.setText(cli.getCli().getEndereco().getRua());
            varSaldo.setText("" + cli.getSaldo());
            varSenha.setText(cli.getSenha());
            varTelefone.setText(cli.getCli().getTelefone());
            varNumeroConta.setText(cli.getNumero());
            varLimite.setText("" + cli.getLimite());
            if (cli.isAtivo()) {
                varAtivo.setSelectedItem("Ativo");
            } else {
                varAtivo.setSelectedItem("Inativo");
            }
        }
    }

    public void limpar() {
        varLimite.setText("");
        varAgencia.setText("");
        varBairro.setText("");
        varBuscar.setText("");
        varCep.setText("");
        varCidade.setText("");
        varComplemento.setText("");
        varCpf.setText("");
        varDataNascimento.setText("");
        varEmail.setText("");
        varEstado.setText("");
        varIdade.setValue(0);
        varNome.setText("");
        varNumero.setText("");
        varPais.setText("");
        varRendaMensal.setText("");
        varRg.setText("");
        varRua.setText("");
        varSaldo.setText("");
        varSenha.setText("");
        varTelefone.setText("");
        vardtaCriacao.setText("");
        varNumeroConta.setText("");
        btnCriarNovoCliente.setEnabled(true);
        btnSalvarAlteracoes.setEnabled(false);
        varDataInicio.setText("");
        varDtaFim.setText("");
        varNumConta.setText("");
    }

    public void alteraConta(Object conta) {
        Deposito dep = new Deposito();
        if (conta instanceof ContaPoupanca) {
            ContaPoupanca cp = new ContaPoupanca();
            cp = (ContaPoupanca) conta;
            cp.setAgencia(varAgencia.getText());
            cp.setEmail(varEmail.getText());
            cp.setNumero(varNumeroConta.getText());
            cp.setRendaMensal(converteDouble1(varRendaMensal.getText()));
            cp.setSaldo(converteDouble1(varSaldo.getText()));
            cp.setSenha(varSenha.getText());
            cp.setTipo(varTipo.getSelectedItem().toString());
            cp.getCli().setCpf(varCpf.getText());
            cp.getCli().setDataNasc(extrato.converteData(varDataNascimento.getText()));
            cp.getCli().setIdade(converteInt1(varIdade.getValue().toString()));
            cp.getCli().setNome(varNome.getText());
            cp.getCli().setRg(varRg.getText());
            cp.getCli().setTelefone(varTelefone.getText());
            cp.getCli().getEndereco().setBairro(varBairro.getText());
            cp.getCli().getEndereco().setCep(varCep.getText());
            cp.getCli().getEndereco().setCidade(varCidade.getText());
            cp.getCli().getEndereco().setComplemento(varCidade.getText());
            cp.getCli().getEndereco().setEstado(varEstado.getText());
            cp.getCli().getEndereco().setNumero(varNumero.getText());
            cp.getCli().getEndereco().setPais(varPais.getText());
            cp.getCli().getEndereco().setRua(varRua.getText());

            dep.alteraConta(cp);

        } else if (conta instanceof ContaCorrenteComum) {
            ContaCorrenteComum cp = new ContaCorrenteComum();
            cp = (ContaCorrenteComum) conta;

            cp.setAgencia(varAgencia.getText());
            cp.setEmail(varEmail.getText());
            cp.setNumero(varNumeroConta.getText());
            cp.setRendaMensal(converteDouble1(varRendaMensal.getText()));
            cp.setSaldo(converteDouble1(varSaldo.getText()));
            cp.setSenha(varSenha.getText());
            cp.setTipo(varTipo.getSelectedItem().toString());
            cp.getCli().setCpf(varCpf.getText());
            cp.getCli().setDataNasc(extrato.converteData(varDataNascimento.getText()));
            cp.getCli().setIdade(converteInt1(varIdade.getValue().toString()));
            cp.getCli().setNome(varNome.getText());
            cp.getCli().setRg(varRg.getText());
            cp.getCli().setTelefone(varTelefone.getText());
            cp.getCli().getEndereco().setBairro(varBairro.getText());
            cp.getCli().getEndereco().setCep(varCep.getText());
            cp.getCli().getEndereco().setCidade(varCidade.getText());
            cp.getCli().getEndereco().setComplemento(varCidade.getText());
            cp.getCli().getEndereco().setEstado(varEstado.getText());
            cp.getCli().getEndereco().setNumero(varNumero.getText());
            cp.getCli().getEndereco().setPais(varPais.getText());
            cp.getCli().getEndereco().setRua(varRua.getText());

            dep.alteraConta(cp);

        } else if (conta instanceof ContaCorrenteLimitada) {
            ContaCorrenteLimitada cp = new ContaCorrenteLimitada();
            cp = (ContaCorrenteLimitada) conta;

            cp.setAgencia(varAgencia.getText());
            cp.setEmail(varEmail.getText());
            cp.setNumero(varNumeroConta.getText());
            cp.setRendaMensal(converteDouble1(varRendaMensal.getText()));
            cp.setSaldo(converteDouble1(varSaldo.getText()));
            cp.setSenha(varSenha.getText());
            cp.setTipo(varTipo.getSelectedItem().toString());
            cp.getCli().setCpf(varCpf.getText());
            cp.getCli().setDataNasc(extrato.converteData(varDataNascimento.getText()));
            cp.getCli().setIdade(converteInt1(varIdade.getValue().toString()));
            cp.getCli().setNome(varNome.getText());
            cp.getCli().setRg(varRg.getText());
            cp.getCli().setTelefone(varTelefone.getText());
            cp.getCli().getEndereco().setBairro(varBairro.getText());
            cp.getCli().getEndereco().setCep(varCep.getText());
            cp.getCli().getEndereco().setCidade(varCidade.getText());
            cp.getCli().getEndereco().setComplemento(varCidade.getText());
            cp.getCli().getEndereco().setEstado(varEstado.getText());
            cp.getCli().getEndereco().setNumero(varNumero.getText());
            cp.getCli().getEndereco().setPais(varPais.getText());
            cp.getCli().getEndereco().setRua(varRua.getText());
            cp.setLimite(converteDouble1(varLimite.getText()));

            dep.alteraConta(cp);

        }
    }

    public int converteInt1(String valor) {
        try {
            int v = Integer.valueOf(valor);
            return v;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Há valores inválidos em algum campo!\nConfira Por Favor!!", "", ERROR_MESSAGE);
            return 0;
        }
    }

    public double converteDouble1(String valor) {
        try {
            double v = Double.valueOf(valor);
            return v;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Há valores inválidos em algum campo!\nConfira Por Favor!!", "", ERROR_MESSAGE);
            return 0;
        }

    }

    /**
     * Creates new form TelaGerente
     */
    public TelaGerente() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        varNome = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        varRg = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        varIdade = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        varRendaMensal = new javax.swing.JFormattedTextField();
        varDataNascimento = new javax.swing.JFormattedTextField();
        varTelefone = new javax.swing.JFormattedTextField();
        jLabel23 = new javax.swing.JLabel();
        varCpf = new javax.swing.JFormattedTextField();
        vardtaCriacao = new javax.swing.JFormattedTextField();
        jLabel26 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        varRua = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        varNumero = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        varComplemento = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        varBairro = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        varCidade = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        varEstado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        varPais = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        varCep = new javax.swing.JFormattedTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        varAgencia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        varNumeroConta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        varSenha = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        varEmail = new javax.swing.JTextField();
        varSaldo = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        varTipo = new javax.swing.JComboBox<>();
        varAtivo = new javax.swing.JComboBox<>();
        varLimite = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btnLimpar = new javax.swing.JButton();
        btnSalvarAlteracoes = new javax.swing.JButton();
        btnOkBuscar = new javax.swing.JButton();
        varBuscar = new javax.swing.JTextField();
        btnCriarNovoCliente = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        btnPoupanca = new javax.swing.JRadioButton();
        btnCorrenteComum = new javax.swing.JRadioButton();
        btnCorrenteLimitada = new javax.swing.JRadioButton();
        btnSair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        varValorExtorno = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        varNumeroConta2 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        btnSalvar2 = new javax.swing.JButton();
        varBuscar2 = new javax.swing.JButton();
        btnCc = new javax.swing.JRadioButton();
        btnCl = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        varAtivo2 = new javax.swing.JComboBox<>();
        btnSalvar3 = new javax.swing.JButton();
        varNumeroConta3 = new javax.swing.JTextField();
        btnBuscar2 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        btnPoupanca3 = new javax.swing.JRadioButton();
        btnCorrenteComum3 = new javax.swing.JRadioButton();
        btnCorrenteLimitada3 = new javax.swing.JRadioButton();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        varDataInicio = new javax.swing.JFormattedTextField();
        jLabel34 = new javax.swing.JLabel();
        varNumConta = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        varDtaFim = new javax.swing.JFormattedTextField();
        jLabel36 = new javax.swing.JLabel();
        btnOk4 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        varDados = new javax.swing.JTextPane();
        varLimpar4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(204, 204, 0));

        jTabbedPane2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 0, 153));
        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        varNome.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        varNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varNomeActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel11.setText("Nome");

        jLabel12.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel12.setText("C.P.F");

        jLabel13.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel13.setText("R.G");

        varRg.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel14.setText("Data de Nascimento");

        jLabel15.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel15.setText("Idade");

        varIdade.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel16.setText("Renda Mensal");

        varRendaMensal.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        try {
            varDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        varDataNascimento.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        varDataNascimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                varDataNascimentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                varDataNascimentoFocusLost(evt);
            }
        });

        varTelefone.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel23.setText("Telefone");

        try {
            varCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        varCpf.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        varCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                varCpfFocusLost(evt);
            }
        });

        try {
            vardtaCriacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        vardtaCriacao.setEnabled(false);
        vardtaCriacao.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel26.setText("Data da Criação");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addGap(243, 243, 243))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addGap(178, 178, 178))
                                    .addComponent(varTelefone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addComponent(vardtaCriacao, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(varIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(varRendaMensal, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(varRg, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(varNome, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel12)
                                    .addComponent(varDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(varCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(65, 65, 65))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addGap(9, 9, 9)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(varCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(varDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(varRg, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(varIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(varRendaMensal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(varTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vardtaCriacao, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(varNome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Dados Pessoais", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 0, 153));

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel7.setText("Rua");

        varRua.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel8.setText("Número");

        varNumero.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel9.setText("Complemento");

        varComplemento.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel10.setText("Bairro");

        varBairro.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel17.setText("Cidade");

        varCidade.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText("Estado");

        varEstado.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setText("Pais");

        varPais.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel3.setText("CEP");

        try {
            varCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        varCep.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(varPais, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(varCidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(varRua, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(varComplemento, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel17)))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(varNumero)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(varBairro)
                    .addComponent(jLabel1)
                    .addComponent(varEstado)
                    .addComponent(jLabel3)
                    .addComponent(varCep, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
                .addGap(44, 44, 44))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(varNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(varComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(varBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(varCidade)
                    .addComponent(varEstado))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(varPais)
                    .addComponent(varCep))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Endereço", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 0, 153));

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel4.setText("Agência");

        varAgencia.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel5.setText("Numero da Conta");

        varNumeroConta.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        varNumeroConta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                varNumeroContaFocusLost(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel6.setText("Senha");

        varSenha.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel18.setText("E-mail");

        varEmail.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        varSaldo.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        varSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varSaldoActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel19.setText("Saldo ");

        jLabel21.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel21.setText("Ativo");

        jLabel22.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel22.setText("Tipo");

        varTipo.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        varTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Poupança", "Corrente Comum", "Corrente Limitada" }));

        varAtivo.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        varAtivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));

        varLimite.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        varLimite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varLimiteActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel24.setText("Limite");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4)
                                    .addComponent(varAgencia, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                    .addComponent(jLabel5)
                                    .addComponent(varNumeroConta, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6)
                                    .addComponent(varSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                    .addComponent(jLabel18)
                                    .addComponent(varEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 387, Short.MAX_VALUE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(varAtivo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(133, 133, 133)))
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(varSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24)
                                    .addComponent(varLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(76, 76, 76))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(varTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(varSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varNumeroConta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(varEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(varSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(varAtivo)
                        .addGap(2, 2, 2)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(varTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(varLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane2.addTab("Dados da Conta", jPanel7);

        jPanel9.setBackground(new java.awt.Color(204, 204, 0));

        btnLimpar.setBackground(new java.awt.Color(0, 51, 153));
        btnLimpar.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnLimpar.setForeground(new java.awt.Color(254, 254, 254));
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnSalvarAlteracoes.setBackground(new java.awt.Color(0, 51, 153));
        btnSalvarAlteracoes.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnSalvarAlteracoes.setForeground(new java.awt.Color(254, 254, 254));
        btnSalvarAlteracoes.setText("Salvar Alterações");
        btnSalvarAlteracoes.setEnabled(false);
        btnSalvarAlteracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarAlteracoesActionPerformed(evt);
            }
        });

        btnOkBuscar.setBackground(new java.awt.Color(0, 51, 153));
        btnOkBuscar.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnOkBuscar.setForeground(new java.awt.Color(254, 254, 254));
        btnOkBuscar.setText("OK");
        btnOkBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkBuscarActionPerformed(evt);
            }
        });

        varBuscar.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        varBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varBuscarActionPerformed(evt);
            }
        });

        btnCriarNovoCliente.setBackground(new java.awt.Color(0, 51, 153));
        btnCriarNovoCliente.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnCriarNovoCliente.setForeground(new java.awt.Color(254, 254, 254));
        btnCriarNovoCliente.setText("Criar Novo Cliente");
        btnCriarNovoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarNovoClienteActionPerformed(evt);
            }
        });

        jLabel20.setBackground(new java.awt.Color(254, 254, 254));
        jLabel20.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(254, 254, 254));
        jLabel20.setText("Buscar Cliente");

        btnPoupanca.setBackground(new java.awt.Color(204, 204, 0));
        buttonGroup1.add(btnPoupanca);
        btnPoupanca.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPoupanca.setForeground(new java.awt.Color(255, 255, 255));
        btnPoupanca.setText("Poupança");

        btnCorrenteComum.setBackground(new java.awt.Color(204, 204, 0));
        buttonGroup1.add(btnCorrenteComum);
        btnCorrenteComum.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCorrenteComum.setForeground(new java.awt.Color(255, 255, 255));
        btnCorrenteComum.setText("Corrente Comum");

        btnCorrenteLimitada.setBackground(new java.awt.Color(204, 204, 0));
        buttonGroup1.add(btnCorrenteLimitada);
        btnCorrenteLimitada.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCorrenteLimitada.setForeground(new java.awt.Color(255, 255, 255));
        btnCorrenteLimitada.setText("Corrente Limitada");

        btnSair.setBackground(new java.awt.Color(0, 51, 153));
        btnSair.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnSair.setForeground(new java.awt.Color(254, 254, 254));
        btnSair.setText("SAIR");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(28, 28, 28)
                        .addComponent(btnPoupanca)
                        .addGap(18, 18, 18)
                        .addComponent(btnCorrenteComum)
                        .addGap(18, 18, 18)
                        .addComponent(btnCorrenteLimitada))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(varBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCriarNovoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnOkBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(btnSalvarAlteracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(106, 106, 106)
                .addComponent(btnSair)
                .addGap(25, 25, 25))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPoupanca)
                    .addComponent(btnCorrenteComum)
                    .addComponent(btnCorrenteLimitada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOkBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(varBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCriarNovoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvarAlteracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2))
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 579, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Cadastro e Alteração ", jPanel1);

        jPanel10.setBackground(new java.awt.Color(204, 204, 0));

        jPanel11.setBackground(new java.awt.Color(255, 0, 153));

        varValorExtorno.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jLabel28.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel28.setText("Valor do Extorno");

        varNumeroConta2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        varNumeroConta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varNumeroConta2ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel27.setText("Numero da Conta");

        btnSalvar2.setBackground(new java.awt.Color(0, 51, 153));
        btnSalvar2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnSalvar2.setForeground(new java.awt.Color(254, 254, 254));
        btnSalvar2.setText("Salvar");
        btnSalvar2.setEnabled(false);
        btnSalvar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvar2ActionPerformed(evt);
            }
        });

        varBuscar2.setBackground(new java.awt.Color(0, 51, 153));
        varBuscar2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        varBuscar2.setForeground(new java.awt.Color(254, 254, 254));
        varBuscar2.setText("Buscar");
        varBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varBuscar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                            .addComponent(varNumeroConta2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(varBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                            .addComponent(varValorExtorno, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(104, 104, 104)
                            .addComponent(btnSalvar2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(276, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addGap(9, 9, 9)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel28)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(varValorExtorno, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalvar2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(varNumeroConta2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(varBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        btnCc.setBackground(new java.awt.Color(204, 204, 0));
        buttonGroup2.add(btnCc);
        btnCc.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCc.setForeground(new java.awt.Color(255, 255, 255));
        btnCc.setText("Corrente Comum");

        btnCl.setBackground(new java.awt.Color(204, 204, 0));
        buttonGroup2.add(btnCl);
        btnCl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCl.setForeground(new java.awt.Color(255, 255, 255));
        btnCl.setText("Corrente Limitada");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCc)
                    .addComponent(btnCl))
                .addContainerGap(641, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnCc)
                .addGap(18, 18, 18)
                .addComponent(btnCl)
                .addGap(92, 92, 92)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(215, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Estorno de Lançamento", jPanel2);

        jPanel12.setBackground(new java.awt.Color(204, 204, 0));

        jPanel13.setBackground(new java.awt.Color(255, 0, 153));

        varAtivo2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        varAtivo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));

        btnSalvar3.setBackground(new java.awt.Color(0, 51, 153));
        btnSalvar3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnSalvar3.setForeground(new java.awt.Color(254, 254, 254));
        btnSalvar3.setText("Salvar");
        btnSalvar3.setEnabled(false);
        btnSalvar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvar3ActionPerformed(evt);
            }
        });

        varNumeroConta3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        varNumeroConta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varNumeroConta3ActionPerformed(evt);
            }
        });

        btnBuscar2.setBackground(new java.awt.Color(0, 51, 153));
        btnBuscar2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnBuscar2.setForeground(new java.awt.Color(254, 254, 254));
        btnBuscar2.setText("Buscar");
        btnBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar2ActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel30.setText("Ativo");

        jLabel31.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel31.setText("Numero da Conta");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(varNumeroConta3)
                            .addComponent(varAtivo2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSalvar3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(350, Short.MAX_VALUE))
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(589, Short.MAX_VALUE)))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varNumeroConta3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addGap(5, 5, 5)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSalvar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(varAtivo2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jLabel31)
                    .addContainerGap(113, Short.MAX_VALUE)))
        );

        btnPoupanca3.setBackground(new java.awt.Color(204, 204, 0));
        buttonGroup3.add(btnPoupanca3);
        btnPoupanca3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnPoupanca3.setForeground(new java.awt.Color(255, 255, 255));
        btnPoupanca3.setText("Poupança");

        btnCorrenteComum3.setBackground(new java.awt.Color(204, 204, 0));
        buttonGroup3.add(btnCorrenteComum3);
        btnCorrenteComum3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCorrenteComum3.setForeground(new java.awt.Color(255, 255, 255));
        btnCorrenteComum3.setText("Corrente Comum");

        btnCorrenteLimitada3.setBackground(new java.awt.Color(204, 204, 0));
        buttonGroup3.add(btnCorrenteLimitada3);
        btnCorrenteLimitada3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCorrenteLimitada3.setForeground(new java.awt.Color(255, 255, 255));
        btnCorrenteLimitada3.setText("Corrente Limitada");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPoupanca3)
                    .addComponent(btnCorrenteComum3)
                    .addComponent(btnCorrenteLimitada3))
                .addContainerGap(641, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPoupanca3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCorrenteComum3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCorrenteLimitada3)
                .addGap(125, 125, 125)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Bloqueio e Desbloqueio", jPanel3);

        jPanel15.setBackground(new java.awt.Color(204, 204, 0));

        try {
            varDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        varDataInicio.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        varDataInicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                varDataInicioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                varDataInicioFocusLost(evt);
            }
        });
        varDataInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varDataInicioActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel34.setText("Data Inicial");

        varNumConta.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jLabel35.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel35.setText("Número da Conta");

        try {
            varDtaFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        varDtaFim.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        varDtaFim.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                varDtaFimFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                varDtaFimFocusLost(evt);
            }
        });
        varDtaFim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varDtaFimActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel36.setText("Data Final");

        btnOk4.setBackground(new java.awt.Color(0, 51, 153));
        btnOk4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnOk4.setForeground(new java.awt.Color(254, 254, 254));
        btnOk4.setText("Ok");
        btnOk4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOk4ActionPerformed(evt);
            }
        });

        varDados.setBackground(new java.awt.Color(255, 0, 153));
        varDados.setEnabled(false);
        jScrollPane1.setViewportView(varDados);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
        );

        varLimpar4.setBackground(new java.awt.Color(0, 51, 153));
        varLimpar4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        varLimpar4.setForeground(new java.awt.Color(254, 254, 254));
        varLimpar4.setText("Limpar");
        varLimpar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varLimpar4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(varNumConta, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                            .addComponent(varLimpar4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnOk4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(varDtaFim, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36)
                            .addComponent(jLabel34)
                            .addComponent(varDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(480, Short.MAX_VALUE))
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(varNumConta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(varDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(varDtaFim, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk4, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(varLimpar4, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Extrato", jPanel14);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSairActionPerformed

    private void varBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_varBuscarActionPerformed

    private void btnOkBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkBuscarActionPerformed
        if (!varBuscar.getText().isEmpty()) {
            varTipo.setEnabled(false);
            if (btnCorrenteComum.isSelected()) {
                ContaCorrenteComum ccc = ContaCorrenteComum.Leitura(varBuscar.getText());
                if (ccc.getTipo().equals("Corrente Comum")) {
                    JOptionPane.showMessageDialog(null, ccc.toString(), "", ERROR_MESSAGE);
                    preenche(ccc);
                    c2 = ccc;
                    ob = c2;
                    btnSalvarAlteracoes.setEnabled(true);
                    btnCriarNovoCliente.setEnabled(false);
                    varSaldo.setEnabled(false);
                }
            } else if (btnCorrenteLimitada.isSelected()) {
                ContaCorrenteLimitada ccl = ContaCorrenteLimitada.Leitura(varBuscar.getText());
                if (ccl.getTipo().equals("Corrente Limitada")) {
                    JOptionPane.showMessageDialog(null, ccl.toString(), "", ERROR_MESSAGE);
                    preenche(ccl);
                    c3 = ccl;
                    ob = c3;
                    btnSalvarAlteracoes.setEnabled(true);
                    btnCriarNovoCliente.setEnabled(false);
                    varSaldo.setEnabled(false);
                }
            } else if (btnPoupanca.isSelected()) {
                ContaPoupanca cp = ContaPoupanca.Leitura(varBuscar.getText());
                if (cp.getTipo().equals("Poupança")) {
                    JOptionPane.showMessageDialog(null, cp.toString(), "", ERROR_MESSAGE);
                    preenche(cp);
                    c1 = cp;
                    ob = c1;
                    btnSalvarAlteracoes.setEnabled(true);
                    btnCriarNovoCliente.setEnabled(false);
                    varSaldo.setEnabled(false);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um Tipo de Conta para Buscar!!", "", ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Digite o numero da conta!", "", ERROR_MESSAGE);
        }

        //Conta.visualizarArquivos(varBuscar.getText());
    }//GEN-LAST:event_btnOkBuscarActionPerformed

    private void btnCriarNovoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarNovoClienteActionPerformed
        /*String numero, String agencia, double saldo, String tipo,
        String senha, String email*/
        Object tipoConta;
        if (!verifica()) {
            if (varTipo.getSelectedItem().toString().equals("Poupança")) {
                tipoConta = new ContaPoupanca();
                Calendar ca = Calendar.getInstance();
                String data;
                int dia, mes, ano;
                dia = ca.get(Calendar.DAY_OF_MONTH);
                mes = ca.get(Calendar.MONTH) + 1;
                ano = ca.get(Calendar.YEAR);
                data = "" + dia + "/" + mes + "/" + ano;

                Endereco end = new Endereco(varRua.getText(), varNumero.getText(), varComplemento.getText(),
                        varBairro.getText(), varCidade.getText(), varEstado.getText(), varPais.getText(),
                        varCep.getText());

                /*Conta conta, String senha, String nome, String rg, String cpf, String telefone,
                Endereco endereco, int id*/
                Extrato ex = new Extrato();
                Cliente cli = new Cliente(varNome.getText(), varRg.getText(), varCpf.getText(),
                        varTelefone.getText(), ex.converteData(varDataNascimento.getText()),
                        converteInt(varIdade.getValue().toString()), end);

                c1 = new ContaPoupanca(ex.converteData(data), varNumeroConta.getText(), varAgencia.getText(),
                        converteDouble(varSaldo.getText()),
                        varTipo.getSelectedItem().toString(), varSenha.getText(),
                        varEmail.getText(), converteDouble(varRendaMensal.getText()),
                        verificaAtivo(varAtivo.getSelectedItem().toString()), cli);
                ///if (dao.procuraConta(tipoConta, varNumConta.getText(), varAgencia.getText()) == null) {
                dao.cadastrar(c1);
                JOptionPane.showMessageDialog(null, "Conta Aberta Com Sucesso!!");
                limpar();
                //} else {
                //  JOptionPane.showMessageDialog(null, "Houve um problema ao criar a Conta, Contate o Suporte!!", "", ERROR_MESSAGE);
                //}
            } else if (varTipo.getSelectedItem().toString().equals("Corrente Comum")) {
                tipoConta = new ContaCorrenteComum();

                Endereco end = new Endereco(varRua.getText(), varNumero.getText(), varComplemento.getText(),
                        varBairro.getText(), varCidade.getText(), varEstado.getText(), varPais.getText(),
                        varCep.getText());

                /*Conta conta, String senha, String nome, String rg, String cpf, String telefone,
                Endereco endereco, int id*/
                Cliente cli = new Cliente(varNome.getText(), varRg.getText(), varCpf.getText(),
                        varTelefone.getText(), extrato.converteData(varDataNascimento.getText()),
                        converteInt(varIdade.getValue().toString()), end);

                c2 = new ContaCorrenteComum(varNumeroConta.getText(), varAgencia.getText(),
                        converteDouble(varSaldo.getText()),
                        varTipo.getSelectedItem().toString(), varSenha.getText(),
                        varEmail.getText(), converteDouble(varRendaMensal.getText()),
                        verificaAtivo(varAtivo.getSelectedItem().toString()), cli);

                dao.cadastrar(c2);
                JOptionPane.showMessageDialog(null, "Conta Aberta Com Sucesso!!");
                limpar();

            } else if (varTipo.getSelectedItem().toString().equals("Corrente Limitada")) {
                tipoConta = new ContaCorrenteLimitada();
                Endereco end = new Endereco(varRua.getText(), varNumero.getText(), varComplemento.getText(),
                        varBairro.getText(), varCidade.getText(), varEstado.getText(), varPais.getText(),
                        varCep.getText());

                /*Conta conta, String senha, String nome, String rg, String cpf, String telefone,
                Endereco endereco, int id*/
                Cliente cli = new Cliente(varNome.getText(), varRg.getText(), varCpf.getText(),
                        varTelefone.getText(), extrato.converteData(varDataNascimento.getText()),
                        converteInt(varIdade.getValue().toString()), end);
                double limite = Double.valueOf(varLimite.getText());
                c3 = new ContaCorrenteLimitada(limite, varNumeroConta.getText(), varAgencia.getText(),
                        converteDouble(varSaldo.getText()),
                        varTipo.getSelectedItem().toString(), varSenha.getText(),
                        varEmail.getText(), converteDouble(varRendaMensal.getText()),
                        verificaAtivo(varAtivo.getSelectedItem().toString()), cli);
                dao.cadastrar(c3);
                JOptionPane.showMessageDialog(null, "Conta Aberta Com Sucesso!!");
                limpar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Há Campos em Branco, tente novamente!", "", ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnCriarNovoClienteActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
        btnCriarNovoCliente.setEnabled(true);
        varTipo.setEnabled(true);
        varTipo.setSelectedItem(0);
        varSaldo.setEnabled(true);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void varNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_varNomeActionPerformed

    private void varCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_varCpfFocusLost
        Cliente cli = new Cliente();
        String cpf = "";
        if (cli.verificarCpf(cli.retiraPontos(varCpf.getText()))) {

        } else {
            JOptionPane.showMessageDialog(null, "O CPF digitado é inválido!", "", ERROR_MESSAGE);
            varCpf.requestFocus();
        }
    }//GEN-LAST:event_varCpfFocusLost

    private void varSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varSaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_varSaldoActionPerformed

    private void varLimiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varLimiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_varLimiteActionPerformed

    private void btnSalvarAlteracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarAlteracoesActionPerformed
        alteraConta(ob);
        limpar();
    }//GEN-LAST:event_btnSalvarAlteracoesActionPerformed

    private void varNumeroConta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varNumeroConta2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_varNumeroConta2ActionPerformed

    private void btnSalvar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvar2ActionPerformed
        Extrato et = new Extrato();
        Deposito dp = new Deposito();
        if (btnCc.isSelected()) {
            ContaCorrenteComum ccc = new ContaCorrenteComum();
            ccc = (ContaCorrenteComum) ob;
            dp = new Deposito(ccc.getNumero(), ccc.getAgencia(), converteDouble1(varValorExtorno.getText()),
                    ccc.getCli().getTelefone());
            dp.deposita(dp, ccc);
            String d = "Estorno no Valor de R$" + varValorExtorno.getText() + "\nPropietário da Conta: " + ccc.getCli().getNome()
                    + "\n";
            varNumeroConta2.setText("");
            varValorExtorno.setText("");
            btnSalvar2.setEnabled(false);

            et.gravaLog(ccc.getNumero(), d);

        } else if (btnCl.isSelected()) {
            ContaCorrenteLimitada ccc = new ContaCorrenteLimitada();
            ccc = (ContaCorrenteLimitada) ob;
            dp = new Deposito(ccc.getNumero(), ccc.getAgencia(), converteDouble1(varValorExtorno.getText()),
                    ccc.getCli().getTelefone());
            dp.deposita(dp, ccc);
            String d = "Estorno no Valor de R$" + varValorExtorno.getText() + "\nPropietário da Conta: " + ccc.getCli().getNome()
                    + "\n";
            varNumeroConta2.setText("");
            varValorExtorno.setText("");
            btnSalvar2.setEnabled(false);
            et.gravaLog(ccc.getNumero(), d);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um tipo de Conta Por Favor!", "", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvar2ActionPerformed

    private void varNumeroConta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varNumeroConta3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_varNumeroConta3ActionPerformed

    private void varBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varBuscar2ActionPerformed
        if (btnCc.isSelected()) {
            ContaCorrenteComum ccc = ContaCorrenteComum.Leitura(varNumeroConta2.getText());
            if (ccc != null && ccc.getTipo().equals("Corrente Comum")) {
                JOptionPane.showMessageDialog(null, ccc.toString(), "", ERROR_MESSAGE);
                ob = ccc;
                btnSalvar2.setEnabled(true);
            }
        } else if (btnCl.isSelected()) {
            ContaCorrenteLimitada ccl = ContaCorrenteLimitada.Leitura(varNumeroConta2.getText());
            if (ccl != null && ccl.getTipo().equals("Corrente Limitada")) {
                JOptionPane.showMessageDialog(null, ccl.toString(), "", ERROR_MESSAGE);
                ob = ccl;
                btnSalvar2.setEnabled(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um tipo de Conta!", "", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_varBuscar2ActionPerformed

    private void btnBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar2ActionPerformed
        if (btnPoupanca3.isSelected()) {
            ContaPoupanca cp = new ContaPoupanca();
            cp = ContaPoupanca.Leitura(varNumeroConta3.getText());
            if (cp != null && cp.getTipo().equals("Poupança")) {
                JOptionPane.showMessageDialog(null, cp.toString(), "", ERROR_MESSAGE);
                ob = cp;
                btnSalvar3.setEnabled(true);
                if (cp.isAtivo()) {
                    varAtivo2.setSelectedItem("Ativo");
                } else {
                    varAtivo2.setSelectedItem("Inativo");
                }
            }

        } else if (btnCorrenteComum3.isSelected()) {
            ContaCorrenteComum ccc = new ContaCorrenteComum();
            ccc = ContaCorrenteComum.Leitura(varNumeroConta3.getText());
            if (ccc != null && ccc.getTipo().equals("Corrente Comum")) {
                JOptionPane.showMessageDialog(null, ccc.toString(), "", ERROR_MESSAGE);
                ob = ccc;
                btnSalvar3.setEnabled(true);
                if (ccc.isAtivo()) {
                    varAtivo2.setSelectedItem("Ativo");
                } else {
                    varAtivo2.setSelectedItem("Inativo");
                }

            }

        } else if (btnCorrenteLimitada3.isSelected()) {
            ContaCorrenteLimitada ccl = new ContaCorrenteLimitada();
            ccl = ContaCorrenteLimitada.Leitura(varNumeroConta3.getText());
            if (ccl != null && ccl.getTipo().equals("Corrente Limitada")) {
                JOptionPane.showMessageDialog(null, ccl.toString(), "", ERROR_MESSAGE);
                ob = ccl;
                btnSalvar3.setEnabled(true);
                if (ccl.isAtivo()) {
                    varAtivo2.setSelectedItem("Ativo");
                } else {
                    varAtivo2.setSelectedItem("Inativo");
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Escolha um Tipo de Conta!", "", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscar2ActionPerformed

    private void btnSalvar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvar3ActionPerformed
        Deposito dp = new Deposito();
        if (ob instanceof ContaPoupanca) {
            ContaPoupanca cp = new ContaPoupanca();
            cp = (ContaPoupanca) ob;
            cp.setAtivo(verificaAtivo(varAtivo2.getSelectedItem().toString()));
            dp.alteraConta(cp);
            limpaAtivo();
        } else if (ob instanceof ContaCorrenteComum) {
            ContaCorrenteComum ccc = new ContaCorrenteComum();
            ccc = (ContaCorrenteComum) ob;
            ccc.setAtivo(verificaAtivo(varAtivo2.getSelectedItem().toString()));
            dp.alteraConta(ccc);
            limpaAtivo();
        } else if (ob instanceof ContaCorrenteLimitada) {
            ContaCorrenteLimitada ccl = new ContaCorrenteLimitada();
            ccl = (ContaCorrenteLimitada) ob;
            ccl.setAtivo(verificaAtivo(varAtivo2.getSelectedItem().toString()));
            dp.alteraConta(ccl);
            limpaAtivo();
        } else {
            JOptionPane.showMessageDialog(null, "Escolha um tipo de Conta!", "", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvar3ActionPerformed

    private void varDataNascimentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_varDataNascimentoFocusGained

    }//GEN-LAST:event_varDataNascimentoFocusGained

    private void varDataNascimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_varDataNascimentoFocusLost
        Date date = new Date();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = (java.util.Date) formatter.parse(varDataNascimento.getText());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Data Inválida!");
            varDataNascimento.setText("");
        }
        GregorianCalendar hj = new GregorianCalendar();
        GregorianCalendar nascimento = new GregorianCalendar();
        if (date != null) {
            nascimento.setTime(date);
        }
        int anohj = hj.get(Calendar.YEAR);
        int anoNascimento = nascimento.get(Calendar.YEAR);
        int idadeReal = anohj - anoNascimento;
        varIdade.setValue(idadeReal);        // TODO add your handling code here:
    }//GEN-LAST:event_varDataNascimentoFocusLost

    private void varDataInicioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_varDataInicioFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_varDataInicioFocusGained

    private void varDataInicioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_varDataInicioFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_varDataInicioFocusLost

    private void varDtaFimFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_varDtaFimFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_varDtaFimFocusGained

    private void varDtaFimFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_varDtaFimFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_varDtaFimFocusLost

    private void btnOk4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOk4ActionPerformed
        Extrato ex = new Extrato();
        try {
            varDados.setText(ex.extratoPeriodo(varNumConta.getText(), varDataInicio.getText(), varDtaFim.getText()));
            varNumConta.setText("");
            varDataInicio.setText("");
            varDtaFim.setText("");
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Nenhuma Conta Encontrada ou não há extrato!");
        }
    }//GEN-LAST:event_btnOk4ActionPerformed

    private void varLimpar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varLimpar4ActionPerformed
        varDados.setText(""); // TODO add your handling code here:
    }//GEN-LAST:event_varLimpar4ActionPerformed

    private void varDataInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varDataInicioActionPerformed
        requestFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_varDataInicioActionPerformed

    private void varDtaFimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varDtaFimActionPerformed
        requestFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_varDtaFimActionPerformed

    private void varNumeroContaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_varNumeroContaFocusLost
        /*if(dao.procuraConta(varNumeroConta.getText(), varAgencia.getText())!= null) {
            JOptionPane.showMessageDialog(null, "Já Existe uma Conta com estes Dados!", "", ERROR_MESSAGE);
        }*/
    }//GEN-LAST:event_varNumeroContaFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaGerente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar2;
    private javax.swing.JRadioButton btnCc;
    private javax.swing.JRadioButton btnCl;
    private javax.swing.JRadioButton btnCorrenteComum;
    private javax.swing.JRadioButton btnCorrenteComum3;
    private javax.swing.JRadioButton btnCorrenteLimitada;
    private javax.swing.JRadioButton btnCorrenteLimitada3;
    private javax.swing.JButton btnCriarNovoCliente;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnOk4;
    private javax.swing.JButton btnOkBuscar;
    private javax.swing.JRadioButton btnPoupanca;
    private javax.swing.JRadioButton btnPoupanca3;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar2;
    private javax.swing.JButton btnSalvar3;
    private javax.swing.JButton btnSalvarAlteracoes;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField varAgencia;
    private javax.swing.JComboBox<String> varAtivo;
    private javax.swing.JComboBox<String> varAtivo2;
    private javax.swing.JTextField varBairro;
    private javax.swing.JTextField varBuscar;
    private javax.swing.JButton varBuscar2;
    private javax.swing.JFormattedTextField varCep;
    private javax.swing.JTextField varCidade;
    private javax.swing.JTextField varComplemento;
    private javax.swing.JFormattedTextField varCpf;
    private javax.swing.JTextPane varDados;
    private javax.swing.JFormattedTextField varDataInicio;
    private javax.swing.JFormattedTextField varDataNascimento;
    private javax.swing.JFormattedTextField varDtaFim;
    private javax.swing.JTextField varEmail;
    private javax.swing.JTextField varEstado;
    private javax.swing.JSpinner varIdade;
    private javax.swing.JTextField varLimite;
    private javax.swing.JButton varLimpar4;
    private javax.swing.JTextField varNome;
    private javax.swing.JTextField varNumConta;
    private javax.swing.JTextField varNumero;
    private javax.swing.JTextField varNumeroConta;
    private javax.swing.JTextField varNumeroConta2;
    private javax.swing.JTextField varNumeroConta3;
    private javax.swing.JTextField varPais;
    private javax.swing.JFormattedTextField varRendaMensal;
    private javax.swing.JTextField varRg;
    private javax.swing.JTextField varRua;
    private javax.swing.JTextField varSaldo;
    private javax.swing.JTextField varSenha;
    private javax.swing.JFormattedTextField varTelefone;
    private javax.swing.JComboBox<String> varTipo;
    private javax.swing.JTextField varValorExtorno;
    private javax.swing.JFormattedTextField vardtaCriacao;
    // End of variables declaration//GEN-END:variables
}

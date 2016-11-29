/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate;

import Classes.ContaCorrenteComum;
import Classes.ContaCorrenteLimitada;
import Classes.ContaPoupanca;
import Classes.Transacao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.transaction.RollbackException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rafael
 */
public class ClasseDAO {

    private static final long serialVersionUID = 1L;
    private Session session;// = HibernateUtil.getSessionFactory().openSession();
    private Transaction transacao;

    public boolean cadastrar(Object a) {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Transaction tx = this.session.beginTransaction();
            this.session.save(a);
            tx.commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void atualizar(Object cliente) {

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transacao = this.session.beginTransaction();
            this.session.update(cliente);
            this.transacao.commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possível inserir o cliente. Erro: " + e.getMessage());
        } finally {
            try {
                if (this.session.isOpen()) {
                    this.session.close();
                }
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de inserção. Mensagem: " + e.getMessage());
            }
        }
    }

    public void modifica(Object obj) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            org.hibernate.Transaction tx = this.session.beginTransaction();
            this.session.update(obj);
            tx.commit();
            this.session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Houve um erro ao Efetuar a transação, tente novamente!", "", ERROR_MESSAGE);

        } finally {
            this.session.close();
        }
    }

    public List<Object> listarTudoA() {
        session.beginTransaction();
        return this.session.createCriteria(Object.class).list();
    }

    

    

    public List<Object> buscarEquipamento() {
        session.beginTransaction();
        return session.createCriteria(Object.class).list();
    }

    

    public List<Object> buscarAtivo() {
        session.beginTransaction();
        Criteria cri = session.createCriteria(Object.class)
                .add(Restrictions.eq("ativo", true));
        return (List<Object>) cri.list();
    }

    public ArrayList<Transacao> buscaExtrato(long id) {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            Criteria cri = (Criteria) session.createCriteria(Transacao.class)
                    .add(Restrictions.eq("cliente_id", id)).list();
            return (ArrayList<Transacao>) cri;
        } catch (HibernateException e) {
            return null;
        } finally {
            this.session.close();
        }
    }
    

    public Object procuraConta(Object obj, String numero, String agencia) {
        session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        try {
            if (obj instanceof ContaPoupanca) {
                Criteria cri = session.createCriteria(ContaPoupanca.class)
                        .add(Restrictions.eq("numero", numero));
                cri.add(Restrictions.eq("agencia", agencia));
                return (Object) cri.uniqueResult();
            } else if (obj instanceof ContaCorrenteComum) {
                Criteria cri = session.createCriteria(ContaCorrenteComum.class)
                        .add(Restrictions.eq("numero", numero));
                cri.add(Restrictions.eq("agencia", agencia));
                return (Object) cri.uniqueResult();
            } else if (obj instanceof ContaCorrenteLimitada) {
                Criteria cri = session.createCriteria(ContaCorrenteLimitada.class)
                        .add(Restrictions.eq("numero", numero))
                        .add(Restrictions.eq("agencia", agencia));
                return (Object) cri.uniqueResult();
            }
        } catch (TransactionException e) {
            return null;
        } catch (AbstractMethodError e) {
            return null;
        } catch (HibernateException e) {
            return null;
        } finally {
            this.session.close();
        }
        return null;
    }

    public ContaPoupanca procuraCp(String numero) {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            Criteria cri = session.createCriteria(ContaPoupanca.class)
                    .add(Restrictions.eq("numero", numero));

            return (ContaPoupanca) cri.uniqueResult();
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Deu Ruim");
            return null;
        } finally {
            session.close();
        }
    }   
}

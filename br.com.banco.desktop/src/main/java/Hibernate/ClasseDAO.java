/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate;

import Classes.ContaCorrenteComum;
import Classes.ContaCorrenteLimitada;
import Classes.ContaPoupanca;
import java.util.List;
import javax.swing.JOptionPane;
import javax.transaction.RollbackException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.TransactionException;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rafael
 */
public class ClasseDAO {

    private static final long serialVersionUID = 1L;
    private Session session = HibernateUtil.getSessionFactory().openSession();

    public boolean cadastrar(Object a) {
        try {
            org.hibernate.Transaction tx = this.session.beginTransaction();
            this.session.save(a);
            tx.commit();
            //session.close();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void alterarAluno(Object a) {
        try {
            org.hibernate.Transaction tx = this.session.beginTransaction();
            this.session.update(a);
            tx.commit();
            this.session.close();
        } catch (HibernateException erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro contate o Suporte");
        }
    }

    public void alteraEquipamento(Object eq) {
        try {
            org.hibernate.Transaction tx = this.session.beginTransaction();
            this.session.update(eq);
            tx.commit();
            this.session.close();
        } catch (HibernateException err) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro contate o Suporte");
        }
    }

    public void alterarAtendente(Object a) {
        try {
            org.hibernate.Transaction tx = this.session.beginTransaction();
            this.session.update(a);
            tx.commit();
            session.close();
        } catch (HibernateException erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro contate o suporte");
        }
    }

    public void alterarAdministrador(Object a) {
        try {
            org.hibernate.Transaction tx = this.session.beginTransaction();
            this.session.update(a);
            tx.commit();
            session.close();
        } catch (HibernateException erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro contate o suporte");
        }
    }

    public void alterarPersonal(Object a) {
        try {
            org.hibernate.Transaction tx = this.session.beginTransaction();
            this.session.update(a);
            tx.commit();
            session.close();
        } catch (HibernateException erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro contate o suporte");
        }
    }

    public void excluirAluno(Object a) throws RollbackException {
        org.hibernate.Transaction tx = this.session.beginTransaction();
        this.session.delete(a);
        tx.commit();
        session.close();
    }

    public Object procura(Long id, Object ob) {
        return (Object) this.session.load(Object.class, id);
    }

    public Object procura(String nome) {
        return (Object) this.session.load(Object.class, nome);
    }

    public List<Object> listaTudo() {
        return this.session.createCriteria(
                Object.class).list();
    }

    public List<Object> listaTudoP() {
        return this.session.createCriteria(
                Object.class).list();
    }

    public List<Object> listaTudoL() {
        session.beginTransaction();
        return this.session.createCriteria(Object.class).list();
    }

    public List<Object> listarTudoG() {
        session.beginTransaction();
        return this.session.createCriteria(Object.class).list();
    }

    public List<Object> listarTudoA() {
        session.beginTransaction();
        return this.session.createCriteria(Object.class).list();
    }

    public Object buscarNomeEquipamento(String nome) {
        session.beginTransaction();
        Criteria cri = session.createCriteria(Object.class)
                .add(Restrictions.eq("nomeequip", nome));
        return (Object) cri.uniqueResult();
    }

    public Object buscaCodEqui(String cod) {
        session.beginTransaction();
        Criteria cri = session.createCriteria(Object.class)
                .add(Restrictions.eq("idEquipamento", cod));
        return (Object) cri.uniqueResult();
    }

    public List<Object> buscarEquipamento() {
        session.beginTransaction();
        return session.createCriteria(Object.class).list();
    }

    public Object bucar(String nome) {
        try {
            session.beginTransaction();
            Criteria cri = session.createCriteria(Object.class)
                    .add(Restrictions.eq("nome", nome));
            return (Object) cri.uniqueResult();
        } catch (HibernateException erro) {
            JOptionPane.showMessageDialog(null, "Houve um Erro contate o suporte");
            return null;
        }
    }

    public List<Object> buscarAtivo() {
        session.beginTransaction();
        Criteria cri = session.createCriteria(Object.class)
                .add(Restrictions.eq("ativo", true));
        return (List<Object>) cri.list();
    }

    public Object procuraConta(Object obj, String numero, String agencia) {
        session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        try{
        if (obj instanceof ContaPoupanca) {
            Criteria cri = session.createCriteria(ContaPoupanca.class)
                    .add(Restrictions.eq("numero", numero));
            cri.add(Restrictions.eq("agencia", agencia));
            //session.close();
            return (Object) cri.uniqueResult();
        } else if(obj instanceof ContaCorrenteComum) {
            Criteria cri = session.createCriteria(ContaCorrenteComum.class)
                    .add(Restrictions.eq("numero", numero));
            cri.add(Restrictions.eq("agencia", agencia));
            //session.close();
            return (Object) cri.uniqueResult();
        } else if(obj instanceof ContaCorrenteLimitada) {
            Criteria cri = session.createCriteria(ContaCorrenteLimitada.class)
                    .add(Restrictions.eq("numero", numero))
                    .add(Restrictions.eq("agencia", agencia));
            //session.close();
            return (Object) cri.uniqueResult();
        }
        }catch(TransactionException  e) {
            return null;
        }catch(AbstractMethodError e) {
            return null;
        }catch(HibernateException e) {
            return null;
        }
        return null;
    }
    
    public ContaPoupanca procuraCp(String numero) {
        Criteria cri = session.createCriteria(ContaPoupanca.class)
                    .add(Restrictions.eq("numero", numero));
            //session.close();
            return (ContaPoupanca) cri.uniqueResult();
    }

    public Object procuraLogin(String nome) {
        session.beginTransaction();
        Criteria cri = session.createCriteria(Object.class)
                .add(Restrictions.eq("login", nome));
        return (Object) cri.uniqueResult();
    }

    public Object procuraId(String id) {
        session.beginTransaction();
        Criteria cri = session.createCriteria(Object.class)
                .add(Restrictions.eq("codFunc", id));
        return (Object) cri.uniqueResult();
    }

    public Object procuraNomeA(String nome) {
        session.beginTransaction();
        Criteria cri = session.createCriteria(Object.class)
                .add(Restrictions.eq("nome", nome));
        return (Object) cri.uniqueResult();
    }

    public Object procuraIdA(String id) {
        session.beginTransaction();
        Criteria cri = session.createCriteria(Object.class)
                .add(Restrictions.eq("codFunc", id));
        return (Object) cri.uniqueResult();
    }

    public Object procuraNomeP(String nome) {
        this.session.beginTransaction();
        Criteria cri = session.createCriteria(Object.class)
                .add(Restrictions.eq("nome", nome));
        return (Object) cri.uniqueResult();
    }

    public Object procuraIdP(String id) {
        session.beginTransaction();
        Criteria cri = session.createCriteria(Object.class)
                .add(Restrictions.eq("codFunc", id));
        return (Object) cri.uniqueResult();

    }
}

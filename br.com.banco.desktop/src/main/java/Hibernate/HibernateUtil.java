package Hibernate;


import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import Classes.*;
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static SessionFactory buildSessionFactory(){    
        try {
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");   
            cfg.addAnnotatedClass(Cliente.class);
            cfg.addAnnotatedClass(Conta.class);
            cfg.addAnnotatedClass(ContaCorrenteComum.class);
            cfg.addAnnotatedClass(ContaCorrenteLimitada.class);
            cfg.addAnnotatedClass(ContaPoupanca.class);
            cfg.addAnnotatedClass(Conta.class);
            cfg.addAnnotatedClass(Deposito.class);
            cfg.addAnnotatedClass(Endereco.class);
            cfg.addAnnotatedClass(Extrato.class);
            cfg.addAnnotatedClass(Pessoa.class);
            
            StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
            sb.applySettings(cfg.getProperties());
            StandardServiceRegistry standardServiceRegistry = sb.build();                   
            return cfg.buildSessionFactory(standardServiceRegistry);              
        }catch(HibernateException e) {
            throw new ExceptionInInitializerError(e);
        } catch (Throwable th) {
                System.err.println("Criação inicial do objeto SessionFactory falhou" + th);
                throw new ExceptionInInitializerError(th);
        } 
    }
    public static SessionFactory getSessionFactory() {
            return sessionFactory;
    }
    
}

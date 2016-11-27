package Hibernate;

import Classes.*;

/*public class GeraTabelas implements Serializable{

    private static final long serialVersionUID = -2L;

    public static void main(String[] args) {*/
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GeraTabelas {

    public static void main(String[] args) {
        Configuration conf = new AnnotationConfiguration();
        conf.configure();
        conf.addAnnotatedClass(Pessoa.class);
        conf.addAnnotatedClass(Cliente.class);
        conf.addAnnotatedClass(Conta.class);
        conf.addAnnotatedClass(ContaCorrenteComum.class);
        conf.addAnnotatedClass(ContaCorrenteLimitada.class);
        conf.addAnnotatedClass(ContaPoupanca.class);
        //conf.addAnnotatedClass(Deposito.class);
        conf.addAnnotatedClass(Endereco.class);
        conf.addAnnotatedClass(Transacao.class);
        
        SchemaExport se = new SchemaExport(conf);
        se.create(true, true);
    }
}
// Cria uma configuracao para a classe Produto
/*EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("postgres");
		
        /*Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Cliente.class);
        cfg.addAnnotatedClass(Conta.class);
        cfg.addAnnotatedClass(ContaCorrenteComum.class);
        cfg.addAnnotatedClass(ContaCorrenteLimitada.class);
        cfg.addAnnotatedClass(ContaPoupanca.class);
        cfg.addAnnotatedClass(Transacao.class);
        cfg.addAnnotatedClass(Pessoa.class);
        cfg.addAnnotatedClass(Deposito.class);
        cfg.addAnnotatedClass(Endereco.class);
        cfg.addAnnotatedClass(Transacao.class);
        
        
        /*cfg.addAnnotatedClass(Mensalidade.class);
        cfg.addAnnotatedClass(Exercicio.class);
        cfg.addAnnotatedClass(Exercicios.class);*/
//cfg.addAnnotatedClass(Exercicio.class); 
//cfg.addAnnotatedClass(Treino.class);
//cfg.addAnnotatedClass(ExercicioTreino.class);
//cfg.addAnnotatedClass(Login2.class);
//..poderia adicionar outras classes...
/*SchemaExport schemaExport = new SchemaExport(cfg);
        schemaExport.create(true,true);
        factory.close();

}
}*/

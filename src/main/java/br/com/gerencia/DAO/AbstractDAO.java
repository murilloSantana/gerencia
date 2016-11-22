package br.com.gerencia.DAO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.Work;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDAO<PK extends Serializable, T> {

	private final Class<T> classePersistente;
	@Autowired
	private SessionFactory sessionFactory;



	@SuppressWarnings("unchecked")
	public AbstractDAO() {
		this.classePersistente = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}


	protected Session getSession() {

		sessionFactory.getCurrentSession().doWork(new Work() {

			public void execute(Connection connection) throws SQLException {
				connection.setSchema("public");
			}
		});
		return sessionFactory.getCurrentSession();
	}

	public void login() {

	}


	public Boolean salvar(T obj) {
		try {
			getSession().persist(obj);
			gerarTabelas();

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean editar(T obj) {
		try {
			getSession().update(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean excluir(T obj) {
		try {
			getSession().delete(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean excluirPorChave(Long chave) {
		try {
			excluir(pesquisarPorChave(chave));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	protected List<?> listarTodos() {
		return getSession().createCriteria(this.classePersistente).list();
	}

	@SuppressWarnings("unchecked")
	public T pesquisarPorChave(Long chave) {
		return (T) getSession().get(this.classePersistente, chave);
	}

	public List<?> pesquisarPorNome(String nomeAtributo, String valor) {
		Criteria crit = getSession().createCriteria(this.classePersistente);
		crit.add(Restrictions.eq(nomeAtributo, valor));
		return crit.list();
	}

	public Object pesquisarConta(String valor) {
		Criteria crit = getSession().createCriteria(this.classePersistente);
		crit.add(Restrictions.eq("username", valor));
		return crit.uniqueResult();
	}

	public void gerarTabelas() {
		 Configuration cfg = new Configuration();
		 SchemaExport export = new SchemaExport(cfg);
		 export.setOutputFile("C:\\Users\\atsoc\\Documents\\query.sql");
		 export.execute(true, false, false, true);
	}
}

package br.com.gerencia.DAO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
@SuppressWarnings("unchecked")
public abstract class DefaultAbstractDAO<PK extends Serializable, T > {

	private final Class<T> classePersistente;
	@Autowired
	private SessionFactory sfDefault;

	public DefaultAbstractDAO() {
		this.classePersistente = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	protected Session getSessionDefault() {

		sfDefault.getCurrentSession().doWork(new Work() {

			public void execute(Connection connection) throws SQLException {
				connection.setSchema("schema_conta");
			}
		});
		return sfDefault.getCurrentSession();

	}

	public Boolean salvarDefault(T obj){
		try {
			getSessionDefault().persist(obj);

			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Boolean editarDefault(T obj) {
		try {
			getSessionDefault().update(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean excluirDefault(T obj) {
		try {
			getSessionDefault().delete(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean excluirPorChaveDefault(Long chave) {
		try {
			excluirDefault(pesquisarPorChaveDefault(chave));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	protected List<?> listarTodosDefault() {
		return getSessionDefault().createCriteria(this.classePersistente).list();
	}

	public T pesquisarPorChaveDefault(Long chave) {
		return (T) getSessionDefault().get(this.classePersistente, chave);
	}

	public List<?> pesquisarPorNomeDefault(String nomeAtributo, String valor) {
		Criteria crit = getSessionDefault().createCriteria(this.classePersistente);
		crit.add(Restrictions.eq(nomeAtributo, valor));
		return crit.list();
	}

	public Object pesquisarContaDefault(String valor) {
		Criteria crit = getSessionDefault().createCriteria(this.classePersistente);
		crit.add(Restrictions.eq("username", valor));
		return crit.uniqueResult();
	}

}

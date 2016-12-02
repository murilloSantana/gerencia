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

import br.com.gerencia.model.ContaUsuario;

public abstract class AbstractDAO<PK extends Serializable, T> extends DefaultAbstractDAO<Serializable, T> {

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
				connection.setSchema(getSchema());
			}
		});
		return sessionFactory.getCurrentSession();
	}
	public String getSchema(){
		Criteria criteria =  super.getSessionDefault().createCriteria(ContaUsuario.class);
		criteria.add(Restrictions.eq("username", "atsoc"));
		ContaUsuario conta = (ContaUsuario) criteria.uniqueResult();
		
		return conta.getSchema();
	}
	public void login() {

	}

	public Boolean salvar(T obj) {
		try {
			getSession().merge(obj);
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
		try {
			return getSession().createCriteria(this.classePersistente).list();
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public T pesquisarPorChave(Long chave) {
		return (T) getSession().get(this.classePersistente, chave);
	}

	public List<?> pesquisarPorNome(String nomeAtributo, String valor) {
		Criteria crit = null;
		try {
			crit = getSession().createCriteria(this.classePersistente);
			crit.add(Restrictions.eq(nomeAtributo, valor));
		} catch (Exception e) {
		}
		return crit.list();
	}

	public List<?> pesquisarPorNome(String nomeAtributo, Integer valor) {
		Criteria crit = null;
		try {
			crit = getSession().createCriteria(this.classePersistente);
			crit.add(Restrictions.eq(nomeAtributo, valor));
		} catch (Exception e) {
		}
		return crit.list();
	}
	
	public List<?> pesquisarPorNome(String nomeAtributo, Long valor) {
		Criteria crit = null;
		try {
			crit = getSession().createCriteria(this.classePersistente);
			crit.add(Restrictions.eq(nomeAtributo, valor));
		} catch (Exception e) {
		}
		return crit.list();
	}
	
	public Object pesquisarConta(String valor) {
		Criteria crit = getSession().createCriteria(this.classePersistente);
		crit.add(Restrictions.eq("username", valor));
		return crit.uniqueResult();
	}

}

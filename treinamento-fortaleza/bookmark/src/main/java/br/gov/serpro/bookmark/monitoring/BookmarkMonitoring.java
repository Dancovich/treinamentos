package br.gov.serpro.bookmark.monitoring;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import br.gov.frameworkdemoiselle.monitoring.stereotype.MBean;
import br.gov.frameworkdemoiselle.util.Beans;
import br.gov.serpro.bookmark.domain.Bookmark;

@MBean
public class BookmarkMonitoring implements BookmarkMonitoringMBean {

	@PersistenceContext(name="bookmark-ds")
	private EntityManager entityManager;
	
	@Override
	public int getQuantidadeBookmarksCadastrados(){
		
		Query query = entityManager.createQuery("select count(*) from Bookmark");
		Number qtdBookmarks = (Number)query.getSingleResult();
		
		return qtdBookmarks.intValue();
	}
	
	public void cadastrarNovoBookmark(String descricao , String link){
		Bookmark bookmark = new Bookmark(descricao , link);
		
		UserTransaction transaction = Beans.getReference(UserTransaction.class);
		
		try{
			//entityManager.getTransaction().begin();
			transaction.begin();
			
			entityManager.persist(bookmark);
			entityManager.flush();
			
			//entityManager.getTransaction().commit();
			transaction.commit();
		}
		catch(Throwable t){
			throw new RuntimeException("Não foi possível cadastrar um novo bookmark",t);
		}

	}

}

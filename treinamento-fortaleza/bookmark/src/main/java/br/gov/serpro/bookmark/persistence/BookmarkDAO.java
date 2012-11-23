package br.gov.serpro.bookmark.persistence;

import javax.annotation.PostConstruct;
import javax.persistence.FlushModeType;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.gov.serpro.bookmark.domain.Bookmark;

@PersistenceController
public class BookmarkDAO extends JPACrud<Bookmark, Long> {
	
	private static final long serialVersionUID = 1L;
	
	@PostConstruct
	public void setUp(){
		getEntityManager().setFlushMode(FlushModeType.COMMIT);
	}
	
	/*@PersistenceContext(name="bookmark-ds")
	private EntityManager entityManager;

	@Override
	protected EntityManager getEntityManager() {
		return this.entityManager;
	}*/
	
}

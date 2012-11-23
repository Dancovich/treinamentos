package br.gov.serpro.bookmark.ejb;

import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.serpro.bookmark.business.BookmarkBC;
import br.gov.serpro.bookmark.domain.Bookmark;

@WebService
public class BookmarkEJB {
	
	@Inject
	private BookmarkBC bookmarkBC;
	
	@Inject
	private Logger logger;

	@Transactional
	public boolean createBookmark(@WebParam(name="description") String description , @WebParam(name="link")String link){
		Bookmark bookmark = new Bookmark(description , link);
		
		try{
			bookmarkBC.insert(bookmark);
			return true;
		}
		catch(Throwable t){
			logger.error("Falha ao cadastrar um bookmark", t);
			return false;
		}
	}

}

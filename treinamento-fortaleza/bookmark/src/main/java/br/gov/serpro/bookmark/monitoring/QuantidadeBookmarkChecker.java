package br.gov.serpro.bookmark.monitoring;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.gov.frameworkdemoiselle.monitoring.annotation.SNMP;
import br.gov.frameworkdemoiselle.monitoring.annotation.Scheduled;
import br.gov.frameworkdemoiselle.monitoring.stereotype.Checker;
import br.gov.frameworkdemoiselle.monitoring.trapping.SimpleTrapper;

@Checker
public class QuantidadeBookmarkChecker {
	
	@PersistenceContext(name="bookmark-ds")
	private EntityManager entityManager;
	
	@Inject
	@SNMP
	private SimpleTrapper simpleTrapper;
	
	@Scheduled(interval=30 , unit = TimeUnit.SECONDS)
	public void informarQuantidadeBookmarks(){
		Query query = entityManager.createQuery("select count(*) from Bookmark");
		Number qtdBookmarks = (Number)query.getSingleResult();
		
		simpleTrapper.send(qtdBookmarks.toString()+ " Bookmarks");
	}

}

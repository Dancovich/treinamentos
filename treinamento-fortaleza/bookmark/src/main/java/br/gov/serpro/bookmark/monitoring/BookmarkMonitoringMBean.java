package br.gov.serpro.bookmark.monitoring;

public interface BookmarkMonitoringMBean {

	public abstract int getQuantidadeBookmarksCadastrados();
	
	public void cadastrarNovoBookmark(String descricao , String link);

}
package br.gov.serpro.bookmark.monitoring;

public interface SNMPBookmarkMonitoringMBean {

	public abstract int getQuantidadeChamadas();

	public abstract void setQuantidadeChamadas(int quantidadeChamadas);

}
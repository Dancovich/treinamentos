package br.gov.serpro.bookmark.monitoring;

import br.gov.frameworkdemoiselle.monitoring.annotation.snmp.MIB;
import br.gov.frameworkdemoiselle.monitoring.annotation.snmp.OID;
import br.gov.frameworkdemoiselle.monitoring.annotation.snmp.access.ReadWrite;
import br.gov.frameworkdemoiselle.monitoring.stereotype.MBean;

@MBean
@MIB(".2")
public class SNMPBookmarkMonitoring implements SNMPBookmarkMonitoringMBean {
	
	@OID(".1")
	@ReadWrite
	private int quantidadeChamadas = 0;

	@Override
	public int getQuantidadeChamadas() {
		return quantidadeChamadas++;
	}

	@Override
	public void setQuantidadeChamadas(int quantidadeChamadas) {
		this.quantidadeChamadas = quantidadeChamadas;
	}
	
}

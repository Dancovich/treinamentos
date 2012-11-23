package br.gov.serpro.bookmark.monitoring;

import br.gov.frameworkdemoiselle.monitoring.annotation.SNMP;
import br.gov.frameworkdemoiselle.monitoring.annotation.snmp.type.OctetString;
import br.gov.frameworkdemoiselle.monitoring.stereotype.Trapper;

@Trapper
@SNMP
//@MIB(".1")
public class TrapBookmark {
	
	//@OID(".2")
	public void avisarBookmarkCriado(@OctetString String mensagem,@OctetString String bookmark){
	}

}

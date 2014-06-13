package com.ws.model.entidade;

import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@IdClass(EmpresaProtocoloId.class)
@Table(name="\"many_Protocolo_has_many_Empresa\"", schema="public")
public class EmpresaProtocolo implements java.io.Serializable {
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_protocolo")
	private Protocolo protocolo;
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_empresa")
	private Empresa empresa;
	
	@Temporal(TemporalType.DATE)
	private Date dataAbertura;

	public Protocolo getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(Protocolo protocolo) {
		this.protocolo = protocolo;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa idEmpresa) {
		this.empresa = empresa;
	}
		
}

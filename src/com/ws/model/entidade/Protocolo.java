package com.ws.model.entidade;

import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="\"Protocolo\"", schema="public")
public class Protocolo implements java.io.Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_protocolo")
	private Integer idProtocolo;
	
	@Column(name="\"dados_protocolo\"")
	private String dadosProtocolo;
	
	@Column(name="\"id_usuario_Usuario\"")
	private Integer idUsuario;
	
	@OneToMany(mappedBy = "protocolo")
	private List<EmpresaProtocolo> empresas;

	public Integer getIdProtocolo() {
		return idProtocolo;
	}

	public void setIdProtocolo(Integer idProtocolo) {
		this.idProtocolo = idProtocolo;

	}

	public String getDadosProtocolo() {
		return dadosProtocolo;
	}

	public void setDadosProtocolo(String dadosProtocolo) {
		this.dadosProtocolo = dadosProtocolo;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
		
}

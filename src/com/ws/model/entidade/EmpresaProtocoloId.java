package com.ws.model.entidade;

import java.io.Serializable;

public class EmpresaProtocoloId implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    private int protocolo;
    private int empresa;
 
    public int getProtocolo() {
        return protocolo;
    }
 
    public void setProtocolo(int protocolo) {
        this.protocolo = protocolo;
    }
 
    public int getEmpresa() {
        return empresa;
    }
 
    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }
 
    @Override
    public int hashCode() {
        return protocolo + empresa;
    }
 
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof EmpresaProtocoloId){
            EmpresaProtocoloId protocoloEmpresaId = (EmpresaProtocoloId) obj;
            return protocoloEmpresaId.empresa == empresa && protocoloEmpresaId.protocolo == protocolo;
        }
 
        return false;
    }
}
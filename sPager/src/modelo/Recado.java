/*
 * 
 */
package modelo;

import java.io.Serializable;

/**
 * @author tuler
 */
public class Recado implements Serializable{
    private int codigo;
    private Pessoa remetente;
    private Pessoa destinatario;
    private String mensagem;
    private boolean visualizacao;

    public Recado() {}

    public Recado(Pessoa remetente, Pessoa destinatario, String mensagem) {
        this.codigo = 0;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.mensagem = mensagem;
        this.visualizacao = false;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Pessoa getRemetente() {
        return remetente;
    }

    public void setRemetente(Pessoa remetente) {
        this.remetente = remetente;
    }

    public Pessoa getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Pessoa destinatario) {
        this.destinatario = destinatario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isVisualizacao() {
        return visualizacao;
    }

    public void setVisualizacao(boolean visualizacao) {
        this.visualizacao = visualizacao;
    }

    @Override
    public String toString() {
        return "Recado{" + "remetente=" + remetente.getNome() + ", mensagem=" + mensagem + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Recado other = (Recado) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }
}

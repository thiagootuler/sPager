/*
 * 
 */
package modelo;

import controle.AcessoException;
import controle.ManutencaoException;
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

    public Recado(Pessoa remetente, Pessoa destinatario, String mensagem) throws ManutencaoException, AcessoException {
        setCodigo();
        setRemetente(remetente);
        setDestinatario(destinatario);
        setMensagem(mensagem);
        setVisualizacao();
    }
    
    public int getCodigo() {
        return codigo;
    }

    public Pessoa getRemetente() {
        return remetente;
    }

    public Pessoa getDestinatario() {
        return destinatario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public boolean isVisualizacao() {
        return visualizacao;
    }

    private void setCodigo() {
        this.codigo = 0;
    }
    
    protected void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    private void setRemetente(Pessoa remetente) throws ManutencaoException, AcessoException {
        if(!DAOPessoa.isUsuario(remetente))
            throw new ManutencaoException("Remetente inexistente");
        else    
            this.remetente = remetente;
    }
    
    private void setDestinatario(Pessoa destinatario) throws ManutencaoException, AcessoException {
        if(!DAOPessoa.isUsuario(destinatario))
            throw new ManutencaoException("Destinatário inexistente!");
        else if(remetente.equals(destinatario))
            throw new ManutencaoException("Remetente e destinatário idênticos!");
        else
            this.destinatario = destinatario;
    }
    
    private void setMensagem(String mensagem) throws ManutencaoException {
        if(mensagem.equals(""))
            throw new ManutencaoException("Campo nao informado!");
        else 
            this.mensagem = mensagem;
    }
    
    private void setVisualizacao() {
        this.visualizacao = false;
    }
            
    private void setVisualizacao(boolean visualizacao) {
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

/*
 * 
 */
package modelo;

import controle.ManutencaoException;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author tuler
 */
public class Situacao implements Serializable{
    private Pessoa pessoa;
    private String atividade;
    private boolean disponibilidade;

    public Situacao() {}

    public Pessoa getPessoa() {
        return pessoa;
    }

    public String getAtividade() {
        return atividade;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }
    
    protected void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    protected void setAtividade(String atividade) throws ManutencaoException {
        if(atividade.equals("")){
            throw new ManutencaoException("Campo não informado!");}
        else
            this.atividade = atividade;
    }
    
    protected void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    @Override
    public String toString() {
        return "Situacao{" + "pessoa=" + pessoa.getNome() + ", atividade=" + atividade + ", disponibilidade=" + disponibilidade + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.pessoa);
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
        final Situacao other = (Situacao) obj;
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        return true;
    }
}

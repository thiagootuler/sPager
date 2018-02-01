/*
 * 
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author tuler
 */
public class Pessoa implements Serializable{
    private String nome;
    private String email;
    private String usuario;
    private String senha;
    private Situacao situacao;

    public Pessoa() {}

    public Pessoa(String nome, String email, String usuario, String senha) {
        this.nome = nome;
        this.email = email;
        this.usuario = usuario;
        this.senha = senha;
        this.situacao = new Situacao();
        setSituacao("Conhecendo o sistema...", true);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public final void setSituacao(String atividade, boolean disponibilidade){
        this.situacao.setPessoa(this);
        this.situacao.setAtividade(atividade);
        this.situacao.setDisponibilidade(disponibilidade);
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", email=" + email + ", usuario=" + usuario + ", senha=" + senha + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.usuario);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }
}

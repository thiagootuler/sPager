/*
 * 
 */
package modelo;

import controle.AcessoException;
import controle.ManutencaoException;
import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tuler
 */
public final class Pessoa implements Serializable{
    private String nome;
    private String email;
    private String usuario;
    private String senha;
    private Situacao situacao;

    public Pessoa() {}

    public Pessoa(String nome, String email, String usuario, String senha) throws ManutencaoException, AcessoException {
        setNome(nome);
        setEmail(email);
        setUsuario(usuario);
        setSenha(senha);
        setSituacao();
    }

    public String getNome() {
        return nome;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getUsuario() {
        return usuario;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public Situacao getSituacao() {
        return situacao;
    }
    
    private void setNome(String nome) throws ManutencaoException {
        if(nome.equals(""))
            throw new ManutencaoException("Campo não informado!");
        else
            this.nome = nome;
    }
    
    private void setEmail(String email) throws ManutencaoException {
        if(email.equals(""))
            throw new ManutencaoException("Campo não informado!");
        else if(!isEmailValid(email))
            throw new ManutencaoException("Email inválido!");
        else
            this.email = email;
    }

    private void setUsuario(String usuario) throws ManutencaoException, AcessoException {
        if(usuario.equals(""))
            throw new ManutencaoException("Campo não informado!");
        else if(DAOPessoa.isUsuario(this))
            throw new ManutencaoException("Usuario ja cadastrado!");
        else
            this.usuario = usuario;
    }

    private void setSenha(String senha) throws ManutencaoException {
        if(senha.equals(""))
            throw new ManutencaoException("Campo não informado!");
        else
            this.senha = senha;
    }
    
    public void setSituacao() throws ManutencaoException{
        this.situacao = new Situacao();
        setSituacao("Conhecendo o sistema...", true);
    }

    public void setSituacao(String atividade, boolean disponibilidade) throws ManutencaoException{
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
    
    public boolean isEmailValid(String email){
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}

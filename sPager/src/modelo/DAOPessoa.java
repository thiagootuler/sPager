/*
 * 
 */
package modelo;

import controle.AcessoException;
import controle.ManutencaoException;
import java.util.List;

/**
 * @author tuler
 */
public class DAOPessoa {

    public DAOPessoa() {}
    
    public static List<Pessoa> getLista() throws AcessoException {
        if(Dados.pessoas!=null)
            return Dados.pessoas;
        else
            throw new AcessoException("Sem usuários cadastrados!");
    }
    
    public static Pessoa procurar(String usuario) throws AcessoException {
        //return Dados.pessoas.indexOf(pessoa);
        for(Pessoa pessoa: DAOPessoa.getLista())
            if(pessoa.getUsuario().equals(usuario))
                return pessoa;
        return null;
    }
    
    public static boolean isUsuario(Pessoa pessoa) throws AcessoException {
        return procurar(pessoa.getUsuario()) != null;
    }
    
    public static void cadastrar(Pessoa pessoa) throws AcessoException, ManutencaoException {
        if(!isUsuario(pessoa))
            Dados.pessoas.add(pessoa);
        else
            throw new ManutencaoException("Usuário já cadastrado!");
    }
    
    public static void alterar(String nome, String email, String usuario, String senha) throws ManutencaoException, AcessoException{
        Pessoa pessoa = procurar(usuario);
        int index = Dados.pessoas.indexOf(pessoa);
        if(index != -1){
            pessoa.setNome(nome);
            pessoa.setEmail(email);
            pessoa.setSenha(senha);
            Dados.pessoas.set(index, pessoa);
        }else{
            throw new ManutencaoException("Usuário não cadastrado");
        }
    }
    
    public static void remover(Pessoa pessoa) throws ManutencaoException {
        int index = Dados.pessoas.indexOf(pessoa);
        if(index != -1)
            Dados.pessoas.remove(pessoa);
        else
            throw new ManutencaoException("Usuário ainda não cadastrado");
    }
}

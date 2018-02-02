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
    
    public static boolean isUsuario(Pessoa pessoa_p) throws AcessoException {
        for(Pessoa pessoa_e: DAOPessoa.getLista())
            if(pessoa_e.equals(pessoa_p))
                return true;
        return false;
    }
    
    public static void cadastrar(Pessoa pessoa) throws AcessoException, ManutencaoException {
        if(!isUsuario(pessoa))
            Dados.pessoas.add(pessoa);
        else
            throw new ManutencaoException("Usuário já cadastrado!");
    }
    
    public boolean remover(Pessoa pessoa) {
        Dados.pessoas.remove(pessoa);
        return true;
    }
}

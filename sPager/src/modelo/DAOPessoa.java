/*
 * 
 */
package modelo;

import java.util.List;

/**
 * @author tuler
 */
public class DAOPessoa {

    public DAOPessoa() {}
    
    public List<Pessoa> getLista() {
        return Dados.pessoas;
    }
    
    public static boolean isUsuario(Pessoa pessoa_p) {
        if(Dados.pessoas!=null){
            for(Pessoa pessoa_e: Dados.pessoas){
                if(pessoa_e.equals(pessoa_p)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean salvar(Pessoa pessoa) {
        if(!isUsuario(pessoa))
            Dados.pessoas.add(pessoa);
        return true;
    }
    
    public boolean remover(Pessoa pessoa) {
        Dados.pessoas.remove(pessoa);
        return true;
    }
}

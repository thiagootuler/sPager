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
public class DAORecado {

    public DAORecado() {}
    
    public static List<Recado> getLista() throws AcessoException {
        if(Dados.recados!=null)
            return Dados.recados;
        else
            throw new AcessoException("Sem recados submetidos!");
    }
    
    public static void cadastrar(Recado recado_p) throws ManutencaoException, AcessoException {
        if(recado_p.getCodigo() <= 0){
            Integer codigo = Dados.recados.size() + 1;
            recado_p.setCodigo(codigo);
            Dados.recados.add(recado_p);
        }else{
            for(Recado recado_e: DAORecado.getLista())
                if(recado_e.equals(recado_p))
                    throw new ManutencaoException("O recado não pode ser sobrescrito!");
                else
                    Dados.recados.add(recado_p);
        }
    }
    
    public boolean remover(Recado recado) {
        Dados.recados.remove(recado);
        return true;
    }
}

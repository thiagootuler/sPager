/*
 * 
 */
package modelo;

import java.util.List;

/**
 * @author tuler
 */
public class DAORecado {

    public DAORecado() {}
    
    public List<Recado> getLista() {
        return Dados.recados;
    }
    
    public static boolean salvar(Recado recado) {
        if(recado.getCodigo() == 0){
            Integer codigo = Dados.recados.size() + 1;
            recado.setCodigo(codigo);
            Dados.recados.add(recado);
        }
        return true;
    }
    
    public boolean remover(Recado recado) {
        Dados.recados.remove(recado);
        return true;
    }
}

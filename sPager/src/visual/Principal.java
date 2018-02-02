package visual;

/*
 * 
 */

import controle.AcessoException;
import controle.ManutencaoException;
import modelo.DAOPessoa;
import modelo.DAORecado;
import modelo.Dados;
import modelo.Pessoa;
import modelo.Recado;

/**
 * @author tuler
 */
public class Principal {
    static public void testeClasses(){
        try{
            DAOPessoa.cadastrar(new Pessoa("João Souza","joao@mail.com","joao","123"));
            DAOPessoa.cadastrar(new Pessoa("Maria da Silva","maria@mail.com","maria","222"));
            DAOPessoa.cadastrar(new Pessoa("José Alves","jose@mail.com","jose","321"));
            
            Dados.pessoas.get(0).setSituacao("Viajando",true);
            Dados.pessoas.get(1).setSituacao("Em reuniao",false);
            
            DAORecado.cadastrar(new Recado(Dados.pessoas.get(0), Dados.pessoas.get(1), "Mensagem de teste 1"));
        }catch(AcessoException | ManutencaoException e){
            System.err.println(e.getMessage());
        }
        for(Pessoa pessoa: Dados.pessoas)
            System.out.println(pessoa.toString());
        System.out.println("");
        for(Pessoa pessoa: Dados.pessoas)
            System.out.println(pessoa.getSituacao().toString());
        System.out.println("");
        for(Recado recado:Dados.recados)
            System.out.println(recado.toString());
    }
    
    public static void main(String[] args) {
        testeClasses();
    }
}

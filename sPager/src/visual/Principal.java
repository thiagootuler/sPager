package visual;

/*
 * 
 */


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
        DAOPessoa.salvar(new Pessoa("Joao Souza","joao@mail.com","joao","123"));
        DAOPessoa.salvar(new Pessoa("Maria da Silva","maria@mail.com","maria","222"));
        DAOPessoa.salvar(new Pessoa("Jose Alves","jose@mail.com","jose","321"));
        for(Pessoa pessoa: Dados.pessoas)
            System.out.println(pessoa.toString());
        System.out.println("");
        Dados.pessoas.get(0).setSituacao("Viajando",true);
        Dados.pessoas.get(1).setSituacao("Em reuniao",false);
        for(Pessoa pessoa: Dados.pessoas)
            System.out.println(pessoa.getSituacao().toString());
        System.out.println("");
        DAORecado.salvar(new Recado(Dados.pessoas.get(0), Dados.pessoas.get(1), "Mensagem de teste 1"));
        for(Recado recado:Dados.recados)
            System.out.println(recado.toString());
    }
    
    public static void main(String[] args) {
        testeClasses();
    }
}

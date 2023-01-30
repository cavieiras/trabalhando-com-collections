package lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Dadas as seguintes informações sobre meus gatos, crie uma lista e
ordene esta lista exibindo:
(nome - idade - cor);

Gato 1 = nome: Tatu, idade: 11, cor: tigrado
Gato 2 = nome: Lil, idade: 10, cor: frajola
Gato 3 = nome: Katarina, idade: 3.5, cor: branca/cinza
*/

public class OrdenaçãoElementos {
    public static void main(String[] args) {

        //primeiro criar uma classe gato que terá os atributos necessários
        class Gato implements Comparable<Gato> {
            private String nome;  
            private Integer idade;
            private String cor;
            //o tipo _private_ quer dizer que esses atributos
            //estaram visíveis dentro desta classe apenas

            //aqui cria-se um _construtor_ (constrói um objeto a partir
            //da classe, neste caso, a classe gato)

            public Gato (String nome, Integer idade, String cor) {
                this.nome = nome;
                this.idade = idade;
                this.cor = cor;

                //this.variável é uma maneira de preencher as variáveis da
                //classe, utilizando o construtor.
            }

            //função getVariável()
            //é como se fosse um segundo construtor que se utiliza do
            //primeiro construtor que está dentro da MESMA CLASSE

            public String getNome() {
                return nome;
            }
            public Integer getIdade() {
                return idade;
            }
            public String getCor() {
                return cor;
            }

            @Override
            public String toString() {
                return "{" + "nome = " + nome + '\'' + 
            ", idade = " + idade + '\'' + ", cor = " + cor + '\''
            + '}';
            }

            @Override
            public int compareTo(Gato gato) {
                return this.getNome().compareToIgnoreCase(gato.getNome());

                //ao utilizar o getNome().compareToIgnoreCase (gato.getNome())
                //vai retornar um int;
                //se int == 0, então o resultado nome é igual para ambos os gatos
                // se int == 1, fica depois do nome que estou comparando
                //se int == -1, fica antes do nome que se está comparando
            }
             
            }
        
        //criação do Comparator para Idade
        class ComparatorIdade implements Comparator<Gato> {
            @Override
            public int compare(Gato g1, Gato g2) {
    
                return Integer.compare(g1.getIdade(),g2.getIdade());
            }
        }
        //criação do Comparator para Cor
        class ComparatorCor implements Comparator<Gato> {
            @Override
            public int compare(Gato g1, Gato g2) {

                return g1.getCor().compareToIgnoreCase(g2.getCor());
                //vai comparar a cor do gato1 e comparar com o gato 2
                //ToIgnoreCase ignora letras maiúsculas já que a variável é string
            }
        }
        class ComparatorNomeCorIdade implements Comparator<Gato>{
            @Override
            public int compare(Gato g1, Gato g2){
                //bloco para critérios de desempate

                int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
                //criou-se uma variável para armazenar o resultado da comparação
                //caso tenha nomes igual
                if (nome != 0) //condição para quando os nomes forem diferentes
                return nome; 
                //ai a ordenação vai ser por nome

                //variável para armazenar cor
                int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
                if (cor != 0) return cor; //condição para quando as cores forem diferentes
                //ai a ordenação vai ser por cor

                //caso cor e nome forem iguais, então o critério de desempate será
                //a idade
                return Integer.compare(g1.getIdade(), g2.getIdade());
            }

        }
        

    //criação da lista Gato
    List<Gato> meusGatos = new ArrayList<>() {{
        add(new Gato("Tatu", 11, "tigrado"));
        add(new Gato("Lil", 10, "frajola"));
        add(new Gato("Katarina", 4, "branco/cinza"));
    }};

    System.out.println(meusGatos);
    
        
        // "--\t TEXTO \t---" 
        //

        
    System.out.println("--\tOrdem de inserção\t---");
    System.out.println(meusGatos);
    
    //toda lista preenchida, quando é imprimida, é pela ordem de inserção
    //dos dados

    System.out.println("--\tOrdem aleatória\t---");
    Collections.shuffle(meusGatos);
    //não existe dentro da list uma funcionalidade para imprimir
    //de forma aleatória. então utiliza-se o collections
    System.out.println(meusGatos);
    

    System.out.println("--\tOrdem Natural (Nome)\t---");
    //aqui utiliza-se o _comparable_, mas é indicado na classe Gato
    Collections.sort(meusGatos);
    System.out.println(meusGatos);

    //o método list também possui o comando .sort(list); mas é preciso
    //que o método comparator seja utilizado;
    //na classe Gatos estamos usando o _Comparable_ e por isso
    //o .sort() é usado de Collections

    //utilizando a interface Comparator
    //isso é porque como já usamos a sobrescrita com o Comparable,
    // é importante utilizar outro método de comparação; caso contrário,
                                //teria que voltar no pedaço de código 
                                // @override
                                // public compareTo() 
                                //e ficar mudando os parâmetros
    // *dá dinamismo e agilidade no código**

    System.out.println("--\tOrdem Idade\t---");
    // Collections.sort(meusGatos, new ComparatorIdade()); //precisa criar uma classe para fazer o comparator
    meusGatos.sort(new ComparatorIdade());
    System.out.println(meusGatos);

    //**o Comparator deixa a lista em ordem crescente de int

    System.out.println("--\tOrdem Cor\t---"); //vai ser utilizado o Comparator também
        Collections.sort(meusGatos, new ComparatorCor()); //precisa criar uma classe para fazer o comparator
        meusGatos.sort(new ComparatorCor()); //imprime a mesma coisa que o comando anterior
        System.out.println(meusGatos);
        //a impressão vai começar a ser feita comparando-se letra por letra
        // b vem antes de f que vem antes de t
        //(-1,             0                +1)

    System.out.println("--\tOrdem nome/Cor/Idade\t---");
        Collections.sort(meusGatos, new ComparatorNomeCorIdade()); //precisa criar uma classe para fazer o comparator
        // meusGatos.sort(new ComparatorNome/Idade/Cor()); //imprime a mesma coisa que o comando anterior
        System.out.println(meusGatos);


}
}



    


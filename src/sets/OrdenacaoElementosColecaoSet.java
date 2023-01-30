package sets;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/*
 Dadas as seguintes informações sobre minhas férias favoritas,
 crie um conjunto e ordene este conjunto exibindo:
 {nome, gênero, tempo de episódio}

 Série 1 = Nome: Gilmore Girls, gênero: Comédia, tempoEpisódio: 45)
 Série 1 = Nome: Downton Abbey, gênero: Drama, tempoEpisódio: 50)
 Série 1 = Nome: GoT, gênero: Ficção, tempoEpisódio: 60)

 */

  //primeiro é preciso criar uma classe "Séries" para adicionar os
  //atributos mencionados acima

class Séries implements Comparable<Séries> {
    
    private String nome;
    private String gênero;
    private Integer tempoEpisódio;

    //criação do constructor
    public Séries (String nome, String gênero, Integer tempoEpisódio) {
        this.nome = nome;
        this.gênero = gênero;
        this.tempoEpisódio = tempoEpisódio;
        //this.variável é a chamada da variável

    }

    //criação dos get(); DENTRO DA CLASSE
public String getNome() {
    return nome;
}
public String getGênero() {
    return gênero;
}
public Integer gettempoEpisódio() {
    return tempoEpisódio;
}

    //sobrescrever
    
public String toString() {
    return "{" + "Nome: " + nome + "," + "Gênero: " + gênero + "," + 
                "Tempo Episódio: " + tempoEpisódio + "}";
}

    //chamar e sobrescrever o método equals() e hashCode()
    //quando usamos implementações com a palavra "hash"
    @Override
public boolean equals(Object object) { //o método equals é o responsável por verificar se existe um hash dentro da classe
    if (this == object) return true;
    if (object == null || getClass() != object.getClass()) return false;
    Séries séries = (Séries) object;
    return nome.equals(séries.nome) && gênero.equals(séries.gênero) && tempoEpisódio.equals(séries.tempoEpisódio);
}
    @Override
public int hashCode() {
    return Objects.hash(nome, gênero, tempoEpisódio);
}
    @Override
public int compareTo (Séries séries) {
    int tempoEpisódio = this.gettempoEpisódio().compareTo(séries.gettempoEpisódio());
    if (tempoEpisódio != 0) return tempoEpisódio;
    return this.getGênero().compareTo(séries.getGênero());

}

} 

//criação de critérios de desempate
class ComparatorNomeGêneroTempoEpisódio implements Comparator<Séries> {

    @Override
    public int compare(Séries s1, Séries s2) {
        //se os nomes forem diferentes, então a comparação será por nome
        int nome = s1.getNome().compareTo(s2.getNome());
        if (nome != 0) return nome;

        //se os nomes forem iguais, a comparação será por gênero
        int gênero = s1.getGênero().compareTo(s2.getGênero());
        if (gênero != 0) return gênero;

        //caso nome e gênero igual, a comparação é por tempo de episódio
        return Integer.compare(s1.gettempoEpisódio(), s2.gettempoEpisódio());
        
        
    }
class ComparatorGênero implements Comparator<Séries> {

    @Override
    public int compare(Séries s1, Séries s2){
        int gênero = s1.getGênero().compareToIgnoreCase(s2.getGênero());
        if (gênero !=0) return gênero;
       return 0;
    }
}
}

public class OrdenacaoElementosColecaoSet { 
        
    public static void main(String[] args) {

    System.out.println("--\tOrdem Aleatória\t--");
    Set<Séries> minhasSéries = new HashSet<>() {{ //criação da lista/collection minhas séries
        //adição das séries
        add(new Séries("Gilmore Girls", "Comédia", 45));
        add(new Séries("Downton Abbey", "Drama", 50));
        add(new Séries("GoT", "Ficção", 60));
        
    }};
    for (Séries séries : minhasSéries)
    System.out.println(séries.getNome() + " - " + séries.getGênero() + " - " + séries.gettempoEpisódio());
    System.out.println();


    System.out.println("--\tOrdem Inserção\t--");
    //aqui é preciso usar o LinkedHashSet()
    Set<Séries> minhasSéries2 = new LinkedHashSet<>() {{
        add(new Séries("Gilmore Girls", "Comédia", 45));
        add(new Séries("Downton Abbey", "Drama", 50));
        add(new Séries("GoT", "Ficção", 60));
        
    }};
    for (Séries séries : minhasSéries2)
    System.out.println(séries.getNome() + " - " + séries.getGênero() + " - " + séries.gettempoEpisódio());
    System.out.println();

    System.out.println("--\tOrdem Natural (tempoEpisódio)\t--");
    //nesse caso é preciso utiliza o TreeSet();
    Set<Séries> minhasSéries3 = new TreeSet<>(minhasSéries2);
    //deixando apenas dessa maneira, irá dar erro de complicação porque
    //a classe Séries não tem comparable. Então será preciso implementar
    for (Séries séries : minhasSéries3)
    System.out.println(séries.getNome() + " - " + séries.getGênero() + " - " + séries.gettempoEpisódio());
    System.out.println();
    //aqui imprimiu apenas 2 séries com tempos diferentes (em ordem natural, do menor
    //para o maior) e como o SET NÃO PERMITE dados duplicados, uma das séries
    //foi suprimida
    //para resolver, é preciso adicionar o critério de desempate
    System.out.println();


    System.out.println("--\tOrdem Nome/Gênero/tempoEpisódio\t--");
    //é preciso criar a classe Comparator que vai implementar o Comparator<Séries>
    //para conseguir exercutar o que está sendo pedido.

    Set<Séries> minhasSéries4 = new TreeSet<>(new ComparatorNomeGêneroTempoEpisódio());
    //quando manda executar só assim, dá set vazio. é preciso inserir valores
    //para consertar isso executar
    //chama o novo treeSet.comando para adicionar (de onde vou tirar os valores)
    minhasSéries4.addAll(minhasSéries);
    //as séries vão ser ordenadas conforme solicitado
    for (Séries séries : minhasSéries4)
    System.out.println(séries.getNome() + " - " + séries.getGênero() + " - " + séries.gettempoEpisódio());
    System.out.println();


/*
 Faça você mesmo
 */

    System.out.println("--\tOrdem Gênero\t--"); //ordem natural, alfabética
    Set<Séries> minhasSéries5 = new TreeSet<>(minhasSéries);
    //a partir da set Minhas Séries, ele organiza em ordem alfabética o 
    //gênero das séries
    for (Séries séries : minhasSéries5)
    System.out.println(séries.getNome() + " - " + séries.getGênero() + " - " + séries.gettempoEpisódio());
    System.out.println();

    System.out.println("--\tOrdem tempoEpisódio\t--");
    Set<Séries> minhasSéries6 = new TreeSet<>(minhasSéries);
    //a partir da set Minhas Séries, ele organiza em ordem crescente
    //o tempo das séries
    for (Séries séries : minhasSéries6)
    System.out.println(séries.getNome() + " - " + séries.getGênero() + " - " + séries.gettempoEpisódio());
    System.out.println();

    }
 
}

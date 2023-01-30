package intermaps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


/*
 Dadas as seguintes informações sobre livros e seus autores, 
 crie um dicionário e ordene esse dicionário:
 exibindo (Nome Autor - Nome Livro)

 Autor = Hawking, Stephen - Livro = Uma breve história do tempo, páginas: 256
 Autor = Duhigg, Charles - Livro = O Poder do Hábito, páginas: 408
 Autor = Harari, Yuval Noah - Livro = 21 Lições para o Século 21, páginas: 432
 */

class Livros{ //classe
    private String nome;
    private Integer páginas;

    //constructor
    public Livros(String nome, Integer páginas) {
        this.nome = nome;
        this.páginas = páginas;   
    }
//getters
public String getNome(){
    return nome;
}
public Integer getPáginas(){
    return páginas;
}
//sobrescrita
public String toString(){
    return "{" + "Nome: " + nome + " - " + "páginas: " + páginas + "}";
}

@Override
public boolean equals(Object object) { //o método equals é o responsável por verificar se existe um hash dentro da classe
    if (this == object) return true;
    if (object == null || getClass() != object.getClass()) return false;
    Livros livros = (Livros) object;
    return nome.equals(livros.nome) && páginas.equals(livros.páginas);
}
@Override
public int hashCode() {
    return Objects.hash(nome, páginas);
}
}

class ComparatorNome implements Comparator<Map.Entry<String,Livros>> {

    @Override
    public int compare(Map.Entry<String,Livros> l1, Map.Entry<String,Livros> l2) {

        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
    
}

public class OrdeanaçãoMap {
    public static void main(String[] args) {
        
        System.out.println("--\tOrdem Aleatória\t--");
        Map <String,Livros> meusLivros = new HashMap<>() {{
            put("Hawking, Stephen", new Livros("Uma breve História do Tempo",256));
            put("Duhigg, Charles", new Livros("O Poder do Hábito",408));
            put("Harari, Yuval Noah", new Livros("21 Lições para o Século 21",432));
        }};
        for( Map.Entry<String,Livros> livros : meusLivros.entrySet()) {
            System.out.println(livros.getKey() + " - " + livros.getValue().getNome());
        }
        System.out.println();


        System.out.println("--\tOrdem Inserção\t--");
        Map <String,Livros> meusLivros2 = new LinkedHashMap<>() {{
            put("Hawking, Stephen", new Livros("Uma breve História do Tempo",256));
            put("Duhigg, Charles", new Livros("O Poder do Hábito",408));
            put("Harari, Yuval Noah", new Livros("21 Lições para o Século 21",432));
        }};
        for( Map.Entry<String,Livros> livros : meusLivros2.entrySet()) {
            System.out.println(livros.getKey() + " - " + livros.getValue().getNome());
        }
        System.out.println();


        System.out.println("--\tOrdem Alfabética Autores\t--");
        Map<String,Livros> meusLivros3 = new TreeMap<>(meusLivros2);
        for(Map.Entry<String,Livros> livros : meusLivros3.entrySet()) {
            System.out.println(livros.getKey() + " - " + livros.getValue().getNome());
        }
        System.out.println();

        
        System.out.println("--\tOrdem Alfabética Livros\t--");
        Set<Map.Entry<String,Livros>> meusLivros4 = new TreeSet<>(new ComparatorNome());
        meusLivros4.addAll(meusLivros.entrySet());
        for(Map.Entry<String,Livros> livros : meusLivros4) {
            System.out.println(livros.getKey() + " - " + livros.getValue().getNome());
        }
        System.out.println();

/*
 * Faça você mesmo
 */
        System.out.println("--\tOrdem número de Páginas\t--");

        
        
    }
    
}

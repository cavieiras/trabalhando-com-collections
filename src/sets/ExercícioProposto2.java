package sets;

import java.util.Comparator;

/*
 Crie uma classe LinguagemFavorita que possua os atributos nome,
 anoDeCriação e IDE (OK). Em seguida, crie um conjunto com 3 linguagens
 e faça um programa que ordene esse conjunto por
 1) Ordem de inserção (LinkedHashSet())
 2) Ordem Natural (nome) (TreeSet())
 3) IDE
 4) Ano de Criação e nome
 5) Nome, Ano de Criação e IDE
Ao final, exiba as linguagens no console, uma abaixo da outra; (loop forEach)
 */


import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

//     //chamar e sobrescrever o método equals() e hashCode()
//     //quando usamos implementações com a palavra "hash"
//     @Override
// public boolean equals(Object object) { //o método equals é o responsável por verificar se existe um hash dentro da classe
//     if (this == object) return true;
//     if (object == null || getClass() != object.getClass()) return false;
//     LinguagemFavorita linguagem = (LinguagemFavorita) object;
//     return nome.equals(linguagem.nome) && ide.equals(linguagem.ide) && anoCriação.equals(linguagem.anoCriação);
// }
//     @Override
// public int hashCode() {
//     return Objects.hash(nome, ide, anoCriação);
// }

class ComparatorNomeAnoCriaçãoIDE implements Comparator<LinguagemFavorita>{
    //chamar método de sobrescrita
    @Override
    public int compare(LinguagemFavorita nome1, LinguagemFavorita nome2){
        int nome = nome1.getide().compareTo(nome2.getide());
        if (nome !=0) return nome;

        int anoCriação = nome1.getanoCriação().compareTo(nome2.getanoCriação());
        if (anoCriação != 0) return anoCriação;

        return nome1.getide().compareTo(nome2.getide());
    }
}
class ComparatorIDE implements Comparator<LinguagemFavorita>{
    //chamar método de sobrescrita
    @Override
    public int compare(LinguagemFavorita ide1, LinguagemFavorita ide2){
        int ide = ide1.getide().compareTo(ide2.getide());
        if (ide !=0) return ide;
        return ide1.getNome().compareTo(ide2.getNome());
    }
}
class ComparatorAnoCriaçãoNome implements Comparator<LinguagemFavorita>{
    //método de sobrescrita
    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2){ //parâmentro de comparação
        //para anos diferentes, o anoCriação é será prioritário
        int anoCriação = l1.getanoCriação().compareTo(l2.getanoCriação());
        if (anoCriação !=0) return anoCriação;
        //para anos iguais, o valor de desempate será o nome
        return l1.getNome().compareTo(l2.getNome());
        
    }
}
class LinguagemFavorita implements Comparable<LinguagemFavorita>{ //criação da classe com os atributos
    private String nome;
    private String ide;
    private Integer anoCriação;

    public LinguagemFavorita(String nome, String ide, Integer anoCriação){ //contructor
        this.nome = nome;
        this.ide = ide;
        this.anoCriação = anoCriação;
    }
    //criando os GETTERS usando os tipos corretos (String e Integer)
    public String getNome(){
        return nome;
    }
    public String getide(){
        return ide;
    }
    public Integer getanoCriação(){
        return anoCriação;
    }

    //função sobrescrever
    public String toString(){
        return "{" + "nome: " + nome + "," + "IDE: " + ide + "," 
        + "Ano de Criação: " + anoCriação + "}";
    }
    @Override
    public int compareTo(LinguagemFavorita linguagem) {
        int nome = this.getNome().compareTo(linguagem.getNome());
    if (nome != 0) return nome;
    return this.getide().compareTo(linguagem.getide());
    }
 }


public class ExercícioProposto2 {
    public static void main(String[] args) {
        System.out.println("--\tOrdem de Inserção\t--");
        //primeiro criar o set com os dados usando LinkedHashSet()
        Set<LinguagemFavorita> linguagensfav = new LinkedHashSet<>() {{
            add (new LinguagemFavorita("Python","PyCharm", 1989));
            add (new LinguagemFavorita("JAVA","ItelliJ", 1991));
            add (new LinguagemFavorita("CSharp","VS Code", 1999));
        }};
        //criação do forLoop para impressão dos itens por linha
        for (LinguagemFavorita linguagem : linguagensfav) {
            System.out.println(linguagem.getNome() + " - " + linguagem.getide() + 
            " - " + linguagem.getanoCriação());
        }
        System.out.println();


        System.out.println("--\tOrdem Natural (Nome)\t--");
        //necessário implementar o Comparable na class LinguagensFavoritas
        //para que o programa consiga comparar os dados e imprimir na ordem solicitada
        Set<LinguagemFavorita> linguagensfav2 = new TreeSet<>(linguagensfav);
        for (LinguagemFavorita linguagem : linguagensfav2) {
            System.out.println(linguagem.getNome() + " - " + linguagem.getide() + 
            " - " + linguagem.getanoCriação());
        }
        System.out.println();


        System.out.println("--\tOrdem de IDE\t--");
        //necessário criar o Comparator para comparar as IDEs em ordem alfabética
        Set<LinguagemFavorita> linguagensfav3 = new TreeSet<>(new ComparatorIDE());
        for (LinguagemFavorita linguagem : linguagensfav3) {
            System.out.println(linguagem.getNome() + " - " + linguagem.getide() + 
            " - " + linguagem.getanoCriação()); 
        }
        System.out.println();


         System.out.println("--\tOrdem de Ano de Criação / Nome\t--");
        //necessário criar o Comparator para comparar por Nome/IDE/AnoCriação
        Set<LinguagemFavorita> linguagensfav4 = new TreeSet<>(new ComparatorAnoCriaçãoNome());
        for (LinguagemFavorita linguagem : linguagensfav4) {
            System.out.println(linguagem.getNome() + " - " + linguagem.getide() + 
            " - " + linguagem.getanoCriação());
        }
        System.out.println();


        System.out.println("--\tOrdem de Nome / Ano de Criação / IDE\t--");
        Set<LinguagemFavorita> linguagensfav5 = new TreeSet<>(new ComparatorNomeAnoCriaçãoIDE());
        for (LinguagemFavorita linguagem : linguagensfav5) {
            System.out.println(linguagem.getNome() + " - " + linguagem.getide() + 
            " - " + linguagem.getanoCriação());
        }
        System.out.println();
        
    }
    
}

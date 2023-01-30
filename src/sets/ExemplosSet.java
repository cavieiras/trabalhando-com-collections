package sets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set; //importando a interface
import java.util.TreeSet;

/*
 Dada uma lista com 7 notas de um aluno [7, 8.5, 9.3, 5, 7, 0, 3.6], faça:
 */

public class ExemplosSet {
    public static void main(String[] args) {

        /*
        Inicialização de um Set
        */

        /* 
        Set notas = new HashSet<>();
        // o new HashSet() cria um novo set vazio que será preenchido
        //e armazenado na variável notas. Neste caso.
        Set<Double> notas = new HashSet<>();
        //criação da Collection Set do tipo Double
        HashSet<Double> notas = new HashSet<>();
        
         Set<Double> notas = new HashSet<>();
         //criação da Collection Set do tipo Double e com um novo objeto
         //HashSet que será preenchido

         Set<Double> notas =  new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
         // o parâmetro foi definido com colocando a lista de notas na forma 
         //de uma lista array

         //métodos de adição e remoção de itens
         notas.add(1d);
         notas.remove(5d);

        */

        System.out.println("Crie um conjunto de notas e adicione as notas: ");
        //Set<Double> notas = new HashSet<>();
        Set<Double> notas =  new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas);
        //a impressão não ficou na ordem porque estamos trabalhando
        // com o HashSet();
        //os elementos repetidos entraram só uma vez, já que não
        //permite repetição 

        /* System.out.println("Exiba a posição da nota 5.0: ");
        //não dá pra fazer busca de posição no método Set
        */

        /*System.out.println("Adicione a lista a nota 8.0 na posição 4: ");
        // também NÃO É POSSÍVEL trabalhar com posições dentro de um set
        */

        /*System.out.println("Substitua a nota 5.0 pela nota 6.0: ");
        // como não há o recurso set(), também não é possível 
        //substituir as notas (ou qualquer outro item dentro de um set)
        */

        System.out.println("Confira de a nota 5.0 está no conjunto: " + notas.contains(5d));
        //o comando .contains(); retorna na forma de boolean se determinado
        //item se encontra dentro do Set

        /*System.out.println("Exiba a terceira nota adicionada: ");
        //também não é possível, pois não existe o método .get()
        //pois não há indices (index) nesta interface
        */

        System.out.println("Exiba a menor nota: " + Collections.min(notas));
        //de forma análoga à Listas, aqui é possível usar o Collections
        //ja que Set é uma collection

        System.out.println("Exiba a maior nota: " + Collections.max(notas));
        //mesmo caso da anterior, porém agora com a maior nota.

        System.out.println("Exiba a soma de valores:");
        //assim como em List, é preciso usar o iterator para
        //que seja possível calcular a soma das notas.
        Iterator<Double> iterator = notas.iterator(); //criação do iterator
        Double soma = 0d; //variável de controle
        while (iterator.hasNext()){  //novamente, para que seja possível fazer a soma é preciso o laço while
            Double next = iterator.next(); //ajuda na visualização ao guardar um item dentro de uma variável
            soma += next; //comando de soma, onde os valores ficaram armazenador em soma;
        }
        System.out.println("Soma: " + soma);
        //o valor da soma deu diferente porque não há a repetição de elementos!

        System.out.println("Exiba a média das notas: " + (soma/notas.size()));
        // dividir o valor da soma 
        //pelo notas.size(), que dá o número de itens que contém o set

        System.out.println("Remova a nota zero:");
        notas.remove(0d); //comando para a remoção da nota
        System.out.println(notas);

        /*System.out.println("Remova a nota da posição zero:");
        // como não se trabalha com index em set, então não é possível
        //excluir um item de uma determinada posição
        */

        System.out.println("Remova as notas menores que 7 e exiba a lista");
        Iterator<Double> iterator2 = notas.iterator(); //criação do iterator
        while(iterator2.hasNext()){ //o laço while é necessário para que sejam percorridos todos os itens da lista
            Double next = iterator2.next(); 
            if (next < 7d){
                iterator2.remove();
            }
        }
        System.out.println(notas); //para visualizar se foram removidas as notas <7

        System.out.println("Exiba todas as notas na ordem em que foram informadas: ");
        //para que sejam fornecidas as notas na ordem que foram colocadas,
        //é preciso trabalhar com o LinkedHashSet
        //para isso é preciso que se crie uma nova lista de notas e use o LinkedHashSet
        //outra forma de criar a lista de notas2 é:
        Set<Double> notas2 = new LinkedHashSet<>();
        notas2.add(7d);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5d);
        notas2.add(7d);
        notas2.add(0d);
        notas2.add(3.6);
        System.out.println(notas2);


        System.out.println("Exiba todas as notas na ordem crescente: ");
        //para executar esta função, é preciso se utilizar do método
        //TreeSet, já que ela organiza com a ordem natural default (ordem alfabética, ordem numérica)
        Set<Double> notas3 = new TreeSet<>(notas2);
        //o notas2 como é tipo Double, ele tem o Comparable e por isso é possível fazer a comparação
        //entre as notas;
        //caso fosse uma classe que não tivesse o Comparable e não fosse criado o 
        //Comparator, não iria dar certo usar este método TreeSet();
        System.out.println(notas3);

        
        System.out.println("Apague todo o conjunto: ");
        notas.clear();
        System.out.println(notas);
        
        System.out.println("Confira se o conjunto está vazio: " + notas.isEmpty());
        System.out.println("Confira se o conjunto está vazio: " + notas2.isEmpty());
        System.out.println("Confira se o conjunto está vazio: " + notas3.isEmpty());

    }   
}

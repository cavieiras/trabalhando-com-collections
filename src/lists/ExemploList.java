package lists;

//primeiro e mais importante, importar as utilidades que serão utilizadas

import java.util.ArrayList; //implemento dessa interface
import java.util.Collections;
import java.util.Iterator; //percorre os itens da lista
import java.util.List; //interface list
import java.util.LinkedList;

// List<double> notas = Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6 )
// o método acima não é recomendado pois limitados. não permite aumentar a quantidade de dados dentro da lista

// List<double> notas = list.of(7d, 8.5, 9.3, 5, 7, 0, 3.6) também é um método IMUTÁVEL
// não permite e adição e nem a remoção de itens da lista.

//comandos:
//nome[da variável].add[comando](item a ser adicionado); - adiciona um item à lista
//nome[da variável].remove[comando](o: item a ser retirado da lista); - remove o item especificado da lista

public class ExemploList {
    public static void main(String[] args) {
// Dada uma lista com 7 notas de um aluno [7, 8.5, 9.3, 5, 7, 0, 3.6], faça:

    System.out.println("Crie uma lista e adicione as sete notas: ");

    //inicializando a lista:
    List<Double> notas = new ArrayList<Double>(); //a variável notas irá armazenar a lista que será preenchida
    notas.add(0, 7d); //esse metodo permite escolher a posição em que se quer colocar o valor
    notas.add(1, 8.5);
    notas.add(2, 9.3);
    notas.add(3, 5d); //como o tipo da list é DOUBLE, números inteiros que forem adicionados nessa lista, precisam vir acompanhados da letra d, para indicar que é um double.
    notas.add(4, 7d);
    notas.add(5, 0d);
    notas.add(6, 3.6);
    //operação tem que ser repetida de maneira necessária (em um primeiro momento) 
    //para adicionar todos os itens que se deseja

    System.out.println(notas); //imprime em uma única linha
    //System.out.println(notas.toString()); - faz a conversão de uma variável do tipo Double para String
    
    System.out.println("Exiba a posição de nota 5.0: " + notas.indexOf(5d)); 
    //o comando .indexOf() irá mostrar a posição de terminado elemento na lista
    System.out.println("Confira de a nota 5.0 está na lista: " + notas.contains(5d)); 
    //o comando .contains() mostra se determinado objeto (elemento) se encontra na lista;
    // retorna boolean

    //em ambos os casos acima, como o retorno é um int, ele pode ser concatenado ao 
    //imprimir a string. por isso não dá erro de compilação
    
    System.out.print("Adicione na lista a nota 8.0 na posição 4: "); 
    //o comando .add(index: , element: ); adiciona um valor na lista  posição pedida
    notas.add(4, 8d); //como este método não retorna nenhum valor, 
    //pois é do tipo void, não dá pra concatenar ele com a String que será imprimida.
    //ele precisa ser chamado for do Sysout

    System.out.println("Nova lista: " + notas);
    System.out.println("Substitua a nota 5.0 pela nota 6.0 " + notas.set(notas.indexOf(5d), 6d)); 
    //é possível colocar um comando dentro de um comando para tornar o processo 
    //mais automatizado
    System.out.println(notas);

    System.out.println("Exiba a terceira nota adicionada: " + notas.get(2));
    //retorna o elemento na posição pedida. o tipo de retorno é int então pode ser usado
    //dentro do comando de println

    //A comparação entre maior valor e menor valor só é possível
    //porque a classe _Double_ implementa a _interface Comparable_;
    //outras classes como Integer, int, String também implementam a interface Comparable
    System.out.println("Exiba a menor nota: "  + Collections.min(notas));
    //não existe em list um comando para retornar o menor valor
    //aqui usa-se collections (objeto)
    //.min(objeto a ser analisado) retorna o menor valor da sua collection (lista)
    
    System.out.println("Exiba a maior nota: " + Collections.max(notas));
    //.max(objeto a ser analisado) retorna o maior valor da sua collection (lista)

    //Também não existe o método Sum para retornar a soma.
    //É possível utilizar o iterator
    
    Iterator <Double> iterator = notas.iterator(); //chamada do método
    Double soma = 0d; //variável inicial
    while (iterator.hasNext()) { 
        //pergunta para o programa se existe um item depois do cursor
        //retorno é boolen (true/false)
        //caso true, então ele chama esse valor pelo comando .next();
        
        Double next = iterator.next();
        //a variável next guarda o valor na frente do cursor
        soma += next;
        //o valor inicial na variável soma será somado com o item da vez e o resultado
        //será guardado na variável soma
        
        //como tudo isso está dentro do loop while, então ele vai se repetir até que não
        //haja mais nenhum item depois do cursor (false);
    }
    System.out.println("Exiba a soma dos valores: " + soma);
    //tem que aparecer depois da variável soma que foi criada.

    System.out.println("Exiba a média das notas: " + (soma/notas.size()));
    //.size(); retorna a quantidade de elementos na lista
    //o resultado da operação retorna um int.


    System.out.println("Remova a nota 0: ");
    notas.remove(0d); //remove item especificado da lista
    //se não colocar o "d" depois do número, ele irá remover o item na posição 0
    System.out.println(notas);


    System.out.println("Remova a nota da posição 0: ");
    notas.remove(0);
    System.out.println(notas);


    System.out.println("Remova as notas menores que 7 e exiba a lista: ");
    //Para selecionar os item menores que 7
    Iterator<Double> iterator2 = notas.iterator();
    while (iterator2.hasNext()) {
        Double next2 = iterator2.next();
        if (next2 <7 ){
            iterator2.remove();
        }
        
        System.out.println(notas);

        // System.out.println("Apague toda a lista");
        // notas.clear(); //limpa toda a lista
        
    }
    System.out.println("Confira se a lista esta vazia " + notas.isEmpty());
        //o comando isEmpty(), retorna true/false e verifica se a lista esta ou não 
        //vazia

/**
Crie uma lista chamada notas2 e coloque todos os elementos
da list ArrayList nesta nova lista
*/

    LinkedList<Double> notas2 = new LinkedList<Double>(notas);

    System.out.println("Lista notas2: " + "\n" + notas2);

    System.out.println("Mostre a primeira nota da nova lista sem  removê-lo: " + notas2.getFirst());
    //.getFirst(); retorna o primeiro item da lista
    System.out.println(notas2);

    System.out.println("Mostre a primeira nota da nova lista removendo-o: " + notas2.getFirst());
    notas2.removeFirst();
    
    System.out.println(notas2);
}
}

package streamAPI;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

public class ExercícioStream {

    public static <T> void main(String[] args) {
//      uma List de elementos String
        List<String> numerosAleatórios = 
        Arrays.asList( "1", "0", "4", "1", "2", "3", "9", "9", "6", "5"
);
        System.out.println("Imprima todos os elementos desta lista de String: ");
        
        // numerosAleatórios.stream().forEach(new Consumer<String>() {
        //     //pega cada elemento do tipo string e irá imprimi-lo
        //     @Override
        //     public void accept(String t) { //usa o método accept para imprimir os elementos
        //         System.out.println(t);
        //     }
            
        // });

//      utilizando o método lambda
        //numerosAleatórios.stream().forEach(t -> System.out.println(t)); 

//      utilizando o reference method
        numerosAleatórios.stream().forEach(System.out::println);

        System.out.println("Pegue os 5 últimos primeiros e coloque dentro de um Set: ");
//      o comando collect pega a quantidade de itens que vc quer e transfere
//      para outro lugar (SET)

//      reference method
        numerosAleatórios.stream().limit(5).collect(Collectors.toSet())
        .forEach(System.out::println);
//      lembrando que um set não aceita números repetidos, por isso a impressão vai ter apenas
//      quatro números (o número 1 vai ser impresso apenas uma vez)

        System.out.println("Transforme esta lista de String em uma lista de números inteiros: ");
//      reference method
        // List<Integer> numerosAleatórios1 = numerosAleatórios.stream()
        // .map(Integer::parseInt).collect(Collectors.toList());

//      aqui é uma transformação: mudança de tipo.
//      .map() é muito importante!!!!! NÃO É MAP DE COLLECTIONS.
//      ele recebe a interface function
//      .map retorna uma stream (fluxo)

//      escrito de maneira completa

        // numerosAleatórios.stream().map(new Function<String, Integer>() {
        //     @Override
        //     public Integer apply(String t) {
        //         return Integer.parseInt(t, 0);
        //     }   
        // });

            //referente method
//                               a função map fez a transformação pra Int
        numerosAleatórios.stream().map(Integer::parseInt)
        .collect(Collectors.toList()).forEach(System.out::println);
//      Collectors.toList() é uma nova lista criada do tipo
//      Integer; vai ser impressa em coluna por causa do forEach()
//      que vai imprimir um item de cada vez da lista
//      é possível salvar o caminho em uma variável para melhor compreensão, p.ex:
//         List<Integer> collectList = numerosAleatórios.stream().map(Integer::parseInt)
//          .collect(Collectors.toList());

        System.out.println("Pegue os números pares e maiores que 2 e coloque-os em uma lista: ");
//      primeiro passo é transformar a lista de String em Integer
//      pode ou não estar dentro de uma variável

        // List<Integer> ListParesMaioresQue2 = numerosAleatórios.stream().map(Integer::parseInt)
        // .filter(new Predicate<Integer>() { //cria-se um filtro para selecionar os valores desejados
        //     @Override
        //     public boolean test(Integer i) {
        //         if(i%2 == 0 && i>2) return true; //condição para recolher os números escolhidos
        //         return false;
        //     }
        // }).collect(Collectors.toList()); //coleta os valores e adicionar numa nova lista
        // System.out.println(ListParesMaioresQue2);

//      escrito como lambda
        List<Integer> ListParesMaioresQue2 = numerosAleatórios.stream().map(Integer::parseInt)
        .filter(i -> (i%2 == 0 && i>2)).collect(Collectors.toList()); //coleta os valores e adicionar numa nova lista
        System.out.println(ListParesMaioresQue2);


        System.out.println("Mostre a média dos números: ");
        // numerosAleatórios.stream().mapToInt(new ToIntFunction<T>() {
        //     @Override
        //     public int applyAsInt(T value) {
               
        //         return Integer.parseInt(value);
        //     }
        // });
        
        // numerosAleatórios.stream().mapToInt(value -> Integer.parseInt(value))
        // .average() //o retorno optionalDouble serve para trabalhar com valores Null
        // .ifPresent(new DoubleConsumer() {
        //     @Override
        //     public void accept(double v) {
        //         System.out.println(v);
        //     }
        // });
        numerosAleatórios.stream().mapToInt(value -> Integer.parseInt(value))
        .average() //o retorno optionalDouble serve para trabalhar com valores Null
        .ifPresent(v -> System.out.println(v)); //da pra simplificar mais

        System.out.println("Remova os valores ímpares: ");
//      aqui ocorre modificação da fonte! Por conta disso, não dá
//      pra remover os valores com uma lista de Stream, tem que ser com
//      uma de integer, então cria-se uma nova lista que pode ser modificada
//      usando o stream().map().collect(Collectors.toList()) para criar uma nova lista
//      que possa ser alterada
        List<Integer> numerosAleatorios = numerosAleatórios.stream().map(Integer::parseInt)
        .collect(Collectors.toList());
        // numerosAleatorios.removeIf(new Predicate<Integer>() {

        //     @Override
        //     public boolean test(Integer t) {
        //         if (t % 2 !=0) return true;
        //         return false;
        //     }
            
        // });
        // System.out.println(numerosAleatorios);

        //metodo lambda
        numerosAleatorios.removeIf(t -> (t % 2 !=0));
        System.out.println(numerosAleatorios);

/*
*Pra você
*/

        // System.out.println("Ignore os 3 primeiros elementos da lista e imprima o restante: ");

        // System.out.println("Retirando os números repetidos da lista, quantos números ficam? ");

        // System.out.println("Mostre o menor valor da lista: ");

        // System.out.println("Mostre o maior valor da lista: ");

        // System.out.println("Pegue apenas os números ímpares e some: ");
        
        // System.out.println("Mostre a lista na ordem numérica: ");
        
        // System.out.println("Agrupe os valores ímpares múltiplos de 3 e de 5: ");
//      dica: collect(Collectors.groupingBy(new Function())


    }
}


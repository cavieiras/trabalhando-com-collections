package sets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.Set;


/*
 Crie um conjunto contendo as cores do arco-íris e:
 1) Exiba todas as cores uma embaixo da outra; (forEach loop) OK
 2) A quantidade de cores que o arco-iris tem; (.size()) OK
 3) Exiba as cores em ordem alfabética; (Set<> / TreeSet<>) OK
 4) Exiba as cores na ordem INVERSA da que foi informada; OK
 5) Exiba todas as cores que começam com a letra "v"; OK
 6) Remova todas as cores que começam com a letra "v"; (.remove()) OK
 7) Limpe o conjunto; (.clear()) OK
 8) Confira se o conjunto está vazio; (.isEmpty()) OK
 */
public class ExercícioProposto {
    public static void main(String[] args) { 
        List<String> arcoÍris = new ArrayList<>(); //criação da lista arcoÍris
        arcoÍris.add("Vermelho");
        arcoÍris.add("Laranja");
        arcoÍris.add("Amarela");
        arcoÍris.add("Verde");
        arcoÍris.add("Azul");
        arcoÍris.add("Anil");
        arcoÍris.add("Violeta");

        System.out.print("Nome das cores do arco-íris: \n");
        //o loop forEach neste caso permite que a cada novo item
        //ele seja impresso na linha de baixo
        for (String cor : arcoÍris) {
            System.out.println(cor);
        }
        System.out.println();

        System.out.println("Quantidade de cores no arco-íris: " + arcoÍris.size() + "\n");


        System.out.println("Cores em ordem alfabética: ");
        Set<String> arcoÍris2 = new TreeSet<>(arcoÍris); 
        //TreeSet() usa a ordem natural por default (neste caso, ordem alfabética)
        for (String cor : arcoÍris2){
            System.out.println(cor);
        }
        System.out.println();


        System.out.println("Cores do arco-íris na ordem inversa à colocada: ");
        //também seria possível utilizar um for loop. mas ficaria extenso.
        Collections.reverse(arcoÍris);
        for (String cor : arcoÍris) {
            System.out.println(cor);
        }
        System.out.println();


        System.out.println("Cores que começam com a letra 'v': " );
        for (String cor : arcoÍris2) {
            if (cor.startsWith("v") || cor.startsWith("V")) {
                System.out.println(cor);
            }               
        }
        System.out.println();
        
        System.out.println("Remova todas as cores que começam com a letra 'v'");
        //criar um novo Set para armazenar a nova lista sem os item que começam com V
        Set<String> arcoÍris3 = new HashSet<>();
        for (String cor : arcoÍris) {                               //ao percorrer a lista aroÍris, para cada cor
            if (!cor.toLowerCase().startsWith("v")) {       //!cor.toLowerCase().startsWith(); - cores que não começam com V
                arcoÍris3.add(cor);                                 //são adicionadas na lista arcoÍris3
            }
        }
        for (String cor : arcoÍris3) {      //imprime as cores restantes
            System.out.println(cor);
        }     
        System.out.println();


        System.out.println("Limpe todo o conjunto: ");
        arcoÍris.clear();
        System.out.println(arcoÍris + "\n");
        

        System.out.println("A lista está vazia: " + arcoÍris.isEmpty());
    
    }
    
    
}

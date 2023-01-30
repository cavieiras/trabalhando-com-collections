package lists;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;


public class ExercicioTemperaturasMédias {
    public static void main(String[] args) {

    //criação das listas de temperaturas e meses
    List<Double> temperaturas = new ArrayList<Double>();
    List <String> meses = new ArrayList<>();

    //adição de elementos às listas
    //um único bloco deixa mais 'clean'
    temperaturas.add(0,15d);
    temperaturas.add(1,28d);
    temperaturas.add(2,22d);
    temperaturas.add(3,33d);
    temperaturas.add(4,30d);
    temperaturas.add(5,18d);
    meses.add(0, "Janeiro");
    meses.add(1, "Fevereiro");
    meses.add(2, "Março");
    meses.add(3, "Abril");
    meses.add(4, "Maio");
    meses.add(5, "Junho");

    //calculando a média das temperaturas
    Iterator <Double> iterator = temperaturas.iterator();
    Double soma = 0d;
    while(iterator.hasNext()) {
        Double next = iterator.next();
        soma += next; //acumulando a soma das temperaturas
    }
    Double média = soma / temperaturas.size(); //calculando a média dividindo a soma pelo tamanho da lista
    System.out.println("A média semestral é de: " + média);
    System.out.println();

    //criação de uma lista de índices das temperaturas acima da média
    List<Integer> indicesAcimaDaMedia = new ArrayList<>();
    for (int i = 0; i < temperaturas.size(); i++) {
        if (temperaturas.get(i) > média) { //verificando se a temperatura atual é acima da média
            indicesAcimaDaMedia.add(i); //adicionando o índice da temperatura acima da média à lista
        }
    }

    System.out.println("Meses com temperaturas acima da média: ");
    //iterando através da lista de índices e imprimindo os meses correspondentes
    for (int index : indicesAcimaDaMedia) {
        System.out.println(meses.get(index) + " - " + temperaturas.get(index));
    }
    }
}
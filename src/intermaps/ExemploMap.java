package intermaps;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;


/*
 Dado os modelos de carros e seus respectivos consumos na estrada, faça:
         (key)            (value)
 modelo = gol - consumo = 14.4km/l
 modelo = uno - consumo = 15.6km/l
 modelo = mobi - consumo = 16.1km/l
 modelo = hb20 - consumo = 14.5km/l
 modelo = kwid - consumo = 15.6km/l
 */

public class ExemploMap {
    public static void main(String[] args) {
        // Map carrosPopulares2020 = newHashMap(); //criação da bucked list com menos de 8 itens
        // Map<String, Double> carrosPopulares = new HashMap; //criação de doubly bucked list 
        // Map<String, Double> carrosPopulares2020 = Map.of("gol", 14.4, "uno", 15.6, "mobi", 16.1, "hb20", 14.5, "kwid", 15.6);
        //o ouso do Map.of() cria um Map que NÃO É POSSÍVEL alterar;

        System.out.println("Crie um dicionário que relacione os modelos e seus respectivos consumos: ");
        //para a criação de um Map, é preciso especificar o tipo de key e o tipo 
        //de chave
        // CUIDADO: NÃO PODE TER KEYS DUPLICADAS;
        // **o método Map não permite a adição dos itens utilizando o add();
        // **então será utilizado o equivalente que é o put();

        Map<String,Double> carrosPopulares = new HashMap<>(){{
            //como está sendo utilizado um HashMap, a ordem de impressão
            //é diferente da ordem de inserção; ele disponibiliza os dados
            //de maneira RANDOM
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);

        }};
        System.out.println(carrosPopulares);


        System.out.println("Substitua o consumo do gol por 15.2 km/l: ");
        //como não pode haver chaves repetidas, utiliza-se novamente o put()
        //e irá sobrescrever o valor
        carrosPopulares.put("gol", 15.2);
        //especificar o Map que será alterado.
        //colocar a chave que vc gostaria de alterar e o novo valor.
        //como já existe uma chave gol, não será adicionado outro, apenas irá sobrescrever
        //o valor do consume que já consta nesta chave
        System.out.println(carrosPopulares);


        System.out.println("Confira se o modelo Tucson está no dicionário: " + carrosPopulares.containsKey("Tucson"));
        //o comando contains.key(objeto/item de interesse): procura a chave
        //de interesse
        //é boolean. retorna true (caso positivo)/false (caso negativo)
        

        System.out.println("Exiba o consumo do uno: " + carrosPopulares.get("uno"));
        //uso do comando get(key);
        //ele retorna o VALUE associado a uma determinada key.


        // System.out.println("Exiba o terceiro modelo do dicionário: "); 
        // ** NÃO existe um método que possa exibir o que está sendo pedido


        System.out.println("Exiba os modelos: ");
//(criar Set string)    (variável) (comando para impressão dos modelos)
        Set<String> modelos = carrosPopulares.keySet(); //retorna um SET!!!!
        System.out.println(modelos);


        System.out.println("Exiba os consumos dos carros: ");
        //utilização do método values();
        //ele retorna uma Collection, então é preciso CRIAR UMA COLLECTION
        Collection <Double> consumo = carrosPopulares.values();
        System.out.println(consumo);


        System.out.println("Exiba o modelo mais econômico e seu consumo: ");
        //o modelo mais economico tem que saber o modelo (key) e o valor (value)
        //mais eficiente
        Double consumoMaisEficiente = Collections.max(carrosPopulares.values());
        //criou-se a variável para armazenar o valor de interesse
        //o Collections.max(Collection) retona o valor máximo dentro de uma collection
        //esse método retona um set e os valores dentro desse set
        Set<Map.Entry<String,Double>> entradas = carrosPopulares.entrySet();
        //Entry é uma interface do Map
        //.entryset() [método especial] vai retornar um set e os elementos 
        //dentro deste set e portanto
        //deve estar guardado dentro de uma variável que seja um set 
        String modeloMaisEficiente = ""; //variável de controle

        for (Entry <String,Double> entry : entradas) {
            if (entry.getValue().equals(consumoMaisEficiente)) 
            modeloMaisEficiente = entry.getKey();
        }
        System.out.println("Modelo mais eficiente: " + modeloMaisEficiente + " - " + consumoMaisEficiente);
        //caso o sysout fosse colocado dentro do if, ele iria imprimir todos os modelos
        //que fossem mais eficientes, caso existissem


        System.out.println("Exiba o modelo menos econômico e seu consumo: ");
        //também é preciso trabalhar com os valores separadamente de key e value
        //mesmo pensamento do anterior, porém usando os mínimos
        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entradas2 = carrosPopulares.entrySet();
        String modeloMenosEficiente = "";

        for (Entry<String,Double> entry : entradas2) {
            if(entry.getValue().equals(consumoMenosEficiente))
            modeloMenosEficiente = entry.getKey();
        }
        System.out.println("Modelo menos eficiente: " + modeloMenosEficiente + " - " + consumoMenosEficiente);


        System.out.println("Exiba a soma dos consumos: ");
        //criar iterator para somar os valores
        //como o retorno dos carros populares é um collection, então é possível usar o 
        //iterator sem problemas
        Iterator <Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0d;
        while (iterator.hasNext()) {
            Double next = iterator.next();
            soma += next;
        }
        System.out.println(soma);


        System.out.println("Exiba a média dos consumos desde dicionário de carros: ");
        // .size() dá o número de itens
        System.out.println("Média: " + (soma /carrosPopulares.size()));
        
        System.out.println("Remova os modelos com o consumo igual a 15.6 km/l");
        Iterator<Double> iterator2 = carrosPopulares.values().iterator();
        while (iterator2.hasNext()) {
            if(iterator2.next().equals(15.6)) {
                iterator2.remove();
            }
        }
        System.out.println(carrosPopulares);
    
        System.out.println("Exiba todos os carros na ordem em que foram informados: ");
        //utilizar LinkedHashMap
        Map<String,Double> carrosPopulares2 = new LinkedHashMap<>(){{
            //como está sendo utilizado um HashMap, a ordem de impressão
            //é diferente da ordem de inserção; ele disponibiliza os dados
            //de maneira RANDOM
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);

        }};
        System.out.println(carrosPopulares2);


        System.out.println("Exiba o dicionário ordenado pelo modelo: ");
        //usar TreeMap
        Map<String, Double> carrosPopulares3 = new TreeMap<>(carrosPopulares2);
        System.out.println(carrosPopulares3);
        //vai ser impresso na ordem alfabética

        System.out.println("Apague o conjunto de carros: ");
        carrosPopulares.clear();
        System.out.println(carrosPopulares);

        System.out.println("Confira se a lista está vazia: " + carrosPopulares.isEmpty());



    }


}


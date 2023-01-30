package intermaps;
/*
 Dada a população estimada de alguns estados do NE brasileiro, faça:
 Estado = PE - População = 9616621
 Estado = AL - População = 3351543
 Estado = CE- População = 9187103
 Estado = RN - População = 3534265

 1) Crie um dicionário e relacione os Estados e suas populações; 
 (Map<String, Integer> estados = new HashMap<>() / estados.put())

 2) Substitua a população do Estado do RN por 3534165; 
 (estados.put("RN", 3534165)

 3) Confira se o Estado de PB está no dicionário, caso não, adicione: PB - 4039277; 
 (estados.containsKey("PB") / estados.put (key, value))

 4) Exiba a população de PE; 
 (estados.get(PE))

 5) Exiba todos os Estados e suas populações na ordem que foram informados;
 (Set<String> estados2 = new HashSet<>() / estados2 = estados.keySet())

 6) Exiba os estados e as suas populações em ordem alfabética; 
 (Map<String,Integer> estados2 = new TreeMap<>(estados))

 --Criar classe Estados para resolver os exercícios 7 e 8-- (olhar Ordenação Maps)
 7) Exiba o estado com a menor população e sua quantidade;
 8) Exiba o estado com a maior população e sua quantidade;

 9) Exiba a soma da população desses estados; 
 (variável soma / criar iterator / while loop (iterator.hasNext()) / variável = iterator.next() / soma += variável; )
 
 10) Exiba a média da população desses estados; 
 (soma / estados.size())

 11) Remova os estados com a população menor que 4000000; 
 (criar iterator / if loop / .equals(40000) / iterator.remove())

 12) Apague o dicionário de estados; 
 (.clear())

 13)Confira se o dicionário está vazio. 
 (.isEmpty())
 */
public class ExercícioProposto1 {
    
}

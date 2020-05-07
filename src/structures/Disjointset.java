package structures;
import java.util.*;

public class Disjointset<E> {
	
	private HashMap<E,HashMap<E,E>> conjuntos;
	
	public Disjointset() {
		
		conjuntos = new HashMap<E,HashMap<E,E>>();
		
	}
	
	public E findSet(E element) {
		
		if (conjuntos.get(element)== null) {
			E represent = null;
			boolean found = false;
			for(Map.Entry<E , HashMap<E,E>> entry :conjuntos.entrySet()) {
				if(!found) {
					if(entry.getValue().containsKey(element)) {
						represent=entry.getKey();
						found = true;
						
					}
				}else {
					break;
				}
			}
			return represent;
		}else {
			
			return element;
		}
	}
	
	public int size() {
		return conjuntos.size();
	}
	
	public ArrayList<E> getSet(E element){
		E represent = findSet(element);
		if (represent !=null) {
			Set<E> conjunto =conjuntos.get(represent).keySet();
			ArrayList<E> elements = new ArrayList<>();
			for(E key : conjunto ) {
				elements.add(key);
			}
			return elements;
		}else {
			return null;
		}
	}
	
	public boolean union (E conjunto1,E conjunto2) {
		E conjun1 = findSet(conjunto1);
		E conjun2 = findSet(conjunto2);
		if( conjun1 != null && conjun2 != null ) {
			HashMap <E,E> conjuntoPrincipal = conjuntos.get(conjun1);
			Set<E> elementos = conjuntos.get(conjun2).keySet();
			conjuntos.remove(conjun2);
			
			for(E e : elementos) {
				conjuntoPrincipal.put(e, conjun1);
			}
			
			return true;
			
		} else {
			return false;	
		}
		
	}
	
	public boolean makeSet(E element) {
		if (findSet(element)==null) {
			HashMap<E,E> map = new HashMap<>();
			map.put(element, element);
			conjuntos.put(element,map);
			return true;
		}else {
			return false;
		}
		
	}
		
	
	

}

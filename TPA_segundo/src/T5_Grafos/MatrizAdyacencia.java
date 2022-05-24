package T5_Grafos;

import java.util.ArrayList;
import java.util.List;

public class MatrizAdyacencia {

	List<List<Integer>> matriz;
	
	public void Grafos() {
		matriz = new ArrayList<>();
	}
	
	public void addVertice() {
		matriz.add(new ArrayList<>());
		if(matriz.size() > 1) {
			for(int i=0; i<matriz.get(0).size(); i++) {
				matriz.get(matriz.size()-1).add(0);
			}
			for(int i=0; i<matriz.size(); i++) {
				matriz.get(i).add(0);
			}
		}else{
			matriz.get(0).add(0);
		}
	}
	
	public void addArista(int x, int y) {
		if(x<matriz.size() && matriz.get(x).size()>y) {
			matriz.get(x).remove(y);
			matriz.get(x).add(y, 1);
		}
	}
	
}

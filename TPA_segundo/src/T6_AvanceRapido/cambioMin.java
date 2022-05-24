package T6_AvanceRapido;

import java.util.ArrayList;
import java.util.List;

public class cambioMin {
	
	public static void cambioMinimo(double devolver) {
		//List<Double> monedas = new ArrayList<Double>();
		double[] monedas = {2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01};
		int i = 0;
		while(i<monedas.length) {
			while(devolver>monedas[i]) {
				devolver = devolver-monedas[i];
				System.out.println(monedas[i]);
			}
			i++;
		}
	}
	
	
	public static void cambioMinimo2(double devolver) {
		//List<Double> monedas = new ArrayList<Double>();
		double[] monedas = {2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01};
		int i = 0;
		while(i<monedas.length && devolver>monedas[i]) {
			devolver = devolver-monedas[i];
			System.out.println(monedas[i]);
			i++;
		}
	}
	
	
	public static void main(String[] args) {
		cambioMinimo2(5.89);
	}
}

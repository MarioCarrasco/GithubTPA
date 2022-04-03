package Practica1;

/**
 * 
 * @author Mario Carrasco Perez
 * @expediente 21960626
 * @fecha 30-03-2022
 *
 */

public class Neutraliza {

	/**
	 * Funcion que resta dos matrices cuadradas NxN: m1-m2
	 * @param m1 Matriz NxN de enteros
	 * @param m2 Matriz NxN de enteros
	 * @return Matriz NxN de enteros resultado de hacer m1-m2
	 */
	private static int[][] resta (int[][] m1, int[][] m2){

		int[][] resultado = new int[m1.length][m1.length];

		for (int fila=0; fila < resultado.length; fila++)
			for (int col=0; col < resultado[fila].length; col++)
				resultado[fila][col] = m1[fila][col] - m2[fila][col];

		return resultado;		
	} 

	// CORREGIR esta funcion
	public static boolean esNeutralizada_v1 (int[][] m1, int[][] m2) {
		boolean neutraliza = true;
		int[][] matrizResta = resta(m1, m2);

		for (int fila = 0; fila < m1.length; fila++) { 		  // No editar esta linea
			for (int col = 0; col < m1[fila].length; col++) { // No editar esta linea
				if (fila==col)
					if (matrizResta[fila][col] == 1)
						neutraliza = true;
					else
						return false; //PRIMERA MODIFICACION

				else
					if (matrizResta[fila][col] == 0)
						neutraliza = true;
					else
						return false; //SEGUNDA MODIFICACION
			}//for
		}//for
		return neutraliza;
	}

	public static boolean esNeutralizada_v2 (int[][] m1, int[][] m2) {
		// INICIALIZAMOS LA VARIABLE BOOLEANA Y EL RESULTADO DE LA RESTA DE MATRICES
		boolean neutraliza = true;
		int[][] matrizResta = resta(m1, m2);
		
		// RECORREREMOS LAS MATRIZES CON ÚNICO BUCLE WHILE
		int fila = 0, col = 0;
		while (fila < matrizResta.length) {
			// COMPROBACIONES PARA IR RECORRIENDO LAS MATRICES DE FORMA CORRECTA
			if (col == matrizResta[0].length - 1) {
				if (fila==col)
					if (matrizResta[fila][col] == 1)
						neutraliza = true;
					else
						return false;
				else
					if (matrizResta[fila][col] == 0)
						neutraliza = true;
					else
						return false;
				
				fila++; //PASAMOS A LA SIGUIENTE FILA
				col = 0; //AL PASAR A LA SIGUIENTE FILA REINICIAMOS EL RECORRIDO DE LAS COLUMNAS
			} else {
				if (fila==col)
					if (matrizResta[fila][col] == 1)
						neutraliza = true;
					else
						return false;
				else
					if (matrizResta[fila][col] == 0)
						neutraliza = true;
					else
						return false;
				col++; //SI NO HEMOS LLEGADO AL FINAL DE LA FILA, PASAMOS A LA SIGUIENE COLUMNA
			}
		}
		return neutraliza;
	}

	public static boolean esNeutralizada_DyV (int[][] m1, int[][] m2) {
		
		return true; // sentencia insertara para poder compilar
	}

	public static void main(String[] args) {

		int[][] m1 = {	{2,1,0,0},
						{0,2,0,0},
						{0,0,2,0},
						{0,0,0,2}};

		int[][] m2 = {	{1,1,0,0},
						{0,1,0,0},
						{0,0,1,0},
						{0,0,0,1}};

		int[][] m3 = {	{2,0,0,0},
						{0,2,0,0},
						{0,0,2,0},
						{0,0,0,3}};

		System.out.println("PRUEBA v1:");
		System.out.println(" * esNeutraliza_v1 (m1, m2): " + esNeutralizada_v1(m1, m2));
		System.out.println(" * esNeutraliza_v1 (m3, m1): " + esNeutralizada_v1(m3, m1));
		//Indicar aqui alguna prueba mas si se considera oportuno

		System.out.println("\nPRUEBA v2:");
		System.out.println(" * esNeutraliza_v2 (m1, m2): " + esNeutralizada_v2(m1, m2));
		System.out.println(" * esNeutraliza_v2 (m3, m1): " + esNeutralizada_v2(m3, m1));
		//Indicar aqui alguna prueba mas si se considera oportuno

		System.out.println("\nPRUEBA DyV:");
		System.out.println(" * esNeutraliza_DyV (m1, m2): " + esNeutralizada_DyV(m1, m2));
		System.out.println(" * esNeutraliza_DyV (m3, m1): " + esNeutralizada_DyV(m3, m1));
		//Indicar aqui alguna prueba mas si se considera oportuno

		/* ****** DATOS PERSONALES ****** */

		String miNombre = "Mario";
		String misApellidos = "Carrasco Pérez";
		String miExpediente = "21960626";

		System.out.println("\nESTUDIANTE:");
		System.out.println(" * Apellidos:\t" + misApellidos);
		System.out.println(" * Nombre:\t" + miNombre);
		System.out.println(" * Expediente:\t" + miExpediente);

		System.out.println("\n*** FIN ***");

	}//main

}//class


public class TrianguloEquilatero {

	public static void main(String[] args) {
		trianguloEqu(4);
	}

	public static void trianguloEqu(int n) {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}

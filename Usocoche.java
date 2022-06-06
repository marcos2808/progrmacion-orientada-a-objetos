package camioneta;

import java.util.Scanner;

public class Usocoche {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		camioneta camioneta2 = new camioneta();
		System.out.println("la camioneta es automatica o manual?");
		String traccion1 = entrada.nextLine();
		camioneta2.pedirTraccion(traccion1);
		System.out.println("el anio de fabricacion?");
		int anio = entrada.nextInt();
		camioneta2.pedirAnofabricacion(anio);
		System.out.println("posee calefaccion?");
		String calefaccion1 = entrada.nextLine();
		camioneta2.pedircalefaccion(calefaccion1);
		System.out.println("tiene asientos de tela?");
		String asientosdetela1 = entrada.nextLine();
		camioneta2.pedirAsientosdetela(asientosdetela1);
		System.out.println("fue fabricada por?");
		String marca1 = entrada.nextLine();
		camioneta2.pedirMarca(marca1);
		System.out.println("que modelo es?");
		String modelo1 = entrada.nextLine();
		camioneta2.pedirModelo(modelo1);
		
		System.out.println(camioneta2.darEspecificaciones());

	}

}

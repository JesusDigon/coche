package coches;

import java.util.Random;

public class CarreradeCoches {
	
	public static void main(String[] args) {
			
		Random valor = new Random();  // Variable que me genera números aleatorios
		final int META = 1500; // 500 kilómetros		
		coche parrilla [] = new coche [5]; // Parrilla de salida con 5 coches
	
		
		parrilla [0] = new coche ("Ferrari",300);
		parrilla [1] = new coche ("600",100);
		parrilla [2] = new coche ("BMW",220);
		parrilla [3] = new coche ("Seat",150);
		parrilla [4] = new coche ("La Cabra",10);
		
		// Test de pruebas para comporbar la detección de errores
	
		coche c1 = parrilla[0];
		coche c2 = parrilla[1];
		c1.acelera(10);
		c2.frena(20);
		c1.parar();
		c2.recorre();
	
		
		// Arranquen los motores
		for(int i=0; i< parrilla.length; i++){
			parrilla[i].arrancar();
		}
		
		// Comienza la carrera
		
		do {
			for (int i = 0; i < parrilla.length; i++) {
				parrilla[i].acelera(valor.nextInt(30));
				parrilla[i].recorre();
				parrilla[i].frena(valor.nextInt(10));
				System.out.println(parrilla[i].info());
			}
			System.out.println("----------------------------------------");
				
		} while ( ! alcanzarMeta ( parrilla, META) );

		// Ordena la tabla para mostrar la clasificación
	    ordenarClasificacion ( parrilla);
		
	    
		// Muestra la clasificación
		for(int i=0; i< parrilla.length; i++){
			System.out.println((i+1)+"º Clasificado "+ parrilla[i].info());
		}
		
	
	}








	// MÉTODOS AUXILIAREs
	// Devuelve verdadero si hay algun coche que haya recorrido la distancia indicada.
	
	static public boolean alcanzarMeta ( coche tcoches[], int distancia){
		boolean fin = false;
		for (int t = 0; t < tcoches.length; t++) {
		     if ( tcoches[t].getKilometros() >= distancia ){
		    	 fin = true; 
		    	 break;
		     }
		}
		return fin;
	}
	
	// Ordeno por el método de la burbuja, no es le mejor pero si el más
	// sencillo
	static void ordenarClasificacion ( coche tcoches[]){
	   
	 for ( int i = 0; i < tcoches.length-1; i++) {
	     for (int j=0; j < tcoches.length-i-1; j++){
				// Si no esta ordenado realizo el intercambio
				if ( tcoches[j].getKilometros() < tcoches[j+1].getKilometros()){
					coche aux = tcoches[j];
					tcoches[j] = tcoches[j+1];
					tcoches[j+1] = aux;
				}
			}
	    }	
	}
}
	


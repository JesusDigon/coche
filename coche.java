package coches;

public class coche {
	// Definir los atributos
	private String Modelo;
	private int velocidadmax, distanciatot, distancia, velocidad;
	private boolean arrancado;
	
	
	// Definir los métodos
	
	coche ( String modelo, int velocidadMax){
		this.Modelo=modelo;
		this.velocidadmax=velocidadMax;
		
		this.distanciatot=0;
		this.arrancado=false;
		this.velocidad=0;
	}
	
	public boolean arrancar(){
		if (this.arrancado==false) {
		this.arrancado=true;
		this.distancia=0;
	  return true;	
		}else {
		infoError("no se puede arrancar el coche, pues ya esta arrancado");
			return false;
		}
	}

	public boolean parar(){
		if(this.arrancado==true) {
		this.arrancado=false;
		return true;	
		}else {
			infoError("no se puede parar el coche, pues ya esta parado");
			return false;
		}
	}

	public boolean acelera( int cantidad){
		 if (arrancado==false) {
   		  infoError("no se puede acelerar, el coche esta parado");
   		  return false;
		 }else {
		
		if (cantidad+this.velocidad < this.velocidadmax) {
			this.velocidad=this.velocidad+cantidad;
			return true;
		}else {
			infoError("no se puede acelerar por encima de la velocidad maxima");
			return false;
		}
		 }	
	}
	
      public boolean frena ( int cantidad){
    	  if (arrancado==false || this.velocidad==0) {
    		  infoError("no se puede frenar, el coche esta parado");
    		  return false;
    	  }else {
    	  if(this.velocidad-cantidad >= 0) {
    		  this.velocidad=this.velocidad-cantidad;
    		  
    	  }else this.velocidad=0;
    	  return true;	
    	  }
	}
	
     public boolean recorre (){
    	 
    	 this.distancia=this.velocidad+this.distancia;
    	 this.distanciatot=this.distanciatot+this.distancia;
	   return true;	
     }
	
     public String info(){
    	 String estado;
    	 if (arrancado=true) {
    		 estado="arrancado";
    	 }else estado="parado";
	   return "el coche: "+ Modelo+"va a una velocidad de: "+ velocidad + "con el motor: "+ estado+ "lleva; "+distancia+" km parciales "+ "y: "+distanciatot+ " km totales ";
     }
	
     public int getKilometros(){
    	 int dis=this.distancia;
	   return dis;
   }
   
    private void infoError( String mensaje){
	  
    	System.out.println(mensaje);
   }	
}


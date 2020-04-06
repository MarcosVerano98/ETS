package ETS;

import java.util.Scanner;

public class PruebasUnitarias {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean fine = false;
		 double precio1 = 0.0, preciofinal=0.0, precio2 = 0.0, precio3 = 0.0, precio4=0.0;
		do {
			System.out.println("Que prueba quiere relizar \n 1.Primera sin maestro \n 2.Segunda con maestro \n 3. Tercera con maestro y con pintor \n 4. Salir");
			int opcion= sc.nextInt();
			
			switch(opcion) {
			case 1: precio1 = Material("cemento", 50);
					precio2 = Herramientas("pala", 40);
					precio3 = ManoDeObra("albañil", "cemento", "pala", 4, 3);
					preciofinal = precio1+precio2+precio3;
				System.out.println("El precio final de la obra es: " + preciofinal);
				break;
				
			case 2: precio1 = Material("pintura", 50);
			precio2 = Herramientas("perfilador", 40);
			precio3 = ManoDeObra("maestro", "cemento", "pala", 35, 1);
			preciofinal = precio1+precio2+precio3;
			System.out.println("El precio final de la obra es: " + preciofinal);
			break;
			
			case 3: precio1 = Material("pintura", 50);
			precio2 = Herramientas("pinceles", 40);
			precio3 = ManoDeObra("maestro", "cemento", "pala", 35, 1);
			precio4 = ManoDeObra("pintor", "pintura", "pinceles", 35, 1);
			preciofinal = precio1+precio2+precio3;
			System.out.println("El precio final de la obra es: " + preciofinal);
			break;
			case 4: fine=true;
			break; 
			
			default: System.out.println("Se ha equivocado con la eleccion vuelva a introducir la opcion ");
			break;
			}
		}while(!fine);
	}
	public static double Material(String material, double cantidad) {
		double precio =0.0;
		
		if(material.equals("cemento")) {
			if(cantidad>50) {
				System.out.println("Le voy a comprar solo 50kg porque es el maximo de cemento que puede comprar "  + material +"\n");
				precio = cantidad * 0.34;
			}
			precio = cantidad *0.34;
		} else {
			if(material.equals("pintura")) {
				if(cantidad>50) {
					System.out.println("Le voy a cobrar solo 100L porque ha superado el limite de " + material +"\n");
					precio = cantidad *2.54;
				}
				precio = cantidad *2.54;
			} else if(material.equals("losas")) {
				if(cantidad>600) {
					System.out.println("Le voy a cobrar solo 600 metros cuadrados ya que ha superado el limite "  + material +"\n");
					precio = cantidad *3.15; 
				}
				
				precio = cantidad *3.15; 
			} else if(material.equals("yeso")) {
				if(cantidad > 35) {
					System.out.println("Le voy a cobrar solo 35kg ya que ha superado el limite "  + material +"\n");
					precio = cantidad *0.56;
				}
				precio = cantidad *0.56;
			}
		}
		return precio;
	}
	
	public static double Herramientas(String material, double cantidad) {
		double precio =0.0;
		
		if(material.equals("llana")) {
			
				
				precio = cantidad * 1.13;
			
			
		} else {
			if(material.equals("pala")) {
				
					
					precio = cantidad *4.15;
				
				
			} else if(material.equals("pinceles")) {
				
					
					precio = cantidad *0.65; 
				
				
				
			} else if(material.equals("perfilador")) {
				if(cantidad > 15) {
					System.out.println("Le voy a cobrar solo 15 ya que ha superado el limite "  + material +"\n");
					precio = cantidad *1.21;
				}
				precio = cantidad *1.21;
			}
		}
		return precio;
	}
	
	
	public static double ManoDeObra(String tipo, String mat1, String mat2, int horas, int cantidad) {
		double precio = 0.0;
		if(tipo.equals("albañil")) {
			if(cantidad>3) {
				System.out.println("Solo se puede un maximo de tres albañiles por el precio sera evaluado a traves de esos 3 albañiles \n");
				precio = (cantidad *14) * horas;
			}
			precio = (cantidad *14) * horas;
		} else if((mat1.equals("pinceles") && mat2.equals("pintura")) || (mat1.equals("pintura") && mat2.equals("pinceles"))){
			if(tipo.equals("pintor")) {
				precio = (cantidad*16.50) * horas;
			}
			
		} else if(horas>34) {
			if(tipo.equals("maestro")) {
				if(cantidad >1) {
					System.out.println("Solo puede haber un maestro en la obra \n");
					precio = (cantidad *22)*horas;
				}
				precio = (cantidad *22)*horas;
			}
		}
		
		return precio;
	}
}

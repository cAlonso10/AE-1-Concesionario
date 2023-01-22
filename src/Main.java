import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class Main {

	public static void main(String[] args) {
		 ArrayList<Coches> listaCoches = new ArrayList<Coches>();
		 Scanner sc = new Scanner(System.in);
		 
		 File archivo = new File("coches.dat");
		 if (archivo.exists()) {
			 try {
				    FileInputStream fichero = new FileInputStream("coches.dat");
				    ObjectInputStream lectura = new ObjectInputStream(fichero);

				    ArrayList<Coches> cocheLeido = (ArrayList<Coches>) lectura.readObject();
				    while (cocheLeido != null) {
				        listaCoches.addAll(cocheLeido);
				        cocheLeido = (ArrayList<Coches>) lectura.readObject();
				    }

				    lectura.close();
				    fichero.close();
				} catch (EOFException e) {
				    // Fin del archivo alcanzado
				} catch (IOException e) {
				    e.printStackTrace();
				} catch (ClassNotFoundException e) {
				    e.printStackTrace();
				}
		 } else {
		     System.out.println("El archivo "+archivo+" no existe");
		 }
		 
		 //Menu
		 int opcion = 0;
		 while (opcion != 6) {
		 System.out.println("##########Concesionario##########");
         System.out.println("1- Añadir nuevo coche");
         System.out.println("2- Borrar coche por id");
         System.out.println("3- Consulta coche por id");
         System.out.println("4- Listado de coches");
         System.out.println("5- Exportar coches a archivo CSV");
         System.out.println("6- Terminar programa");
         System.out.println("#################################\n");
         opcion = sc.nextInt();
         
         switch(opcion) {
         	case 1:
         		System.out.println("Introduzca el id:");
                int id = sc.nextInt();
                System.out.println("Introduzca la matricula:");
                String matricula = sc.next();
                if (Coches.existeMatricula(matricula, listaCoches)) {
                    System.out.println("La matrícula ya existe, no se puede agregar el coche");
                    break;
                }
                System.out.println("Introduzca la marca:");
                String marca = sc.next();
                System.out.println("Introduzca el modelo:");
                String modelo = sc.next();
                System.out.println("Introduzca el color:");
                String color = sc.next();
                Coches nuevoCoche = new Coches(id, matricula, marca, modelo, color);
                listaCoches.add(nuevoCoche);
                break;
         	case 2:
         		System.out.println("Escriba la ID del coche que quiera borrar:");
         		int idBorrar = sc.nextInt();
         		for (int i = 0; i < listaCoches.size(); i++) {
                    Coches coches = listaCoches.get(i);
                    	if (idBorrar == coches.getId()) {
						listaCoches.remove(coches);
                    	}
					}
                break;
         	case 3:
         		System.out.println("Escriba la ID del coche que quiera consultar:");
         		int idConsulta = sc.nextInt();
         		for (int i = 0; i < listaCoches.size(); i++) {
                    Coches coches = listaCoches.get(i);
                    	if (idConsulta == coches.getId()) {
						System.out.println(coches);	
                    	}
					}
                break;
         	case 4:
         		for (int i = 0; i < listaCoches.size(); i++) {
                    Coches coches = listaCoches.get(i);
						System.out.println(coches);	
					}
                break;
         	case 5:
         		FileWriter csv = null;
                try {
                    csv = new FileWriter("coches.csv");
                    for (Coches coche : listaCoches) {
                        csv.write(coche.getId() + ";" + coche.getMatricula() + ";" + coche.getMarca() + ";" + coche.getModelo() + ";" + coche.getColor() + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        csv.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
         	case 6:
         		try {
         			FileOutputStream fichero = new FileOutputStream("coches.dat");
         			ObjectOutputStream escritura = new ObjectOutputStream(fichero);
         			escritura.writeObject(listaCoches);
         			escritura.close();
         			fichero.close();
                     System.out.println("Programa terminado, se ha guardado la información en" + archivo);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
         }
         
		 }
         
		 

		
		 
	}

}

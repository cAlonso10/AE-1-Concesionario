import java.io.Serializable;
import java.util.ArrayList;

public class Coches implements Serializable{
	
	 private int id;
	 private String matricula;
	 private String marca;
	 private String modelo;
	 private String color;
	 
	 
	 
	public Coches() {
		super();
	}
	public Coches(int id, String matricula, String marca, String modelo, String color) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
	}
	
	static boolean existeMatricula(String matricula, ArrayList<Coches> listaCoches) {
	    for (Coches coche : listaCoches) {
	        if (coche.getMatricula().equals(matricula)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Coches [id=" + id + ", matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", color="
				+ color + "]";
	}

	

}

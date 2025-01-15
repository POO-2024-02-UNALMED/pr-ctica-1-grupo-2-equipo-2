package ordenFisica;



public class Plato {
	private float precio;
	private  Ingrediente[] ingredientesNecesarios;
	
	public Plato(float precio,Ingrediente[] I_N) {
		this.precio=precio;
		this.ingredientesNecesarios=I_N;
	}
	
	public float getPrecio() {
		return precio;
	}
	
	public void setPrecio(float precio) {
		this.precio=precio;
	}
	
	public Ingrediente[] getI_N() {
		return ingredientesNecesarios;
	}
	
	public void setI_N(Ingrediente[] I_N) {
		this.ingredientesNecesarios=I_N;
	}
}

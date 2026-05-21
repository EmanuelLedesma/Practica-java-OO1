package modelo;

public class Circulo {
	private Punto origen;
	private double radio;
	
	public Circulo(Punto origen, double radio) {
		super();
		this.origen = origen;
		this.radio = radio;
	}
	

	public Punto getOrigen() {
		return origen;
	}


	public void setOrigen(Punto origen) {
		this.origen = origen;
	}


	public double getRadio() {
		return radio;
	}


	public void setRadio(double radio) {
		
		this.radio = radio;
		
	}
	
	
	public void setRadio(Punto radio){
		this.radio = this.origen.calcularDistancia(radio);
	}
	
	public double calcularPerimetro() {
		return 2*Math.PI*this.radio;
	}
	
	public double calcularArea(){
		return Math.PI*Math.pow(this.radio, 2);
	}
	
	public double calcularDistancia(Circulo circulo) {
		return this.origen.calcularDistancia(circulo.getOrigen());
	}


	@Override
	public String toString() {
		return "Circulo [origen=" + origen + ", radio=" + radio + "]";
	}
	
	public boolean equals (Circulo circulo) {
		return this.origen.equals(circulo.getOrigen()) && this.radio == circulo.getRadio();
	}

	
}

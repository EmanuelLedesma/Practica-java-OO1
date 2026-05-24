package modelo;

import java.util.Objects;

public class AlimentoNoPerecedero extends Producto{
	private int mesesDeGarantia;
	private int cantidadMinima;
	
	public AlimentoNoPerecedero(int idProducto, int codigo, String nombre, float precio, Categoria categoria,
			int cantidadDisponible, int mesesDeGarantia, int cantidadMinima) {
		super(idProducto, codigo, nombre, precio, categoria, cantidadDisponible);
		this.mesesDeGarantia = mesesDeGarantia;
		this.cantidadMinima = cantidadMinima;
	}
	public int getMesesDeGarantia() {
		return mesesDeGarantia;
	}
	public void setMesesDeGarantia(int mesesDeGarantia) {
		this.mesesDeGarantia = mesesDeGarantia;
	}
	public int getCantidadMinima() {
		return cantidadMinima;
	}
	public void setCantidadMinima(int cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}
	@Override
	public String toString() {
		return "AlimentoNoPerecedero [mesesDeGarantia=" + mesesDeGarantia + ", cantidadMinima=" + cantidadMinima + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cantidadMinima, mesesDeGarantia);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlimentoNoPerecedero other = (AlimentoNoPerecedero) obj;
		return cantidadMinima == other.cantidadMinima && mesesDeGarantia == other.mesesDeGarantia;
	}
	
	
	@Override
	public boolean esNecesarioReabastecer() {
	    return this.cantidadDisponible < this.cantidadMinima;
	}
	
	
}

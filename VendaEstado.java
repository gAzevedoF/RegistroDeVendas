
public class VendaEstado {
	private String estado;
	private int qtde;
	private double vlrVenda;

	public VendaEstado(String estado, int qtde, double vlrVenda) {
		this.estado = estado;
		this.qtde = qtde;
		this.vlrVenda = vlrVenda;
	}

	@Override
	public String toString() {
		return estado + "            " + qtde + "            " + vlrVenda;
	}

	public String toCommaText() {
		return estado + ";" + qtde + ";" + vlrVenda;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VendaEstado other = (VendaEstado) obj;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		return true;
	}

	public String getEstado() {
		return estado;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public double getVlrVenda() {
		return vlrVenda;
	}

	public void setVlrVenda(double vlrVenda) {
		this.vlrVenda = vlrVenda;
	}

}

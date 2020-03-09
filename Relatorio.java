import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Relatorio implements IRelatorio {

	private SinglyLinkedList<VendaEstado> venda;
	private int pos;

	public Relatorio() {
		this.venda = new SinglyLinkedList<>();
		this.pos = 0;
	}

	@Override
	public void carregar(File file) throws IOException {
		// TODO Auto-generated method stub
		try (BufferedReader ler = new BufferedReader(new FileReader(file))) {
			for (String linha = ler.readLine(); linha != null; linha = ler.readLine()) {
				String[] dados = linha.split(";");
				VendaEstado v = new VendaEstado(dados[1], Integer.parseInt(dados[4]), Double.parseDouble(dados[5]));
				if (isExiste(v)) {
					venda.get(pos).setQtde(venda.get(pos).getQtde() + v.getQtde());
					venda.get(pos).setVlrVenda(venda.get(pos).getVlrVenda() + v.getVlrVenda());
				} else {
					venda.insertLast(v);
				}
			}
		}
	}

	private boolean isExiste(VendaEstado v) {
		for (int i = 0; i < venda.numElements(); i++) {
			if (venda.get(i).getEstado().equalsIgnoreCase(v.getEstado())) {
				pos = i;
				return true;
			}
		}
		return false;
	}

	@Override
	public void exibir() {
		// TODO Auto-generated method stub
		int totalVendas = 0;
		double valorTotaldeVendas = 0;

		System.out.println("Vendas por Estado");
		System.out.println("==============================");
		for (int i = 0; i < venda.numElements(); i++) {
			totalVendas += venda.get(i).getQtde();
			valorTotaldeVendas += venda.get(i).getVlrVenda();
			System.out.println(venda.get(i).toString());
		}
		System.out.println("==============================");
		System.out.println("              " + totalVendas + "           " + valorTotaldeVendas);
	}

	@Override
	public void exibirMelhorEstado() {
		// TODO Auto-generated method stub
		SinglyLinkedList<VendaEstado> maiorVenda = new SinglyLinkedList<VendaEstado>();
		VendaEstado aux = null;
		double maior = 0;
		for (int i = 0; i < venda.numElements(); i++) {
			if (venda.get(i).getVlrVenda() > maior) {
				maior = venda.get(i).getVlrVenda();
			}
		}

		for (int i = 0; i < venda.numElements(); i++) {
			if (venda.get(i).getVlrVenda() >= maior) {
				maior = venda.get(i).getVlrVenda();
				aux = venda.get(i);
				maiorVenda.insertLast(aux);
			}
		}

		System.out.println("Estados(s) com Maior Venda");
		System.out.println("==============================");
		for (int i = 0; i < maiorVenda.numElements(); i++) {
			System.out.println(maiorVenda.get(i).toString());
		}
		System.out.println("==============================");

	}

	@Override
	public void salvar(File file) throws IOException {
		// TODO Auto-generated method stub
		try (BufferedWriter escrever = new BufferedWriter(new FileWriter(file))) {
			if (venda.isEmpty()) {
				escrever.write("Sem Vendas");
			} else {
				for (int i = 0; i < venda.numElements(); i++) {
					escrever.write(venda.get(i).toCommaText());
					escrever.newLine();
				}
			}
		}
	}

}

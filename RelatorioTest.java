import java.io.File;
import java.io.IOException;

public class RelatorioTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IRelatorio relatorio = new Relatorio();

		try {
			relatorio.carregar(new File("c://temp/Entrada.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		relatorio.exibir();
		
		System.out.println();
		System.out.println();
		
		relatorio.exibirMelhorEstado();
		
		try {
			relatorio.salvar(new File("c://temp/Saida.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

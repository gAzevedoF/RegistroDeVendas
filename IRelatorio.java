import java.io.File;
import java.io.IOException;

public interface IRelatorio {
	public void carregar(File file) throws IOException;

	public void exibir();

	public void exibirMelhorEstado();

	public void salvar(File file) throws IOException;

}

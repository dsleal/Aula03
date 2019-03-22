package br.com.aulajpadao;

import java.util.List;
import javax.swing.JOptionPane;
import br.com.aulajpa.Contato;

public class TesteContatoDaoJpa {
	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setNome("Joaquim");
		ContatoDaoJpa cdao = new ContatoDaoJpa();
		cdao.incluir(contato);
		List<Contato> lista = cdao.listar();
		for (Contato c : lista) {
			System.out.printf("\n%10d%-30s", c.getCodigo(), c.getNome());
		}
		int codigoExcluir = new Integer(JOptionPane.showInputDialog("Qual registro excluir?"));

		cdao.excluir(codigoExcluir);
		lista = cdao.listar();
		for (Contato c : lista) {
			System.out.printf("\n%10d%-30s", c.getCodigo(), c.getNome());
		}
	}
}
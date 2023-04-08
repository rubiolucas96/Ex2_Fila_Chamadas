package Controller;

import br.edu.fateczl.filastring.Fila;

	public class TelefoneController {
		public void insereLigacao(Fila f, String numeroTelefone) {
			f.insert(numeroTelefone);
		}

		public void consultaLigacoes(Fila f) throws Exception {
			if (f.isEmpty()) {
				throw new Exception("Nenhuma ligação perdida!");
			}

			System.out.println("Ligações perdidas:");
			while (!f.isEmpty()) {
				System.out.println(f.remove());
			}
		}
	}



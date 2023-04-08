package View;


import javax.swing.JOptionPane;

import br.edu.fateczl.filastring.Fila;
import Controller.TelefoneController;

public class Principal {

    public static void main(String[] args) {

        Fila chamadasPerdidas = new Fila();
        TelefoneController controller = new TelefoneController();

        int opcao = -1;
        do {
            String input = JOptionPane.showInputDialog(null, "Escolha uma opção:\n"
                    + "1. Registrar uma chamada perdida\n"
                    + "2. Consultar as chamadas perdidas\n"
                    + "0. Sair");

            if (input == null) {
               
                continue;
            }

            try {
                opcao = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida, digite uma valida!");
                continue;
            }

            switch (opcao) {
                case 1:
                    String numeroTelefone = JOptionPane.showInputDialog(null, "Digite o número de telefone:");
                    if (numeroTelefone != null && !numeroTelefone.isBlank()) {
                        controller.insereLigacao(chamadasPerdidas, numeroTelefone);
                        JOptionPane.showMessageDialog(null, "Chamada perdida registrada.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Número de telefone inválido.");
                    }
                    break;
                case 2:
                    try {
                        controller.consultaLigacoes(chamadasPerdidas);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Encerrando a aplicação...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
            }

        } while (opcao != 0);

    }

}

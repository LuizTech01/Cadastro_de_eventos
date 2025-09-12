package menu.alterarEvento;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class alterarEvento {

    public void alterarEvento() {
        List<String> linhas = carregarArquivo();

        if (linhas.isEmpty()) {
            System.out.println("Nenhum evento encontrado para alterar.");
            return;
        }

        System.out.println("\nEventos cadastrados:");
        for (int i = 0; i < linhas.size(); i++) {
            if (linhas.get(i).startsWith("Nome: ")) {
                System.out.println((i + 1) + " - " + linhas.get(i).substring(6));
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDigite o nome do evento que deseja alterar: ");
        String nomeProcurado = scanner.nextLine();

        int indice = -1;
        for (int i = 0; i < linhas.size(); i++) {
            if (linhas.get(i).equals("Nome: " + nomeProcurado)) {
                indice = i;
                break;
            }
        }

        if (indice == -1) {
            System.out.println("Evento não encontrado!");
            return;
        }

        System.out.println("\nO que deseja alterar?");
        System.out.println("1 - Nome");
        System.out.println("2 - Endereço");
        System.out.println("3 - Categoria");
        System.out.println("4 - Data e Hora");
        System.out.println("5 - Descrição");
        System.out.print("Escolha: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // limpar buffer

        System.out.print("Digite o novo valor: ");
        String novoValor = scanner.nextLine();

        switch (opcao) {
            case 1 -> linhas.set(indice, "Nome: " + novoValor);
            case 2 -> linhas.set(indice + 1, "Endereço: " + novoValor);
            case 3 -> linhas.set(indice + 2, "Categoria: " + novoValor);
            case 4 -> linhas.set(indice + 3, "Data e Hora: " + novoValor);
            case 5 -> linhas.set(indice + 4, "Descrição: " + novoValor);
            default -> {
                System.out.println("Opção inválida!");
                return;
            }
        }

        salvarArquivo(linhas);

        System.out.println("Evento alterado com sucesso!");
    }

    private List<String> carregarArquivo() {
        List<String> linhas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("evento.data"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                linhas.add(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler eventos: " + e.getMessage());
        }
        return linhas;
    }

    private void salvarArquivo(List<String> linhas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("evento.data", false))) {
            for (String linha : linhas) {
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar eventos: " + e.getMessage());
        }
    }
}

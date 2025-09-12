package menu.participarEvento;

import java.io.*;
import java.util.Scanner;

public class participarEvento {
    private static final String ARQUIVO_PARTICIPACAO = "participacao.data";

    public void confirmarParticipacao() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome do evento que deseja participar: ");
        String nome = sc.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_PARTICIPACAO, true))) {
            writer.write(nome);
            writer.newLine();
            System.out.println("Participação confirmada no evento: " + nome);
        } catch (IOException e) {
            System.out.println("Erro ao salvar participação: " + e.getMessage());
        }
    }

    public void cancelarParticipacao() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome do evento que deseja cancelar: ");
        String nome = sc.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_PARTICIPACAO))) {
            String linha;
            StringBuilder sb = new StringBuilder();
            while ((linha = reader.readLine()) != null) {
                if (!linha.equalsIgnoreCase(nome)) {
                    sb.append(linha).append(System.lineSeparator());
                }
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_PARTICIPACAO, false))) {
                writer.write(sb.toString());
            }
            System.out.println("Participação cancelada para: " + nome);
        } catch (IOException e) {
            System.out.println("Erro ao cancelar participação: " + e.getMessage());
        }
    }

    public void listarParticipacoes() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_PARTICIPACAO))) {
            String linha;
            System.out.println("Eventos confirmados:");
            while ((linha = reader.readLine()) != null) {
                System.out.println("- " + linha);
            }
        } catch (IOException e) {
            System.out.println("Nenhuma participação encontrada.");
        }
    }
}

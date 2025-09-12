package menu.cadastroDeEvento;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class cadastrarEvento {
    private String nome;
    private String endereco;
    private String categoria;
    private String horario;
    private String descricao;

    public void cadastroEvento() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o nome do evento: ");
        this.nome = scanner.nextLine();

        System.out.print("Informe o endereço do evento: ");
        this.endereco = scanner.nextLine();

        System.out.print("Informe a categoria do evento: ");
        this.categoria = scanner.nextLine();

        System.out.print("Informe a hora do evento (HH:mm): ");
        this.horario = scanner.nextLine();

        try {
            LocalTime.parse(this.horario, DateTimeFormatter.ofPattern("HH:mm"));
        } catch (Exception e) {
            System.out.println("Formato inválido. Use HH:mm (ex: 14:30).");
            return;
        }

        System.out.print("Informe uma descrição para o evento: ");
        this.descricao = scanner.nextLine();

        System.out.println("Evento registrado com sucesso!");

        salvarNoArquivo();
    }

    private void salvarNoArquivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("evento.data", true))) {
            writer.write("Nome: " + this.nome);
            writer.newLine();
            writer.write("Endereço: " + this.endereco);
            writer.newLine();
            writer.write("Categoria: " + this.categoria);
            writer.newLine();
            writer.write("Hora: " + this.horario);
            writer.newLine();
            writer.write("Descrição: " + this.descricao);
            writer.newLine();
            writer.write("-----------------------------");
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar o evento: " + e.getMessage());
        }
    }
}

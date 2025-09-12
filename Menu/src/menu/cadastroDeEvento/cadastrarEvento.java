package menu.cadastroDeEvento;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class cadastrarEvento {
    private String nome;
    private String endereco;
    private String categoria;
    private String horario;
    private String descricao;

    public void cadastroEvento() {

        Scanner scanner = new Scanner(System.in);

        System.out.printf("Informe o nome do evento ");
        this.nome = scanner.nextLine();

        System.out.printf("Informe o endereco do evento: ");
        this.endereco = scanner.nextLine();

        System.out.printf("Informe a categoria do evento: ");
        this.categoria = scanner.nextLine();

        System.out.printf("Informe a data e hora do evento: ");
        this.horario = scanner.nextLine();

        System.out.printf("Informe uma descricao para o evento: ");
        this.descricao = scanner.nextLine();

        System.out.println("Evento regisrado com sucesso!");

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
            writer.write("Data e Hora: " + this.horario);
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

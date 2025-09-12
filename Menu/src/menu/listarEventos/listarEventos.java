package menu.listarEventos;

import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class listarEventos {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
    private static final String PARTICIPACAO_FILE = "participacao.data";

    public void listarEventos() {
        Set<String> participacoes = carregarParticipacoes();

        try (BufferedReader reader = new BufferedReader(new FileReader("evento.data"))) {
            String linha;
            LocalTime agora = LocalTime.now();
            String nomeEventoAtual = null;

            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);

                if (linha.startsWith("Nome: ")) {
                    nomeEventoAtual = linha.substring(6);
                }

                if (linha.startsWith("Hora: ")) {
                    String horaStr = linha.substring(6);
                    LocalTime horaEvento = LocalTime.parse(horaStr, FORMATTER);

                    if (horaEvento.isBefore(agora)) {
                        System.out.println("Status: Já ocorreu");
                    } else if (horaEvento.equals(agora)) {
                        System.out.println("Status: Ocorrendo agora");
                    } else {
                        System.out.println("Status: Futuro");
                    }

                    if (nomeEventoAtual != null) {
                        if (participacoes.contains(nomeEventoAtual)) {
                            System.out.println("Presença confirmada!");
                        } else {
                            System.out.println("Sem confirmação.");
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler os eventos: " + e.getMessage());
        }
    }

    private Set<String> carregarParticipacoes() {
        Set<String> participacoes = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PARTICIPACAO_FILE))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                participacoes.add(linha);
            }
        } catch (IOException ignored) {
        }
        return participacoes;
    }
}

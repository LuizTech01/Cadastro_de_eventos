package menu.listarEventos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class listarEventos {

    public void listarEventos() {
        try (BufferedReader reader = new BufferedReader(new FileReader("evento.data"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler os eventos: " + e.getMessage());
        }
    }
}

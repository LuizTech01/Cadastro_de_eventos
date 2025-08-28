import java.util.Scanner;

public class menu {

    public static void inicio() {

        System.out.println("Menu: ");
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            mostrarMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Você escolheu a opção 1: Cadastrar");
                    break;
                case 2:
                    System.out.println("Você escolheu a opção 2: Alterar");
                    break;
                case 0:
                    System.out.println("Saindo do programa. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();

    }

    public static void mostrarMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Cadastrar novo evento");
        System.out.println("2. Consultar eventos");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

}
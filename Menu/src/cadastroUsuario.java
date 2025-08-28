import java.util.Scanner;

public class cadastroUsuario {

    String user;
    String senha;
    int cpf;

    public static void cadastro(){

        login login = new login();
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Informe seu login: ");
        String usuario = scanner.nextLine();

        System.out.printf("Informe sua senha: ");
        String senha = scanner.nextLine();

    }

}

import java.util.Scanner;

public class login {

    String usuarioRoot = "root";
    String senhaRoot = "1234";

    public static void main(String[] args) {

        login login = new login();
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Informe seu login: ");
        String usuario = scanner.nextLine();

        System.out.printf("Informe sua senha: ");
        String senha = scanner.nextLine();

        if (usuario.equals(login.usuarioRoot) && senha.equals(login.senhaRoot)) {
            System.out.println("Login realizado com sucesso!");

            menu.inicio();
        } else {
            System.out.println("Login ou senha inválidos");
        }

        scanner.close();

    }

}

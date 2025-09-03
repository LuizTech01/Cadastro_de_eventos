package login;
import cadastro.cadastroUsuario;
import menu.menu;

import java.util.Scanner;

public class login {

    private cadastroUsuario usuarioCadastrado;

    public login(cadastroUsuario usuario) {
        this.usuarioCadastrado = usuario;
    }

    public void logins() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe seu login: ");
        String usuario = scanner.nextLine();

        System.out.print("Informe sua senha: ");
        String senha = scanner.nextLine();

        if (usuario.equals(usuarioCadastrado.getUser()) &&
                senha.equals(usuarioCadastrado.getSenha())) {

            System.out.println("Login realizado com sucesso!");
            menu.inicio();

        } else {
            System.out.println("Login ou senha inválidos");
        }

        scanner.close();
    }
}

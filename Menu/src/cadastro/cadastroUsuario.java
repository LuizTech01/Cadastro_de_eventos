package cadastro;

import login.login;
import java.util.Scanner;

public class cadastroUsuario {

    private String user;
    private String senha;
    private String cpf;

    public void cadastrar() {

        Scanner scanner = new Scanner(System.in);

        System.out.printf("Informe seu usuario para o cadastro: ");
        this.user = scanner.nextLine();

        System.out.printf("Informe sua senha para o cadastro: ");
        this.senha = scanner.nextLine();

        System.out.printf("Informe seu CPF para o cadastro: ");
        this.cpf = scanner.nextLine();

        System.out.println("Usuário cadastrado com sucesso!");

        login login = new login(this);
        login.logins();
    }

    public String getUser() {
        return user;
    }

    public String getSenha() {
        return senha;
    }

    public String getCpf() {
        return cpf;
    }


}

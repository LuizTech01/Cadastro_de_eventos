import cadastro.cadastroUsuario;
import login.login;

public class sistema {
    public static void main(String[] args) {
        cadastroUsuario cadastro = new cadastroUsuario();
        cadastro.cadastrar();

        login login = new login(cadastro);
        login.logins();
    }
}

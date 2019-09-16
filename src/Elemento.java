import java.util.Scanner;

public class Elemento {
    String nome;
    String email;
    String tel;
    int cod;
    double nota1;
    double nota2;
    double media;

    @Override
    public String toString() {
        return
                " Nome= " + nome +
                " Email= " + email +
                " Telefone= "+ tel +
                " Codigo= "+ cod +
                " Nota 1= "+ nota1 +
                " Nota 2= "+ nota2 +
                " Media= "+ media;
    }

    public void ler(){
        Scanner tc = new Scanner(System.in);

        cod = lerCod();
        System.out.println("Digite o nome");
        nome= tc.next();
        email = lerEmail();
        tel = lerTel();
        System.out.println("Digite a nota 1");
        nota1 = tc.nextDouble();
        System.out.println("Digite a nota 2");
        nota2 = tc.nextDouble();
        media = (nota1 + nota2*2)/3;
    }

    public String lerTel(){
        Scanner tc = new Scanner(System.in);
        String tel;
        boolean validar;
        String val = "\\d\\d-\\d\\d\\d\\d\\d\\d\\d\\d\\d";

        System.out.println("Digite seu Telefone (xx-xxxxxxxx)");
        tel = tc.next();
        validar = tel.matches(val);

        if (validar == true){
            return tel;
        }else
            System.out.println("falta algum numero");
        return lerTel();
    }

    public String lerEmail(){
        Scanner tc = new Scanner(System.in);
        String email;
        boolean validar;

        System.out.println("Digite seu email");
        email = tc.next();
        validar = email.matches(".*@.*");

        if (validar == true){
            return email;
        }else
            System.out.println("email errado, tente novamente");
            return lerEmail();
    }

    public static int lerCod() {
        boolean valida = true;
        int numero = 0;
        Scanner tc = new Scanner(System.in);
        do {
            System.out.println("Digite o código numérico (xxx)");
            try {
                numero = Integer.parseInt(tc.nextLine());
                return (numero);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite apenas números!");
                valida = false;
            }
        } while (valida != true);
        return (numero);
    }
}
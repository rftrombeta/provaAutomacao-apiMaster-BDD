package testCases.utilitarios;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class Uteis {

    static Random random = new Random();

    public static String selecionaCpfComRestricaoAleatorio() {


        Integer valor = random.nextInt(10) + 1;

        if (valor == 1) return RegistrosComRestricao.cpf1;
        if (valor == 2) return RegistrosComRestricao.cpf2;
        if (valor == 3) return RegistrosComRestricao.cpf3;
        if (valor == 4) return RegistrosComRestricao.cpf4;
        if (valor == 5) return RegistrosComRestricao.cpf5;
        if (valor == 6) return RegistrosComRestricao.cpf6;
        if (valor == 7) return RegistrosComRestricao.cpf7;
        if (valor == 8) return RegistrosComRestricao.cpf8;
        if (valor == 9) return RegistrosComRestricao.cpf9;
        if (valor == 10) return RegistrosComRestricao.cpf10;
        return null;
    }

    public static String geraCpf() {
        int n = 9;
        int n1 = randomiza(n);
        int n2 = randomiza(n);
        int n3 = randomiza(n);
        int n4 = randomiza(n);
        int n5 = randomiza(n);
        int n6 = randomiza(n);
        int n7 = randomiza(n);
        int n8 = randomiza(n);
        int n9 = randomiza(n);
        int d1 = n9 * 2 + n8 * 3 + n7 * 4 + n6 * 5 + n5 * 6 + n4 * 7 + n3 * 8 + n2 * 9 + n1 * 10;

        d1 = 11 - (mod(d1, 11));

        if (d1 >= 10)
            d1 = 0;

        int d2 = d1 * 2 + n9 * 3 + n8 * 4 + n7 * 5 + n6 * 6 + n5 * 7 + n4 * 8 + n3 * 9 + n2 * 10 + n1 * 11;

        d2 = 11 - (mod(d2, 11));

        String retorno = null;

        if (d2 >= 10)
            d2 = 0;
        retorno = "";

        return retorno = "" + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + d1 + d2;
    }

    private static int randomiza(int n) {
        int ranNum = (int) (Math.random() * n);
        return ranNum;
    }

    private static int mod(int dividendo, int divisor) {
        return (int) Math.round(dividendo - (Math.floor(dividendo / divisor) * divisor));
    }

    public static String geraNomes() {

        String[] nomes = {"Rodrigo", "Fernando", "Ana Carla", "Manuela", "Isabella"};
        String[] sobreNomes = {"Trombeta", "Silva", "Souza", "Fernandes", "Almeida"};

        return nomes[random.nextInt(4) + 1] + " " + sobreNomes[random.nextInt(4) + 1];
    }

    public static String geraEmail() {

        byte[] array = new byte[7];
        new Random().nextBytes(array);

        String email = RandomStringUtils.randomAlphabetic(10);

        return email+"@gmail.com";
    }

    public static Integer geraValor() {

        return random.nextInt((40000 - 1000) + 1) + 1000;
    }

    public static Integer geraParcelas() {

        return random.nextInt((48 - 2) + 1) + 48;
    }
}

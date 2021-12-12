import java.util.Arrays;

class DadosEx03 {
    static Float[] numeros;
    static float valMediana;
    static float valDesvio;
    static float valVariancia;
}

public class ex03 {

    public static void mediana() {
        Float[] ordenada = Arrays.copyOf(DadosEx03.numeros, DadosEx03.numeros.length);
        Arrays.sort(ordenada);
        int tam = ordenada.length;
        if (tam % 2 == 0) {
            tam = tam / 2;
            DadosEx03.valMediana = (float) (ordenada[tam - 1] + ordenada[tam]) / 2;
        } else {
            DadosEx03.valMediana = ordenada[tam / 2];
        }
    }

    public static void desvioPadrao() {
        variancia();
        DadosEx03.valDesvio = (float) Math.sqrt(DadosEx03.valVariancia);
    }

    public static void variancia() {
        float soma = 0;
        float media = media();
        for (float num : DadosEx03.numeros) {
            soma += Math.pow(num - media, 2);
        }
        DadosEx03.valVariancia = soma / DadosEx03.numeros.length;
    }

    public static float media() {
        float soma = 0;
        for (float num : DadosEx03.numeros) {
            soma += num;
        }
        return soma / DadosEx03.numeros.length;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Uso : java ex03 <numero1> <numero2> ...");
            System.exit(-1);
        }
        DadosEx03.numeros = Arrays.stream(args).map(Float::valueOf).toArray(Float[]::new);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mediana();
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                desvioPadrao();
            }
        });
        t2.start();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                variancia();
            }
        });
        t3.start();

        try {
            t1.join();
            System.out.println("Mediana: " + DadosEx03.valMediana);
            t2.join();
            System.out.println("Desvio-Padrao: " + DadosEx03.valDesvio);
            t3.join();
            System.out.println("Variancia: " + DadosEx03.valVariancia);
        } catch (Exception e) {
        }
    }
}

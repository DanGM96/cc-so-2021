import java.util.Arrays;

class DadosEx02 {
    static Float[] numeros;
    static float valMedio;
    static float valMax;
    static float valMin;
}

public class ex02 {

    public static void media() {
        float soma = 0;
        for (float num : DadosEx02.numeros) {
            soma += num;
        }
        DadosEx02.valMedio = soma / DadosEx02.numeros.length;
    }

    public static void min() {
        float min = Integer.MAX_VALUE;
        for (float num : DadosEx02.numeros) {
            if (num < min) {
                min = num;
            }
        }
        DadosEx02.valMin = min;
    }

    public static void max() {
        float max = Integer.MIN_VALUE;
        for (float num : DadosEx02.numeros) {
            if (num > max) {
                max = num;
            }
        }
        DadosEx02.valMax = max;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Uso : java ex02 <numero1> <numero2> ...");
            System.exit(-1);
        }
        DadosEx02.numeros = Arrays.stream(args).map(Float::valueOf).toArray(Float[]::new);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                media();
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                min();
            }
        });
        t2.start();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                max();
            }
        });
        t3.start();

        try {
            t1.join();
            System.out.println("Media: " + DadosEx02.valMedio);
            t2.join();
            System.out.println("Min: " + DadosEx02.valMin);
            t3.join();
            System.out.println("Max: " + DadosEx02.valMax);
        } catch (Exception e) {
        }
    }
}

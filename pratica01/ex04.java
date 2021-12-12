public class ex04 {

    public static void primos(int numero) {
        int i, j;
        boolean ePrimo;

        for (i = 2; i <= numero; i++) {
            ePrimo = true;

            for (j = 2; j <= i / 2; ++j) {
                if (i % j == 0) {
                    ePrimo = false;
                    break;
                }
            }

            if (ePrimo) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Uso : java ex04 <numero>");
            System.exit(-1);
        }
        int numero = Integer.valueOf(args[0]);

        new Thread(() -> {
            primos(numero);
        }).start();
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ex01 {

    public static void contagem(File file) {
        int linhas = 0;
        int palavras = 0;
        int letras = 0;
        String str = "";
        Scanner scan = null;

        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scan.hasNextLine()) {
            linhas++;
            str += "\n" + scan.nextLine();
        }
        scan.close();

        String[] words = str.split("\\s+");
        palavras = words.length - 1;

        letras = str.replaceAll("[^a-zA-Z]", "").length();

        System.out.println(file.getName() + "\t linhas[" + linhas + "]" + " palavras[" + palavras + "]" + " letras["
                + letras + "]");
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Uso : java ex01 <nome_diretorio>");
            System.exit(-1);
        }

        File folder = new File(args[0]);
        for (File file : folder.listFiles()) {
            if (file.getName().endsWith(".txt")) {
                new Thread(() -> {
                    contagem(file);
                }).start();
            }
        }
    }
}

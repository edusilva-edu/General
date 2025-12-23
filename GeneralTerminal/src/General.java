import java.util.Random;
import java.util.Scanner;

public class General {
    public static Scanner teclado = new Scanner(System.in);

    // ================
    // Pontuações fixas
    // ================
    final static int FULL_HOUSE = 25;
    final static int STRAIGTH = 50;
    final static int GENERAL = 60;

    // =========
    // Atributos
    // =========
    final static int NUM_DADOS = 5;
    final static int NUM_JOGADAS = 3;

    // =========
    // Variáveis
    // =========
    static boolean estado = true;

    static void rolarDados(boolean[] travar) {
        Random rand = new Random();
        int[] dados = new int[NUM_DADOS];
        int contadorDeJogadas = 0;

        while (contadorDeJogadas < NUM_JOGADAS) {
            System.out.print(" ");
            for(int i = 0; i < NUM_DADOS; i++) {
                System.out.print((i+1) + "     ");
            }

            System.out.println(); // Pular a linha

            for(int i = 0; i < NUM_DADOS; i++) {
                if (!travar[i]) {
                    dados[i] = rand.nextInt(1, 7);
                }
                System.out.print("[" + dados[i] + "]   "); 
            }

            System.out.println(); // Pular a linha

            System.out.print("Dados pra travar: ");
            String praTravar = new String();
            praTravar = teclado.next();
            travar = travarDados(praTravar);

            contadorDeJogadas++;
        }
    }
    
    static boolean[] travarDados(String praTravar) {
        boolean[] travar = new boolean[NUM_DADOS];
        
        for(int i = 0; i < (praTravar.length()); i++) {
            travar[Character.getNumericValue((praTravar.charAt(i)) - 1)] = true;
        }
        return travar;
        
    }
    public static void main(String[] args) throws Exception {
        System.out.println("==== GENERAL ====");
        teclado.nextLine();
        boolean[] travar = new boolean[NUM_DADOS];
        rolarDados(travar);
    }
} 

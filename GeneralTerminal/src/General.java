import java.util.Random;
import java.util.Scanner;

public class General {
    public static Scanner teclado = new Scanner(System.in);

    // ================
    // Pontuações
    // ================
    final static int UM = 1;
    final static int DOIS = 2;
    final static int TRES = 3;
    final static int QUATRO = 4;
    final static int CINCO = 5;
    final static int SEIS = 6;
    final static int TRINCA = 5; // Somatório dos dados + 5.
    final static int QUADRA = 10; // Somatório dos dados + 10.
    final static int FULL_HOUSE = 25;
    final static int STRAIGTH = 50;
    final static int CORINGA = 0; // Somatório dos dados.
    final static int GENERAL = 60;

    // =========
    // Atributos
    // =========
    final static int NUM_DADOS = 5;
    final static int NUM_JOGADAS = 3;

    // =========
    // Variáveis
    // =========
    static int score = 0;
    static boolean estado = true;
    static String[] tabela = {"Um: ", "Dois: ", "Tres: ", "Quatro: ", "Cinco: ", "Seis: ",
    "Trinca: ", "Quadra: ", "Full House: ", "Straight: ", "Coringa: ", "General I: ", "General II: "};
    static int[] scoreIndividual = new int[13];
    static boolean[] jaPontuado = new boolean[13];

    static int[] rolarDados(boolean[] travar) {
        Random rand = new Random();
        int[] dados = new int[NUM_DADOS];
        int contadorDeJogadas = 0;

        while (contadorDeJogadas < NUM_JOGADAS) {
            System.out.print(" ");
            for(int i = 0; i < NUM_DADOS; i++) {
                System.out.print((i + 1) + "     ");
            }

            System.out.println(); // Pular a linha

            for(int i = 0; i < NUM_DADOS; i++) {
                if (!travar[i]) {
                    dados[i] = rand.nextInt(1,7);
                }
                System.out.print("[" + dados[i] + "]   "); 
            }

            calcularPontuação(dados);
            
            System.out.println(); // Pular a linha

            if (contadorDeJogadas < (NUM_JOGADAS - 1)) {
                System.out.print("Dados pra travar: ");
                String praTravar = new String();
                praTravar = teclado.next();
                travar = travarDados(praTravar);
            }
            contadorDeJogadas++;
        }

        return dados;
    }

    static void calcularPontuação(int[] dados) {
        for (int t = 1; t <= tabela.length; t++) {
            int ocorrências = 0;
            for (int i = 0; i < NUM_DADOS; i++) {
                if (t == dados[i]) {
                    ocorrências++;
                }
            }
            if (!jaPontuado[t - 1]){
                scoreIndividual[t - 1] = ocorrências * t;
            }
        }
        jogos(); // Imprime tabela
        System.out.print("Pontuar: ");
        jaPontuado[teclado.nextInt() - 1] = true;
    }

    static void jogos() {

        System.out.println(); // Pular a linha
        System.out.println(); // Pular a linha

        System.out.println("======Tabela======");
        for (int i = 0; i < tabela.length; i++) {
            if (jaPontuado[i]) {
                System.out.println((i + 1) + " - " + tabela[i] + scoreIndividual[i] + " *");
            } else {
                System.out.println((i + 1) + " - " + tabela[i] + scoreIndividual[i]);
            }
        }
        System.out.println("==================");
        System.out.println("Pontuação: " + score);
    }

    static boolean[] travarDados(String praTravar) {
        boolean[] travar = new boolean[NUM_DADOS];
        
        for(int i = 0; i < (praTravar.length()) && Character.getNumericValue(praTravar.charAt(i)) != 0; i++) {
            travar[Character.getNumericValue((praTravar.charAt(i)) - 1)] = true;
        }
        return travar;
        
    }
    public static void main(String[] args) throws Exception {
        System.out.println("==== GENERAL ====");
        teclado.nextLine();
        boolean[] travar = new boolean[NUM_DADOS];
        rolarDados(travar);
        teclado.nextLine();
    }
} 
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o tempo limite do jogo (em segundos): ");
        int tempoLimite = scanner.nextInt() * 1000; // Convertendo para milissegundos
        scanner.nextLine(); // Consumir a quebra de linha após a leitura do inteiro

        JogoDasPalavras jogo = new JogoDasPalavras(tempoLimite);
        jogo.iniciarJogo();
    }
}
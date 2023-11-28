import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class JogoDasPalavras {
    private final int tempoLimite;
    private final Set<String> palavrasConhecidas;
    private List<String> palavrasValidas;
    public void LerArquivo(){
        Path path = Paths.get("br-utf8.txt");
        try {
            palavrasValidas = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public JogoDasPalavras(int tempoLimite) {
        this.tempoLimite = tempoLimite;
        this.palavrasConhecidas = new HashSet<>();
        this.palavrasValidas = new ArrayList<>();
        LerArquivo();
    }

    public void iniciarJogo() {
        char letraSorteada = sortearLetra();
        System.out.println("Comece a digitar palavras que começam com a letra: " + letraSorteada);

        long startTime = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        while (System.currentTimeMillis() - startTime < tempoLimite) {
            String palavra = scanner.nextLine().toLowerCase();
            char primLetra = palavra.charAt(0);
            if (validarPalavra(palavra) && primLetra == letraSorteada){
                if (palavrasValidas.contains(palavra)) {
                    palavrasConhecidas.add(palavra);
                } else {
                    System.out.println("Palavra repetida! Tente outra.");
                }
            } else {
                System.out.println("Palavra inválida! Tente outra.");
            }
        }

        encerrarJogo();
    }

    public char sortearLetra() {
        Random random = new Random();
        return (char) (random.nextInt(26) + 'a');
    }

    private boolean validarPalavra(String palavra) {
        return palavra.length() >= 3 && palavra.matches("[a-zA-Z]+");}

    private void encerrarJogo() {
        System.out.println("Jogo encerrado. Você conhece " + palavrasConhecidas.size() + " palavras diferentes:");
        for (String palavra : palavrasConhecidas) {
            System.out.println(palavra);
        }
    }
}
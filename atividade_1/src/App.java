import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Cadastro dos produtos com imagem
        Map<Integer, Produto> menu = new HashMap<>();
        menu.put(1, new Produto(1, "Cachorro Quente", 4.00, "assets/cachorro_quente.jpg"));
        menu.put(2, new Produto(2, "X-Salada", 4.50, "assets/x_salada.jpg"));
        menu.put(3, new Produto(3, "X-Bacon", 5.00, "assets/x_bacon.jpg"));
        menu.put(4, new Produto(4, "Torrada Simples", 2.00, "assets/torrada.jpg"));
        menu.put(5, new Produto(5, "Refrigerante", 1.50, "assets/refrigerante.jpg"));

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o código do item: ");
        int codigo = scanner.nextInt();
        
        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();
        
        if (menu.containsKey(codigo)) {
            Produto produto = menu.get(codigo);
            double total = produto.getPreco() * quantidade;
            System.out.printf("Total: R$ %.2f\n", total);
            System.out.println("Produto: " + produto.getDescricao());
            System.out.println("Imagem armazenada em: " + produto.getImagem());
        } else {
            System.out.println("Código inválido!");
        }
        
        scanner.close();
    }
}

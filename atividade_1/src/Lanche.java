import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.StandardCopyOption;


class Produto {
    private int codigo;
    private String descricao;
    private double preco;
    private String imagem; // Caminho da imagem

    public Produto(int codigo, String descricao, double preco, String imagemOrigem) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.imagem = salvarImagem(imagemOrigem);
    }

    private String salvarImagem(String imagemOrigem) {
        File pastaImagens = new File("imagens");
        if (!pastaImagens.exists()) {
            pastaImagens.mkdir(); // Cria a pasta se não existir
        }

        File arquivoOrigem = new File(imagemOrigem);
        File arquivoDestino = new File(pastaImagens, arquivoOrigem.getName());

        // Copia a imagem apenas se ainda não estiver na pasta
        if (!arquivoDestino.exists()) {
            try {
                Files.copy(arquivoOrigem.toPath(), arquivoDestino.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.err.println("Erro ao salvar a imagem: " + e.getMessage());
            }
        }

        return arquivoDestino.getPath(); // Retorna o caminho final da imagem
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getImagem() {
        return imagem;
    }
}

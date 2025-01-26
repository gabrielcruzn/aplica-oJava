import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Obra {
    protected String nome;
    protected String autor;
    protected int ano;

    public Obra(String nome, String autor, int ano) {
        this.nome = nome;
        this.autor = autor;
        this.ano = ano;
    }

    public abstract void exibirDetalhes();
}

class Livro extends Obra {
    private int paginas;
    private String editora;

    public Livro(String nome, String autor, int ano, int paginas, String editora) {
        super(nome, autor, ano);
        this.paginas = paginas;
        this.editora = editora;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Livro: " + nome + ", Autor: " + autor + ", Ano: " + ano + ", Páginas: " + paginas + ", Editora: " + editora);
    }
}

class CD extends Obra {
    private String gravadora;

    public CD(String nome, String autor, int ano, String gravadora) {
        super(nome, autor, ano);
        this.gravadora = gravadora;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("CD: " + nome + ", Artista: " + autor + ", Ano: " + ano + ", Gravadora: " + gravadora);
    }
}

class DVD extends Obra {
    private String genero;
    private int duracao;

    public DVD(String nome, String autor, int ano, String genero, int duracao) {
        super(nome, autor, ano);
        this.genero = genero;
        this.duracao = duracao;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("DVD: " + nome + ", Ator: " + autor + ", Ano: " + ano + ", Gênero: " + genero + ", Duração: " + duracao + " min");
    }
}

public class CadastroObras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Obra> obras = new ArrayList<>();

        while (true) {
            System.out.println("\nEscolha o tipo de obra para cadastrar:");
            System.out.println("1 - Livro");
            System.out.println("2 - CD");
            System.out.println("3 - DVD");
            System.out.println("4 - Sair e listar obras cadastradas");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha == 4) break;

            System.out.print("Nome da obra: ");
            String nome = scanner.nextLine();
            System.out.print("Autor/Ator: ");
            String autor = scanner.nextLine();
            System.out.print("Ano de lançamento: ");
            int ano = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1: 
                    System.out.print("Número de páginas: ");
                    int paginas = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Editora: ");
                    String editora = scanner.nextLine();
                    obras.add(new Livro(nome, autor, ano, paginas, editora));
                    break;
                case 2: 
                    System.out.print("Gravadora: ");
                    String gravadora = scanner.nextLine();
                    obras.add(new CD(nome, autor, ano, gravadora));
                    break;
                case 3: 
                    System.out.print("Gênero: ");
                    String genero = scanner.nextLine();
                    System.out.print("Duração (min): ");
                    int duracao = scanner.nextInt();
                    scanner.nextLine();
                    obras.add(new DVD(nome, autor, ano, genero, duracao));
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        System.out.println("\nObras cadastradas:");
        for (Obra obra : obras) {
            obra.exibirDetalhes();
        }
        scanner.close();
    }
}

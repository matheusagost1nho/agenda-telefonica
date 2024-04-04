package app;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.InputMismatchException;

public class AgendaTelefonica {
    private Map<String, Long> contatos;

    public AgendaTelefonica(){
        contatos = new HashMap<>();
    }

    public void adicionarContato(String nome, Long numero){
        contatos.put(nome, numero);
        System.out.println("Contato " + nome + " adicionado com sucesso.");
    }

    public void removerContato(String nome){
        if (contatos.containsKey(nome)){
            contatos.remove(nome);
            System.out.println("Contato " + nome + " removido com sucesso.");
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    public void buscarContatos(String nome){
        if (contatos.containsKey(nome)){
            System.out.println(nome + ": " + contatos.get(nome));
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    public void exibirContatos(){
        if (contatos.isEmpty()){
            System.out.println("Lista vazia.");
        } else {
            System.out.println("Lista de contatos:");
            for (Map.Entry<String, Long> entry : contatos.entrySet()){
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }


    public static void main(String[] args){
        AgendaTelefonica agenda = new AgendaTelefonica();
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;
        boolean entradaValida = true;

        do {
            do {
        System.out.println("\nAgenda Telefônica\n" +
                    "1. Adicionar contato\n" +
                    "2. Remover contato\n" +
                    "3. Buscar contato\n" +
                    "4. Exibir todos os contatos\n" +
                    "5. Sair\n" +
                    "Escolha uma opção:");

        try {
            opcao = scanner.nextInt();
            entradaValida = true;
        } catch (InputMismatchException inputError1) {
            System.err.println("Digite um número");
            entradaValida = false;
        }
        scanner.nextLine();
         } while (!entradaValida);

        switch (opcao){
            case 1: 
            long numero = 0;
            System.out.println("Nome do contato: ");
            String nome = scanner.nextLine();
            System.out.println("Número do contato: ");
            try {
                numero = scanner.nextLong();
                agenda.adicionarContato(nome, numero);
            } catch (InputMismatchException inputError2){
                System.err.println("Contato não adicionado\n" + "Digite apenas números.");
            }
            scanner.nextLine();
            break;

            case 2:
            System.out.println("Nome do contato");
            nome = scanner.nextLine();
            System.out.println("Excluir " + nome + " da lista de contatos? (s/n)");
            String confirma = scanner.nextLine();
            if (confirma.equalsIgnoreCase("s")){
            agenda.removerContato(nome);
            } else {
                System.out.println("Contato " + nome + " não removido.");
            }
            break;

            case 3:
            System.out.println("Contato a ser buscado: ");
            nome = scanner.nextLine();
            agenda.buscarContatos(nome);
            break;

            case 4:
            agenda.exibirContatos();
            break;

            case 5:
            System.out.println("Saindo...");
            break;
        }
        } while (opcao != 5);

        scanner.close();
}
}
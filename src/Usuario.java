import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Usuario {

    private String nome;
    private ArrayList<Contato> contatos;

    public Usuario(String nome){
        this.nome = nome;
        this.contatos = new ArrayList<>();
    }

    public void inserirContato(Contato novoContato){

        if(encontrarContato(novoContato.getNome()) == null){
            contatos.add(novoContato);
            System.out.printf("Contato %s foi adicionado\n", novoContato.getNome());
        }else{
            System.out.printf("Contato %s já foi adicionado anteriormente\n", novoContato.getNome());
        }

    }

    public void enviarMensagem(Contato contato, Mensagem mensagem){

        if(encontrarContato(contato.getNome()) != null){
            contato.newMessage(mensagem);
            System.out.println("Mensagem enviada");
        }

    }

    public void listarMensagens(Contato contato){
            if(encontrarContato(contato.getNome()) != null){
                System.out.printf("\n---%s---", contato.getNome());
                for(Mensagem mensagem : contato.getMensagens()){
                    System.out.printf("\n[%s] %s", new Date(), mensagem.getMensagem());
                }
                System.out.println("\n");
            }
    }

    public Contato encontrarContato(String nome){
        for(Contato listaContato : contatos){
            if(listaContato.getNome().equals(nome)){
                return listaContato;
            }
        }

        return null;
    }

    public void conversar(){
        while(true){

            System.out.println("\nEscolha uma opção:");
            System.out.println("1: Adicionar contato");
            System.out.println("2: Enviar msg para contato");
            System.out.println("3: Mostrar conversa");
            System.out.println("4: Sair :c\n");

            String opcao = new Scanner(System.in).nextLine();

            if(Integer.parseInt(opcao) == 1){
                System.out.println("Insira o nome do contato que deseja adicionar: ");
                String novoContato = new Scanner(System.in).nextLine();

                this.inserirContato(new Contato(novoContato));
            }

            if(Integer.parseInt(opcao) == 2){
                System.out.println("Escolha o contato que deseja enviar a msg: ");
                String contato = new Scanner(System.in).nextLine();

                Contato contatoBuscado = encontrarContato(new Contato(contato).getNome());
                if(contatoBuscado != null){
                    System.out.println("Mande a mensagem: ");
                    String message = new Scanner(System.in).nextLine();
                    this.enviarMensagem(contatoBuscado, new Mensagem(message));
                }else{
                    System.out.printf("%s não está na sua lista de contatos\n", contato);
                }
            }

            if(Integer.parseInt(opcao) == 3){
                System.out.println("Escolha o contato que deseja visualizar as msg: ");
                String contato = new Scanner(System.in).nextLine();

                Contato contatoBuscado = encontrarContato(new Contato(contato).getNome());
                if(contatoBuscado != null){
                    this.listarMensagens(contatoBuscado);
                }else{
                    System.out.printf("%s não está na sua lista de contatos\n", contato);
                }
            }

            if(Integer.parseInt(opcao) == 4){
                break;
            }

        }
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

}

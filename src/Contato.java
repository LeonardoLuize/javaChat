import java.util.ArrayList;

public class Contato {

    private String nome;
    private ArrayList<Mensagem> mensagens;

    public Contato(){
    }

    public Contato(String nome){
        this.nome = nome;
        this.mensagens = new ArrayList<>();
    }

    public ArrayList<Mensagem> getMensagens() {
        return mensagens;
    }

    public String getNome() {
        return nome;
    }

    public void newMessage(Mensagem mensagem){
        mensagens.add(mensagem);
    }
}

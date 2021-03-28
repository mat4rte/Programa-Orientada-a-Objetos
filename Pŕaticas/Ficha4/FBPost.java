import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class FBPost {


    private int id;
    private String utilizador;
    private LocalDateTime data_criacao;
    private String conteudo;
    private int likes;
    private ArrayList<String> comments;

    public FBPost(){
        this.id = -1;
        this.utilizador = "";
        this.data_criacao = LocalDateTime.now();
        this.conteudo = "";
        this.likes = 0;
        this.comments = new ArrayList<String>();
    }

    public FBPost(int id, String utilizador, LocalDateTime data_criacao, String conteudo, int likes, ArrayList<String> comments) {
        this.id = id;
        this.utilizador = utilizador;
        this.data_criacao = data_criacao;
        this.conteudo = conteudo;
        this.likes = likes;
        this.comments = comments;
    }

    public FBPost(FBPost post){
        this.id = post.getId();
        this.utilizador = post.getUtilizador();
        this.data_criacao = post.getData_criacao();
        this.conteudo = post.getConteudo();
        this.likes = post.getLikes();
        this.comments = post.getComments();
    }

    // Clone, .equals, toString

    @Override
    public String toString() {
        return "FBPost{" +
                "id=" + id +
                ", utilizador='" + utilizador + '\'' +
                ", data_criacao=" + data_criacao +
                ", conteudo='" + conteudo + '\'' +
                ", likes=" + likes +
                ", comments=" + comments +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FBPost fbPost = (FBPost) o;
        return  this.id == fbPost.id                                   &&
                this.likes == fbPost.likes                             &&
                this.utilizador.equals(fbPost.utilizador)              &&
                this.data_criacao.equals(fbPost.data_criacao)          &&
                this.conteudo.equals(fbPost.conteudo)                  &&
                this.comments.equals(fbPost.comments);
    }

    public FBPost clone() {
        return new FBPost(this);
    }


    //Getters e setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(String utilizador) {
        this.utilizador = utilizador;
    }

    public LocalDateTime getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(LocalDateTime data_criacao) {
        this.data_criacao = data_criacao;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public ArrayList<String> getComments() {
        return this.comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = new ArrayList<>(comments);
    }
}
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TestaFB {
    public static void main(String[] args) {

        FBPost p1 = new FBPost(1, "Éder", LocalDateTime.now(), "Hoje é Feriado crllll", 567, new ArrayList<String>());
        FBPost p2 = new FBPost(2, "Bruno Aleixo", LocalDateTime.now(), "Nunca comas gelados no café do Aires", 240, new ArrayList<String>());
        FBPost p3 = new FBPost(3, "Renato Alexandre", LocalDateTime.now(), "Colesterol é um mito", 75, new ArrayList<String>());
        FBPost p4 = new FBPost(4, "Um gajo que não o Paulo Portas", LocalDateTime.now(), "Isto é principio é que o Paulo Portas é um burro", 0, new ArrayList<String>());
        FBPost p5 = new FBPost(5, "Paulinho", LocalDateTime.now(), "O Ventura até diz umas verdades", -70, new ArrayList<String>());
        FBPost p6 = new FBPost(6, "Éder", LocalDateTime.now(), "Bom...", 0, new ArrayList<String>());

        ArrayList<FBPost> posts = new ArrayList<>();
        posts.add(p1);
        posts.add(p2);
        posts.add(p3);
        posts.add(p4);
        posts.add(p5);
        posts.add(p6);

        FBFeed feed = new FBFeed(posts);

        feed.comment(1, "Sigaaaa");
        feed.comment(2, "E também nunca bebas nada!!");
        feed.comment(3, "Facts");
        feed.comment(4, "Certo");
        feed.comment(5, "*inserir emoji bandeira PT*");
        feed.comment(6, "Diga Professor");

        feed.like(6);
        System.out.println("Função nrPosts" + "Eder: " + feed.nrPosts("Éder") + " Bruno Aleixo: " + feed.nrPosts("Bruno Aleixo"));
        System.out.println("PostsOf Bruno Aleixo: " + feed.postsOf("Bruno Aleixo"));
        System.out.println("PostsOf Éder: " + feed.postsOf("Éder"));



        //System.out.println("\n\n"+ feed.toString());


    }
}

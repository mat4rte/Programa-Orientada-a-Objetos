import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FBFeed {

    private ArrayList<FBPost> posts;


    public FBFeed() {
        this.posts = new ArrayList<>();
    }

    public FBFeed(ArrayList<FBPost> publ){
        this.setPosts(publ);
    }

    public FBFeed(FBFeed feed){
        setPosts(feed.getPosts());
    }

    // clone, toString, equals

    @Override
    public String toString() {
        return  "-----------------\n" +
                "FEED:\n" +
                "posts = " + posts +
                "\n----------------";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FBFeed fbFeed = (FBFeed) o;
        return this.posts.equals(fbFeed.posts);
    }

    public FBFeed clone(){
        return new FBFeed(this);
    }

    //Getters, setters

    public ArrayList<FBPost> getPosts() {
        return this.posts.stream().map(FBPost :: clone).collect(Collectors.toCollection(ArrayList :: new));
    }

    public void setPosts(ArrayList<FBPost> posts) {
        this.posts = posts.stream().map(FBPost::clone).collect(Collectors.toCollection(ArrayList :: new));
    }

    //i)

    public int nrPosts(String user){
        return (int) this.posts.stream().filter(post -> post.getUtilizador().equals(user)).count();
    }

    //ii)

    public List<FBPost> postsOf(String user){
        return this.posts.stream().filter(pos -> pos.getUtilizador().equals(user)).collect(Collectors.toList());
    }

    //iii)

    public List<FBPost> postsOf(String user, LocalDateTime inicio, LocalDateTime fim){
        return this.posts.stream().filter(pos -> pos.getUtilizador().equals(user) &&
                                          pos.getData_criacao().isBefore(fim) &&
                                          pos.getData_criacao().isAfter(inicio)).collect(Collectors.toList());
    }

    //iv)

    public FBPost getPost(int id){
        //return this.posts.stream().filter(pos -> pos.getId() == id).collect(Collector.;
        for(FBPost post: this.posts){
            if (post.getId() == id){
                return post;
            }
        }
        return null;
    }

    //v)

    public void comment(FBPost post, String comentario){
        post.getComments().add(comentario);
    }

    //vi)

    public void comment(int postid, String comentario){
        for(FBPost post : this.posts){
            if(post.getId() == postid){
                post.getComments().add(comentario);
                System.out.println(post.getComments());
                break;
            }
        }
    }

    //vii)

    public void like(FBPost post){
        post.setLikes(post.getLikes() + 1);
    }

    //viii)

    public void like(int postid){
        like(getPost(postid));
    }

    //ix)



}

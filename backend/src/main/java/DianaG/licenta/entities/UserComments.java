package DianaG.licenta.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class UserComments {
    private String username;
    private List<Comment> commentsList= new ArrayList<>();

    public UserComments() {
    }

    public UserComments(String username, List<Comment> commentsList) {
        this.username = username;
        this.commentsList = commentsList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Comment> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comment> commentsList) {
        this.commentsList = commentsList;
    }

    public void addComment(Comment fave)
    {
        this.commentsList.add(fave);
    }
    public void deleteComment(Comment m) {
        for(int i=0; i<this.commentsList.size(); i++)
        {
            Comment move= this.commentsList.get(i);
            if(move.getId()==m.getId())
            {
                this.commentsList.remove(move);
            }

        }//  this.favouritesMovies.remove(m);
    }
}

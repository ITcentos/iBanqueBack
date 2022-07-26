package com.example.IBanque.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name="Message")
public class Message {
    //@EmbeddedId
    //private UserForumId UserForumId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long messageid;
    @ManyToOne
    @JoinColumn(name="ForumId")
    private Forum forum;

    @ManyToOne
    @Nullable
    @JoinColumn(name="UserId")
    private User user;

    @Column(name = "Content")
    private String Content;

    @Column(name = "Text")
    private String text;

    public Message(long messageid, Forum forum, User user, String content, String text) {
        this.messageid = messageid;
        this.forum = forum;
        this.user = user;
        Content = content;
        this.text = text;
    }
}

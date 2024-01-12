package com.example.jeeproject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id", nullable = false)
    @NotNull
    private User user;
    @ManyToOne
    @JoinColumn(name = "post_id",referencedColumnName = "id", nullable = false)
    @NotNull
    private Post post;

    public Like(User user, Post post){
        this.user = user;
        this.post = post;
    }

    public Like() {

    }
}

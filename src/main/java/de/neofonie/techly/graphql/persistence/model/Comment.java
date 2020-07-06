package de.neofonie.techly.graphql.persistence.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Data
@EqualsAndHashCode
@Entity
public class Comment {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String content;
    private Date created;
    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

}

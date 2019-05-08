package com.codegym.model;

import javax.persistence.*;

@Entity
public class Inote {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Note_type type;

    public Inote() {
    }

    public Inote(String title, String content, Note_type type) {
        this.title = title;
        this.content = content;
        this.type = type;
    }

    public Note_type getType() {
        return type;
    }

    public void setType(Note_type type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

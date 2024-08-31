package com.example.demo.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Entity

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnore
    private Long ID;
    private String name;

    @Enumerated(EnumType.STRING)
    private PostCategory postCategory;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "test_user_id", referencedColumnName = "ID")
    private TestUser testUser;

    public Post(Long ID, String name, PostCategory category) {
        this.ID = ID;
        this.name = name;
        this.postCategory = category;
    }
}

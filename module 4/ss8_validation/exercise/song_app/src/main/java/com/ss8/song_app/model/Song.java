package com.ss8.song_app.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Song implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @NotBlank
    @Size(max = 800)
    private String name;

    @NotEmpty
    @NotBlank
    @Size(max = 300)
    private String performer;

    @NotEmpty
    @NotBlank
    @Size(max = 1000)
    private String genre;

    public Song() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Song song = (Song) target;

        String name = song.getName();
        String performer = song.getPerformer();
        String genre = song.getGenre();

        if (!name.matches("^[0-9A-Za-z ]*$")) {
            errors.rejectValue("name", "name.matches", "something something");
        }

        if (!performer.matches("^[0-9A-Za-z ]+$")) {
            errors.rejectValue("performer", "performer.matches", "something something");
        }

        if (!genre.matches("^[0-9A-Za-z, ]+$")) {
            errors.rejectValue("genre", "genre.matches", "something something");
        }
    }
}

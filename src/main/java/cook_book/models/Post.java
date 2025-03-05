package cook_book.models;

import jakarta.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;

    private String title;

    @Column(length = 5000)
    private String full_text;
    private String imageUrl;

    @Column(length = 5000)
    private String ingredients;

    public Post() {
    }

    public Post(String title, String full_text, String imageUrl, String ingredients) {
        this.title = title;
        this.full_text = full_text;
        this.imageUrl = imageUrl;
        this.ingredients = ingredients;
    }

    public Long getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
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

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

}

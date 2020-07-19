package pl.coderslab.spring01hibernatekrkw04.entity;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 5, groups = {javax.validation.groups.Default.class,
    pl.coderslab.spring01hibernatekrkw04.validator.PropositionValidationGroup.class})
    private String title;
    @Range(min = 1, max = 10)
    private int rating;
    @Size(max = 600, groups = {javax.validation.groups.Default.class,
            pl.coderslab.spring01hibernatekrkw04.validator.PropositionValidationGroup.class})
    private String description;
    @ManyToOne
    @NotNull
    private Publisher publisher;
    @ManyToMany(fetch = FetchType.EAGER)
    @NotEmpty
    private List<Author> authors = new ArrayList<>();
    @Min(2)
    private int pages;
    private boolean proposition;
    @ManyToOne
    private Category category;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public Book setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getRating() {
        return rating;
    }

    public Book setRating(int rating) {
        this.rating = rating;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Book setDescription(String description) {
        this.description = description;
        return this;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public Book setPublisher(Publisher publisher) {
        this.publisher = publisher;
        return this;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public Book setAuthors(List<Author> authors) {
        this.authors = authors;
        return this;
    }

    public int getPages() {
        return pages;
    }

    public Book setPages(int pages) {
        this.pages = pages;
        return this;
    }

    public boolean isProposition() {
        return proposition;
    }

    public Book setProposition(boolean proposition) {
        this.proposition = proposition;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Book setCategory(Category category) {
        this.category = category;
        return this;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", publisher=" + publisher +
                '}';
    }
}

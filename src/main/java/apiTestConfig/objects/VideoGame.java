package apiTestConfig.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VideoGame {

    @JsonProperty("category")
    private String category;
    @JsonProperty("name")
    private String name;
    @JsonProperty("rating")
    private String rating;
    @JsonProperty("releaseDate")
    private String releaseDate;
    @JsonProperty("reviewScore")
    private Integer reviewScore;
    @JsonProperty("id")
    private Integer id;

    /**
     * No args constructor for use in serialization
     */
    public VideoGame() {
    }

    public VideoGame(String category, String name, String rating, String releaseDate, Integer reviewScore) {
        super();
        this.id = id;
        this.category = category;
        this.name = name;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.reviewScore = reviewScore;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("rating")
    public String getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(String rating) {
        this.rating = rating;
    }

    @JsonProperty("releaseDate")
    public String getReleaseDate() {
        return releaseDate;
    }

    @JsonProperty("releaseDate")
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @JsonProperty("reviewScore")
    public Integer getReviewScore() {
        return reviewScore;
    }

    @JsonProperty("reviewScore")
    public void setReviewScore(Integer reviewScore) {
        this.reviewScore = reviewScore;
    }
}

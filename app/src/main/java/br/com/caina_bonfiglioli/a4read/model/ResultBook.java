package br.com.caina_bonfiglioli.a4read.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultBook {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("bookTitle")
    @Expose
    private String bookTitle;
    @SerializedName("authorName")
    @Expose
    private String authorName;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("synopsis")
    @Expose
    private String synopsis;
    @SerializedName("bookFile")
    @Expose
    private Byte[] bookFile;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Byte[] getBookFile() {
        return bookFile;
    }

    public void setBookFile(Byte[] bookFile) {
        this.bookFile = bookFile;
    }
}

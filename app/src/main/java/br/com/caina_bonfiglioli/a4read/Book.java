package br.com.caina_bonfiglioli.a4read;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private int id;
    private String title;
    private String author;
    private String publishingCompany;
    private int year;

    public Book() {
    }

    public Book(int id, String title, String author, String publishingCompany, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishingCompany = publishingCompany;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static List<Book> listAdventure(){
        List<Book> books = new ArrayList<>();

        books.add(new Book(1,
                "A sociedade do anel",
                "J.R.R Tolkien",
                "Allen & Unwin",1954));

        books.add(new Book(2,
                "As duas torres",
                "J.R.R Tolkien",
                "Allen & Unwin", 1954));

        books.add(new Book(3,
                "O retorno do rei",
                "J.R.R Tolkien",
                "Allen & Unwin", 1955));

        books.add(new Book(4,
                "Jogos Vorazes",
                "Suzanne Collins",
                "Scholastic", 2008));

        return books;
    }

    public static  List<Book> listFiction(){
        List<Book> books = new ArrayList<>();

        books.add(new Book(5,
                "O guia do mochileiro das galaxias",
                "Douglas Adams",
                "Pan Books",1979));

        books.add(new Book(6,
                "O restaurante no fim do universo",
                "Douglas Adams",
                "Pan Books",1980));

        books.add(new Book(7,
                "Star Wars - Herdeiro do Imperio",
                "Timothy Zahn",
                "Bantam Spectra",1991));

        books.add(new Book(8,
                "Star Wars - Ascenção da Força Sombria",
                "Timothy Zahn",
                "Bantam Spectra",1993));

        books.add(new Book(9,
                "Star Wars - O Ultimo Comando",
                "Timothy Zahn",
                "Bantam Spectra",1994));

        return books;
    }

    public static  List<Book> listRomance(){
        List<Book> books = new ArrayList<>();

        books.add(new Book(10,
                "A culpa é das estrelas",
                "John Green",
                "Dutton Books", 2012));

        books.add(new Book(11,
                "Cidades de papel",
                "John Green",
                "Dutton Books", 2008));

        return books;
    }
}

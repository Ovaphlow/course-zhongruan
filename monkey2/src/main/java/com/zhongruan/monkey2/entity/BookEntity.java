package com.zhongruan.monkey2.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="book")
public class BookEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private Long id;

    public Long getId() {return this.id;}

    public void setId(Long id) {this.id = id;}

    @Column(name = "isbn", length = 50, nullable = false)
    private String isbn;

  public String getIsbn() {return this.isbn;}

  public void setIsbn(String isbn) {this.isbn = isbn;}

  @Column(name="name", length=100)
  private String name;

  public String getName() {return this.name;}

  public void setName(String name) {this.name = name;}

  @Column(name="former_name", length=100)
  private String formerName;

  public String getFormerName() {return this.formerName;}

  public void setFormerName(String formerName) {this.formerName = formerName;}

  @Column(name="author", length=100)
  private String author;

  public String getAuthor() {return this.author;}

  public void setAuthor(String author) {this.author = author;}

  @Column(name="translator", length=100)
  private String translator;

  public String getTranslator() {return this.translator;}

  public void setTranslator(String translator) {this.translator = translator;}

  @Column(name="publisher", length=50)
  private String publisher;

  public String getPublisher() {return this.publisher;}

  public void setPublisher(String publisher) {this.publisher = publisher;}

  @Column(name="publication_date")
  private String publicationDate;

  public String getPublicationDate() {return this.publicationDate;}

  public void setPublicationDate(String publicationDate) {
    this.publicationDate = publicationDate;
  }

  @Column(name="series", length=100)
  private String series;

  public String getSeries() {return this.series;}

  public void setSeries(String series) {this.series = series;}

  @Column(name="language", length=10)
  private String language;

  public String getLanguage() {return this.language;}

  public void setLanguage(String language) {this.language = language;}

  @Column(name="pages")
  private int pages;

  public int getPages() {return this.pages;}

  public void setPages(int pages) {this.pages = pages;}

  @Column(name="format", length=10)
  private String format;

  public String getFormat() {return this.format;}

  public void setFormat(String format) {this.format = format;}

  @Column(name="intro")
  private String intro;

  public String getIntro() {return this.intro;}

  public void setIntro(String intro) {this.intro = intro;}

  @Override
  public String toString() {
    return "BookEntity{" +
      "id=" + id +
      ", isbn='" + isbn + '\'' +
      ", name='" + name + '\'' +
      ", formerName='" + formerName + '\'' +
      ", author='" + author + '\'' +
      ", translator='" + translator + '\'' +
      ", publisher='" + publisher + '\'' +
      ", publicationDate='" + publicationDate + '\'' +
      ", series='" + series + '\'' +
      ", language='" + language + '\'' +
      ", pages=" + pages +
      ", format='" + format + '\'' +
      ", intro='" + intro + '\'' +
      '}';
  }
}
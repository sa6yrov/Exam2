package Task2;

import java.util.Date;

public class News {
    private Integer id;
    private String title;
    private String textOfNews;
    private Date publicationDate;

    public News(String title, String textOfNews) {
        this.title = title;
        this.textOfNews = textOfNews;
    }
    public News(Integer id, String title, String textOfNews){
        this.id = id;
        this.title = title;
        this.textOfNews = textOfNews;
    }

    @Override
    public String toString() {
        return "News: " + "id = '" + id +
                " | title = '" + title + '\'' +
                " | textOfNews='" + textOfNews;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTextOfNews() {
        return textOfNews;
    }

    public void setTextOfNews(String textOfNews) {
        this.textOfNews = textOfNews;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }
}

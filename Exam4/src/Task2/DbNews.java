package Task2;

import DbConnection.DbConnection;
import org.w3c.dom.ls.LSOutput;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbNews {
    public void addNews(News news) {
        String SQL = "insert into news (id, title, text_of_news, publication_date) values(?, ?, ?, now())";
        try (Connection conn = DbConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, news.getId());
            pstmt.setString(2, news.getTitle());
            pstmt.setString(3, news.getTextOfNews());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showNews(Integer id) {
        System.out.println(getNews(id));
    }

    public String deleteNews(Integer id) {
        if (checkById(id) == true) {
            String SQL = "delete from news where id = ?";
            try (Connection conn = DbConnection.connect();
                 PreparedStatement pstmt = conn.prepareStatement(SQL)) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return "Deleted news";
        }
        return "The news was not deleted";
    }

    public String  updateNews(String title, String textOfNews, Integer id) {
        if (checkById(id) == true) {
            String SQL = "update news set title = ?, text_of_news = ? where id = ?";
            try (Connection conn = DbConnection.connect();
                 PreparedStatement pstmt = conn.prepareStatement(SQL)) {
                pstmt.setString(1, title);
                pstmt.setString(2, textOfNews);
                pstmt.setInt(3, id);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Update was successfully");
        }
        return "Not found id";
    }

    public News getNews(Integer id) {
        if (checkById(id) == true) {
            String SQL = "select  title, text_of_news from news where id = ?";
            News news = null;
            try (Connection conn = DbConnection.connect();
                 PreparedStatement pstmt = conn.prepareStatement(SQL)) {
                pstmt.setInt(1, id);
                try (ResultSet rs = pstmt.executeQuery()) {
                    rs.next();
                    news = new News(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("text_of_news")
                    );
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return news;
        }
        return null;
    }

    public boolean checkById(Integer id) {
        String SQL = "select count(*) from news where id = ?";
        int count = 0;
        try (Connection conn = DbConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                rs.next();
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if (count == 1) return true;
        return false;
    }
}

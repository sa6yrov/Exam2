package Task2;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        News news1 = new News(1,"Малышева и ее секретный муж", "Американские СМИ рассекречили тайну президента РФ всему миру, японцы были в Шоке");
        News news2 = new News(2,"Немецкий вождь в шоке от их силы", "Фюрер отправил группу лучших ученных для изучения " +
                "выживших людей бывшей Кыргызской автономной области СССР и был просто в шоке от их...");

        //Add news
        DbNews dbNews = new DbNews();
//        dbNews.addNews(news1);
//        dbNews.addNews(news2);

       //Show news
        System.out.println("Enter 1 or 2 for show news");
        Integer id = scn.nextInt();
        dbNews.showNews(id);

        //Delete news
//        dbNews.deleteNews(news1);

        //UpdateNews
//        System.out.println("Write a new title of news: ");
//        String title = scn.nextLine();
//        System.out.println("Write a new text of news: ");
//        String texOfNews = scn.nextLine();
//        System.out.println("Enter the news id you want to change");
//        Integer id = scn.nextInt();
//        dbNews.updateNews(title, texOfNews, id);
    }
}

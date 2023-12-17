package com.project.bukuproject;

import com.project.bukuproject.Model.Buku;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller untuk tampilan utama.
 */
public class HelloController implements Initializable {

    @FXML
    private HBox cardLayout;

    @FXML
    private GridPane bookContainer;

    private List<Buku> recentlyAdded;
    private List<Buku> recommended;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        recentlyAdded = recentlyAdded();
        recommended = new ArrayList<>(books());


        loadBookContainer();
    }

    /**
     * Memuat tata letak kartu ke dalam cardLayout.
     */


    /**
     * Memuat tata letak buku ke dalam bookContainer.
     */
    private void loadBookContainer() {
        int column = 0;
        int row = 1;

        try {
            for (Buku buku : recommended) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("book.fxml"));
                VBox bookBox = fxmlLoader.load();
                BookController bookController = fxmlLoader.getController();
                bookController.setData(buku);

                if (column == 6) {
                    column = 0;
                    ++row;
                }

                bookContainer.add(bookBox, column++, row);
                GridPane.setMargin(bookBox, new Insets(10));
            }
        } catch (IOException e) {
            handleLoadError(e);
        }
    }

    /**
     * Menangani kesalahan saat memuat tata letak.
     *
     * @param e Exception yang ditangkap
     */
    private void handleLoadError(IOException e) {
        e.printStackTrace();
        // Lakukan penanganan kesalahan yang sesuai, seperti menampilkan pesan kesalahan kepada pengguna
    }

    /**
     * Menghasilkan daftar buku yang baru-baru ini ditambahkan.
     *
     * @return List of recently added books
     */
    private List<Buku> recentlyAdded() {
        // Implementasi logika untuk mendapatkan buku yang baru-baru ini ditambahkan
        List<Buku> ls = new ArrayList<>();
        Buku buku1 = new Buku("PANTASKAH OJK\nDIBUBARKAN?", "Dr. Hadi Utomo", new String[] {"Pelajaran", "Ekonomi"}, "/img/buku1.jpg");
        ls.add(buku1);
        return ls;
    }

    /**
     * Menghasilkan daftar buku yang direkomendasikan.
     *
     * @return List of recommended books
     */
    private List<Buku> books() {
        // Implementasi logika untuk mendapatkan buku yang direkomendasikan
        List<Buku> ls = new ArrayList<>();
        Buku buku1 = new Buku("PANTASKAH OJK DIBUBARKAN?", "Dr. Hadi Utomo", new String[] {"Pelajaran", "Ekonomi"}, "/img/buku1.jpg",
                "Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis");
        ls.add(buku1);

        Buku buku2 = new Buku("50 PRAYERS FROM THE HOLY QUR'AN", "A.K", new String[] {"Islam"}, "/img/buku2.jpg",
                "Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis");
        ls.add(buku2);

        Buku buku3 = new Buku("Test", "A.K", new String[] {"Detective", "Adventure"}, "/img/buku3.jpg",
                "Harry Potter and the Philosopher's Stone memulai kisahnya dengan Harry Potter, seorang anak yatim piatu yang secara tak terduga mengetahui bahwa dia adalah seorang penyihir dan menerima undangan untuk belajar di Hogwarts, sekolah sihir terkenal. Di sana, bersama teman-teman barunya, Ron dan Hermione, Harry mengeksplorasi dunia sihir yang penuh dengan misteri dan bahaya. Mereka berusaha mengungkap rahasia di balik Batu Bertuah yang dapat memberikan keabadian dan, pada saat yang sama, melawan ancaman gelap dari penyihir jahat bernama Voldemort. Buku ini membawa pembaca ke dalam petualangan magis yang penuh dengan pertemanan, tantangan, dan pertarungan antara kebaikan dan kejahatan di dunia sihir yang kaya dan menarik.");
        ls.add(buku3);

        Buku buku4 = new Buku("Share Loc", "Hartswood Films", new String[] {"Detective"}, "/img/buku3.jpg",
                "Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis");
        ls.add(buku4);

        Buku buku5 = new Buku("Tost", "Dr. Hadi Utomo", new String[] {"Detective"}, "/img/buku3.jpg",
                "Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis");
        ls.add(buku5);

        Buku buku10 = new Buku("Cucus", "Dr. Hadi Utomo", new String[] {"Detective"}, "/img/buku3.jpg",
                "Harry Potter and the Philosopher's Stone memulai kisahnya dengan Harry Potter, seorang anak yatim piatu yang secara tak terduga mengetahui bahwa dia adalah seorang penyihir dan menerima undangan untuk belajar di Hogwarts, sekolah sihir terkenal. Di sana, bersama teman-teman barunya, Ron dan Hermione, Harry mengeksplorasi dunia sihir yang penuh dengan misteri dan bahaya. Mereka berusaha mengungkap rahasia di balik Batu Bertuah yang dapat memberikan keabadian dan, pada saat yang sama, melawan ancaman gelap dari penyihir jahat bernama Voldemort. Buku ini membawa pembaca ke dalam petualangan magis yang penuh dengan pertemanan, tantangan, dan pertarungan antara kebaikan dan kejahatan di dunia sihir yang kaya dan menarik.");
        ls.add(buku10);

        Buku buku6 = new Buku("Gamebell", "Dr. Hadi Utomo", new String[] {"Detective"}, "/img/buku3.jpg",
                "Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis");
        ls.add(buku6);

        Buku buku7 = new Buku("How to", "Hartswood Films", new String[] {"Detective"}, "/img/buku3.jpg",
                "Harry Potter and the Philosopher's Stone memulai kisahnya dengan Harry Potter, seorang anak yatim piatu yang secara tak terduga mengetahui bahwa dia adalah seorang penyihir dan menerima undangan untuk belajar di Hogwarts, sekolah sihir terkenal. Di sana, bersama teman-teman barunya, Ron dan Hermione, Harry mengeksplorasi dunia sihir yang penuh dengan misteri dan bahaya. Mereka berusaha mengungkap rahasia di balik Batu Bertuah yang dapat memberikan keabadian dan, pada saat yang sama, melawan ancaman gelap dari penyihir jahat bernama Voldemort. Buku ini membawa pembaca ke dalam petualangan magis yang penuh dengan pertemanan, tantangan, dan pertarungan antara kebaikan dan kejahatan di dunia sihir yang kaya dan menarik.");
        ls.add(buku7);

        Buku buku8 = new Buku("Football", "Hartswood Films", new String[] {"Detective"}, "/img/buku3.jpg",
                "Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis");
        ls.add(buku8);

        Buku buku9 = new Buku("Pemrograman Mahir", "Hartswood Films", new String[] {"Detective"}, "/img/buku3.jpg",
                "Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis Sinopsis");
        ls.add(buku9);

        return ls;
    }
}

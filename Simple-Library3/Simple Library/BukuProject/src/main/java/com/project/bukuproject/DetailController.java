package com.project.bukuproject;

import com.project.bukuproject.Model.Buku;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class DetailController implements Initializable {

    @FXML
    private HBox cardLayout;

    @FXML
    private ImageView bookImage;

    @FXML
    private Label genre;

    @FXML
    private Label judul;

    @FXML
    private Label penulis;

    @FXML
    private Label sinopsis;

    @FXML
    private GridPane penulisBookContainer;

    @FXML
    private GridPane genreBookContainer;

    @FXML
    private GridPane sinopsisBookContainer;

    @FXML
    private Button homeButton; //mengubah yang sebelumnya backButton



    public void setBookDetails(Buku bukuSekarang) {
        // Mengatur informasi buku pada halaman detail
        judul.setText(bukuSekarang.judul);
        genre.setText(Arrays.toString(bukuSekarang.genre));
        penulis.setText(bukuSekarang.penulis);
        sinopsis.setText(bukuSekarang.sinopsis);
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(bukuSekarang.ImgSrc)));
        bookImage.setImage(image);

        // Pemanggilan metode rekomendasi untuk mendapatkan buku dengan genre yang sama
        bukuSekarang.rekomendasi(Buku.daftarBuku);

        // Menampilkan buku rekomendasi pada halaman detail
        tampilkanBukuSamaGenre(bukuSekarang.bukuTerhubungRekomendasi);

        // Pemanggilan metode cekGenreDFS untuk mendapatkan buku dengan genre yang sama
        bukuSekarang.cekGenreDFS(Buku.daftarBuku);

        // Menampilkan buku dengan genre yang sama pada halaman detail
        tampilkanRekomendasiBuku(bukuSekarang.bukuTerhubungGenre);

        // Pemanggilan metode cekPenulisDFS untuk mendapatkan buku dengan genre yang sama
        bukuSekarang.cekPenulisDFS(Buku.daftarBuku);

        // Menampilkan buku dengan penulis yang sama pada halaman detail
        tampilkanBukuSamaPenulis(bukuSekarang.bukuTerhubungPenulis);
    }

    private void tampilkanRekomendasiBuku(List<Buku> bukuRekomendasi) {
        // Membersihkan konten sebelum menambahkan buku baru
        sinopsisBookContainer.getChildren().clear();

        if (bukuRekomendasi != null && !bukuRekomendasi.isEmpty()) {
            int column = 0;
            int row = 1;

            // Menambahkan buku-buku dengan genre yang sama
            for (Buku buku : bukuRekomendasi) {
                // Menggunakan komponen FXML atau JavaFX untuk menampilkan informasi buku
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("book.fxml"));
                try {
                    VBox bookBox = fxmlLoader.load();
                    BookController bookController = fxmlLoader.getController();
                    bookController.setData(buku);

                    // Menambahkan buku ke gridPane
                    sinopsisBookContainer.add(bookBox, column++, row);

//                    // menghapus code dibawah ini, supaya hanya bisa di scroll horizontal
//                    if (column == 6) {
//                        column = 0;
//                        ++row;
//                    }

                    GridPane.setMargin(bookBox, new Insets(10));
                } catch (IOException e) {
                    e.printStackTrace();
                    // Handle error jika terjadi kesalahan dalam memuat komponen buku
                }
            }
        } else {
            // Menambahkan label untuk menunjukkan bahwa tidak ada buku dengan genre yang sama
            Label label = new Label("Tidak Ada Buku dengan Genre yang Sama");
            sinopsisBookContainer.add(label, 0, 0);
        }
    }

    @FXML
    private void goBack() {
        // Handle the "Kembali" button action
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Parent root = loader.load();

            // Set up the controller or pass any necessary data

            // Switch to the previous page
            Stage currentStage = (Stage) homeButton.getScene().getWindow();
            currentStage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
            // Handle error jika terjadi kesalahan navigasi
        }
    }

    private void tampilkanBukuSamaGenre(List<Buku> bukuSamaGenre) {
        // Membersihkan konten sebelum menambahkan buku baru
        genreBookContainer.getChildren().clear();

        if (bukuSamaGenre != null && !bukuSamaGenre.isEmpty()) {
            int column = 0;
            int row = 1;

            // Menambahkan buku-buku dengan genre yang sama
            for (Buku buku : bukuSamaGenre) {
                // Menggunakan komponen FXML atau JavaFX untuk menampilkan informasi buku
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("book.fxml"));
                try {
                    VBox bookBox = fxmlLoader.load();
                    BookController bookController = fxmlLoader.getController();
                    bookController.setData(buku);

                    // Menambahkan buku ke gridPane
                    genreBookContainer.add(bookBox, column++, row);

                    // menghapus code dibawah ini, supaya hanya bisa di scroll horizontal
//                    if (column == 6) {
//                        column = 0;
//                        ++row;
//                    }

                    GridPane.setMargin(bookBox, new Insets(10));
                } catch (IOException e) {
                    e.printStackTrace();
                    // Handle error jika terjadi kesalahan dalam memuat komponen buku
                }
            }
        } else {
            // Menambahkan label untuk menunjukkan bahwa tidak ada buku dengan genre yang sama
            Label label = new Label("Tidak Ada Buku dengan Genre yang Sama");
            genreBookContainer.add(label, 0, 0);
        }
    }

    private void tampilkanBukuSamaPenulis(List<Buku> bukuSamaPenulis) {
        // Membersihkan konten sebelum menambahkan buku baru
        penulisBookContainer.getChildren().clear();

        if (bukuSamaPenulis != null && !bukuSamaPenulis.isEmpty()) {
            int column = 0;
            int row = 1;

            // Menambahkan buku-buku dengan genre yang sama
            for (Buku buku : bukuSamaPenulis) {
                // Menggunakan komponen FXML atau JavaFX untuk menampilkan informasi buku
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("book.fxml"));
                try {
                    VBox bookBox = fxmlLoader.load();
                    BookController bookController = fxmlLoader.getController();
                    bookController.setData(buku);

                    // Menambahkan buku ke gridPane
                    penulisBookContainer.add(bookBox, column++, row);

                    // menghapus code dibawah ini, supaya hanya bisa di scroll horizontal
//                    if (column == 6) {
//                        column = 0;
//                        ++row;
//                    }

                    GridPane.setMargin(bookBox, new Insets(10));
                } catch (IOException e) {
                    e.printStackTrace();
                    // Handle error jika terjadi kesalahan dalam memuat komponen buku
                }
            }
        } else {
            // Menambahkan label untuk menunjukkan bahwa tidak ada buku dengan genre yang sama
            Label label = new Label("Tidak Ada Buku dengan Penulis yang Sama");
            penulisBookContainer.add(label, 0, 0);
        }
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}

package Wojaro;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField e;

    @FXML
    private TextField a;


    @FXML
    private ScatterChart<Number,Number> Wykres;

    @FXML
    private NumberAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    private Button btnBisekcja;

    @FXML
    private Button btnPktStaly;

    @FXML
    private Button btnNewton;

    @FXML
    private Button btnSieczne;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnZapis;

    @FXML
    private TextField eaMax;

    @FXML
    void ActBtnBisekcja(ActionEvent event) {
        System.out.println("Wybrano metodę bisekcji");



        XYChart.Series series= new XYChart.Series();

        double M;
        double eks=Double.valueOf(e.getText());
        double dist=Double.valueOf(a.getText());
        double maxEa=Double.valueOf(eaMax.getText());

        for (int i=0;i<=360;i++) {
           M = i * Math.PI / (180);
            double finalM = M;

            double E = RootSolver.bisekcja(0, 2 * Math.PI, maxEa, 30, (x) -> finalM + eks * Math.sin(x) - x);

            double x = dist * Math.cos(E - eks);
            double y = dist * Math.sqrt(1 - Math.pow(eks, 2)) * Math.sin(E);
            series.getData().add(new XYChart.Data(x,y));
        }
        // dodaj dane do wykresu
        Wykres.getData().add(series);


    }

    @FXML
    void ActBtnNewton(ActionEvent event) {
        System.out.println("Wybrano metodę Newtona");



        XYChart.Series series= new XYChart.Series();

        double M;
        double eks=Double.valueOf(e.getText());
        double dist=Double.valueOf(a.getText());
        double maxEa=Double.valueOf(eaMax.getText());

        for (int i=0;i<=360;i++) {
            M = i * Math.PI / (180);
            double finalM = M;

            double E = RootSolver.styczne(0,maxEa,50,(x) -> finalM + eks * Math.sin(x) - x,eks);

            double x = dist * Math.cos(E - eks);
            double y = dist * Math.sqrt(1 - Math.pow(eks, 2)) * Math.sin(E);
            series.getData().add(new XYChart.Data(x,y));
        }
        // dodaj dane do wykresu
        Wykres.getData().add(series);

    }

    @FXML
    void ActBtnPktStaly(ActionEvent event) {
        System.out.println("Wybrano metodę Punktu Stałego");



        XYChart.Series series= new XYChart.Series();

        double M;
        double eks=Double.valueOf(e.getText());
        double dist=Double.valueOf(a.getText());
        double maxEa=Double.valueOf(eaMax.getText());

        for (int i=0;i<=360;i++) {
            M = i * Math.PI / (180);
            double finalM = M;

            double E = RootSolver.pktStaly(0,maxEa,50,(x) -> finalM + eks * Math.sin(x) - x);

            double x = dist * Math.cos(E - eks);
            double y = dist * Math.sqrt(1 - Math.pow(eks, 2)) * Math.sin(E);
            series.getData().add(new XYChart.Data(x,y));
        }
        // dodaj dane do wykresu
        Wykres.getData().add(series);

    }

    @FXML
    void ActBtnSieczne(ActionEvent event) {
        System.out.println("Wybrano metodę Siecznych");



        XYChart.Series series= new XYChart.Series();

        double M;
        double eks=Double.valueOf(e.getText());
        double dist=Double.valueOf(a.getText());
        double maxEa=Double.valueOf(eaMax.getText());

        for (int i=0;i<=360;i++) {
            M = i * Math.PI / (180);
            double finalM = M;

            double E = RootSolver.sieczne(10,8,maxEa,50,(x) -> finalM + eks * Math.sin(x) - x);

            double x = dist * Math.cos(E - eks);
            double y = dist * Math.sqrt(1 - Math.pow(eks, 2)) * Math.sin(E);
            series.getData().add(new XYChart.Data(x,y));
        }
        // dodaj dane do wykresu
        Wykres.getData().add(series);

    }

    @FXML
    void ActReset(ActionEvent event) {
        Wykres.getData().clear();
    }

    @FXML
    public void actZapis(ActionEvent event) {
        WritableImage wykres=Wykres.snapshot(new SnapshotParameters(),null);

        File plik=new File("Orbity.png");

        try {
            ImageIO.write(SwingFXUtils.fromFXImage(wykres,null),"png",plik);
        } catch (IOException e){

        }

    }

    @FXML
    void initialize() {
        assert Wykres != null : "fx:id=\"Wykres\" was not injected: check your FXML file 'graph.fxml'.";
        assert btnBisekcja != null : "fx:id=\"btnBisekcja\" was not injected: check your FXML file 'graph.fxml'.";
        assert btnPktStaly != null : "fx:id=\"btnPktStaly\" was not injected: check your FXML file 'graph.fxml'.";
        assert btnNewton != null : "fx:id=\"btnNewton\" was not injected: check your FXML file 'graph.fxml'.";
        assert btnSieczne != null : "fx:id=\"btnSieczne\" was not injected: check your FXML file 'graph.fxml'.";
        assert e != null : "fx:id=\"e\" was not injected: check your FXML file 'graph.fxml'.";
        assert a != null : "fx:id=\"a\" was not injected: check your FXML file 'graph.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'graph.fxml'.";
        assert btnZapis != null : "fx:id=\"btnZapis\" was not injected: check your FXML file 'graph.fxml'.";
        assert eaMax != null : "fx:id=\"eaMax\" was not injected: check your FXML file 'graph.fxml'.";

    }
}

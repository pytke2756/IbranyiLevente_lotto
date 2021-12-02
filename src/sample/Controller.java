package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Controller {
    @FXML
    private Button btnSorsol;
    @FXML
    private Label lblSorsoltSzam, lblSorsoltSzamok;

    private ArrayList<Integer> sorsoltak;
    private Random rnd;

    @FXML
    public void initialize(){
        sorsoltak = new ArrayList<>();
        rnd = new Random();
    }

    @FXML
    public void sorsol(){
        boolean kihuzvaOsszes = sorsoltak.size() < 5;
        if (kihuzvaOsszes){
            int szam = rnd.nextInt(91);
            lblSorsoltSzam.setText(String.valueOf(szam));
            sorsoltak.add(szam);
            lblSorsoltSzamok.setText(lblListaFeltolt());
            if(sorsoltak.size() == 5){
                btnSorsol.setText("Rendez");
            }
        }
        else{
            rendez();
            lblSorsoltSzamok.setText(lblListaFeltolt());
            //System.out.println(lblListaFeltolt());
            btnSorsol.setText("Sorsol");
            sorsoltak.clear();
        }

    }

    private String lblListaFeltolt(){
        String sorsoltakString = "";
        for (int szam : sorsoltak) {
            sorsoltakString += String.valueOf(szam) + " ";
        }
        return sorsoltakString;
    }

    private void rendez(){
        boolean sorted = false;
        System.out.println("asd");
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < sorsoltak.size() - 1; i++) {
                if (sorsoltak.get(i) > sorsoltak.get(i + 1)) {
                    temp = sorsoltak.get(i);
                    sorsoltak.set(i, sorsoltak.get(i + 1));
                    sorsoltak.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
    }

}

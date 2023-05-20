package com.vigjoaopaulo.controleacidente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView dt_inicio;
    TextView txtDataAtual;
    TextView contagemAtual;
    TextView contDiasAnterior;
    TextView nome;


    int contagemInicial = 656;
    int dia_referencia = 0;
    long days;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contagemAtual = (TextView) findViewById(R.id.txtContagemAtual);
        dt_inicio = (TextView) findViewById(R.id.txt_data_inicio);
        contDiasAnterior = (TextView) findViewById(R.id.contDiasAnterior);
        txtDataAtual = (TextView) findViewById(R.id.txtDataAtual);
        nome = (TextView) findViewById(R.id.txtNome);

        getData();
    }

    public void getData(){
        Date date = new Date();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        int contagemInicial = 656;
        String data = "14/06/2022";

        int dayInit = contagemInicial;

        LocalDate anterior       = LocalDate.of(2022, 06, 14);
        LocalDateTime endDate =  LocalDateTime.now();

        long dias =  anterior.until(endDate, ChronoUnit.DAYS);
        dias-=1;
        long res = contagemInicial += dias;

        contagemAtual.setText(Long.toString(res));
        dt_inicio.setText(String.valueOf(anterior.format(formatter)));
        contDiasAnterior.setText(Integer.toString(dayInit));
        nome.setText("Developed by João Paulo de Oliveira");


        //Log.i("hr", "hora certa" + date);

        hora();
    }

    public void hora(){
        Thread atualizaHora = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    while (true) {
                        Date date = new Date();
                        StringBuffer data = new StringBuffer();

                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

                        txtDataAtual.setText(data.toString() + sdf.format(date));
//						System.out.println(data.toString() + sdf.format(date));
                        Thread.sleep(1000);


                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

            }
        });
        atualizaHora.start();
    }

}
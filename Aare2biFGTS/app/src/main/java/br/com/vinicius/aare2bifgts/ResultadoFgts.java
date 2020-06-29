package br.com.vinicius.aare2bifgts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.time.LocalDate;

public class ResultadoFgts extends AppCompatActivity {

    private TextView pParcela, sParcela, tParcela;

    private LocalDate dataNascimento, dataPPagamento, dataSPagamento, dataTPagamento;
    private int diaPagamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_fgts);

        initVariables();
        validarDatas();

        this.pParcela.setText(this.dataPPagamento.getDayOfMonth() + "/" + this.dataPPagamento.getMonthValue() + "/" + this.dataPPagamento.getYear());
        this.sParcela.setText(this.dataSPagamento.getDayOfMonth() + "/" + this.dataSPagamento.getMonthValue() + "/" + this.dataSPagamento.getYear());
        this.tParcela.setText(this.dataTPagamento.getDayOfMonth() + "/" + this.dataTPagamento.getMonthValue() + "/" + this.dataTPagamento.getYear());

    }

    protected void initVariables(){
        this.pParcela = findViewById(R.id.tvPParcela);
        this.sParcela = findViewById(R.id.tvSParcela);
        this.tParcela = findViewById(R.id.tvTParcela);
    }

    protected void validarDatas(){
        if (dataNascimento.getDayOfMonth() >= 1 && dataNascimento.getDayOfMonth() <= 10 ){
            this.diaPagamento = 5;
        }else if(dataNascimento.getDayOfMonth() > 10 && dataNascimento.getDayOfMonth() <= 20){
            this.diaPagamento = 10;
        }else if(dataNascimento.getDayOfMonth() > 10 && dataNascimento.getDayOfMonth() <= 31){
            this.diaPagamento = 15;
        }

        this.dataPPagamento = LocalDate.of(2020, dataNascimento.getMonthValue(), this.diaPagamento );
        this.dataPPagamento = this.dataPPagamento.plusMonths(1);
        this.dataSPagamento = LocalDate.of(2020, dataNascimento.getMonthValue(), this.diaPagamento );
        this.dataSPagamento = this.dataSPagamento.plusMonths(2);
        this.dataTPagamento = LocalDate.of(2020, dataNascimento.getMonthValue(), this.diaPagamento );
        this.dataTPagamento = this.dataTPagamento.plusMonths(3);
    }


}

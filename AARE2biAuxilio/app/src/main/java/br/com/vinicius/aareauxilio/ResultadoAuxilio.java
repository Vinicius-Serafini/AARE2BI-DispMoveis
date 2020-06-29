package br.com.vinicius.aareauxilio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.time.LocalDate;

public class ResultadoAuxilio extends AppCompatActivity {

    private TextView tvValorReceber, tvDataPagamento;

    private LocalDate dataPagamento;
    private String dataNascimento;
    private Double rendaMensal, valorAuxilio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_auxilio);

        initVariables();
        getVariables();

        this.tvDataPagamento.setText(this.dataPagamento.toString());
        this.tvValorReceber.setText(String.format("R$ %.2f", this.valorAuxilio));

    }


    protected void initVariables(){
        this.tvValorReceber = findViewById(R.id.tvValorReceber);
        this.tvDataPagamento = findViewById(R.id.tvDataPagamento);
    }

    protected void getVariables(){
        Bundle b = getIntent().getExtras();
        this.rendaMensal = b.getDouble("rendaMensal");
        this.dataNascimento = b.getString("dataNascimento");
        if (this.rendaMensal * 0.7 > 475){
            this.valorAuxilio = 475.00;
        } else{
            this.valorAuxilio = this.rendaMensal * 0.7;
        }
        this.dataPagamento = LocalDate.parse(dataNascimento);
        this.dataPagamento = this.dataPagamento.plusDays(20);

    }


}

package br.com.vinicius.aareauxilio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class MainActivity extends AppCompatActivity {

    private EditText etCpf, etRendaMensal;
    private DatePicker pkDataNascimento;

    private LocalDate dataNascimento;
    private Double rendaMensal;
    private String cpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    protected void initVariables(){
        this.etCpf = findViewById(R.id.etCpf);
        this.etRendaMensal = findViewById(R.id.etRendaMensal);
        this.pkDataNascimento = findViewById(R.id.pkDataNascimento);
    }


    public void validarAuxilio(View view){

        initVariables();


        String msgErro = "Auxilio negado! ";

        if (etRendaMensal.length() > 0 && etCpf.length() > 0) {
            this.cpf = this.etCpf.getText().toString();
            this.dataNascimento = LocalDate.of(pkDataNascimento.getYear(), pkDataNascimento.getMonth(), pkDataNascimento.getDayOfMonth());
            this.rendaMensal = Double.parseDouble(etRendaMensal.getText().toString());

            Period p = Period.between(dataNascimento, LocalDate.now());
            if (p.getYears() > 18 && rendaMensal < 5000) {
                goToNewActivity();
            } else {
                if (p.getYears() < 18) {
                    msgErro += "\n É necessário ser maior de idade para receber o auxilio";
                    msgErro += "\n" + dataNascimento.toString();
                }
                if (this.rendaMensal > 5000) {
                    msgErro += "\n É necessário possuir uma renda menor que R$ 5000,00";
                }
                Toast.makeText(this, msgErro, Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Por favor informe todos os campos", Toast.LENGTH_SHORT).show();
        }
    }




    private void goToNewActivity(){

        // vai para a outra Activity passando os dados
        Intent intent = new Intent(MainActivity.this, ResultadoAuxilio.class);
        Bundle b = new Bundle();
        b.putString("cpf", this.cpf);
        b.putDouble("rendaMensal", rendaMensal);
        b.putString("dataNascimento", dataNascimento.toString());
        intent.putExtras(b);
        startActivity(intent);
    }


}

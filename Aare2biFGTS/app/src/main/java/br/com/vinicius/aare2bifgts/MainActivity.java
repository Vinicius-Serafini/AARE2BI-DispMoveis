package br.com.vinicius.aare2bifgts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalDate;

public class MainActivity extends AppCompatActivity {

    private EditText etCpf;
    private DatePicker pkDataNascimento;

    private LocalDate dataNascimento;
    private String cpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();
    }

    protected void initVariables(){
        this.etCpf = findViewById(R.id.etCpf);
        this.pkDataNascimento = findViewById(R.id.pkDataNascimento);
    }

    public void verificarFGTS(View view){
        if(etCpf.length() > 0){
            this.cpf = this.etCpf.getText().toString();
            this.dataNascimento = LocalDate.of(pkDataNascimento.getYear(), pkDataNascimento.getMonth(), pkDataNascimento.getDayOfMonth());

            goToNewActivity();
        }else{
            Toast.makeText(this, "Por favor informe todos os campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void goToNewActivity(){
        Intent intent = new Intent(MainActivity.this, ResultadoFgts.class);
        Bundle b = new Bundle();
        b.putString("dataNascimento", dataNascimento.toString());
        b.putString("cpf", cpf);
        intent.putExtras(b);
        startActivity(intent);
        finish();
    }



}

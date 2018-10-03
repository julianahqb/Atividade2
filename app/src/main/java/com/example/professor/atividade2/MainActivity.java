package com.example.professor.atividade2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtTel;
    private RadioButton rdbFem;
    private RadioButton rdbMasc;
    private CheckBox chkMusica;
    private CheckBox chkCinema;
    private CheckBox chkEsporte;
    private CheckBox chkGastronomia;
    private Switch swtNotif;
    private Button btnExibir;
    private Button btnLimpar;
    private LinearLayout lblDados;
    private TextView txtNome;
    private TextView txtSexo;
    private RadioGroup rdgSexo;
    private TextView txtEmail;
    private TextView txtTel;
    private TextView txtPref;
    private TextView txtNotif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);
        edtTel = findViewById(R.id.edtTel);
        rdbFem = findViewById(R.id.rdbFem);
        rdbMasc = findViewById(R.id.rdbMasc);
        chkMusica = findViewById(R.id.chkMusica);
        chkCinema = findViewById(R.id.chkCinema);
        chkEsporte = findViewById(R.id.chkEsporte);
        chkGastronomia = findViewById(R.id.chkGastronomia);
        swtNotif = findViewById(R.id.swtNotif);
        btnExibir = findViewById(R.id.btnExibir);
        btnLimpar = findViewById(R.id.btnLimpar);
        lblDados = findViewById(R.id.lblDados);
        txtNome = findViewById(R.id.txtNome);
        txtSexo = findViewById(R.id.txtSexo);
        rdgSexo = findViewById(R.id.rdgSexo);
        txtEmail = findViewById(R.id.txtEmail);
        txtTel = findViewById(R.id.txtTel);
        txtPref = findViewById(R.id.txtPref);
        txtNotif = findViewById(R.id.txtNotif);

        btnExibir.setOnClickListener(this);
        btnLimpar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnExibir){
            lblDados.setVisibility(View.VISIBLE);
            txtNome.setText("Nome: " + edtNome.getText().toString());

            int idRadioButtonSelecionado = rdgSexo.getCheckedRadioButtonId();
            if (idRadioButtonSelecionado > 0){
                RadioButton rdbSelecionado = findViewById(idRadioButtonSelecionado);
                txtSexo.setText(" /  Sexo: " + rdbSelecionado.getText().toString());
            }

            txtEmail.setText("E-mail: " + edtEmail.getText().toString());
            txtTel.setText("Telefone: " + edtTel.getText().toString());

            String pref="";
            if (chkMusica.isChecked())
                pref = chkMusica.getText().toString();
            if (chkCinema.isChecked()) {
                pref += " + ";
                pref += chkCinema.getText().toString();
            }
            if (chkEsporte.isChecked()) {
                pref += " + ";
                pref += chkEsporte.getText().toString();
            }
            if (chkGastronomia.isChecked()){
                pref += " + ";
                pref += chkGastronomia.getText().toString();
            }
            txtPref.setText("Preferências: " + pref);

            if (swtNotif.isChecked())
                txtNotif.setText("Notificação: " + swtNotif.getTextOn());
            else
                txtNotif.setText("Notificação: " + swtNotif.getTextOff());

        }
        else if (v.getId() == R.id.btnLimpar){
            lblDados.setVisibility(View.INVISIBLE);
            edtNome.getText().clear();
            rdgSexo.clearCheck();
            edtEmail.getText().clear();
            edtTel.getText().clear();
            chkMusica.setChecked(false);
            chkCinema.setChecked(false);
            chkEsporte.setChecked(false);
            chkGastronomia.setChecked(false);
            swtNotif.setChecked(false);
        }

    }
}
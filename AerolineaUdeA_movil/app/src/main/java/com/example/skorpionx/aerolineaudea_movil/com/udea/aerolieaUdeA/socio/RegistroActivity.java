package com.example.skorpionx.aerolineaudea_movil.com.udea.aerolieaUdeA.socio;


import android.app.ProgressDialog;
import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.Toast;
import com.example.skorpionx.aerolineaudea_movil.R;
import com.example.skorpionx.aerolineaudea_movil.com.udea.aerolineaUdeA.Servicios.ServiociosAerolinea;
import com.example.skorpionx.aerolineaudea_movil.com.udea.aerolineaUdeA.util.Constantes;
import com.example.skorpionx.aerolineaudea_movil.com.udea.model.Resultado;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private TextInputLayout input_nombre;
    private TextInputLayout input_apellidos;
    private TextInputLayout input_contraseña;
    private TextInputLayout input_contraseña2;
    private TextInputLayout input_movil;
    private TextInputLayout input_correo_electronico;
    private TextInputLayout input_tarjeta_de_credito;
    private Button registrarse;
    private  Button fecha_botton;
    private  EditText fecha_text;

    String nombre;
    String apellidos;
    String contraseña;
    String contraseña2;
    String movil;
    String correo;
    String tarjeta;
    String fecha_nacimiento;

    int año;
    int mes;
    int dia;
    ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        input_nombre = (TextInputLayout) findViewById(R.id.input_nombre);
        input_apellidos = (TextInputLayout) findViewById(R.id.input_apellidos);
        input_contraseña = (TextInputLayout) findViewById(R.id.input_contraseña);
        input_contraseña2 = (TextInputLayout) findViewById(R.id.input_contraseña2);
        input_movil = (TextInputLayout) findViewById(R.id.input_movil);
        input_correo_electronico = (TextInputLayout) findViewById(R.id.input_correo);
        input_tarjeta_de_credito = (TextInputLayout) findViewById(R.id.input_tarjeta_credito);
        registrarse =(Button) findViewById(R.id.input_registrarse);
        fecha_botton=(Button) findViewById(R.id.input_calendar_button);
        fecha_text=(EditText) findViewById(R.id.input_calendar_text);
        fecha_text.setEnabled(false);

        registrarse.setOnClickListener(this);
        fecha_botton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==findViewById(R.id.input_registrarse).getId()){
            if(actionRegistrarse()){
                progress = new ProgressDialog(this);
                progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progress.setTitle(Constantes.PROGRESS_BAR_REGISTRO);
                progress.setMessage(Constantes.PROGRESS_BAR_REGISTRO_MESSAGE);
                fecha_nacimiento=año+"-"+mes+"-"+dia;
                progress.show();
                final Toast[] toast;


                ServiociosAerolinea.getAutenticacionService().iniciarSesion(nombre,apellidos,fecha_nacimiento,
                        movil,correo,tarjeta,contraseña,
                        new Callback<Resultado>() {

                            @Override
                            public void success(Resultado resultado, Response response) {
                                if (resultado.getTipo().equals("Success")) {

                                }
                                if(resultado.getTipo().equals("Error")){

                                }
                                progress.dismiss();
                            }

                            @Override
                            public void failure(RetrofitError error) {
                                progress.dismiss();
                            }
                        });

            }

        }else if(view.getId()==findViewById(R.id.input_calendar_button).getId()){
            actionCalendar();
        }
    }

    public void actionCalendar(){

        final Calendar c = Calendar.getInstance();
        año = c.get(Calendar.YEAR);
        mes = c.get(Calendar.MONTH);
        dia = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        fecha_text.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, año, mes, dia);
        datePickerDialog.show();
    }


    public boolean actionRegistrarse(){
        hideKeyboard();
        boolean formOk=true;
        nombre = input_nombre.getEditText().getText().toString();
        apellidos = input_apellidos.getEditText().getText().toString();
        contraseña = input_contraseña.getEditText().getText().toString();
        contraseña2 = input_contraseña2.getEditText().getText().toString();
        movil = input_movil.getEditText().getText().toString();
        correo = input_correo_electronico.getEditText().getText().toString();
        tarjeta = input_tarjeta_de_credito.getEditText().getText().toString();
        fecha_nacimiento=fecha_text.getText().toString();


        if(nombre.length()==0) {
            input_nombre.setError(Constantes.ERROR_FORM_EMPTY_FIELD);
            formOk=false;
        }else{
            input_nombre.setErrorEnabled(false);
        }
        if(apellidos.length()==0){
            input_apellidos.setError(Constantes.ERROR_FORM_EMPTY_FIELD);
            formOk=false;
        }else{
            input_apellidos.setErrorEnabled(false);
        }
        if(contraseña.length()==0){
            input_contraseña.setError(Constantes.ERROR_FORM_EMPTY_FIELD);
            formOk=false;
        }else{
            input_contraseña.setErrorEnabled(false);
        }
        if(movil.length()==0){
            input_movil.setError(Constantes.ERROR_FORM_EMPTY_FIELD);
            formOk=false;
        }else{
            input_movil.setErrorEnabled(false);
        }
        if(tarjeta.length()==0){
            input_tarjeta_de_credito.setError(Constantes.ERROR_FORM_EMPTY_FIELD);
            formOk=false;
        }else{
            input_tarjeta_de_credito.setErrorEnabled(false);
        }
        if(!contraseña2.equals(contraseña)){
            input_contraseña2.setError(Constantes.ERROR_FORM_DIFFERENTS_PASSWORDS);
            formOk=false;
        }else{
            input_contraseña2.setErrorEnabled(false);
        }
        if (!validarCorreo(correo)) {
            input_correo_electronico.setError(Constantes.ERROR_FORM_EMAIL_PATTERN);
            formOk=false;
        }else{
            input_correo_electronico.setErrorEnabled(false);
        }
        return formOk;
    }

    public boolean validarCorreo(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher;

        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}

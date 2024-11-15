package Bindings;

import android.widget.Button;
import android.widget.EditText;


public class Activity_crear_cuentaBinding implements ViewBinding {

    private final EditText editTextTextEmailAddress;
    private final EditText editTextTextPassword;
    EditText editTextText;
    Button buttonCrearCuenta;
    public Activity_crear_cuentaBinding(Button buttonCrearCuenta,EditText editTextTextEmailAddress, EditText editTextTextPassword, EditText editTextText) {
        this.editTextTextEmailAddress = editTextTextEmailAddress;
        this.editTextTextPassword = editTextTextPassword;
        this.editTextText = editTextText;
        this.buttonCrearCuenta = buttonCrearCuenta;
    }

}

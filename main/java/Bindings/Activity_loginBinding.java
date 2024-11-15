package Bindings;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Activity_loginBinding {

    Button logginButton;
    Button crearButton;
    EditText email;
    EditText password;
    ImageView imageView;

    public Activity_loginBinding(Button logginButton, Button crearButton, EditText email, EditText password, ImageView imageView) {
        this.logginButton = logginButton;
        this.crearButton = crearButton;
        this.email = email;
        this.password = password;
        this.imageView = imageView;
    }


}

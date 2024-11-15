package Bindings;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.tfg.R;

public class Activity_userBinding {
    ImageView imageView;
    TextView textViewName;
    TextView textviewEmail;
    TextView distance_text;
    SeekBar distance_seekbar;
    Button buttonLogOut;

    public Activity_userBinding(ImageView imageView, TextView textViewName, TextView textviewEmail, TextView distance_text, SeekBar distance_seekbar, Button buttonLogOut) {
        this.imageView = imageView;
        this.textViewName = textViewName;
        this.textviewEmail = textviewEmail;
        this.distance_text = distance_text;
        this.distance_seekbar = distance_seekbar;
        this.buttonLogOut = buttonLogOut;
    }



}

package p.fetch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPassword extends AppCompatActivity {

    private EditText inputEmail;
    private Button btnReset;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        inputEmail= (EditText) findViewById(R.id.email);
        btnReset =   (Button) findViewById(R.id.send);
        auth = FirebaseAuth.getInstance();


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString().trim();
                auth.sendPasswordResetEmail(email)

                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(ResetPassword.this, "We have sent you instructions to reset your password", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(ResetPassword.this, "Failed to send reset email", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
            }
        });

    }
}
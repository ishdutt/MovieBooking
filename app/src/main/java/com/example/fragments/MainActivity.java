package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    boolean status = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            final FragmentManager fragmentManager = getSupportFragmentManager();
            f1 f1 = new f1();
            f2 f2 = new f2();
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                if(!status)
                {
                    fragmentTransaction.add(R.id.l1,f1);
                    fragmentTransaction.isAddToBackStackAllowed();
                    fragmentTransaction.commit();
                    b1.setText("Book Ticket");
                    status=true;
                }
                else
                {
                    fragmentTransaction= fragmentTransaction.remove(f1);
                    fragmentTransaction.add(R.id.l1,f2);
                    fragmentTransaction.isAddToBackStackAllowed();
                    fragmentTransaction.commit();
                    b1.setText("Back");
                    status=false;
                }
            }
        });
    }
}

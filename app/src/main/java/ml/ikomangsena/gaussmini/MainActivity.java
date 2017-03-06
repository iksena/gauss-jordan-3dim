package ml.ikomangsena.gaussmini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText satu,dua,tiga,empat,lima,enam,tujuh,delapan,sembilan,hasil1,hasil2,hasil3;
    Button hitung;
    TextView sil1,sil2,sil3;
    SeekBar geser;
    Double A[][],co;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hitung = (Button) findViewById(R.id.hitung);
        sil1 = (TextView) findViewById(R.id.sil1);
        sil2 = (TextView) findViewById(R.id.sil2);
        sil3 = (TextView) findViewById(R.id.sil3);
        satu = (EditText) findViewById(R.id.satu);
        dua = (EditText) findViewById(R.id.dua);
        tiga = (EditText) findViewById(R.id.tiga);
        empat = (EditText) findViewById(R.id.empat);
        lima = (EditText) findViewById(R.id.lima);
        enam = (EditText) findViewById(R.id.enam);
        tujuh = (EditText) findViewById(R.id.tujuh);
        delapan = (EditText) findViewById(R.id.delapan);
        sembilan = (EditText) findViewById(R.id.sembilan);
        hasil1 = (EditText) findViewById(R.id.hasil1);
        hasil2 = (EditText) findViewById(R.id.hasil2);
        hasil3 = (EditText) findViewById(R.id.hasil3);
        geser = (SeekBar) findViewById(R.id.seekBar);

        final Double A[][] = new Double[10][10];

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co = 0.0;
                A[0][0] = Double.parseDouble(satu.getText().toString());
                A[0][1] = Double.parseDouble(dua.getText().toString());
                A[0][2] = Double.parseDouble(tiga.getText().toString());
                A[1][0] = Double.parseDouble(empat.getText().toString());
                A[1][1] = Double.parseDouble(lima.getText().toString());
                A[1][2] = Double.parseDouble(enam.getText().toString());
                A[2][0] = Double.parseDouble(tujuh.getText().toString());
                A[2][1] = Double.parseDouble(delapan.getText().toString());
                A[2][2] = Double.parseDouble(sembilan.getText().toString());
                A[0][3] = Double.parseDouble(hasil1.getText().toString());
                A[1][3] = Double.parseDouble(hasil2.getText().toString());
                A[2][3] = Double.parseDouble(hasil3.getText().toString());
                for(int j=0; j<=2; j++){
                    for(int i=0; i<=2; i++){
                        if(i != j){
                            co = A[i][j]/A[j][j];
                            for(int k=0; k<=3; k++){
                                A[i][k]= A[i][k]-co*A[j][k];
                            }
                        }
                    }
                }
                sil1.setText("A = " + A[0][3]/A[0][0]);
                sil2.setText("B = " + A[1][3]/A[1][1]);
                sil3.setText("C = " + A[2][3]/A[2][2]);
            }
        });

    }
}

package dodo1305.kr.hs.emirim.layoutcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import static dodo1305.kr.hs.emirim.layoutcalculator.R.id.text_result;

public class MainActivity extends AppCompatActivity {

     EditText edit1, edit2;
Button [] butnums = new Button[10];
    Button butOps[] = new Button[4];
    public static final int SELECT_EDIT1=0;
    public static final int SELECT_EDIT2=1;
    int selectEdit=SELECT_EDIT1;
    String numStr="";
    TextView textResult;

    /*int ids[]={R.id.but0,R.id.but1,R.id.but2,R.id.but3,R.id.but4,R.id.but5,R.id.but6,R.id.but7,R.id.but8,R.id.but9};*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         edit1= (EditText)findViewById(R.id.edit1);
         edit1= (EditText)findViewById(R.id.edit2);
        edit1.setOnTouchListener(editHandler);
         edit2.setOnTouchListener(editHandler);
        textResult=(TextView)findViewById(text_result);

        for(int i =0; i<butnums.length; i++) {
            butnums[i] = (Button) findViewById(R.id.but0 + i);
            butnums[i].setOnClickListener(butNumHandler);

        }
        for(int j =0; j<butOps.length; j++){
            butOps[j] = (Button)findViewById(R.id.butop1);
            butnums[j].setOnClickListener(butOpHandler);
        }

    }
    View.OnClickListener butNumHandler = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button but=(Button)view;
            numStr+=but.getText();
          switch(selectEdit){
              case SELECT_EDIT1:
                  edit1.setText(numStr);
                  break;

                case SELECT_EDIT2:
                    edit1.setText(numStr);
                    break;
            }
        }
    };
    View.OnClickListener butOpHandler = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int num1= Integer.parseInt(edit1.getText().toString()); //edit1에 입력받은 값
            int num2= Integer.parseInt(edit1.getText().toString()); //edit2에 입력받은 값
            double result=0;
            switch (view.getId()){
                case R.id.butop1:
                    result=num1+num2;
                    break;
                case R.id.butop2:
                    result=num1-num2;
                    break;
                case R.id.butop3:
                    result=num1*num2;
                    break;
                case R.id.butop4:
                    result=num1/(double)num2;
                    break;
            }//end of switch
            textResult.setText("계산 결과 = "+result);


        }
    };


    View.OnTouchListener editHandler=new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch(view.getId()){
                case R.id.edit1:
                    selectEdit=SELECT_EDIT1;
                    break;
                case R.id.edit2:
                    selectEdit=SELECT_EDIT2;
                    break;

            }
            return false;
        }
    };
}

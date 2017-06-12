package com.example.compiler.qxcgame;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


//https://github.com/compilerxx/QXCgame.git

public class MainActivity extends AppCompatActivity {
    private int singleAmt = 92;
    private int baseAmt = 1000;

    private boolean isFirstBit0Selected = false;
    private boolean isFirstBit1Selected = false;
    private boolean isFirstBit2Selected = false;
    private boolean isFirstBit3Selected = false;
    private boolean isFirstBit4Selected = false;
    private boolean isFirstBit5Selected = false;
    private boolean isFirstBit6Selected = false;
    private boolean isFirstBit7Selected = false;
    private boolean isFirstBit8Selected = false;
    private boolean isFirstBit9Selected = false;

    private boolean isFourthBit0Selected = false;
    private boolean isFourthBit1Selected = false;
    private boolean isFourthBit2Selected = false;
    private boolean isFourthBit3Selected = false;
    private boolean isFourthBit4Selected = false;
    private boolean isFourthBit5Selected = false;
    private boolean isFourthBit6Selected = false;
    private boolean isFourthBit7Selected = false;
    private boolean isFourthBit8Selected = false;
    private boolean isFourthBit9Selected = false;


    int []firstBit  = new int[10];
    int []fourthBit  = new int[10];
    int []singleGroup = new int[100] ; //初始化为默认值,int型为0


    private String selectCodeOut ="";
    private String firstBitSelect;
    private String fourthBitSelect;
    private String selectCountStr ="";
    private int totalSelectCount = 0;

    int backColor = Color.parseColor("#FF9800");


    public class MyListener implements View.OnClickListener{

        @Override
        public void onClick(View view){

            switch (view.getId()){
                case R.id.first_bit_0:
                    if (isFirstBit0Selected){
                        isFirstBit0Selected = false;
                        view.setBackgroundColor(backColor);
                        firstBit[0] = 0;

                    }else {
                        isFirstBit0Selected = true;
                        view.setBackgroundColor(Color.RED);
                        firstBit[0] = 1;

                    }
                    break;
                case R.id.first_bit_1:
                    if (isFirstBit1Selected){
                        isFirstBit1Selected = false;
                        view.setBackgroundColor(backColor);
                        firstBit[1] = 0;

                    }else {
                        isFirstBit1Selected = true;
                        view.setBackgroundColor(Color.RED);
                        firstBit[1] = 1;

                    }
                    break;
                case R.id.first_bit_2:
                    if (isFirstBit2Selected){
                        isFirstBit2Selected = false;
                        view.setBackgroundColor(backColor);
                        firstBit[2] = 0;

                    }else {
                        isFirstBit2Selected = true;
                        view.setBackgroundColor(Color.RED);
                        firstBit[2] = 1;

                    }
                    break;
                case R.id.first_bit_3:
                    if (isFirstBit3Selected){
                        isFirstBit3Selected = false;
                        view.setBackgroundColor(backColor);
                        firstBit[3] = 0;

                    }else {
                        isFirstBit3Selected = true;
                        view.setBackgroundColor(Color.RED);
                        firstBit[3] = 1;

                    }
                    break;
                case R.id.first_bit_4:
                    if (isFirstBit4Selected){
                        isFirstBit4Selected = false;
                        view.setBackgroundColor(backColor);
                        firstBit[4] = 0;

                    }else {
                        isFirstBit4Selected = true;
                        view.setBackgroundColor(Color.RED);
                        firstBit[4] = 1;

                    }
                    break;
                case R.id.first_bit_5:
                    if (isFirstBit5Selected){
                        isFirstBit5Selected = false;
                        view.setBackgroundColor(backColor);
                        firstBit[5] = 0;

                    }else {
                        isFirstBit5Selected = true;
                        view.setBackgroundColor(Color.RED);
                        firstBit[5] = 1;

                    }
                    break;
                case R.id.first_bit_6:
                    if (isFirstBit6Selected){
                        isFirstBit6Selected = false;
                        view.setBackgroundColor(backColor);
                        firstBit[6] = 0;

                    }else {
                        isFirstBit6Selected = true;
                        view.setBackgroundColor(Color.RED);
                        firstBit[6] = 1;

                    }
                    break;
                case R.id.first_bit_7:
                    if (isFirstBit7Selected){
                        isFirstBit7Selected = false;
                        view.setBackgroundColor(backColor);
                        firstBit[7] = 0;

                    }else {
                        isFirstBit7Selected = true;
                        view.setBackgroundColor(Color.RED);
                        firstBit[7] = 1;

                    }
                    break;
                case R.id.first_bit_8:
                    if (isFirstBit8Selected){
                        isFirstBit8Selected = false;
                        view.setBackgroundColor(backColor);
                        firstBit[8] = 0;

                    }else {
                        isFirstBit8Selected = true;
                        view.setBackgroundColor(Color.RED);
                        firstBit[8] = 1;

                    }
                    break;
                case R.id.first_bit_9:
                    if (isFirstBit9Selected){
                        isFirstBit9Selected = false;
                        view.setBackgroundColor(backColor);
                        firstBit[9] = 0;

                    }else {
                        isFirstBit9Selected = true;
                        view.setBackgroundColor(Color.RED);
                        firstBit[9] = 1;

                    }
                    break;
                case R.id.fourth_bit_0:
                    if (isFourthBit0Selected){
                        isFourthBit0Selected = false;
                        view.setBackgroundColor(backColor);
                        fourthBit[0] = 0;
                    }else {
                        isFourthBit0Selected = true;
                        view.setBackgroundColor(Color.RED);
                        fourthBit[0] = 1;
                    }
                    break;
                case R.id.fourth_bit_1:
                    if (isFourthBit1Selected){
                        isFourthBit1Selected = false;
                        view.setBackgroundColor(backColor);
                        fourthBit[1] = 0;
                    }else {
                        isFourthBit1Selected = true;
                        view.setBackgroundColor(Color.RED);
                        fourthBit[1] = 1;
                    }
                    break;
                case R.id.fourth_bit_2:
                    if (isFourthBit2Selected){
                        isFourthBit2Selected = false;
                        view.setBackgroundColor(backColor);
                        fourthBit[2] = 0;
                    }else {
                        isFourthBit2Selected = true;
                        view.setBackgroundColor(Color.RED);
                        fourthBit[2] = 1;
                    }
                    break;
                case R.id.fourth_bit_3:
                    if (isFourthBit3Selected){
                        isFourthBit3Selected = false;
                        view.setBackgroundColor(backColor);
                        fourthBit[3] = 0;
                    }else {
                        isFourthBit3Selected = true;
                        view.setBackgroundColor(Color.RED);
                        fourthBit[3] = 1;
                    }
                    break;
                case R.id.fourth_bit_4:
                    if (isFourthBit4Selected){
                        isFourthBit4Selected = false;
                        view.setBackgroundColor(backColor);
                        fourthBit[4] = 0;
                    }else {
                        isFourthBit4Selected = true;
                        view.setBackgroundColor(Color.RED);
                        fourthBit[4] = 1;
                    }
                    break;
                case R.id.fourth_bit_5:
                    if (isFourthBit5Selected){
                        isFourthBit5Selected = false;
                        view.setBackgroundColor(backColor);
                        fourthBit[5] = 0;
                    }else {
                        isFourthBit5Selected = true;
                        view.setBackgroundColor(Color.RED);
                        fourthBit[5] = 1;
                    }
                    break;
                case R.id.fourth_bit_6:
                    if (isFourthBit6Selected){
                        isFourthBit6Selected = false;
                        view.setBackgroundColor(backColor);
                        fourthBit[6] = 0;
                    }else {
                        isFourthBit6Selected = true;
                        view.setBackgroundColor(Color.RED);
                        fourthBit[6] = 1;
                    }
                    break;
                case R.id.fourth_bit_7:
                    if (isFourthBit7Selected){
                        isFourthBit7Selected = false;
                        view.setBackgroundColor(backColor);
                        fourthBit[7] = 0;
                    }else {
                        isFourthBit7Selected = true;
                        view.setBackgroundColor(Color.RED);
                        fourthBit[7] = 1;
                    }
                    break;

                case R.id.fourth_bit_8:
                    if (isFourthBit8Selected){
                        isFourthBit8Selected = false;
                        view.setBackgroundColor(backColor);
                        fourthBit[8] = 0;
                    }else {
                        isFourthBit8Selected = true;
                        view.setBackgroundColor(Color.RED);
                        fourthBit[8] = 1;
                    }
                    break;
                case R.id.fourth_bit_9:
                    if (isFourthBit9Selected){
                        isFourthBit9Selected = false;
                        view.setBackgroundColor(backColor);
                        fourthBit[9] = 0;
                    }else {
                        isFourthBit9Selected = true;
                        view.setBackgroundColor(Color.RED);
                        fourthBit[9] = 1;
                    }
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final EditText mSelectCount = (EditText)findViewById(R.id.edit_select_count);
        Button mSelectCode = (Button)findViewById(R.id.select_code);
        Button mResetSelectCode = (Button)findViewById(R.id.reset_select_code);
        final TextView mShowSelectCode = (TextView)findViewById(R.id.text_select_num);

        Button firstBit0 = (Button)findViewById(R.id.first_bit_0);
        Button firstBit1 = (Button)findViewById(R.id.first_bit_1);
        Button firstBit2 = (Button)findViewById(R.id.first_bit_2);
        Button firstBit3 = (Button)findViewById(R.id.first_bit_3);
        Button firstBit4 = (Button)findViewById(R.id.first_bit_4);
        Button firstBit5 = (Button)findViewById(R.id.first_bit_5);
        Button firstBit6 = (Button)findViewById(R.id.first_bit_6);
        Button firstBit7 = (Button)findViewById(R.id.first_bit_7);
        Button firstBit8 = (Button)findViewById(R.id.first_bit_8);
        Button firstBit9 = (Button)findViewById(R.id.first_bit_9);

        Button fourthBit0 = (Button)findViewById(R.id.fourth_bit_0);
        Button fourthBit1 = (Button)findViewById(R.id.fourth_bit_1);
        Button fourthBit2 = (Button)findViewById(R.id.fourth_bit_2);
        Button fourthBit3 = (Button)findViewById(R.id.fourth_bit_3);
        Button fourthBit4 = (Button)findViewById(R.id.fourth_bit_4);
        Button fourthBit5 = (Button)findViewById(R.id.fourth_bit_5);
        Button fourthBit6 = (Button)findViewById(R.id.fourth_bit_6);
        Button fourthBit7 = (Button)findViewById(R.id.fourth_bit_7);
        Button fourthBit8 = (Button)findViewById(R.id.fourth_bit_8);
        Button fourthBit9 = (Button)findViewById(R.id.fourth_bit_9);


        firstBit0.setOnClickListener(new MyListener());
        firstBit1.setOnClickListener(new MyListener());
        firstBit2.setOnClickListener(new MyListener());
        firstBit3.setOnClickListener(new MyListener());
        firstBit4.setOnClickListener(new MyListener());
        firstBit5.setOnClickListener(new MyListener());
        firstBit6.setOnClickListener(new MyListener());
        firstBit7.setOnClickListener(new MyListener());
        firstBit8.setOnClickListener(new MyListener());
        firstBit9.setOnClickListener(new MyListener());


        fourthBit0.setOnClickListener(new MyListener());
        fourthBit1.setOnClickListener(new MyListener());
        fourthBit2.setOnClickListener(new MyListener());
        fourthBit3.setOnClickListener(new MyListener());
        fourthBit4.setOnClickListener(new MyListener());
        fourthBit5.setOnClickListener(new MyListener());
        fourthBit6.setOnClickListener(new MyListener());
        fourthBit7.setOnClickListener(new MyListener());
        fourthBit8.setOnClickListener(new MyListener());
        fourthBit9.setOnClickListener(new MyListener());



        mSelectCode.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View arg0){
                firstBitSelect = " ";
                fourthBitSelect = " ";
                int first = 0;
                int fourth = 0;
                int k = 0;

                for (int i=0;i<=9;i++){
                    if (firstBit[i]==1){
                        firstBitSelect += " " + String.valueOf(i);
                        first+=1;
                    }
                    if (fourthBit[i]==1){
                        fourthBitSelect += " " + String.valueOf(i);
                        fourth+=1;
                    }
                }

                selectCountStr = mSelectCount.getText().toString();
                selectCodeOut += firstBitSelect + " - " + fourthBitSelect + " | " + selectCountStr + "\n";



                int intCount = Integer.parseInt(selectCountStr);

                for (int i=0;i<=9;i++){
                    if (firstBit[i]==1){
                        for (int n=0;n<=9;n++){
                            if (fourthBit[n]==1){
                                k = i * 10 + n;
                                singleGroup[k] += intCount;
                            }
                        }
                    }
                }


                totalSelectCount += first * fourth * intCount;



                int riskLimit = (totalSelectCount + baseAmt)/singleAmt;

                String outputStr = selectCodeOut + " total count: " + totalSelectCount + "\n";
                outputStr = outputStr + " risk limit: " + riskLimit + "\n";
                outputStr = outputStr + " risk control: " + "\n ";

                for (int i=0;i<=99;i++){
                    int overRiskLimit = singleGroup[i] - riskLimit;
                    int a = 0;
                    int b = 0;
                    if (i>=10){
                        a=i/10;
                        b=i%10;

                    }else {
                        a = 0;
                        b = i;
                    }

                    if (overRiskLimit > 0){
                        outputStr = outputStr + a + " - " + b + " | " + overRiskLimit + "\n ";
                    }
                }

                mShowSelectCode.setText(outputStr);
            }
        });


        mResetSelectCode.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0){
                selectCodeOut ="";
                selectCountStr = "";
                totalSelectCount = 0;
                for (int i=0;i<=99;i++){
                    singleGroup[i] = 0;
                }
                mShowSelectCode.setText(" ");
            }

        });

    }



}

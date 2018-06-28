package com.ag_al.calculator;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    public final static String TEXT_LOG = "MainActivity";
    // EXEMPLO DE LOG:  Log.v(TEXT_LOG, "Entrou");

    String operation;
    int total;
    boolean pass = false; // USAR O RESULTADO ANTERIOR PARA CALCULAR COM O PRÓXIMO, UTILIZANDO ALGUM OPERADOR.
    StringBuilder arm = new StringBuilder("");
    ArrayList<String> list = new ArrayList<>();

    //equal without assigning value
    int equal_w = 5;
    private TextView textview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Activity activity = MainActivity.this;
        if(getScreenOrientation(activity) == "Landscape"){
            Button exponentten = (Button) findViewById(R.id.exponentTen);
            exponentten.setOnClickListener(this);
            Button pi = (Button) findViewById(R.id.pi);
            pi.setOnClickListener(this);
        }

        textview = (TextView) findViewById(R.id.textView);

        Button one = (Button) findViewById(R.id.one);
        one.setOnClickListener(this);
        Button two = (Button) findViewById(R.id.two);
        two.setOnClickListener(this);
        Button three = (Button) findViewById(R.id.three);
        three.setOnClickListener(this);
        Button four = (Button) findViewById(R.id.four);
        four.setOnClickListener(this);
        Button five = (Button) findViewById(R.id.five);
        five.setOnClickListener(this);
        Button six = (Button) findViewById(R.id.six);
        six.setOnClickListener(this);
        Button seven = (Button) findViewById(R.id.seven);
        seven.setOnClickListener(this);
        Button eight = (Button) findViewById(R.id.eight);
        eight.setOnClickListener(this);
        Button nine = (Button) findViewById(R.id.nine);
        nine.setOnClickListener(this);
        Button zero = (Button) findViewById(R.id.zero);
        zero.setOnClickListener(this);

        Button addition = (Button) findViewById(R.id.plus);
        addition.setOnClickListener(this);
        Button subtraction = (Button) findViewById(R.id.minus);
        subtraction.setOnClickListener(this);
        Button multiplicaion = (Button) findViewById(R.id.times);
        multiplicaion.setOnClickListener(this);
        Button division = (Button) findViewById(R.id.obelus);
        division.setOnClickListener(this);

        Button equal = (Button) findViewById(R.id.equal);
        equal.setOnClickListener(this);


        Button clear = (Button) findViewById(R.id.clear);
        clear.setOnClickListener(this);
        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);
        Button percentage = (Button) findViewById(R.id.percent);
        percentage.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.info){
            startActivity(new Intent(MainActivity.this, Info_Activity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("text", (String) textview.getText());
        outState.putString("arm", (String) arm.toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        textview.setText(savedInstanceState.getString("text"));
        arm.delete(0,arm.length());
        arm.append(savedInstanceState.getString("arm"));
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

//############   NUMBERS   #########################
            case R.id.one:
                pass = false;
                arm.append("1");
                textview.setText(arm);
                break;
            case R.id.two:
                pass = false;
                arm.append("2");
                textview.setText(arm);
                break;
            case R.id.three:
                pass = false;
                arm.append("3");
                textview.setText(arm);
                break;
            case R.id.four:
                pass = false;
                arm.append("4");
                textview.setText(arm);
                break;
            case R.id.five:
                pass = false;
                arm.append("5");
                textview.setText(arm);
                break;
            case R.id.six:
                pass = false;
                arm.append("6");
                textview.setText(arm);
                break;
            case R.id.seven:
                pass = false;
                arm.append("7");
                textview.setText(arm);
                break;
            case R.id.eight:
                pass = false;
                arm.append("8");
                textview.setText(arm);
                break;
            case R.id.nine:
                pass = false;
                arm.append("9");
                textview.setText(arm);
                break;
            case R.id.zero:
                pass = false;
                arm.append("0");
                textview.setText(arm);
                break;

//#############   OPERATIONS   #######################
            case R.id.plus:
                if(pass == true){
                    operation = "+";
                    list.add(Integer.toString(total));
                    textview.setText(total+" "+operation);
                }else {
                    operation = "+";
                    list.add(arm.toString());
                    arm.delete(0, arm.length());
                    textview.setText(operation);
                }
                break;
            case R.id.minus:
                if(pass == true){
                    operation = "-";
                    list.add(Integer.toString(total));
                    textview.setText(total+" "+operation);
                }else {
                    operation = "-";
                    list.add(arm.toString());
                    arm.delete(0, arm.length());
                    textview.setText(operation);
                }
                break;
            case R.id.times:
                if(pass == true){
                    operation = "×";
                    list.add(Integer.toString(total));
                    textview.setText(total+" "+operation);
                }else {
                    operation = "×";
                    list.add(arm.toString());
                    arm.delete(0, arm.length());
                    textview.setText(operation);
                }
                break;
            case R.id.obelus:
                if(pass == true){
                    operation = "÷";
                    list.add(Integer.toString(total));
                    textview.setText(total+" "+operation);
                }else {
                    operation = "÷";
                    list.add(arm.toString());
                    arm.delete(0, arm.length());
                    textview.setText(operation);
                }
                break;




//#############    RESULTS   #####################
            case R.id.equal:

                if (operation == null) {
                    break;


                /*}else if (list.size() == 1) {
                    textview.setText(Integer.toString(list.size()));
                    break;

                    switch (operation) {
                        case "+":
                            total += Integer.parseInt(list.get(0));
                            textview.setText(Integer.toString(total));
                            break;
                        case "-":
                            total -= Integer.parseInt(list.get(0));
                            textview.setText(Integer.toString(total));
                            break;
                        case "×":
                            total *= Integer.parseInt(list.get(0));
                            textview.setText(Integer.toString(total));
                            break;
                    }*/
                }else {


                    switch (operation) {

                        case "+":
                            list.add(arm.toString());
                            total = Integer.parseInt(list.get(0)) + Integer.parseInt(list.get(1));
                            // equal_w = Integer.parseInt(list.get(1));
                            textview.setText(Integer.toString(total));
                            arm.delete(0, arm.length());
                            list.clear();
                            operation = null;
                            pass = true;
                            break;
                        case "-":
                            list.add(arm.toString());
                            total = Integer.parseInt(list.get(0)) - Integer.parseInt(list.get(1));
                            // equal_w = Integer.parseInt(list.get(1));
                            textview.setText(Integer.toString(total));
                            arm.delete(0, arm.length());
                            list.clear();
                            operation = null;
                            pass = true;
                            break;
                        case "×":
                            list.add(arm.toString());
                            total = Integer.parseInt(list.get(0)) * Integer.parseInt(list.get(1));
                            // equal_w = Integer.parseInt(list.get(1));
                            textview.setText(Integer.toString(total));
                            arm.delete(0, arm.length());
                            list.clear();
                            operation = null;
                            pass = true;
                            break;
                        case "÷":
                            list.add(arm.toString());
                            total = Integer.parseInt(list.get(0)) / Integer.parseInt(list.get(1));
                            // equal_w = Integer.parseInt(list.get(1));
                            textview.setText(Integer.toString(total));
                            arm.delete(0, arm.length());
                            list.clear();
                            operation = null;
                            pass = true;
                            break;

                    }
                }
                break;



//###############   COMMANDS   ##############################
            case R.id.clear:
                arm.delete(0,arm.length());
                list.clear();
                operation = null;
                pass = false;
                textview.setText("0");
                break;

            case R.id.back:
                try {
                    if (arm.length() == 1) {
                        arm.delete(0, arm.length());
                        textview.setText("0");
                    } else {
                        arm.deleteCharAt(arm.length() - 1);
                        textview.setText(arm);
                    }
                }catch (Exception e){
                    break;
                }
                break;

            case R.id.percent:
                if(operation == "×") {
                    try {
                        list.add(arm.toString());
                        total = Integer.parseInt(list.get(0)) * Integer.parseInt(list.get(1));
                        textview.setText(Integer.toString(total / 100));
                        arm.delete(0, arm.length());
                        list.clear();
                        operation = null;
                    } catch (Exception e) {
                        textview.setText("0");
                    }
                }
                arm.delete(0,arm.length());
                list.clear();
                operation = null;
                break;

            case R.id.exponentTen:
                try {
                    double exponent = Math.pow(10, Integer.parseInt(arm.toString()));
                    arm.delete(0, arm.length());
                    textview.setText(Double.toString(exponent));
                }catch (Exception e){
                    break;
                }

                break;
            case R.id.pi:
                textview.setText(Double.toString(Math.PI));
                break;

        }

    }

    public static String getScreenOrientation(Activity activity) {

        String orientation = "";

        int currentOrientation = activity.getResources().getConfiguration().orientation;

        if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            orientation = "Landscape";
        }

        if (currentOrientation == Configuration.ORIENTATION_PORTRAIT) {
            orientation = "Portrait";
        }

        return orientation;
    }


}

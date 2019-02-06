package pro.buzi.calc_project;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private  EditText text_first;
    private TextView result;
    private Button btn;
    private FloatingActionButton floatbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onBtnClik();
    }
    public void onBtnClik() {
        //find opjects and messenger
        this.text_first = findViewById(R.id.txtViewIn);
        this.result = findViewById(R.id.txtViewOut);
        this.btn = findViewById(R.id.btn_convert);
        this.floatbtn = findViewById(R.id.floatbtn);

        //обработчик событий
        floatbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //перекидываем пользователя на другую страницу
                Intent intent = new Intent("pro.buzi.calc_project.LoginPageActivity");
                startActivity(intent);
            }
        });

        //обработчик событий
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //обьявляем переменную и передаем обьект конвертируя его в стринг
                String text = text_first.getText().toString();

                if(!text.matches("")) {
                    float num = Float.parseFloat(text);
                    num *= 1.61;
                    result.setText(Float.toString(num) + " mile"); //выводим результат
                    btn.setText("is ready");

                    //проверка на совместимость, могу ли я менять цвет в этой версии
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                        btn.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
                    else btn.setBackgroundColor(Color.BLUE); //меняем цвет кнопки
                }else {
                    Toast.makeText(MainActivity.this, "Please, enter km",
                            Toast.LENGTH_LONG).show(); //уведомление, подсказска
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                        btn.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    else btn.setBackgroundColor(Color.RED);
                }
            }
        });
    }
}

package cm0117.jec.ac.android111r;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * イベントハンドラーの実装クラス
     */
    class DialogDataSetEvent implements DatePickerDialog.OnDateSetListener{

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            EditText editText = (EditText)findViewById(R.id.editText);
            editText.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.btnSel);
        btn.setOnClickListener(this);
    }

    /**
     * 日付選択ボタンをタップすると日付が選べる
     * イベントハンドラーの定義
     * @param v
     */
    @Override
    public void onClick(View v) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog dialog = new DatePickerDialog(
                this,//このダイアログを表示する親となるView
                new DialogDataSetEvent(),//OKを押された時のイベントハンドラ
                calendar.get(Calendar.YEAR),//初期表示の年(今年の日付の年)
                calendar.get(Calendar.MONTH),//初期表示の月(今年の日付の月)
                calendar.get(Calendar.DAY_OF_MONTH)//初期表示の日(今年の日付の日)
        );
        dialog.show();
    }
}

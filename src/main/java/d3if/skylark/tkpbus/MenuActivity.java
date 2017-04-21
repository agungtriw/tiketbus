package d3if.skylark.tkpbus;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    GridView grid;
    String[] dataArrayCustomGrid = {"PROFILE", "JADWAL", "BOOKING", "TENTANG"};

    int[] imageId = {
            R.drawable.ic_account_box_black_24dp,
            R.drawable.ic_event_black_24dp,
            R.drawable.ic_bookmark_border_black_24dp,
            R.drawable.ic_error_black_24dp,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        CustomGrid adapter = new CustomGrid(MenuActivity.this, dataArrayCustomGrid, imageId);
        grid = (GridView)findViewById(R.id.gridViewCustomData);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        Intent newActivity0 = new Intent(MenuActivity.this,ProfileActivity.class);
                        startActivity(newActivity0);
                        break;
                    case 1:
                        Intent newActivity1 = new Intent(MenuActivity.this, JadwalActivity.class);
                        startActivity(newActivity1);
                        break;
                    case 2:
                        Intent newActivity2 = new Intent(MenuActivity.this, BookingActivity.class);
                        startActivity(newActivity2);
                        break;
                    case 3:
                        Intent newActivity3 = new Intent(MenuActivity.this, AboutActivity.class);
                        startActivity(newActivity3);
                        break;
                    default:
                        System.out.println("Menu tidak ada");
                }

            }
        });
    }

    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Klik BACK sekali lagi untuk EXIT", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

}

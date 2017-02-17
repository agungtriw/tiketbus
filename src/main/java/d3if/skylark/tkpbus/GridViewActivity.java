package d3if.skylark.tkpbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class GridViewActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_grid_view);

        CustomGrid adapter = new CustomGrid(GridViewActivity.this, dataArrayCustomGrid, imageId);
        grid = (GridView)findViewById(R.id.gridViewCustomData);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        Intent newActivity0 = new Intent(GridViewActivity.this,MainActivity.class);
                        startActivity(newActivity0);
                        break;
                    case 1:
                        Intent newActivity1 = new Intent(GridViewActivity.this, GridViewActivity.class);
                        startActivity(newActivity1);
                        break;
                    case 2:
                        Intent newActivity2 = new Intent(GridViewActivity.this, BookingActivity.class);
                        startActivity(newActivity2);
                        break;
                    case 3:
                        Intent newActivity3 = new Intent(GridViewActivity.this, AboutActivity.class);
                        startActivity(newActivity3);
                        break;
                    default:
                        System.out.println("Menu tidak ada");
                }

            }
        });
    }

}

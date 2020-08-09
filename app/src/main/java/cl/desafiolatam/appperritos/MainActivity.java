package cl.desafiolatam.appperritos;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import cl.desafiolatam.appperritos.vista.ListaFragmtPerritos;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.mainFrameLayout,
                ListaFragmtPerritos.newInstance(1),"lista perritos").commit();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Fragment oldFragment = getSupportFragmentManager().findFragmentByTag("details");
        if (oldFragment == null) {
            super.onBackPressed();
        } else {
            getSupportFragmentManager().beginTransaction().add(R.id.mainFrameLayout,
                    ListaFragmtPerritos.newInstance(1),
                    "listaPerritos").remove(oldFragment).commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
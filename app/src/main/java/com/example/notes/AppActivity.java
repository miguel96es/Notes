package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import java.util.ArrayList;
import java.util.List;

import yuku.ambilwarna.AmbilWarnaDialog;


public class AppActivity extends AppCompatActivity {

    private List<String> items;

    private GridView gridView;
    private MyAdapter myAdapter;
    private int Elementos2;
    int mDefaultColor;
    private int contador=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        //
        mDefaultColor = ContextCompat.getColor(AppActivity.this, R.color.black);
        //poner el icono en el action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        gridView = (GridView) findViewById(R.id.gridView);
        items = new ArrayList<String>();
        Elementos2 = R.layout.grid_item;



        //nombres.add("Imagen");


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(AppActivity.this, "clic en "+items.get(position), Toast.LENGTH_LONG).show();
            }
        });

        //IMAGEN
        myAdapter = new MyAdapter(this, Elementos2, items);
        gridView.setAdapter(myAdapter);

        registerForContextMenu(gridView);

        // NOTA




    }

    //metodo para mostrar los botones de accion
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
        return true;
    }

    //Metodo para agregar las acciones de los botones
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id== R.id.add_item){
            Toast.makeText(this, "Se agrega una nota", Toast.LENGTH_SHORT).show();
            this.items.add("");
            this.myAdapter.agregarNota();
            return true;
        }
        if (id== R.id.add_img){
            Toast.makeText(this, "Se agrega imagen", Toast.LENGTH_SHORT).show();
            //agregamos un nuevo nombre
            //this.nombres.add("nombre"+ (++contador));
            this.items.add("item"+ (++contador));
            //Notificamos al adaptador del cambio producido
            this.myAdapter.agregarImagen();
            //this.myAdapter.notifyDataSetChanged();

            return true;
        }
        if (id== R.id.exit){
            Toast.makeText(this, "Se sale de la aplicacion", Toast.LENGTH_SHORT).show();
            finish();
            return true;
        } return super.onOptionsItemSelected(item);
    }

    //Creamos el menu contextual
    @Override
    public void onCreateContextMenu(ContextMenu menu,View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        MenuInflater inflater = getMenuInflater();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(this.items.get(info.position));
        inflater.inflate(R.menu.context_menu, menu);
    }

    //manejamos eventos del menu
    @Override
    public boolean onContextItemSelected(MenuItem item){
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()){
            case R.id.cambiar_color:
                //eliminamos el item
                //this.items.remove(info.position);
                //notificamos el cambio
                //this.myAdapter.notifyDataSetChanged();
                Toast.makeText(this, "Se cambia de color", Toast.LENGTH_SHORT).show();
                openCambioColor();
                return true;

            default:
                return super.onContextItemSelected(item);


        }
    }

    public void openCambioColor(){

        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, mDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
            }
            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                mDefaultColor = color;
                //note.setBackgroundColor(mDefaultColor);
            }
        });
        colorPicker.show();
    }

}
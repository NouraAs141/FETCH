package p.fetch;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Item_Detail extends AppCompatActivity {

    private ImageView ImageResource;
    private TextView Name, Description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item__detail);



        ImageResource= (ImageView) findViewById(R.id.image_item_thumbnail);
        Name=(TextView) findViewById(R.id.item_name_d);
        Description=(TextView) findViewById(R.id.item_description_d);

        //Recieve Data

        Intent intent = getIntent();
        int sImageResource = intent.getExtras().getInt("Photo: ");
                String sName= intent.getExtras().getString("Name: ");
                        String sDescription= intent.getExtras().getString("Item Description: ");

   // set value
        ImageResource.setImageResource(sImageResource);
        Name.setText(sName);
        Description.setText(sDescription);
    }
}

package newcryptomarkets.unicorns.com.crypto;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Donate extends Activity{
    TextView txtDonate;
    ImageView donateBIDI;
    ImageView donateImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donate_layout);

        donateBIDI = (ImageView) findViewById(R.id.imgBIDI);
        donateBIDI.setImageResource(0);
        Drawable draw = getResources().getDrawable(R.drawable.mibtcbidi);
        donateBIDI.setImageDrawable(draw);

        donateImg = (ImageView) findViewById(R.id.imgDonate);
        donateImg.setImageResource(0);
        Drawable draw1 = getResources().getDrawable(R.drawable.donatebitcoin);
        donateImg.setImageDrawable(draw1);

        txtDonate = (TextView) findViewById(R.id.txtDonateBit);
        txtDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                String text;
                ClipData clip = ClipData.newPlainText("text", "TextVi1D9yJjFCQrm6M5PGqW2qeUmTQfg9ut1DEVew");
                assert clipboard != null;
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getApplicationContext(), "Text Copied to Clipboard",Toast.LENGTH_SHORT).show();
                clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

            }
        });
    }
}

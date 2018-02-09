package newcryptomarkets.unicorns.com.crypto;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by pabl3 on 30/01/2018.
 */

public class CoinInfo extends Activity {
    ImageView logoCoin;
    TextView tviD;
    TextView tvName;
    TextView tvName2;
    TextView tvPrice;
    TextView tvChange1H;
    TextView tvChange24h;
    TextView tvChange7D;
    TextView marketCapUSD;
    TextView tvavailableSupply;
    Button bttnBuy;
    Button bttnSell;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coininfo_layout);

        logoCoin = (ImageView) findViewById(R.id.imageCoin);
        tviD = (TextView) findViewById(R.id.textViewiD);
        tvName = (TextView) findViewById(R.id.textViewName);
        tvName2 = (TextView) findViewById(R.id.tvTitle2);
        tvPrice = (TextView) findViewById(R.id.tvPrice);
        tvChange1H = (TextView) findViewById(R.id.tvChange1h);
        tvChange24h = (TextView) findViewById(R.id.tvChange24h);
        tvChange7D = (TextView) findViewById(R.id.tvChange7d);
        marketCapUSD = (TextView) findViewById(R.id.tvMarketcapUsd);
        tvavailableSupply = (TextView) findViewById(R.id.tvAvailablesupply);


        String id = getIntent().getExtras().getString("id");
        tviD.setText(id);
        String name = getIntent().getExtras().getString("name");
        tvName.setText(name);
        String title2 = getIntent().getExtras().getString("title2");
        tvName2.setText("(" + title2 + ")");


        String usdprice = getIntent().getExtras().getString("usdprice");
        tvPrice.setText(usdprice);
        String percentchangeoneday = getIntent().getExtras().getString("percentchangeoneday");
        tvChange1H.setText(percentchangeoneday);
        String percentchange24h = getIntent().getExtras().getString("percentchange24h");
        tvChange24h.setText(percentchange24h);
        String percentchange7d = getIntent().getExtras().getString("percentchange7d");
        tvChange7D.setText(percentchange7d);
        String usdmarketCap = getIntent().getExtras().getString("marketcapusd");
        marketCapUSD.setText("$" + usdmarketCap);
        String availableSupply = getIntent().getExtras().getString("availablesupply");
        tvavailableSupply.setText("$" + availableSupply);

        Double number = Double.valueOf(percentchangeoneday);
        if(number<0) {
            tvChange1H.setTextColor(Color.RED);
        } else{
            tvChange1H.setTextColor(Color.parseColor("#32af2b"));
        }

        Double number1 = Double.valueOf(percentchange24h);
        if(number1<0) {
            tvChange24h.setTextColor(Color.RED);
        } else{
            tvChange24h.setTextColor(Color.parseColor("#32af2b"));
        }

        Double number2 = Double.valueOf(percentchange7d);
        if(number2<0) {
            tvChange7D.setTextColor(Color.RED);
        } else{
            tvChange7D.setTextColor(Color.parseColor("#32af2b"));
        }

        bttnBuy = (Button) findViewById(R.id.buttonBuy);
        bttnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://partners.etoro.com/B9214_A70838_TClick.aspx";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        bttnSell = (Button) findViewById(R.id.buttonSell);
        bttnSell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://partners.etoro.com/B9214_A70838_TClick.aspx";

                Intent ii = new Intent(Intent.ACTION_VIEW);
                ii.setData(Uri.parse(url));
                startActivity(ii);
            }
        });

        Picasso.with(this).load("https://chasing-coins.com/api/v1/std/logo/" + title2).into(logoCoin);
    }

}


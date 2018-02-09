package newcryptomarkets.unicorns.com.crypto;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

import java.util.List;

/**
 * Created by pabl3 on 30/01/2018.
 */

public class CoinsAdapter extends BaseAdapter {
    private Context context;
    private List<Coins> coinsList;
    private LayoutInflater inflater = null;

    private static final String IMAGE_BASEURL = "https://chasing-coins.com/api/v1/std/logo/";

    private LruCache<Integer,Bitmap> imageCache;
    private RequestQueue queue;

    CoinsAdapter(Context context, List<Coins> list) {

        this.context = context;
        this.coinsList = list;
        inflater = LayoutInflater.from(context);

        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        final int cacheSize = maxMemory / 10;
        imageCache = new LruCache<>(cacheSize);
        queue = Volley.newRequestQueue(context);
    }

    public class ViewHolder {

        TextView _title;
        TextView _title2;
        TextView _usdprice;
        TextView _change24h;
        ImageView _coinImage;
        Button _button;
    }

    @Override
    public int getCount() {
        return coinsList.size();
    }

    @Override
    public Object getItem(int position) {

        return coinsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {

        final Coins games = coinsList.get(position);
        final ViewHolder holder;
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_templates,null);
            holder = new ViewHolder();

            holder._title = convertView.findViewById(R.id.tvtitle);
            holder._title2 = convertView.findViewById(R.id.tvdesc);
            holder._usdprice = convertView.findViewById(R.id.tvplateform);
            holder._change24h = convertView.findViewById(R.id.tvdesc);
            holder._button = convertView.findViewById((R.id.button));
            holder._button.setOnClickListener(new View.OnClickListener() {


                public void onClick(View v) {
                    String id = games.getId();
                    String title = games.getTitle();
                    String title2 = games.getTitle2();
                    String usdprice = games.getUsdPrice();
                    String pricebtc = games.getBtcPrice();
                    String marketcapusd = games.getMarketCapUsd();
                    String availablesupply = games.getAvailableSupply();
                    String totalsupply = games.getTotalSupply();
                    String percentchange1h = games.getChange1H();
                    String percentchange24h = games.getChange24H();
                    String percentchange7d = games.getChange7d();
                    String lastupdated = games.getLastUpdated();
                    //String maxsupply = games.getMaxSupply();

                    Intent i = new Intent(v.getContext(), CoinInfo.class);

                    i.putExtra("id", games.getId());
                    i.putExtra("name", games.getTitle());
                    i.putExtra("title2", games.getTitle2());
                    i.putExtra("usdprice", "$" + games.getUsdPrice());
                    i.putExtra("pricebtc", games.getBtcPrice());
                    i.putExtra("marketcapusd", games.getMarketCapUsd());
                    i.putExtra("availablesupply", games.getAvailableSupply());
                    i.putExtra("percentchangeoneday", games.getChange1H());
                    i.putExtra("percentchange24h", games.getChange24H());
                    i.putExtra("percentchange7d", games.getChange7d());

                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    v.getContext().startActivity(i);
                    //i.putExtra(games.getMarketCapUsd(), marketcapusd);

                    //i.putExtra(games.getTotalSupply(), totalsupply);
                    //i.putExtra(games.getMaxSupply(), maxsupply);

                    //
                    //
                    //i.putExtra(games.getLastUpdated(), lastupdated);

                }

                //String url = "http://partners.etoro.com/B9214_A70838_TClick.aspx";

                //Intent i = new Intent(Intent.ACTION_VIEW);
                //i.setData(Uri.parse(url));
                //context.startActivity(i);
                //}

            });

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder._title.setText(games.getTitle());
        holder._usdprice.setText("1 "+ games.getTitle2() + " = $" + games.getUsdPrice());
        holder._title2.setText(games.getTitle2());
        holder._change24h.setText(games.getChange24H() + "%");

        Double number = Double.valueOf(games.getChange24H());
        if(number<0) {
            holder._change24h.setTextColor(Color.RED);
        } else{
            holder._change24h.setTextColor(Color.parseColor("#32af2b"));
        }

        Bitmap bitmap = imageCache.get(Integer.parseInt(games.getId()));
        holder._coinImage = convertView.findViewById(R.id.gameImage);

        if (bitmap != null) {

            holder._coinImage.setImageBitmap(bitmap);

        }else {

            String imageURL = IMAGE_BASEURL + games.getTitle2();
            ImageRequest request = new ImageRequest(imageURL,
                    new Response.Listener<Bitmap>() {

                        @Override
                        public void onResponse(Bitmap response) {

                            holder._coinImage.setImageBitmap(response);
                            imageCache.put(Integer.parseInt(games.getId()), response);

                        }
                    },
                    90, 90,
                    Bitmap.Config.ARGB_8888,
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("error", error.getMessage());
                        }
                    });
            queue.add(request);

        }

        return convertView;

    }

}


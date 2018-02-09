package newcryptomarkets.unicorns.com.crypto;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by pabl3 on 01/02/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String IMAGE_BASEURL = "https://chasing-coins.com/api/v1/std/logo/";

    private LruCache<Integer,Bitmap> imageCache;
    private RequestQueue queue;

    Context context;

    private List<CompleteAdapter> dataAdapters;

    RecyclerViewAdapter(List<CompleteAdapter> getDataAdapter, Context context){

        super();

        this.dataAdapters = getDataAdapter;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_complete, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {

        final CompleteAdapter dataAdapter = dataAdapters.get(position);

        viewHolder.TextViewID.setText(dataAdapter.getName());

        viewHolder.TextViewName.setText(String.valueOf(dataAdapter.getId()));

        viewHolder.TextViewLastHour.setText(dataAdapter.getLast_hour() + "%");

        viewHolder.TextViewLast24Hours.setText(dataAdapter.getLast24_hours() + "%");

        viewHolder.TextViewLast7Days.setText(dataAdapter.getLast_7_days() + "%");

        viewHolder.TextViewUsdPrice.setText("$" + dataAdapter.getUsd_price());

        viewHolder.TextMarketCapUSD.setText("$" + dataAdapter.getMarket_cap_usd());

        viewHolder.TextViewAvailableSupply.setText(dataAdapter.getAvailable_supply());

        viewHolder.TextViewVolume24H.setText("$" + dataAdapter.getVolume_24h());

        viewHolder.ImageViewSymbolCrypto.setImageBitmap(dataAdapter.getImage_coin());
        Picasso.with(context).load("https://chasing-coins.com/api/v1/std/logo/" + dataAdapter.getSymbol()).resize(200, 200).into(viewHolder.ImageViewSymbolCrypto);

        /**Bitmap bitmap = imageCache.get(Integer.parseInt(dataAdapter.getSymbol()));
        if (bitmap != null) {

            viewHolder.ImageViewSymbolCrypto.setImageBitmap(bitmap);

        } else {

            String imageURL = IMAGE_BASEURL + dataAdapter.getSymbol();
            ImageRequest request = new ImageRequest(imageURL,
                    new Response.Listener<Bitmap>() {

                        @Override
                        public void onResponse(Bitmap response) {

                            viewHolder.ImageViewSymbolCrypto.setImageBitmap(response);
                            imageCache.put(Integer.parseInt(dataAdapter.getSymbol()), response);

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
         */

        Double number = Double.valueOf(dataAdapter.getLast_hour());
        if(number<0) {
            viewHolder.TextViewLastHour.setTextColor(Color.RED);
        } else{
            viewHolder.TextViewLastHour.setTextColor(Color.parseColor("#32af2b"));
        }

        Double number1 = Double.valueOf(dataAdapter.getLast24_hours());
        if(number1<0) {
            viewHolder.TextViewLast24Hours.setTextColor(Color.RED);
        } else{
            viewHolder.TextViewLast24Hours.setTextColor(Color.parseColor("#32af2b"));
        }

        Double number2 = Double.valueOf(dataAdapter.getLast_7_days());
        if(number2<0) {
            viewHolder.TextViewLast7Days.setTextColor(Color.RED);
        } else{
            viewHolder.TextViewLast7Days.setTextColor(Color.parseColor("#32af2b"));
        }



    }

    //@Override
    public int getItemCount() {

        return dataAdapters.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView TextViewName;
        TextView TextViewID;
        TextView TextViewLastHour;
        TextView TextViewLast24Hours;
        TextView TextViewLast7Days;
        TextView TextViewUsdPrice;
        TextView TextMarketCapUSD;
        TextView TextViewAvailableSupply;
        TextView TextViewVolume24H;
        ImageView ImageViewSymbolCrypto;


        ViewHolder(View itemView) {

            super(itemView);

            TextViewName = (TextView) itemView.findViewById(R.id.txtcvRank) ;
            TextViewID = (TextView) itemView.findViewById(R.id.txtcvName) ;
            TextViewLastHour = (TextView) itemView.findViewById(R.id.txtcvLastHour) ;
            TextViewLast24Hours = (TextView) itemView.findViewById(R.id.txtcvLast24) ;
            TextViewLast7Days = (TextView) itemView.findViewById(R.id.txtcvLast7days);
            TextViewUsdPrice = (TextView) itemView.findViewById(R.id.txtusdPrice);
            TextMarketCapUSD = (TextView) itemView.findViewById(R.id.txtMarketCapUSD);
            TextViewAvailableSupply = (TextView) itemView.findViewById(R.id.txtAvailableSuply);
            TextViewVolume24H = (TextView) itemView.findViewById(R.id.txtVolume24H);

            ImageViewSymbolCrypto = (ImageView) itemView.findViewById(R.id.ivSymbolCrypto);



        }

    }
    public interface  RecyclerViewOnItemClickListener {

        void onClick(View v, int position);
    }
}

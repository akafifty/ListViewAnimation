package cimg.iso.com.listviewanimation;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by akafifty on 18/9/17.
 */

public class CustomAdapter extends ArrayAdapter<ObjetoListView> {

    private final Activity activity;
    private ArrayList<ObjetoListView> arrayList;

    public CustomAdapter(Activity activity, ArrayList<ObjetoListView> arrayList) {
        super(activity, R.layout.custom_layout_listview, arrayList);
        this.activity = activity;
        this.arrayList = arrayList;

    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView =
                    LayoutInflater.from(getContext())
                            .inflate(R.layout.custom_layout_listview,
                                    parent, false);
        }

        TextView txtNombre = convertView.findViewById(R.id.txtNickHistorico);
        TextView txtMensaje = convertView.findViewById(R.id.txtMensajeHistorico);
        TextView txtFecha = convertView.findViewById(R.id.txtFechaHistorico);
        TextView txtBadgeNotification = convertView.findViewById(R.id.badge_notification);
        TextView txtSmallIcon = convertView.findViewById(R.id.txtSmallIcon);

        ImageView imgAudio = convertView.findViewById(R.id.imgAudio);
        ImageView imgPhoto = convertView.findViewById(R.id.imgPhoto);
        ImageView imgVideo = convertView.findViewById(R.id.imgVideo);
        ImageView imgP = convertView.findViewById(R.id.profile_image);


        imgP.setImageDrawable(activity.getResources().getDrawable(arrayList.get(position).getImg()));
        txtNombre.setText(arrayList.get(position).getNombre());
        txtMensaje.setText(arrayList.get(position).getMensaje());
        txtFecha.setText(arrayList.get(position).getFecha());


        String tipoMensaje = arrayList.get(position).getTipoUltimoMensaje();

        switch (tipoMensaje) {
            case MainActivity.TEXTO:
                txtMensaje.setVisibility(View.VISIBLE);
                imgAudio.setVisibility(View.GONE);
                imgPhoto.setVisibility(View.GONE);
                imgVideo.setVisibility(View.GONE);
                txtSmallIcon.setVisibility(View.GONE);
                break;
            case MainActivity.AUDIO:
                txtMensaje.setVisibility(View.GONE);
                imgAudio.setVisibility(View.VISIBLE);
                txtSmallIcon.setVisibility(View.VISIBLE);
                txtSmallIcon.setText(arrayList.get(position).getTxtSmallIcon());
                break;

            case MainActivity.IMAGEN:
                txtMensaje.setVisibility(View.GONE);
                imgPhoto.setVisibility(View.VISIBLE);
                txtSmallIcon.setVisibility(View.VISIBLE);
                txtSmallIcon.setText(arrayList.get(position).getTxtSmallIcon());
                break;

            case MainActivity.VIDEO:
                txtMensaje.setVisibility(View.GONE);
                imgVideo.setVisibility(View.VISIBLE);
                txtSmallIcon.setVisibility(View.VISIBLE);
                txtSmallIcon.setText(arrayList.get(position).getTxtSmallIcon());
                break;

        }


        if (!arrayList.get(position).isMsjLeido()) {
            txtFecha.setTextColor(activity.getResources().getColor(R.color.color_notification));
            txtBadgeNotification.setVisibility(View.VISIBLE);
            txtBadgeNotification.setText(String.valueOf(arrayList.get(position).getNrMsjNoLeido()));

        } else {
            txtFecha.setTextColor(Color.GRAY);
            txtBadgeNotification.setVisibility(View.GONE);
        }



        /**
         * ANIMACION 1
         *
         */
        Animation animation = AnimationUtils.loadAnimation(activity, android.R.anim.slide_in_left);
        convertView.startAnimation(animation);


        /**
         * ANIMACION 2
         *
        Animation animation = AnimationUtils.loadAnimation(activity,
                (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        convertView.startAnimation(animation);
        lastPosition = position;
         */

        /**
         * ANIMACION 3
         *
        Animation animation = AnimationUtils.loadAnimation(activity,
                (position > lastPosition) ? R.anim.up_from_bottom : android.R.anim.slide_in_left);
        convertView.startAnimation(animation);
        lastPosition = position;
         */

        /**
         * ANIMACION 4
         *
        Animation animation = AnimationUtils.loadAnimation(activity, R.anim.top_down);
        convertView.startAnimation(animation);
         */

        return convertView;
    }


    private int lastPosition = -1;










































}

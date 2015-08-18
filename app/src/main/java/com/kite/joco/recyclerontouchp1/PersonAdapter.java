package com.kite.joco.recyclerontouchp1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Joco on 2015.08.18..
 */
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private ArrayList<Person> personArrayList;
    Context context;

    public PersonAdapter(Context context,ArrayList<Person> personArrayList) {
        this.context=context;
        this.personArrayList = personArrayList;

    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.personitem,viewGroup,false);

        return new PersonViewHolder(itemView, new PersonViewHolder.IMyViewHolderClicks() {
            @Override
            public void onPerson(View caller, int position) {
                Toast.makeText(context,personArrayList.get(position).toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onHairColor(TextView textView, int position) {
                Toast.makeText(context,"Haj szine: " +personArrayList.get(position).getHaircolor(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        Person p = personArrayList.get(i);
        personViewHolder.tvPersonName.setText(p.getName());
        personViewHolder.tvHairColor.setText(p.getHaircolor());
    }

    @Override
    public int getItemCount() {
        return personArrayList.size();
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public final String LOGTAG="RecOnTouchDemo";
        TextView tvPersonName;
        TextView tvHairColor;
        IMyViewHolderClicks mListener;


        public PersonViewHolder(View itemView, IMyViewHolderClicks listener) {
            super(itemView);
            mListener = listener;
            tvPersonName = (TextView) itemView.findViewById(R.id.tvPersonName);
            tvHairColor = (TextView) itemView.findViewById(R.id.tvhaircolor);
            tvHairColor.setOnClickListener(this);
            //tvPersonName.setOnClickListener(this);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.tvhaircolor) {
                mListener.onHairColor((TextView)v,getAdapterPosition());
            }
            else {
                mListener.onPerson(v,getAdapterPosition());
            }
        }

        public static interface IMyViewHolderClicks {
            public void onPerson(View caller, int position);
            public void onHairColor(TextView textView, int position);
        }
    }

}

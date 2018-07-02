package com.example.katarzynagedlek.planets_01;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PlanetAdapter extends RecyclerView.Adapter <PlanetAdapter.ViewHolder> {

    private List<Planet> planetList;
    private Context mContext;
    private RecyclerView mRecyclerView;


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;
        public ImageView imageView;
        public TextView readTextView;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            nameTextView = v.findViewById(R.id.row_name);
            imageView = v.findViewById(R.id.row_image);
            readTextView = v.findViewById(R.id.row_read);

        }
    }

    public PlanetAdapter(List<Planet> myDataset, Context context, RecyclerView recyclerView) {
        planetList = myDataset;
        mContext = context;
        mRecyclerView = recyclerView;
    }

    @Override
    public PlanetAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.single_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;

    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final Planet planet = planetList.get(position);
        holder.imageView.setImageResource(planet.getImageResourceId());
        holder.nameTextView.setText(planet.getName());
        if(planet.isRead())
            holder.readTextView.setVisibility(View.VISIBLE);
        else
            holder.readTextView.setVisibility(View.GONE);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PlanetActivity.class);
                intent.putExtra(PlanetActivity.EXTRA_PLANETNO, planetList.get(position).getId());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return planetList.size();
    }

}

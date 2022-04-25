package com.akriti.physicsWallah.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.akriti.physicsWallah.Model.User;
import com.akriti.physicsWallah.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    Context context;
    List<User> data;
    ImageView profilepic;
    TextView username,idno,qual,subj;
    public UserAdapter(List<User> data, Context context)
    {
        this.context=context;
        this.data=data;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final User geter1 =  data.get(position);
        String name,image,s,q,idn;
        name=geter1.getName();
        idn=geter1.getidno();
          s=geter1.getSubject();
            q=geter1.getQual();
        image=geter1.getProfileUrl();
        idno.setText(idn);
        username.setText(name);
        qual.setText(q);
        subj.setText(s);
        Picasso.get().load(image).into(profilepic);



    }

    @Override
    public int getItemCount() {
       return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);

            profilepic=(ImageView)itemView.findViewById(R.id.profilepic);
            username=(TextView)itemView.findViewById(R.id.username);
            idno=(TextView)itemView.findViewById(R.id.idno);
            qual=(TextView)itemView.findViewById(R.id.qual);
            subj=(TextView)itemView.findViewById(R.id.subj);


        }
    }
}

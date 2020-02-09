package edu.sp.mapp_ca2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;


public class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.WordViewHolder> {

    MenuOpenHelper mDB;

    class WordViewHolder extends RecyclerView.ViewHolder {
        public final TextView wordItemView;
        /*Button delete_button;
        Button edit_button;*/

        public WordViewHolder(View itemView) {
            super(itemView);
            wordItemView = (TextView) itemView.findViewById(R.id.chickenchoptext);
            /*delete_button = (Button)itemView.findViewById(R.id.delete_button);
            edit_button = (Button)itemView.findViewById(R.id.edit_button);*/
        }

    }

    private static final String TAG = MenuListAdapter.class.getSimpleName();

    public static final String EXTRA_ID = "ID";
    public static final String EXTRA_WORD = "WORD";

    private final LayoutInflater mInflater;
    Context mContext;

    public MenuListAdapter(Context context, MenuOpenHelper db) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
        mDB = db;
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {

        final WordItem current = mDB.query(position);
        holder.wordItemView.setText(current.getWord());

        final WordViewHolder h= holder;







        /*holder.delete_button.setOnClickListener(
                new MyButtonOnClickListener(current.getId(), null) {

                    @Override
                    public void onClick(View v){
                        int deleted = mDB.delete(id);
                        if(deleted >= 0)
                            notifyItemRemoved(h.getAdapterPosition());
                    }
                });*/

     /*   holder.edit_button.setOnClickListener(new MyButtonOnClickListener(current.getId(), current.getWord()) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, EditWordActivity.class);

                intent.putExtra(EXTRA_ID, id);
                intent.putExtra("POSITION", h.getAdapterPosition());
                intent.putExtra(EXTRA_WORD, word);

                //Start an empty activity
                ((Activity) mContext).startActivityForResult(
                        intent, MainActivity.WORD_EDIT);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        // Placeholder so we can see some mock data.
        return (int) mDB.count();
    }

}

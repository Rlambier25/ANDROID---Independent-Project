//package com.example.guest.nr_studyapp.adapters;
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.example.guest.nr_studyapp.R;
//
//import butterknife.Bind;
//import butterknife.ButterKnife;
//
//import java.util.ArrayList;
//
///**
// * Created by Guest on 7/11/16.
// */
//public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.CardViewHolder> {
//    private ArrayList<Card> mCards = new ArrayList<>();
//    private Context mContext;
//
//    public CardListAdapter(Context context, ArrayList<Card> cards) {
//        mContext = context;
//        mCards = cards;
//    }
//
//    @Override
//    public CardListAdapter.CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flashcard_list_item, parent, false)
//                CardViewHolder viewHolder = new CardViewHolder(view);
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(CardListAdapter.CardViewHolder holder, int position) {
//        holder.bindCard(mCards.get(position));
//    }
//
//    @Override
//    public int getItemCount() {
//        return mCards.size();
//    }
//
//    public class CardViewHolder extends RecyclerView.ViewHolder {
//        @Bind(R.id.flashCards) TextView mflashCards;
//        private Context mContext;
//
//        public CardViewHolder(View itemView) {
//            super(itemView);
//            ButterKnife.bind(this, itemView);
//            mContext = itemView.getContext();
//        }
//
//        public void bindCard(Card card) {
//            mflashCards.setText(card.getTerm());
////            mgetDefinition.setText()
//        }
//    }
//}


//Leaving on CUSTOMER ADAPTERS WITH RECYCLERVIEW. Need to continue at RECYCLER VIEW HOLDERS.
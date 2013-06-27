package com.afzaln.mi_chat;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.afzaln.mi_chat.R.color;
import com.afzaln.mi_chat.provider.ProviderContract.UsersTable;

public class UsersCursorAdapter extends CursorAdapter {

    private int mModNameColor;

    public UsersCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        mModNameColor = context.getResources().getColor(color.mod_name);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View listItemView = LayoutInflater.from(context).inflate(R.layout.user_list_item, parent, false);

        ViewHolder holder = new ViewHolder();
        holder.userNameView = (TextView) listItemView.findViewById(R.id.user_row);

        listItemView.setTag(holder);
        return listItemView;
    }


    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        String userName = cursor.getString(cursor.getColumnIndex(UsersTable.USERNAME));
        int userRole = cursor.getInt(cursor.getColumnIndex(UsersTable.USERROLE));

        ViewHolder holder = (ViewHolder) view.getTag();
        holder.userNameView.setText(userName);
        if (userRole == 2) {
            holder.userNameView.setTextColor(mModNameColor);
        } else {
            holder.userNameView.setTextColor(Color.WHITE);
        }
    }

    static class ViewHolder {
        TextView userNameView;
    }

}

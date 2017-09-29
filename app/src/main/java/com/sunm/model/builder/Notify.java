package com.sunm.model.builder;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/9/28.
 */

public class Notify {

    private String mTitle;
    private String mContent;
    private int mSmallIcon;
    private long mWhen;

    public Notify(NotifyBuilder builder) {
        this.mTitle = builder.mTitle;
        this.mContent = builder.mContent;
        this.mSmallIcon = builder.mSmallIcon;
        this.mWhen = builder.mWhen;
    }

    public NotifyBuilder createBuilder() {
        return new NotifyBuilder();
    }

    public void showNotify(Context context) {
        Toast.makeText(context, "Title " + mTitle +" \n Content: " + mContent,
                Toast.LENGTH_SHORT).show();
    }

    public static class NotifyBuilder {

        private String mTitle;
        private String mContent;
        private int mSmallIcon;
        private long mWhen;

        public NotifyBuilder() {

        }

        public NotifyBuilder setTitle(String title) {
            this.mTitle = title;
            return this;
        }

        public NotifyBuilder setContent(String content) {
            this.mContent = content;
            return this;
        }

        public NotifyBuilder setSmallIcon(int smallIcon) {
            this.mSmallIcon = smallIcon;
            return this;
        }

        public NotifyBuilder setWhen(long time) {
            this.mWhen = time;
            return this;
        }

        public Notify build() {
            return new Notify(this);
        }
    }
}

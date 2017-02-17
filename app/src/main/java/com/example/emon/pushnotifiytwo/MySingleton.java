package com.example.emon.pushnotifiytwo;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Emon on 2/16/2017.
 */
public class MySingleton {
    private static MySingleton mInstance;
    private static Context context;
    private RequestQueue requestQueue;

    private MySingleton(Context mcontext){
        context=mcontext;
        requestQueue = getRequestQueue();
    }
    private RequestQueue getRequestQueue(){
        if(requestQueue==null){
                requestQueue= Volley.newRequestQueue(context.getApplicationContext());
        }

        return requestQueue;
    }
    public static synchronized MySingleton getmInstance(Context context){
        if(mInstance==null){
            mInstance=new MySingleton(context);
        }
        return mInstance;
    }
    public<T> void addToRequestque(Request<T> request){
        getRequestQueue().add(request);
    }
}

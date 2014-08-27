package com.pmovil.toast;

public class NativeToastImpl {
    
    private android.widget.Toast t = null;
    
    public void showText(final String text, final int duration)
    {
        // TODO - parse duration
        final android.app.Activity app = (android.app.Activity)Toast.getContext();
        
        app.runOnUiThread(new Runnable() {
          public void run() {
            t = android.widget.Toast.makeText(app, text, duration);
            t.show();
          }
        });       
    }

    public boolean isShown() {
        if(t == null){
            return false;
        } else {
            return t.getView().isShown();
        }
    }
    
    public boolean isSupported() {
        return true;
    }
}

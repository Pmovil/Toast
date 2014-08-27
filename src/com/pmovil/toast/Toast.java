/*
 * Pmovil LTDA, all rights reserved
 */
package com.pmovil.toast;

import com.codename1.system.NativeLookup;

/**
 * Simple class to use native toast functionality
 *
 * @author Fabricio
 */
public class Toast {
    private static Object contextValue;
    private static NativeToast peer;
    private final String text;
    private final int duration;
    
    public static final int LENGTH_SHORT = 0;
    public static final int LENGTH_LONG = 1;
    
    private Toast(String text, int duration) {
        this.text = text;
        this.duration = duration;
    }
    
    public static Toast makeText(Object context, String text, int duration) throws RuntimeException {
        if (peer == null) {
            peer = (NativeToast)NativeLookup.create(NativeToast.class);
            if ( peer == null ) {
                throw new RuntimeException("Toast is not implemented yet in this platform.");
            }
            if ( !peer.isSupported() ){
                throw new RuntimeException("Toast is not supported in this platform.");
            }
        }
        contextValue = context;
        Toast toast = new Toast(text, duration);
        return toast;
    }
    
    protected static Object getContext() {
        return contextValue;
    }
    
    public boolean isShown(){
        return this.peer.isShown();
    }
    
    public void show() {
        peer.showText(text, duration);
    }
    
}

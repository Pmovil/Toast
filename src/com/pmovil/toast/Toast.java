/*
 * The MIT License
 *
 * Copyright 2014 Pmovil LTDA.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
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
        return peer.isShown();
    }
    
    public void show() {
        peer.showText(text, duration);
    }
    
}

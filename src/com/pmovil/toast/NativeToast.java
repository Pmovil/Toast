/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pmovil.toast;

import com.codename1.system.NativeInterface;

/**
 *
 * @author fabricio
 */
public interface NativeToast extends NativeInterface {
    public void showText(String text, int duration);
    public boolean isShown();
}

package com.pmovil.toast;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.component.Status;
import net.rim.device.api.ui.UiApplication;

public class NativeToastImpl {
    
	//this can not be implemented...
	public boolean isShown() {
        return false;
    }

    public void showText(final String param, final int param1) {
        /*
        public static void show(String message, Bitmap bitmap, int time, long style, boolean allowDismiss, boolean block, int priority)
        Shows a status screen of a particular style for specified time.
        Invoke this method to show a status screen of a particular style to the user.

        Parameters:
        message - Message to display.
        bitmap - Icon to show in the left part of this screen.
        time - Milliseconds for which this screen should remain visible.
        style - The style of the status screen
        allowDismiss - If true, allows the status screen to be dismissed early.
        block - Causes this method to block until the user dismisses this screen, or until the number of seconds specified in the time parameter passes. This parameter has no effect if the Status.GLOBAL_STATUS style is set.
        priority - Display priority for this screen, if it is a Status.GLOBAL_STATUS screen.
        Throws:
        RuntimeException - If no timer is available for use by this screen.
        */
        UiApplication.getApplication().invokeLater(new Runnable() {
            public void run() {
                Status.show(param, Bitmap.getPredefinedBitmap(Bitmap.INFORMATION), param1, 0, true, false, 0);
            }
        });
    }

    public boolean isSupported() {
        return true;
    }

}

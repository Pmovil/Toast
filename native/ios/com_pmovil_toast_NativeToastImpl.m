#import "com_pmovil_toast_NativeToastImpl.h"
#import "CodenameOne_GLViewController.h"
#import "UIView+Toast.h"

@implementation com_pmovil_toast_NativeToastImpl

// TODO
-(BOOL)isShown{
    return YES;
}

-(void)showText:(NSString*)param param1:(NSInteger)param1{
    dispatch_sync(dispatch_get_main_queue(), ^{
        NSTimeInterval d = 3.5; // long
        if (param1 == 0) { // short
            d = 2.0;
        }
        [[CodenameOne_GLViewController instance].view makeToast:param
                    duration:d
                    position:@"center"];
    });
}

-(BOOL)isSupported{
    return YES;
}

@end

#import "com_pmovil_toast_NativeToastImpl.h"
#import "iToast.h"

@implementation com_pmovil_toast_NativeToastImpl

// TODO
-(BOOL)isShown{
    return YES;
}

-(void)showText:(NSString*)param param1:(int)param1{
    NSInteger SHORT_DELAY = 2000; // 2 seconds
    NSInteger LONG_DELAY = 3500; // 3.5 seconds
    if (duration == 0) {
        duration = SHORT_DELAY;
    } else if (duration == 1) {
        duration = LONG_DELAY;
    }
    dispatch_sync(dispatch_get_main_queue(), ^{
        [[[[iToast makeText:param]setGravity:iToastGravityBottom]setDuration:param1]show];
    });
}

-(BOOL)isSupported{
    return YES;
}

@end

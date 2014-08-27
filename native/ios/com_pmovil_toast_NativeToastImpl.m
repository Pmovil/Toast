#import "com_pmovil_toast_NativeToastImpl.h"
#import "iToast.h"

@implementation com_pmovil_toast_NativeToastImpl

// TODO
-(BOOL)isShown{
    return YES;
}

-(void)showText:(NSString*)param param1:(int)param1{
    [[[[iToast makeText:param]setGravity:iToastGravityBottom]setDuration:param1]show];
}

-(BOOL)isSupported{
    return YES;
}

@end

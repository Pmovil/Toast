#import <Foundation/Foundation.h>

@interface com_pmovil_toast_NativeToastImpl : NSObject {
}

-(BOOL)isShown;
-(void)showText:(NSString*)param param1:(NSInteger)param1;
-(BOOL)isSupported;
@end

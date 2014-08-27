#import <Foundation/Foundation.h>

@interface com_pmovil_toast_NativeToastImpl : NSObject {
}

-(BOOL)isShown;
-(int)showText:(NSString*)text duration:(int)duration;
-(BOOL)isSupported;
@end

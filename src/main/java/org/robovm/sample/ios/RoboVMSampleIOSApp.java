package org.robovm.sample.ios;

import org.robovm.cocoatouch.coregraphics.CGRect;
import org.robovm.cocoatouch.foundation.NSAutoreleasePool;
import org.robovm.cocoatouch.foundation.NSDictionary;
import org.robovm.cocoatouch.uikit.*;

public class RoboVMSampleIOSApp extends UIApplicationDelegate.Adapter {

    private UIWindow window;
    private int clickCount;

    public static void main(String[] args) throws Exception {
        NSAutoreleasePool pool = new NSAutoreleasePool();
        UIApplication.main(args, null, RoboVMSampleIOSApp.class);
        pool.drain();
    }

    @Override
    public boolean didFinishLaunching(UIApplication application, NSDictionary launchOptions) {

        final UIButton button = UIButton.fromType(UIButtonType.RoundedRect);
        button.setFrame(new CGRect(115.0f, 121.0f, 91.0f, 37.0f));
        button.setTitle("Click me!", UIControlState.Normal);

        button.addOnTouchUpInsideListener(new UIControl.OnTouchUpInsideListener() {
            @Override
            public void onTouchUpInside(UIControl control, UIEvent event) {
                button.setTitle("Click #" + (++clickCount), UIControlState.Normal);
            }
        });

        window = new UIWindow(UIScreen.getMainScreen().getBounds());
        window.setBackgroundColor(UIColor.lightGrayColor());
        window.addSubview(button);
        window.makeKeyAndVisible();

        return true;
    }
}

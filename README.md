# AusAlert — Shake Detector (redesigned Android app)

This is a native Android Studio **source project**, not an APK. It has a redesigned dark dashboard, cracked-Earth launcher icon, test/stop controls, and the supplied alarm.m4a recording.

## Build
1. Extract the ZIP. Open the **AusAlertShakeDetector** inner folder in Android Studio (the folder with `settings.gradle`).
2. Wait for Gradle sync to finish. Keep the existing Android Gradle Plugin version rather than accepting optional upgrades.
3. Choose **Build > Build Bundle(s) / APK(s) > Build APK(s)**.
4. Locate `app/build/outputs/apk/debug/app-debug.apk`.

## Detection
Sensitivity 65/100 (initial 11 m/s² threshold), three alternating peaks in 1.5 seconds, 30-second cooldown and 2-second start settling. False positives are reduced, not eliminated. A foreground service requests motion events, but some Android devices do not supply them with the screen off. Test on real hardware.

## Important
This is an unofficial demonstration, not an emergency alert service and not an earthquake detector. The audio comes from the supplied user recording. This project has not been compiled or tested in this environment.

# AusAlert Shake Detector — GitHub APK build

Unofficial demonstration; not a government emergency alert app.

## Automatic APK build
Upload the contents of this ZIP (not the ZIP itself) to the ROOT of your GitHub repository. The root must contain `app/`, `build.gradle`, `settings.gradle`, and `.github/workflows/build-apk.yml`.

Open GitHub repository > Actions > Build AusAlert APK > Run workflow. After a successful run, open its run summary and download the `AusAlert-debug-APK` artifact. Extract the artifact ZIP to obtain `app-debug.apk`.

The workflow also runs when changes are pushed to main. This is an unsigned-for-release debug APK; it is intended for testing, not Play Store publishing.

The included Android source is the previously supplied redesigned version. The requested one-second countdown and audio-click fix are NOT yet implemented or validated. Shake detection while the screen is off is device-dependent and requires physical testing.

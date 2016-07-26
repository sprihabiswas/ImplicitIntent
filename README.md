# ImplicitIntent
Shows how you can create implicit intents to launch other apps that can perform an action (Part of the series - Mastering Android)

# Note :
* It's important that you define your Intent to be as specific as possible. For example, if you want to display an image using the ACTION_VIEW intent, you should specify a MIME type of image/*. This prevents apps that can "view" other types of data (like a map app) from being triggered by the intent.

* If you invoke an intent and there is no app available on the device that can handle the intent, your app will crash.

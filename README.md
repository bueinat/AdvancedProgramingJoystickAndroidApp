# Joystick Android Application
In this project we developed Android App which is used to control a plane in `FlightGear` ran in remote computer.

## Run the project
To use the simulation the user need to open the FlightGear program. You can downlaod and install it by following [this link](https://www.flightgear.org/).   
Go to setting page and enter in the `Additional Settings` add the line: `--telnet=socket,in,10,127.0.0.1,<your-port>,tcp`. It should look like this:  

<img src="https://user-images.githubusercontent.com/62245924/123317303-87e7d580-d536-11eb-8d97-c844df162d97.png" width="300">
After that the user need to press on the `Fly` button at the bottom and wait to the airplane to be ready to fly. In the tabs above the user can click on the `Cessna C172P` tab, and click on the `Autostart`. Congratulations! The airplane is ready to start flying.   
Now you can open the app, which should look like this:

<img src="https://user-images.githubusercontent.com/62245924/123325095-48be8200-d540-11eb-95a1-c364505196b9.png" width="200">
Enter the IP of the device that runs the simulator, enter port 5400 (or any other picked port) and click `CONNECT`. The app tries to connect for 5 seconds and then times out with an error message. If it happend, you can try again or maybe look over the ip and port you typed. After the connection was made it should say no error was found. Now you are controlling the simulator.
Note about that: you can only connect once. If you want to connect a different server, you have to close the app and then open it back. This had happened due to some technical issues we couldn't quite figure out.

### Controlling the Plane
You can control 4 parameters:
* Aileron - by moving the joystick right and left
* Elevator - by moving the joystick up and down
* Throttle - by moving the slider below the joystick
* Rudder - by moving the slider besides the joystick

This way you can fully control the plane and fly it.

## Project Composition
The project was written using `Android Studio` IDE. Android apps are built from some main parts:
1) **Activities:** they are like the screens you see when using an app. Each app could have more than one activity. Activities usually operate using *layout*.
2) **Layouts:** one of the most important components. Layouts are `xml` files which define the view. They have view components such as buttons, text fields, sliders, and many other components. Specifically when using MVVM, you can make databinding with some of those components to some view model "properties" (get and set methods). We did it in a few places in the program
3) **Others:** Other java (or kotlin) classes - could be regular code, or some expansions (of view components for example). Plus, you may add resources (layouts, drawables...). For more info about that you can read in [Android's Site](https://developer.android.com/).

### Our Project
This project was divided into a few main parts. You can talk saparately about code and about resources.
#### Resources
1) Layouts: we wrote one intro layout of the main activity which is less relevant. The important layout is the one of the Joystick. It is the one which is shown in the image above. each button, field or slider is binded to some property in the ViewModel (explained later). This is part of the MVVM pattern (which will be explained in the video).
2) Attributes: you can add attributes file which can be used to connect some properties between layout and other app components
3) Others: some files for convenience, such as colors and strings

#### Code
The code of this program was divided into 3 packages, according to the MVVM model:
1) Model: code which is about connecting the server and ending data. Some logic.
2) View: What the user sees and its helpers. Including the different activities (MainActivity.java and JoystickActivity.java) and custom components (VerticalSlideBar.java and Joystick.java).
3) ViewModel: includes the view model's code which controls the whole app. It tracks changes in the View (via data binding as explained) and reports the Model which comes into action. In case of apps where the Model also notifies the View, the view model also passes its messages. Includes only ConcretViewModel.java file.

#### Extra
In [Planning and Design](https://github.com/bueinat/AdvancedProgramingJoystickAndroidApp/tree/master/Planning%20and%20Design) directory, you can find:
1) The sliders which are showed in the clip
2) UML diagram of the main parts of out app
3) A filmed clip introducing our project
4) an APK which can be used to install the app directly to your device
We didn't add any other documentation because we think this README is informative enough.

### NOTE
As was said, Because of some technical issues, the case where your'e trying to re-connect the server after connection was made is not defined. Don't try to do that, instead you should probably try to close the app and re-open it.

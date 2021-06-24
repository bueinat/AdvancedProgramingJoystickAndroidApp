# Joystick Android Application
In this project we developed Android App which is used to control a plane in `FlightGear` ran in remote computer.


## Run the project
To use the simulation the user need to open the FlightGear program. You can downlaod and install it by following [this link](https://www.flightgear.org/).   
Go to setting page and enter in the `Additional Settings` add the line: `--telnet=socket,in,10,127.0.0.1,<your-port>,tcp`.   
![image](https://user-images.githubusercontent.com/62245924/123317303-87e7d580-d536-11eb-8d97-c844df162d97.png)   
After that the user need to press on the `Fly` button and wait to the airplane to be ready to fly. In the tabs above the user can click on the `Cessna C172P` tab, and click on the `Autostart`. Congratulations! The airplane is ready to start fling.   
In the app, the user need to enter the IP of the device that run the simulator, and the port of 5400 (or any other picked port) and click `CONNECT`. Now the user is controlling the simulator.

### Controlling the Plane
You can control 4 parameters:
* Aileron - by moving the joystick right and left
* Elevator - by moving the joystick up and down
* Throttle - by moving the slider below the joystick
* Rudder - by moving the slider besides the joystick

This way you can fully control the plane and fly it.

#include "MQTT.h"

// -----------------------------------------
// Pill Reminder Project - Liferay Of Things
// -----------------------------------------
// This project uses a Photoresistors & LED to detect when pills should to be taken. Main loop works using 3 states.

// State 0: It starts in the first state (0) by checking if a day has passed since a pill was taken,
// and if so, changes to the second state.

// State 1: The second state (1) blinks the LED and checks if the bottle is removed from the base,
// If so, the LED is turned on and waits for the bottle to be put back, and then changes to the third state.

// State 2: The third state (2) checks if the bottle is put back, and if so, turns off the LED,
// calculate the time passed since a pill was last taken, and save the new time.

const int ledPin = D0; // This is where your LED is plugged in. The other side goes to a resistor connected to GND.
const int photoresistorPin = A0; // This is where your photoresistor is plugged in. The other side goes to the "power" pin (below).
int powerPin = A5; // This is the other end of your photoresistor. The other side is plugged into the "photoresistor" pin (above).
// The reason we have plugged one side into an analog pin instead of to "power" is because we want a very steady voltage to be sent to the photoresistor.
// That way, when we read the value from the other side of the photoresistor, we can accurately calculate a voltage drop.

int state = 0;
const int photoresistorThreshold = 40;
const int takenIntervalInSeg = 60; // 86400 (1 Day)
unsigned long lastBlink = 0;
bool ledPinState = LOW;
unsigned long lastTaken = 0;

// Cloud variable
int analogvalue; // Here we are declaring the integer variable analogvalue, which we will use later to store the value of the photoresistor.

// MQTT Server info
/** MQTT Library Integration **/
void callback(char* topic, byte* payload, unsigned int length);
/**
 * if want to use IP address,
 * byte server[] = { XXX,XXX,XXX,XXX };
 * MQTT client(server, 1883, callback);
 * want to use domain name,
 * MQTT client("www.sample.com", 1883, callback);
 **/
byte server[] = { 192,168,0,100 };
MQTT client(server, 1883, callback);

void setup() {

    // First, declare all of our pins. This lets our device know which ones will be used for outputting voltage, and which ones will read incoming voltage.
    pinMode(ledPin,OUTPUT); // Our LED pin is output (lighting up the LED)
    pinMode(photoresistorPin,INPUT);  // Our photoresistor pin is input (reading the photoresistor)
    pinMode(powerPin,OUTPUT); // The pin powering the photoresistor is output (sending out consistent power)

    // Next, write the power of the photoresistor to be the maximum possible, so that we can use this for power.
    digitalWrite(powerPin,HIGH);

    // Configure timezone
    Time.zone(+2);

    // We are going to declare a Spark.variable() here so that we can access the value of the photoresistor from the cloud.
    Particle.variable("analogvalue", &analogvalue, INT);
    // This is saying that when we ask the cloud for "analogvalue", this will reference the variable analogvalue in this app, which is an integer variable.

    // MQTT setup
    // connect to the server
//    client.connect("photonclient");
}

void loop() {

    // Store value in the cloud.
    analogvalue = analogRead(photoresistorPin);

    if (client.isConnected()) {
      client.loop();
    } else {
      client.connect("photonclient");
    }

    switch(state)
    {
    case 0:
      if(Time.now() > lastTaken + takenIntervalInSeg)
      {
        state = 1;
        lastBlink = millis();
      }
      break;
    case 1:
      if(millis() - lastBlink > 150)
      {
        lastBlink = millis();
        ledPinState = !ledPinState;
        digitalWrite(ledPin, ledPinState);
      }
      if(analogRead(photoresistorPin) > photoresistorThreshold)
      {
        state = 2;
        digitalWrite(ledPin, HIGH);
        while(analogRead(photoresistorPin) > photoresistorThreshold) { }
      }
      break;
    case 2:
      if(analogRead(photoresistorPin) < photoresistorThreshold)
      {
        state = 0;
        digitalWrite(ledPin, LOW);
        lastTaken = Time.now();
        String eventTime = String(Time.day()) + "/" + String(Time.month()) + "/" + String(Time.year()) + " " + String(Time.hour()) + ":" + String(Time.minute()) + ":" + String(Time.second());
        char eventTimestamp[eventTime.length() + 1];
        eventTime.toCharArray(eventTimestamp, eventTime.length() + 1);

          // Send data to Liferay using Mosquitto Server.
        if (client.isConnected()) {
            client.publish("20182/pillreminder/sensors/lastTaken", (char *) eventTimestamp);
            //client.subscribe("/inTopic");
        }
      }
    }
}

// recieve message

void callback(char* topic, byte* payload, unsigned int length) {
/**
    char p[length + 1];
    memcpy(p, payload, length);
    p[length] = NULL;
    String message(p);

    if (message.equals("RED"))
        RGB.color(255, 0, 0);
    else if (message.equals("GREEN"))
        RGB.color(0, 255, 0);
    else if (message.equals("BLUE"))
        RGB.color(0, 0, 255);
    else
        RGB.color(255, 255, 255);
    delay(1000);
**/
}

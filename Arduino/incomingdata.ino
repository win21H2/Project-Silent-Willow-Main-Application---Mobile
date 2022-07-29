#include <SoftwareSerial.h>
#include <AccelStepper.h>
#include "SevSeg.h"
SevSeg sevseg;

SoftwareSerial Bluetooth(A5, 0);
//A5 0

int dataIn;

void setup() {
  Serial.begin(38400);
  Bluetooth.begin(9600);

  byte numDigits = 1;
    byte digitPins[] = {};
    byte segmentPins[] = {6, 5, 2, 3, 4, 7, 8, 9};
    bool resistorsOnSegments = true;

    byte hardwareConfig = COMMON_CATHODE;
    sevseg.begin(hardwareConfig, numDigits, digitPins, segmentPins, resistorsOnSegments);
    sevseg.setBrightness(90);
}

void loop() {
  if (Bluetooth.available() > 0) {
    dataIn = Bluetooth.read();
    if (dataIn == 0) {
      sevseg.setNumber(0);
      sevseg.refreshDisplay();
    }
    if (dataIn == 2) {
      sevseg.setNumber(2);
      sevseg.refreshDisplay();
    }
    if (dataIn == 1) {
      sevseg.setNumber(1);
      sevseg.refreshDisplay();
    }
    if (dataIn == 3) {
      sevseg.setNumber(3);
      sevseg.refreshDisplay();
    }
    if (dataIn == 4) {
      sevseg.setNumber(4);
      sevseg.refreshDisplay();
    }
    if (dataIn == 5) {
      sevseg.setNumber(5);
      sevseg.refreshDisplay();
    }
    if (dataIn == 6) {
      sevseg.setNumber(6);
      sevseg.refreshDisplay();
    }
  }
}
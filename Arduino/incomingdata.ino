#include <SoftwareSerial.h>
#include <AccelStepper.h>

SoftwareSerial Bluetooth(A5, 0);

int dataIn;

void setup() {
  Serial.begin(38400);
  Bluetooth.begin(9600);
}

void loop() {
  if (Bluetooth.available() > 0) {
    dataIn = Bluetooth.read();
    if (dataIn == 0) {Serial.println("STOP");}
    if (dataIn == 2) {Serial.println("FORWARDS");}
    if (dataIn == 7) {Serial.println("BACKWARDS");}
    if (dataIn == 4) {Serial.println("LEFT");}
    if (dataIn == 5) {Serial.println("RIGHT");}
    if (dataIn == 9) {Serial.println("ROTATELEFT");}
    if (dataIn == 10) {Serial.println("ROTATERIGHT");}
  }
}
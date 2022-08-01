const int latchPin = 12;
const int clockPin = 8;
const int dataPin = 11;
//display 0,1,2,3,4,5,6,7,8,9,A,b,C,d,E,F
//int datArray[16] = {252, 96, 218, 242, 102, 182, 190, 224, 254, 246, 238, 62, 156, 122, 158, 142};
int datArray[16] = {252, 96, 252, 96, 252, 96, 252, 96, 252, 96, 252, 96, 252, 96, 252, 96};

void setup (){
  pinMode(latchPin,OUTPUT);
  pinMode(clockPin,OUTPUT);
  pinMode(dataPin,OUTPUT);
}

void loop(){
  for(int num = 0; num < 16; num++){
    digitalWrite(latchPin,LOW);
    shiftOut(dataPin,clockPin,MSBFIRST,datArray[num]);
    digitalWrite(latchPin,HIGH);
    delay(500);
  }
}
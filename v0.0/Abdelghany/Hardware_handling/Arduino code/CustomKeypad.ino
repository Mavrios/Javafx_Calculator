#include <Keypad.h>

#define key1 49
#define key2 47
#define key3 53
#define key4 51

int flag = 0;

const byte ROWS = 4;
const byte COLS = 4;

char hexaKeys[ROWS][COLS] = {
  {'1', '2','3', '+'},
  {'4', '5','6', '-'},
  {'7', '8','9', '*'},
  {'=', '0','.', '/'}
};

byte rowPins[ROWS] = {9, 8, 7, 6};
byte colPins[COLS] = {5, 4, 3, 2};

Keypad customKeypad = Keypad(makeKeymap(hexaKeys), rowPins, colPins, ROWS, COLS);

void setup() {
  Serial.begin(9600);
  pinMode(key1, INPUT_PULLUP);
  pinMode(key2, INPUT_PULLUP);
  pinMode(key3, INPUT_PULLUP);
  pinMode(key4, INPUT_PULLUP);
}

void loop() {
  char customKey = customKeypad.getKey();
  int key1S = digitalRead(key1);
  int key2S = digitalRead(key2);
  int key3S = digitalRead(key3);
  int key4S = digitalRead(key4);

  if (customKey) {
    if (flag == 1) {
      switch (customKey) {
        case '2' : Serial.println("UP");
          break;
        case '4' : Serial.println("LEFT");
          break;
        case '6' : Serial.println("RIGHT");
          break;
        case '8' : Serial.println("DOWN");
          break;
      }
    } else {
      Serial.println(customKey);
    }

  }
  if (!key1S) {
    Serial.println("Menue");
    delay(400);
  }
  if (!key2S) {
    Serial.println("Arrows");
    flag ^= 1;
    delay(400);
  }
  if (!key3S) {
    Serial.println("History");
    delay(400);
  }
  if (!key4S) {
    Serial.println("Exit");
    delay(400);
  }
}

package io.silverspoon.bulldog.pi4jTest;

import com.pi4j.io.gpio.*;


public class TestBlink {

   public static void main(String[] args) throws InterruptedException {
      final GpioController gpio = GpioFactory.getInstance();
      final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08, "MyLED", PinState.HIGH);
      pin.setShutdownOptions(true, PinState.LOW);
      int i = 0;
      while (true) {
         if (i == 0) {
            pin.low();
            i = 1;
         } else {
            pin.high();
            i = 0;
         }
      }
   }
}

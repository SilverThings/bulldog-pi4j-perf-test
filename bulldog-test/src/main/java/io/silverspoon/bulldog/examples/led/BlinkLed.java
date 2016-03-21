package io.silverspoon.bulldog.examples.led;

import io.silverspoon.bulldog.core.gpio.DigitalOutput;
import io.silverspoon.bulldog.core.platform.Board;
import io.silverspoon.bulldog.core.platform.Platform;
import io.silverspoon.bulldog.raspberrypi.RaspiNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlinkLed {

   public static final Logger LOG = LoggerFactory.getLogger(BlinkLed.class);

   public static void main(String[] args) {
      Board board = Platform.createBoard();
      DigitalOutput out = board.getPin(RaspiNames.P1_3).as(DigitalOutput.class);
      LOG.info(out.getAppliedSignal().name());
      int i = 0;
      while (true) {
         if (i == 0) {
            out.high();
            i = 1;
         } else {
            out.low();
            i = 0;
         }
      }
   }
}

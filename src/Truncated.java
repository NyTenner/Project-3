/**
 * given a text block and a maximum width, builds a new block that truncates the input block to that width.
 * 
 * @author Nye Tenerelli, Medhashree Adhikari
 */

import java.io.PrintWriter;

public class Truncated {

  // TextBlock trun;
  // int max;
  // Truncated(TextBlock trun, int max)  {
  //   this.trun = trun;
  //   this.max = max;
  // }

  public static TextBlock shorten(TextBlock trun, int max) throws Exception {
    
    if (trun.width() < max || max < 0) {
      throw new Exception("ERROR, invalid spacing");
    } 

    boolean first = true;
    TextBlock temp = new TextLine("");


    for (int i = 0; i < trun.height(); i++) {


      if (trun.row(i).length() <= max) {
        if (first) {
          HComposition after= new HComposition(temp, new TextLine(trun.row(i)));
          temp = after;
          first = false;
        } else {
          VComposition below = new VComposition(temp, new TextLine(trun.row(i)));
          temp = below;
        }
      } else {
          if (first) {
            HComposition after= new HComposition(temp, new TextLine(trun.row(i).substring(0, max)));
            temp = after;
            first = false;
          } else {
            VComposition below = new VComposition(temp, new TextLine(trun.row(i).substring(0, max)));
            temp = below;
          }
      } // condition check
    } // for loop
    return temp;
  } // shorten
} // Truncated class

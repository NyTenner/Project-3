/**
 * rearrange the text blocks horizontally
 * @author Nye Tenerelli, Medhashree Adhikari
 */

public class VerticallyFlipped {
  public static TextBlock VFlip(TextBlock flip) throws Exception {
    boolean first = true;
    TextBlock temp = new TextLine("");
    for (int i = 0; i < flip.height(); i++) {  
      if (first) {
        HComposition _text = new HComposition(new TextLine(flip.row(i)), temp);
        temp = _text;          
        first = false;
      } else {
        VComposition _text = new VComposition(new TextLine(flip.row(i)), temp);
        temp = _text;
        first = false;
      }
    } // for loop
  return temp;
  }
}

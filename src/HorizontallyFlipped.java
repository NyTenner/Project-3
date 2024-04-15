/**
 * rearrange the text blocks horizontally
 * @author Nye Tenerelli, Medhashree Adhikari
 */


public class HorizontallyFlipped {
  public static TextBlock HFlipped(TextBlock flip) throws Exception {
    boolean first = true;
    TextBlock temp = new TextLine("");
    for (int i = 0; i < flip.height(); i++) {
        int lineLen = flip.width();
        TextBlock temp2 = new TextLine("");
        for (int j = 0; j < lineLen; j++) {
          HComposition front = new HComposition(new TextLine(flip.row(i).substring(j, j+1)), temp2);
          temp2 = front;
        } // add spaces before text

        if (first) {
          HComposition _text = new HComposition(temp, temp2);
          temp = _text;          
          first = false;
        } else {
          VComposition _text = new VComposition(temp, temp2);
          temp = _text;
          first = false;
        }
    } // for loop
    return temp;
  }
}

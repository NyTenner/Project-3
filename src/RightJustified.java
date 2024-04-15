/**
 * given a text block and a width, builds a new block that right-justifies the input block within that width.
 * @author Nye Tenerelli, Medhashree Adhikari
 */

public class RightJustified {
  public static TextBlock right(TextBlock text, int max) throws Exception {
    boolean first = true;
    TextBlock temp = new TextLine("");

    for (int i = 0; i < text.height(); i++) {
      if (text.row(i).length() <= max) {

        // compute number of spaces
        int numSpace = (max - text.row(i).length());
        // TBUtils.print(pen, center.contents);

        TextBlock spaces = new TextLine("");

        for (int j = 0; j < numSpace; j++) {
          HComposition front = new HComposition(new TextLine(" "), spaces);
          spaces = front;
        } // add spaces before text

        if (first) {
          HComposition _text = new HComposition(spaces, new TextLine(text.row(i)));
          temp = _text;          
          first = false;
        } else {
          VComposition _text = new VComposition(temp, new HComposition(spaces, new TextLine(text.row(i))));
          temp = _text;
          first = false;
        }
      } // end of condition check
    } // for loop

    return temp;
  }
}

/**
 * given a text block and a width, builds a new block that centers the block within that width
 * @author Nye Tenerelli, Medhashree Adhikari
 */
public class Centered {

  public static TextBlock middle(TextBlock center, int max) throws Exception {
    boolean first = true;
    TextBlock temp = new TextLine("");

    for (int i = 0; i < center.height(); i++) {
      if (center.row(i).length() <= max) {

        // compute number of spaces
        int numSpace = (max - center.row(i).length()) / 2;
        // TBUtils.print(pen, center.contents);

        TextBlock spaces = new TextLine("");

        for (int j = 0; j < numSpace; j++) {
          HComposition front = new HComposition(new TextLine(" "), spaces);
          spaces = front;
        } // add spaces before text

        if (first) {
          HComposition _text = new HComposition(spaces, new TextLine(center.row(i)));
          temp = _text;

          for (int j = 0; j < numSpace; j++) {
            HComposition end = new HComposition(temp, new TextLine(" "));
            temp = end;
          } // add spaces after
          
          first = false;
        } else {
          VComposition _text = new VComposition(temp, new HComposition(spaces, new TextLine(center.row(i))));
          temp = _text;

          // for (int j = 0; j < numSpace; j++) {
          //   HComposition end = new HComposition(temp, new TextLine(" "));
          //   temp = end;
          // } // add spaces after
          
          first = false;
        }
      } // end of condition check
    } // for loop

    if (center.width() > max) {
      System.err.println("ERROR, not enough space");
      System.exit(1);
    } // if there is not enough space, show err & exit
    // temp.classesSet(center.classesGet());
    // temp.classesadd(new TextLine("Centered"));

    return temp;
  }
}

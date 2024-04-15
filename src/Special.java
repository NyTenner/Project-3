/**
 * switches the edges of boxes from "-" to "|" and the same in reverse
 * @author Nye Tenerelli, Medhashree Adhikari
 */
public class Special {
  public static TextBlock _switch_ (TextBlock flip) throws Exception {
        boolean first = true;
        TextBlock temp = new TextLine("");
        for (int i = 0; i < flip.height(); i++) {
            int lineLen = flip.width();
            TextBlock temp2 = new TextLine("");
            for (int j = 0; j < lineLen; j++) {
                if (flip.row(i).substring(j, j+1).equals("-")){
                    HComposition front = new HComposition(new TextLine("|"), temp2);
                    temp2 = front;
                } else if (flip.row(i).substring(j, j+1).equals("|")){
                    HComposition front = new HComposition(new TextLine("-"), temp2);
                    temp2 = front;
                } else {
                    HComposition front = new HComposition(new TextLine(flip.row(i).substring(j, j+1)), temp2);
                    temp2 = front;
                }
            } // add spaces before text
    
            if (first) {
              HComposition _text = new HComposition(temp2, temp);
              temp = _text;          
              first = false;
            } else {
              VComposition _text = new VComposition(temp2, temp);
              temp = _text;
              first = false;
            }
        } // for loop
        
        return temp;
      }
  }

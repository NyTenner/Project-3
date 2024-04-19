import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @author Nye Tenerelli, Medhashree Adhikari
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    // Create a block to use
    TextBlock block1 = new TextLine("Hello");
  // Print out the block

    TextBlock block2 = new TextLine("Goodbye");
    TextBlock block3 = new TextLine("This is a test.");

    BoxedBlock box1 = new BoxedBlock(block1);
    BoxedBlock box2 = new BoxedBlock(block2);

    
    VComposition comp = new VComposition(block1, block2);
    BoxedBlock box3 = new BoxedBlock(comp);


    System.out.println("Test for block3, should output: \"Hello\"");
    TBUtils.print(pen, block3);
    System.out.println("Test for box1, should output: \"Hello\" boxed");
    TBUtils.print(pen, box1);
    System.out.println("Test for box1, should output: \"Hello  \" Boxed\n                              \"Goodbye\"");
    TBUtils.print(pen, box3);

    System.out.println("Truncated test for TextBox-box1 and max-(0, 1, and max length)");
    TextBlock thing;
    Truncated trun = new Truncated();
    thing = trun.shorten(box3, 0);
    TBUtils.print(pen, thing);
    thing = trun.shorten(box3, 1);
    TBUtils.print(pen, thing);
    thing = trun.shorten(box3, 9);
    TBUtils.print(pen, thing);

    System.out.println("Centered test for TextBox-box1 and max-(max length, 15)");
    Centered cen = new Centered();
    thing = cen.middle(box3, 9);
    TBUtils.print(pen, thing);
    thing = cen.middle(box3, 15);
    TBUtils.print(pen, thing);

    System.out.println("Right justified test for TextBox-box1 and max-(max length, 15)");
    RightJustified right = new RightJustified();
    thing = right.right(box3, 9);
    TBUtils.print(pen, thing);
    thing = right.right(box3, 15);
    TBUtils.print(pen, thing);

    System.out.println("HorizontallyFlipped works for nonempty blocks of two or more lines.");
    HorizontallyFlipped hor = new HorizontallyFlipped();
    thing = hor.HFlipped(box3);
    TBUtils.print(pen, thing);

    System.out.println("VerticallyFlipped works for nonempty blocks of two or more lines.");
    VerticallyFlipped vert = new VerticallyFlipped();
    thing = vert.VFlip(box3);
    TBUtils.print(pen, thing);

    System.out.println("HorizontallyFlipped and VerticallyFlipped works with empty blocks (new TextLine(\"\")).");
    hor = new HorizontallyFlipped();
    thing = hor.HFlipped(new TextLine(""));
    TBUtils.print(pen, thing);

    vert = new VerticallyFlipped();
    thing = vert.VFlip(new TextLine(""));
    TBUtils.print(pen, thing);
    
    // Clean up after ourselves.
    pen.close();
  } // main(String[])

} // class TBExpt

//this.contents.width()
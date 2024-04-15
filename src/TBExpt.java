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

    // TextBlock cent;
    // cent = Centered.middle(box3, 18);    
    // TBUtils.print(pen, cent);

    // TextBlock r;
    // r = RightJustified.right(block1, 18);    
    // TBUtils.print(pen, r);

    // TextBlock r;
    // r = HorizontallyFlipped.HFlip(box3);    
    // TBUtils.print(pen, r);

    // TextBlock r;
    // r = VerticallyFlipped.VFlip(box3);    
    // TBUtils.print(pen, r);

    // TextBlock r;
    // r = FlipBoth._switch_(box3);    
    // TBUtils.print(pen, r);


    // HComposition funk1 = new HComposition(box1, block2);
    // HComposition funk2 = new HComposition(block2, box1);
    // TBUtils.print(pen, funk1);
    // TBUtils.print(pen, funk2);


    // TextBlock tb1 =  HorizontallyFlipped.HFlipped( HorizontallyFlipped.HFlipped( HorizontallyFlipped.HFlipped( HorizontallyFlipped.HFlipped(new TextLine("a")))));
    // TextBlock tb2 =  HorizontallyFlipped.HFlipped( HorizontallyFlipped.HFlipped(new TextLine("a")));
    // TextBlock tb3 =  HorizontallyFlipped.HFlipped( HorizontallyFlipped.HFlipped( HorizontallyFlipped.HFlipped( HorizontallyFlipped.HFlipped(new TextLine("a")))));

    //System.out.println(TBUtils.eq(tb1, tb3));
    // System.out.println(TBUtils.eqv(tb1, tb2));
      // TextBlock tb3 = new TextLine("a");
      // TextBlock tb4 = new HFlip(new HFlip(new HFlip(new HFlip(new TextLine("a")))));
    

    // Clean up after ourselves.
    pen.close();
  } // main(String[])

} // class TBExpt

//this.contents.width()
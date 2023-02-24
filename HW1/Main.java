package HW1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start of Main");
        // Create an instance of the Pyramid class and call the Output method (see Pyramid.java for more info)
        Pyramid.Output();
    
        // Create an instance of the Adlibs class and call the story method (see Adlibs.java for more info)
        String story = Adlibs.story("Lindsey", 21, "Blue");
        System.out.println(story);
        // Create an instance of the Replace class and call the charReplace method (see Replace.java for more info)
        String replace = Replace.charReplace("I MAKE BREAD", 2, 'T');
        System.out.println(replace);
    }

}

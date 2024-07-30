public class WordDocument_Factory extends DocumentFactory  {
    public document createDocument(){
        System.out.println("word documnet object created inside WordDocument_Factory class\tthe class extended abstract class");
        return new WordDocument();
    }
}

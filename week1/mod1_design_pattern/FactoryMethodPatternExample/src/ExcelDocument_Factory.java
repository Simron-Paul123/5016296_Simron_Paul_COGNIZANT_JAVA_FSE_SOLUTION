public class ExcelDocument_Factory extends DocumentFactory  {
    public document createDocument(){
        System.out.println("word documnet object created inside ExcelDocument_Factory class\t\tthe class extended abstract class");
        return new ExcelDocument();
    }
}

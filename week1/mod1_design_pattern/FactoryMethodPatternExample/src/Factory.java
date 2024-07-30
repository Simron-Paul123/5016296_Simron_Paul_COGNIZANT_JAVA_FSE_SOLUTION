// for factory method which the client choose that type of object created
public class Factory {
    /*
     *  public static document factory_method(DocumentFactory df){
     * return df.createDocument();
     * }
     * // in main
     * document d_1=Factory.factory_method(new PdfDocument_Factory());
     * d_1.open_doc();
     * document d_2=Factory.factory_method(new ExcelDocument_Factory());
     * d_2.open_doc();
     * document d_3=Factory.factory_method(new WordDocument_Factory());
     * d_3.open_doc();
     */
    public static DocumentFactory factory_method(String s){
        if(s.trim().equals("WordDocument"))
            return new WordDocument_Factory();
        else if(s.trim().equals("PdfDocument"))
            return new PdfDocument_Factory();
        else if(s.trim().equals("ExcelDocument"))
            return new ExcelDocument_Factory();
        else
            return null;
    }
}

import java.util.*;
public class Find_Books {
    private Book[] books;
    Find_Books(Book[] books) {
        this.books = books;
    }
    public Book linear_search(String title){
        for(Book book: books ){
            if(title.equalsIgnoreCase(book.getTitle())){
                return book;
            }
        }
        return null;
    }
    public Book Binary_search(String title){
        Arrays.sort(books);
        int left=0;
        int right=(books.length -1);
        while(left<=right){
            int mid=left+(right-left)/2;
            if(title.compareTo(books[mid].getTitle())==0){
                return books[mid];
            }
            else if(title.compareTo(books[mid].getTitle())<0){//2,4
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return null;
    }
}

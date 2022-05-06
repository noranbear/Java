package vo;

/**
 * Book 정보를 담는 객체 설계
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 27. 오후 1:14:50
 * @version 1.0
 */
public class BookVo {

	private int id;
	private String title;
	private String author;
	private String isbn;
	private int status;		// 1이면 있다, 0이면 없다.
	
	// Constructors
	public BookVo() {
	}
	
	public BookVo(String title, String author, String isbn) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.status = 1;
	}

	public BookVo(int id, String title, String author, String isbn) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.status = 1;
	}

	public BookVo(int id, String title, String author, String isbn, int status) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.status = status;
	}


	// Getters and Setters
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	// toString()
	@Override
	public String toString() {
		return "BookVo [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", status=" + status
				+ "]";
	}
	
	
	
	
	
	
	
}

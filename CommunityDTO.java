package project;

public class CommunityDTO {
	
	private String writer;
	private int writeNumber;
	private String Contents;
	private int writeHits = 0;

	
	
	CommunityDTO(){
		
	}



	CommunityDTO(String writer, int writeNumber, String contents) {
		super();
		this.writer = writer;
		this.writeNumber = writeNumber;
		Contents = contents;
		this.writeHits = writeHits;
	}



	public String getWriter() {
		return writer;
	}



	public void setWriter(String writer) {
		this.writer = writer;
	}



	public int getWriteNumber() {
		return writeNumber;
	}



	public void setWriteNumber(int writeNumber) {
		this.writeNumber = writeNumber;
	}



	public String getContents() {
		return Contents;
	}



	public void setContents(String contents) {
		Contents = contents;
	}



	public int getWriteHits() {
		return writeHits;
	}



	public void setWriteHits(int writeHits) {
		this.writeHits = writeHits;
	}



	@Override
	public String toString() {
		return "CommunityDTO [writer=" + writer + ", writeNumber=" + writeNumber + ", Contents=" + Contents
				+ ", writeHits=" + writeHits + "]";
	}
	
	
	

	
	
	
	
	

}

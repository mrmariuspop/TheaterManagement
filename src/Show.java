import java.util.Date;

public class Show {
	public String title;
	public String genre;
	public String distribution;
	public Date date;
	public int noTickets;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDistribution() {
		return distribution;
	}
	public void setDistribution(String distribution) {
		this.distribution = distribution;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getNoTickets() {
		return noTickets;
	}
	public void setNoTickets(int noTickets) {
		this.noTickets = noTickets;
	}
}

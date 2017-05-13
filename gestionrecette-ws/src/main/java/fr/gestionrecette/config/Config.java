/**
 * 
 */
package fr.gestionrecette.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author knc
 *
 */ 
public class Config {
	
	@Value("${picture.location}")
	String pictureLocation ;
	@Value("${picture.location.web}")
	String pictureLocationWeb ;
	
	public String getPictureLocation() {
		return pictureLocation;
	}
	public void setPictureLocation(String pictureLocation) {
		this.pictureLocation = pictureLocation;
	}
	public String getPictureLocationWeb() {
		return pictureLocationWeb;
	}
	public void setPictureLocationWeb(String pictureLocationWeb) {
		this.pictureLocationWeb = pictureLocationWeb;
	}
}

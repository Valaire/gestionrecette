/**
 * 
 */
package com.angata.core.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import javax.mail.Transport;
import javax.mail.Authenticator;

import javax.mail.internet.AddressException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.MessagingException;

/**
 * @author knc
 *
 */
public class AngataUtils {

	static final Logger log = LogManager.getLogger(AngataUtils.class.getName());
	static String from ="contact@byster.com";
	static String to;
	static String newpassword;
	static String username = "angatamobile@gmail.com";
	static String password = "angatamobile2016";

	/**
	 * envoie du mail
	 * @param from 
	 * @param to 
	 * @param username 
	 * @param password 
	 * @return
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	public static void sendMailSMTP(String to) {


		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		
		props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		
		
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject("Activation du compte Angata");
			message.setText("Bonjour,"
					+ "\n\n Vous venez de creer votre compte sur Angata."
					+ "\n\n Cordialement");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * envoie du mail
	 * @param from 
	 * @param to 
	 * @param username 
	 * @param password 
	 * @param newpassword
	 * @return
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	public static void sendMailSMTPForgetPsw(String to, String newpassword) {


		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject("Mot depasse oublié");
			message.setText("Bonjour,"
					+ "\n\n Vous venez de recevoir un nouveau mot de passe "+newpassword+"."
					+ "Veuillez vous connecter à Angata avec se nouveau mot de passe puis vous pouvez le changer depuis votre profil après connection sur l'apk"
					+ "\n\n Cordialement");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String hashPassword(String password){
		byte[] hash = null;
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			hash = md.digest(password.getBytes());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < hash.length; ++i) {
			String hex = Integer.toHexString(hash[i]);
			if (hex.length() == 1) {
				sb.append(0);
				sb.append(hex.charAt(hex.length() - 1));
			} else {
				sb.append(hex.substring(hex.length() - 2));
			}
		}
		return sb.toString();
	}

	/**
	 * genere une chaine aléatoire d'une taille donnée
	 * @param taille
	 * @return
	 */
	public static String generate(int taille){
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder str = new StringBuilder(taille);
		for(int i=0;i<taille;i++)
		{
			int k = (int)Math.floor(Math.random() * chars.length());
			str.append(chars.charAt(k));
		}
		return str.toString().toUpperCase();
	}
}

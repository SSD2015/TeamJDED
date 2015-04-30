package controllers;

import com.sun.jna.platform.win32.Netapi32Util.User;

public class Authenticator {
	public static Authenticator getInstance() {
		//TODO make this a singleton
		return new DatabaseAuthenticator();
	}

	/** authenticate user */
	public abstract User authenticate(String username, String password);
}

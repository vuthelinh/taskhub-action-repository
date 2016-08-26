package com.synergix.utilities;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SMTPAuthenticator extends Authenticator
{
    public PasswordAuthentication authentication;

    public SMTPAuthenticator(String login, String password)
    {
        authentication = new PasswordAuthentication(login, password);
    }

    @Override
    public PasswordAuthentication getPasswordAuthentication()
    {
        return authentication;
    }
}

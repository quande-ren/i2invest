package com.i2invest.restful;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.i2invest.domain.FacadeService;

public class TestUtil {
	public 	static final String email = "quande.ren@gmail.com";
	public 	static final String password="Yanmei123";
	public 	static final String oldPassword=password;
	public 	static final String newPassword="Yanmei124";


	public static FacadeService getFacadeService() throws NamingException {
		final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL,"remote+http://localhost:8080");
        final Context context = new InitialContext(jndiProperties);

        FacadeService  facadeService = (FacadeService) context.lookup("ejb:i2invest_ear/com.i2invest-ejb-0.0.1/FacadeEjb!com.i2invest.domain.FacadeService");
		return facadeService;
	}
}

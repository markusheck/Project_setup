package com.cometsoftware.pft;

import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.apache.wicket.util.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.cometsoftware.pft.base.MyAuthenticatedWebSession;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see com.cometsoftware.Start#main(String[])
 */
@Component(value = "wicketApplication")
public class WicketApplication extends AuthenticatedWebApplication {

	@Autowired
	private ApplicationContext applicationContext;

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<HomePage> getHomePage() {
		return HomePage.class;
	}

	@Override
	protected void init() {
		super.init();
		
		getResourceSettings().setResourcePollFrequency(Duration.ONE_SECOND);
		getMarkupSettings().setStripWicketTags(true);
		
		getComponentInstantiationListeners().add(new SpringComponentInjector(this, applicationContext, true));
	   
	}
	

	
	@Override
	protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
		return MyAuthenticatedWebSession.class;
	}

	@Override
	protected Class<? extends WebPage> getSignInPageClass() {
		return LoginPage.class;
	}
}

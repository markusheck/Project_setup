package com.cometsoftware.pft;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;

@AuthorizeInstantiation({"ROLE_USER","ROLE_ADMIN"})
public class HomePage extends WebPage {

}

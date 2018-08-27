package ru.javabegin.training.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ru.javabegin.training.impls.FilteredListDetailsStatusesDaoSqlite;
import ru.javabegin.training.impls.UserDaoSqlite;
import ru.javabegin.training.objects.User;
import ru.javabegin.training.objects.softList.FilteredListDetailsStatuses;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserDaoSqlite sqlite;

	@Autowired
	private FilteredListDetailsStatusesDaoSqlite fldssSql;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView main(HttpSession session) {
		return new ModelAndView("login", "user", new User());
	}

	@RequestMapping(value = "/home", method = {  RequestMethod.POST})
	public ModelAndView checkUser(HttpSession session, @ModelAttribute User user) {

		User dbUser = sqlite.checkUserPassword(user);
		if (dbUser!=null) {
			session.setAttribute("user",dbUser);

			FilteredListDetailsStatuses fldss = new FilteredListDetailsStatuses(fldssSql);
			session.setAttribute("fldss",fldss);

			return new ModelAndView("main", "userName", user);
		}else {
			user.setStatus("Bad user name or password. Login again");
			return new ModelAndView("login", "user", user);
		}
	}


	@RequestMapping(value = "/home", method = { RequestMethod.GET})
	public ModelAndView home(HttpSession session) {
		User user = ((User) session.getAttribute("user")  );
		return new ModelAndView("main", "userName", user);
	}



	@RequestMapping(value = "/reg-user", method = RequestMethod.GET)
	public ModelAndView regUserForm(HttpSession session) {
		return new ModelAndView("reg-user", "reg-user", new User());
	}

	@RequestMapping(value = "/reg-user-add", method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView regUserAdd(@ModelAttribute User user) {
        boolean r = this.sqlite.checkUserNameExist(user);
		if (r) return new ModelAndView("reg-user-exist");
		else {
			this.sqlite.insert(user);
			return new ModelAndView("main", "userName", user);
		}
	}


	@RequestMapping(value = "/sign-out", method = RequestMethod.GET)
	public ModelAndView userSignOut(HttpSession session, User user) {
		session=null;
		user.setIduser(0);
		user.setUserName("");
		user.setPassword("");

		user.setStatus("Sign out. Login again");
		return new ModelAndView("login", "user", user);

	}


}

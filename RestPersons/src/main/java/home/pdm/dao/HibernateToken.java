package home.pdm.dao;

import java.util.Date;

import home.pdm.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("tokenRepositoryDao")
@Transactional
public class HibernateToken extends CrudDao<String, User>
        implements PersistentTokenRepository {

    static final Logger logger = LoggerFactory.getLogger(HibernateToken.class);

    public void createNewToken(PersistentRememberMeToken token) {
        logger.info("Creating Token for user : {}", token.getUsername());
        User login = new User();
        login.setUserName(token.getUsername());
        persist(login);
    }

    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        logger.info("Fetch Token if any for seriesId : {}", seriesId);
        try {
            Criteria crit = createEntityCriteria();
            crit.add(Restrictions.eq("series", seriesId));
            User userLogin = (User) crit.uniqueResult();

            return new PersistentRememberMeToken(userLogin.getUserName(), null, null, null);
        } catch (Exception e) {
            logger.info("Token not found...");
            return null;
        }
    }

    public void removeUserTokens(String username) {
        logger.info("Removing Token if any for user : {}", username);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("username", username));
        User userLogin = (User) crit.uniqueResult();
        if (userLogin != null) {
            logger.info("rememberMe was selected");
            delete(userLogin);
        }

    }

    public void updateToken(String userName, String tokenValue, Date lastUsed) {
        logger.info("Updating Token for userName : {}", userName);
        User userLogin = getByKey(userName);
        update(userLogin);
    }
}

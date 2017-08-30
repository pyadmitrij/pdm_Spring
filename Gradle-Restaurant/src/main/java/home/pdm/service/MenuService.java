package home.pdm.service;

import home.pdm.dao.MenuDAO;
import home.pdm.model.Menu;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class MenuService {

    private MenuDAO menuDAO;

    public void setMenuDAO(MenuDAO menuDAO) {
        this.menuDAO = menuDAO;
    }

    @Transactional
    public void saveMenu(Menu menu) {
        menuDAO.save(menu);
    }

    @Transactional
    public List<Menu> getMenu() {
        return menuDAO.findAll();
    }

    @Transactional
    public void updateMenu(Menu menu) {
        menuDAO.update(menu);
    }

    @Transactional
    public void removeMenu(Menu menu) {
        menuDAO.remove(menu);
    }

    @Transactional
    public Menu getMenuById(int menuId) {
        return menuDAO.findById(menuId);
    }

    @Transactional
    public Menu getMenuByName(String menuName) {
        return menuDAO.findByName(menuName);
    }
}

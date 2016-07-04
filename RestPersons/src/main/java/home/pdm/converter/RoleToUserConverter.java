package home.pdm.converter;

import home.pdm.model.Role;
import home.pdm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RoleToUserConverter implements Converter<Object, Role> {

    static final Logger logger = LoggerFactory.getLogger(RoleToUserConverter.class);

    @Autowired
    IRoleService roleService;

    public Role convert(Object element) {
        Integer id = Integer.parseInt((String) element);
        Role role = roleService.getRole(id);
        System.out.println("Role : " + role);
        logger.info("Role : {}", role);
        return role;
    }
}

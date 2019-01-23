package swengs.fooddb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swengs.fooddb.model.Ingredient;
import swengs.fooddb.model.IngredientRepository;
import swengs.fooddb.model.UserRepository;

import javax.annotation.PostConstruct;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")   // It has to be annotated with @Service.
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            swengs.fooddb.model.User user = userRepository.findByUsername(username);
            if (user.getUsername().equals(username)) {

                // Remember that Spring needs roles to be in this format: "ROLE_" + userRole (i.e. "ROLE_ADMIN")
                // So, we need to set it to that format, so we can verify and compare roles (i.e. hasRole("ADMIN")).
                List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                        .commaSeparatedStringToAuthorityList(user.isAdmin() ? "ROLE_ADMIN" : "ROLE_USER");

                // The "User" class is provided by Spring and represents a model class for user to be returned by UserDetailsService
                // And used by auth manager to verify and check user authentication.
                return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
            }
        } catch (Exception e) {
        }
        // If user not found. Throw this exception.
        throw new UsernameNotFoundException("Username: " + username + " not found");
    }

    @PostConstruct()
    @Transactional
    public void initUsers() {
        if (userRepository.count() == 0) {
            swengs.fooddb.model.User admin = new swengs.fooddb.model.User();
            admin.setUsername("admin");
            admin.setPassword(encoder.encode("12345"));
            admin.setAdmin(true);
            userRepository.save(admin);

            swengs.fooddb.model.User tester = new swengs.fooddb.model.User();
            tester.setUsername("tester");
            tester.setPassword(encoder.encode("12345"));
            userRepository.save(tester);
        }
        if(ingredientRepository.count() == 0){
            String[] zutatenNamenListe = {"Ei","Tomate","Karotte","Salat","Milch"}; //diese Liste erweitern um merh Zutaten zu haben
            for(String zutat: zutatenNamenListe){
                Ingredient ing = new Ingredient();
                ing.setIngredientName(zutat);
                ingredientRepository.save(ing);
            }

        }
    }

}
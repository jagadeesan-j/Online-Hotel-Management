package com.hotel.staffmanagement.security;

import com.hotel.staffmanagement.entity.JwtRequest;
import com.hotel.staffmanagement.entity.JwtResponse;
import com.hotel.staffmanagement.entity.Staff;
import com.hotel.staffmanagement.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class JwtService implements UserDetailsService {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String username = jwtRequest.getUsername();
        String password = jwtRequest.getPassword();
        authenticate(username, password);

        final UserDetails userDetails = loadUserByUsername(username);

        String generatedJwtToken = jwtUtil.generateJwtToken(userDetails);

        Staff staff = staffRepository.findByEmployeeCode(username);

        return new JwtResponse(staff, generatedJwtToken);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (BadCredentialsException exception) {
            throw new Exception("Bad credentials!");
        }
//        catch (DisabledException exception) {
//            throw new Exception("User is disabled");
//        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Staff staff = staffRepository.findByEmployeeCode(username);

        if (staff != null) {
            return new User(staff.getEmployeeCode(), staff.getPassword(), getAuthorities(staff));
        } else {
            throw new UsernameNotFoundException("Username is not found!");
        }
    }

//    private SimpleGrantedAuthority getAuthorities(Staff staff) {
//        String role = staff.getRole();
//        return new SimpleGrantedAuthority("ROLE_"+role.toUpperCase());
//    }

    public Collection<? extends GrantedAuthority> getAuthorities(Staff staff) {

        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+staff.getRole().toUpperCase()));

        return grantedAuthorities;
    }
}

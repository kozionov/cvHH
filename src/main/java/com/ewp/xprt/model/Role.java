package com.ewp.xprt.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * Роль (user, admin, mentor и тд)
 */
@Entity
@Table(name = "role")
@NoArgsConstructor @ToString @AllArgsConstructor @RequiredArgsConstructor
public class Role implements GrantedAuthority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	@Getter @Setter
	private Long id;

	@Getter @Setter @NonNull
	@Column(name = "role_name", unique = true, nullable = false)
	private String roleName;

	@Override
	public String getAuthority() {
		return roleName;
	}

}

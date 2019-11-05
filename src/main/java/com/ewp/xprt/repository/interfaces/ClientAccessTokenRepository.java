package com.ewp.xprt.repository.interfaces;

import com.ewp.xprt.model.ClientAccessToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientAccessTokenRepository extends JpaRepository<ClientAccessToken, Long> {
}

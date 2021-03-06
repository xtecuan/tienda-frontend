/*
 * Copyright (c) 2019 xtecuan.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    xtecuan - initial API and implementation and/or initial documentation
 */
package com.livejournal.xtecuan.microprofile.web.beans.utils;


import com.xtesoft.tienda.clientes.dto.ClienteDTO;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author xtecuan
 */
@Named
@SessionScoped
public class UserSessionBean implements Serializable {

    private ClienteDTO user;

    private String passwordChange;

    public ClienteDTO getUser() {
        return user;
    }

    public void setUser(ClienteDTO user) {
        this.user = user;
    }

    public String getPasswordChange() {
        return passwordChange;
    }

    public void setPasswordChange(String passwordChange) {
        this.passwordChange = passwordChange;
    }

}

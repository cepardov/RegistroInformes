/*
 * Copyright (C) 2015 cepardov
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package system.utils;

/**
 * @author cepardov <cepardov@gmail.com>
 */
public class Modnames {
    String NombreAplicacion="NeoMarket";
    String ModuloBase="Escritorio";
    String ModuloLogin="Inicio de sesión";
    String InicioSesion="Usuario: ";

    public String getInicioSesion() {    
        return InicioSesion;
    }

    public void setInicioSesion(String InicioSesion) {
        this.InicioSesion = InicioSesion;
    }

    public String getNombreAplicacion() {
        return NombreAplicacion;
    }

    public void setNombreAplicacion(String NombreAplicacion) {
        this.NombreAplicacion = NombreAplicacion;
    }

    public String getModuloBase() {
        return ModuloBase;
    }

    public void setModuloBase(String ModuloBase) {
        this.ModuloBase = ModuloBase;
    }

    public String getModuloLogin() {
        return ModuloLogin;
    }

    public void setModuloLogin(String ModuloLogin) {
        this.ModuloLogin = ModuloLogin;
    }
    
}

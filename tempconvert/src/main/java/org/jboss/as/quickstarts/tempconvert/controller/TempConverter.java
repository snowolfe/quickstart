/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and/or its affiliates,
 * and individual contributors as indicated by the @author tags.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 *
 * (C) 2011,
 * @author JBoss, by Red Hat.
 */

package org.jboss.as.quickstarts.tempconvert.controller;

import org.jboss.as.quickstarts.tempconvert.ejb.TempConvertEJB;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * A simple managed bean that is used to invoke the TempConvertEJB and store the response. The response is obtained by
 * invoking getTemperature().
 *
 * Code borrowed and modified from another quickstart written by paul robinson
 * 
 * @author bwolfe@redhat.com
 */
@Named("tempConvert")
@SessionScoped
public class TempConverter implements Serializable {

	/**
	 * Injected TempConvertEJB client
	 */
	@EJB
	private TempConvertEJB tempConvertEJB;

	/**
	 * Stores the response from the call to tempConvertEJB.convert(...)
	 */
	private String temperature;

	/**
	 * Invoke tempConvertEJB.convert(tempFrom) and store the temperature
     *
     * @param tempFrom The temperature to be converted
	 */
	public void setTempFrom(String tempFrom) {
		temperature = tempConvertEJB.convert(tempFrom);
	}

    /**
     * Get the converted temperature or simple Error string.
     *
     * @return temperature  The converted temperature or Zero Kelvin for an Input Error :-).
     */
	public String getTemperature() {
		return temperature;
	}

}
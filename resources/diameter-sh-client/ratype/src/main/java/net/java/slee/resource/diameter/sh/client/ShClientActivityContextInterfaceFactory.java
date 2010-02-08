/*
 * Copyright (C) 2006 Open Cloud Ltd.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of version 2.1 of the GNU Lesser 
 * General Public License as published by the Free Software Foundation.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, 
 * MA  02110-1301  USA, or see the FSF site: http://www.fsf.org.
 */
package net.java.slee.resource.diameter.sh.client;

import javax.slee.ActivityContextInterface;
import javax.slee.UnrecognizedActivityException;

/**
 * Obtains an ActivityContextInterface for a given Sh activity
 *
 * @author Open Cloud
 */
public interface ShClientActivityContextInterfaceFactory {

  /**
   * 
   * @param activity
   * @return
   * @throws UnrecognizedActivityException
   */
  ActivityContextInterface getActivityContextInterface(ShClientActivity activity) throws UnrecognizedActivityException;

  /**
   * 
   * @param activity
   * @return
   * @throws UnrecognizedActivityException
   */
  ActivityContextInterface getActivityContextInterface(ShClientSubscriptionActivity activity) throws UnrecognizedActivityException;

}

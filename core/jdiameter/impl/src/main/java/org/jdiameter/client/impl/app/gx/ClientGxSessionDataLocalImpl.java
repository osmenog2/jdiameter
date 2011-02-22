/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat, Inc. and/or its affiliates, and individual
 * contributors as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a full listing
 * of individual contributors.
 * 
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU General Public License, v. 2.0.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License,
 * v. 2.0 along with this distribution; if not, write to the Free 
 * Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 */
package org.jdiameter.client.impl.app.gx;

import java.io.Serializable;

import org.jdiameter.api.Request;
import org.jdiameter.common.api.app.AppSessionDataLocalImpl;
import org.jdiameter.common.api.app.gx.ClientGxSessionState;

/**
 *
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public class ClientGxSessionDataLocalImpl extends AppSessionDataLocalImpl implements IClientGxSessionData {

  protected boolean isEventBased = true;
  protected boolean requestTypeSet = false;
  protected ClientGxSessionState state = ClientGxSessionState.IDLE;
  protected Serializable txTimerId;
  //protected JCreditControlRequest txTimerRequest;
  protected Request txTimerRequest;

  // Event Based Buffer
  //protected Message buffer = null;
  protected Request buffer;

  protected int gatheredRequestedAction = ClientGxSessionImpl.NON_INITIALIZED;

  protected int gatheredCCFH = ClientGxSessionImpl.NON_INITIALIZED;
  protected int gatheredDDFH = ClientGxSessionImpl.NON_INITIALIZED;

  /**
   * 
   */
  public ClientGxSessionDataLocalImpl() {
  }

  public boolean isEventBased() {
    return isEventBased;
  }

  public void setEventBased(boolean isEventBased) {
    this.isEventBased = isEventBased;
  }

  public boolean isRequestTypeSet() {
    return requestTypeSet;
  }

  public void setRequestTypeSet(boolean requestTypeSet) {
    this.requestTypeSet = requestTypeSet;
  }

  public ClientGxSessionState getClientGxSessionState() {
    return state;
  }

  public void setClientGxSessionState(ClientGxSessionState state) {
    this.state = state;
  }

  public Serializable getTxTimerId() {
    return txTimerId;
  }

  public void setTxTimerId(Serializable txTimerId) {
    this.txTimerId = txTimerId;
  }

  public Request getTxTimerRequest() {
    return txTimerRequest;
  }

  public void setTxTimerRequest(Request txTimerRequest) {
    this.txTimerRequest = txTimerRequest;
  }

  public Request getBuffer() {
    return buffer;
  }

  public void setBuffer(Request buffer) {
    this.buffer = buffer;
  }

  public int getGatheredRequestedAction() {
    return gatheredRequestedAction;
  }

  public void setGatheredRequestedAction(int gatheredRequestedAction) {
    this.gatheredRequestedAction = gatheredRequestedAction;
  }

  public int getGatheredCCFH() {
    return gatheredCCFH;
  }

  public void setGatheredCCFH(int gatheredCCFH) {
    this.gatheredCCFH = gatheredCCFH;
  }

  public int getGatheredDDFH() {
    return gatheredDDFH;
  }

  public void setGatheredDDFH(int gatheredDDFH) {
    this.gatheredDDFH = gatheredDDFH;
  }

}

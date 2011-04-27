/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.mobicents.diameter.impl.ha.server.acc;

import java.io.Serializable;

import org.jboss.cache.Fqn;
import org.jdiameter.api.acc.ServerAccSession;
import org.jdiameter.common.api.app.acc.ServerAccSessionState;
import org.jdiameter.server.impl.app.acc.IServerAccSessionData;
import org.mobicents.cluster.MobicentsCluster;
import org.mobicents.diameter.impl.ha.common.AppSessionDataReplicatedImpl;
import org.mobicents.diameter.impl.ha.data.ReplicatedSessionDatasource;

/**
 * 
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public class ServerAccSessionDataReplicatedImpl extends AppSessionDataReplicatedImpl implements IServerAccSessionData {

  private static final String STATELESS = "STATELESS";
  private static final String STATE = "STATE";
  private static final String TS_TIMEOUT = "TS_TIMEOUT";
  private static final String TS_TIMERID = "TS_TIMERID";

  /**
   * @param nodeFqn
   * @param mobicentsCluster
   * @param iface
   */
  public ServerAccSessionDataReplicatedImpl(Fqn<?> nodeFqn, MobicentsCluster mobicentsCluster) {
    super(nodeFqn, mobicentsCluster);

    if (super.create()) {
      setAppSessionIface(this, ServerAccSession.class);
      setServerAccSessionState(ServerAccSessionState.IDLE);
    }
  }

  /**
   * @param sessionId
   * @param mobicentsCluster
   * @param iface
   */
  public ServerAccSessionDataReplicatedImpl(String sessionId, MobicentsCluster mobicentsCluster) {
    this(Fqn.fromRelativeElements(ReplicatedSessionDatasource.SESSIONS_FQN, sessionId), mobicentsCluster);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.jdiameter.server.impl.app.cca.IServerCCASessionData#isStateless()
   */
  @Override
  public boolean isStateless() {
    if (exists()) {
      return (Boolean) getNode().get(STATELESS);
    }
    else {
      throw new IllegalStateException();
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.jdiameter.server.impl.app.cca.IServerCCASessionData#setStateless( boolean)
   */
  @Override
  public void setStateless(boolean stateless) {
    if (exists()) {
      getNode().put(STATELESS, stateless);
    }
    else {
      throw new IllegalStateException();
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.jdiameter.server.impl.app.cca.IServerCCASessionData# getServerCCASessionState()
   */
  @Override
  public ServerAccSessionState getServerAccSessionState() {
    if (exists()) {
      return (ServerAccSessionState) getNode().get(STATE);
    }
    else {
      throw new IllegalStateException();
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.jdiameter.server.impl.app.cca.IServerCCASessionData# setServerCCASessionState
   * (org.jdiameter.common.api.app.cca.ServerCCASessionState)
   */
  @Override
  public void setServerAccSessionState(ServerAccSessionState state) {
    if (exists()) {
      getNode().put(STATE, state);
    }
    else {
      throw new IllegalStateException();
    }
  }

  @Override
  public void setTsTimeout(long value) {
    if (exists()) {
      getNode().put(TS_TIMEOUT, value);
    }
    else {
      throw new IllegalStateException();
    }
  }

  @Override
  public long getTsTimeout() {
    if (exists()) {
      return (Long) getNode().get(TS_TIMEOUT);
    }
    else {
      throw new IllegalStateException();
    }
  }

  @Override
  public void setTsTimerId(Serializable value) {
    if (exists()) {
      getNode().put(TS_TIMERID, value);
    }
    else {
      throw new IllegalStateException();
    }
  }

  @Override
  public Serializable getTsTimerId() {
    if (exists()) {
      return (Serializable) getNode().get(TS_TIMERID);
    }
    else {
      throw new IllegalStateException();
    }
  }

}
